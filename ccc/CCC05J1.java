package ccc;
import java.util.Scanner;


public class CCC05J1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		int daytime = Integer.parseInt(scanner.nextLine()); 
		int evening = Integer.parseInt(scanner.nextLine());
		int weekend = Integer.parseInt(scanner.nextLine());

		float planA = (float) (0.15 * evening + 0.20 * weekend) ;
		float planB = (float) (0.35 * evening + 0.25 * weekend) ;
		
		planA += (float) (daytime <= 100 ? 0 : (daytime - 100) * 0.25);
		planB += (float) (daytime <= 250 ? 0 : (daytime - 250) * 0.45);
		
		System.out.println("Plan A costs " + planA);
		System.out.println("Plan B costs " + planB);
		
		if (planA > planB)
			System.out.println("Plan B is cheapest.");
		
		else if (planA == planB)
			System.out.println("Plan A and B are the same price.");
		
		else
			System.out.println("Plan A is cheapest.");
		
	}

}

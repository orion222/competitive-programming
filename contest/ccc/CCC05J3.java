package ccc;
import java.util.Scanner;

public class CCC05J3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
		String streets[] = new String[100];
		streets[0] = "hi";
		boolean turns[] = new boolean[100];
		
		int i = 0;
		
		do {
			
			boolean turn = scanner.nextLine() == "R"? true : false;
			turns[i] = turn;
			String street = scanner.nextLine();
			streets[i] = street;
			i++;
			
		} while (streets[-1] != "SCHOOL");
		streets[i - 1] = "HOME";
		
		
		for (int e = 0; e < streets.length; e++) {
			System.out.print(streets[e]);
			System.out.print(turns[e]);

		}
		//for (int e = 0; e < streets.length - 1; e++) {
		//	String turnback = turns[-e - 1] == true? "LEFT": "RIGHT";
		//	System.out.println("Turn " + turnback + " onto " + streets[-e - 1] + street)
		
		
		
		System.out.println(streets);
		System.out.println(turns);
		
	}
	
}

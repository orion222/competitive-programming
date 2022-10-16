package algos;

import java.io.*;
import java.util.*;

public class bitwise {

	
	// if position i in bit number N is 1 
	// position is left to right
	
	// << means to shift all bits to the left, 
	// >> means to shift all bits to the right
	public static boolean checkBit1(int N, int i) {
		if ((N & (1 << i)) > 0)
			return true;
		else
			return false;
	}
	
	// an easier way to check if a bit in
	// position i of an integer N converted to binary
	// is a 1 or 0
	
	/*
	 * shift N right i places, then AND it with 1
	 * since 1 is 00000001, the entire thing will either
	 * AND to 0 or 1
	 */
	public static int checkBit2(int N, int i) {
		return ((N >> i) & 1);
	}

	
	public static byte bit(int N, int i) {

		return (byte) (N & (1 << i));
	}

	public static int countSetBit(int n) {
		int count = 0;
		while (n > 0) {
			count += n & 1;
			n >>= 1; // right shift
		}
		return count;
	}

	public static int countSetBits(int n) {
		int cnt = 0;
		int[] setBits = new int[n + 1];
		setBits[0] = 0;
		for (int i = 1; i <= n; i++) {
			setBits[i] = setBits[i >> 1] + (i & 1);
		}

		for (int i = 0; i <= n; i++) {
			cnt = cnt + setBits[i];
		}
		return cnt;
	}

	public static int setBitnTo1(int i, int n) {
		i |= 1 << n; // sets bit 'n' to 1
		return i;
	}

	public static int setBitnTo0(int i, int n) {
		i &= ~(1 << n); // sets bit 'n' to 0
		return i;
	}

	public static int toggleBit(int i, int n) {
		i ^= 1 << n;
		return i;
	}

	// public static int isPowerof2(int x)
	// {
	// return (x && !(x & x-1));
	// }

	public static void main(String[] args) {
		// bit(i, mask) – the i-th bit of mask
		// count(mask) – the number of non-zero bits in the mask
		// first(mask) – the number of the lowest non-zero bit in the mask
		// set(i, mask) – set the ith bit in the mask
		// check(i, mask) – check the ith bit in the mask
		System.out.println(bit(8, 3));
		System.out.println(checkBit1(8, 3));
		System.out.println(countSetBits(12));

		// 1. Bitwise OR (|)

		// 11010111
		int a = 0b01010111;
		int b = 0b10010111;
		// 00010111

		System.out.println(Integer.toBinaryString(a | b));

		// result is 0b11111111

		// 2. Bitwise AND (&)
		// This operator is a binary operator, denoted by ‘&.’
		// It returns bit by bit AND of input values, i.e., if both bits are 1, it gives
		// 1, else it shows 0.

		System.out.println(Integer.toBinaryString(a & b));

		// result is 0b01010111
		// 11000000
		// int a = 0b01010111;
		// int b = 0b10010111;
		// 3. Bitwise XOR (^)
		// This operator is a binary operator, denoted by ‘^.’
		// It returns bit by bit XOR of input values, i.e., if corresponding bits are
		// different, it gives 1, else it shows 0.

		System.out.println(Integer.toBinaryString(a ^ b));

		// result is 10101000

		// 4. Bitwise Complement (~)
		// This operator is a unary operator, denoted by ‘~.’
		// It returns the one’s complement representation of the input value, i.e., with
		// all bits inverted, which means it makes
		// every 0 to 1, and every 1 to 0.
		// 10101000
		// int a = 0b01010111;
		System.out.println(Integer.toBinaryString(~a));

		int c = 0b00000011;
		System.out.println(c);

		System.out.println(countSetBits(8));

		System.out.println(Integer.toBinaryString(setBitnTo1(8, 0)));
		System.out.println(Integer.toBinaryString(setBitnTo0(8, 3)));
		System.out.println(Integer.toBinaryString(toggleBit(8, 0)));
		
		System.out.println("task: " + (0b00011111 & 1));

	}
}

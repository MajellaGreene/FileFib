package ie.gmit;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args)
	{
		
		int first = 0;
		int second = 1;
		int next;
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the terms for Fibonacci Series: ");
		
		System.out.println("y");
		
		int numberOfTerms = scanner.nextInt();
		
		System.out.println(first + " , " + second);
		
		for (int count = 3; count <= numberOfTerms; count++)
		{
			next = first + second;
			System.out.println(", " + next);
			first = second;
			second = next;
			// 0, 1, 1, 2, 3,
		}
		
	}

	public String call(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	public String add(String parameter) {
		// TODO Auto-generated method stub
		return null;
	}
}

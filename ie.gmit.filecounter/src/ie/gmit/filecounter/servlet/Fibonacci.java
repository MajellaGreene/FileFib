package ie.gmit.filecounter.servlet;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

import sun.rmi.server.UnicastServerRef;


public class Fibonacci extends UnicastRemoteObject implements RemoteFibonacci{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected Fibonacci(int portNumb) throws RemoteException {
		super(portNumb);
		
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args)
	{
		
		int first = 0;
		int second = 1;
		int next;
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the terms for Fibonacci Series: ");
		
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

	@Override
	public String setFibonacciSequence(int max) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
}

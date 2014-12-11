package ie.gmit.filecounter.servlet;

import java.rmi.RemoteException;

public interface RemoteFibonacci{
	
	public String setFibonacciSequence(int max) throws RemoteException;

	
}

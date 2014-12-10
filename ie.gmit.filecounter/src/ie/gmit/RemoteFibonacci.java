package ie.gmit;

import java.rmi.RemoteException;

public interface RemoteFibonacci{
	
	public String setFibonacciSequence(int max) throws RemoteException;

}

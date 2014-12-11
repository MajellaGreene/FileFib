package ie.gmit.filecounter.servlet;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteFibonacci extends Remote{
	
	public String getFibonacciSequence(int max) throws RemoteException;

	
}

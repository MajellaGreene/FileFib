package ie.gmit.filecounter.servlet;

import java.util.LinkedList;
import java.util.HashMap;
import java.util.Map;

import org.apache.jasper.tagplugins.jstl.core.Out;

public class FibService {
	
	private LinkedList<FibRequest> inqueue = new LinkedList<FibRequest>();
	private Map<Integer,String> outqueue = new HashMap<Integer,String>();
	
	public int add(int max) {
		//Generate random number
		int number =  (int) ((Math.random() * 99) + 1);
		inqueue.add(new FibRequest(number, max));
		System.out.println("getting service add method");
		return number;
	}
	
	public void addResult(int jobNum, String results)
	{
		this.outqueue.put(jobNum, results);
	}
	
	public String getResult(int jobNumb){
		
		if(outqueue.containsKey(jobNumb)){
			String result = outqueue.get(jobNumb);
			return result;
		}
		else{
			return null;
			
		}
	}
	
}

package ie.gmit;

import java.util.LinkedList;
import java.util.HashMap;
import java.util.Map;

public class FibService {
	
	private LinkedList<FibRequest> inqueue = new LinkedList<FibRequest>();
	private Map<Integer,String> outqueue = new HashMap<Integer,String>();
	
	public int add(int max) {
		//Generate random number
		int number =  (int) Math.random();
		return number;
	}
	public String getResult(int jobNumber){
		
		if(outqueue.containsKey(jobNumber)){
			String result = outqueue.get(jobNumber);
			return result;
		}
		else{
			return null;
			
		}
	}
	
}

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

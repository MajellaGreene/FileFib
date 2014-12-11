package ie.gmit.filecounter.servlet;

public class FibRequest {
	
	private int jobNum;
	private int max;
	
	public FibRequest(int number, int max2) {
		// TODO Auto-generated constructor stub
		jobNum = number;
		max = max2;
	}
	public int getJobNum() {
		return jobNum;
	}
	public void setJobNum(int jobNum) {
		this.jobNum = jobNum;
	}
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
	
}

package ie.gmit.filecounter.servlet;

import ie.gmit.filecounter.maj.FileMaj;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * Servlet implementation class FileCounter
 */



@WebServlet("/FileCounter")
public class FileCounter extends HttpServlet {   	
  private static final long serialVersionUID = 1L;
  private FibService fs;
  int count;
  private FileMaj dao;
  
  public void init() throws ServletException {
	  System.out.println("initialisation");
    dao = new FileMaj();
    fs = new FibService();
    try {
		  RemoteFibonacci remote = new Fibonacci(1099);
		  LocateRegistry.createRegistry(1099);
		  Naming.rebind("remote", remote);
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	  //user input
  }
//    try {
//      count = dao.getCount();
//    } catch (Exception e) {
//      getServletContext().log("An exception occurred in FileCounter", e);
//      throw new ServletException("An exception occurred in FileCounter"
//          + e.getMessage());
//    }
//  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
	  RemoteFibonacci remotefib = null;
	  try {
		 remotefib= (RemoteFibonacci)Naming.lookup("rmi://localhost:1099/remote");//Instantiate the chat server
		  //String fibRes = String.valueOf(remote.getFibRequest(Integer.valueOf(type)));
			//Naming.rebind("ChatServer-1.0", remote); //Bind it to the local RMIRegistry
			System.out.println("************************************");
			System.out.println("*          RMI Chat Server         *");
			System.out.println("************************************");
			System.out.println("Server ready!");
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println("rmi wrong");
	}
	  

    // Set the session valid for 5 secs
    String rType = (String) req.getSession().getAttribute("request-type");
    if(rType.equals("Add")){
    	 // int maximumRe = Integer.parseInt(req.getParameter("jobNum"));
    	  //int noRe = fs.add(maximumRe);
    	 // String type = req.getParameter("Input");
    	  
    	String jobNum = "";
    	jobNum += fs.add(Integer.parseInt(req.getParameter("max")));
    	fs.addResult(Integer.valueOf(jobNum),remotefib.getFibonacciSequence(Integer.parseInt(req.getParameter("max"))));// put jobNum and fib into table
    	System.out.println("add "+jobNum);
    	//response.sendRedirect("FibJob.jsp");
    	//response.getOutputStream().print(jobNum);
    	req.getSession().setAttribute("jobNum", jobNum);
    	//req.getSession().setAttribute("timer", 10);
    	req.getRequestDispatcher("FibJob.jsp").forward(req,response);
    }
    else if(rType.equals("Poll")){
    	System.out.println("this is poll");
    	String Results = "";
    	try {
    		Results += fs.getResult(Integer.parseInt(req.getParameter("jobnum")));
			System.out.println(Results+":"+req.getParameter("jobnum"));
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
    	if(!Results.equals("")){
        	//response.sendRedirect("Result.jsp");
//        	req.getSession().setAttribute("Results", Results);
//        	req.getRequestDispatcher("Results.jsp").forward(req,response);
    		response.sendRedirect("Result.jsp?result="+Results);
    	} else {
    		req.getRequestDispatcher("FibJob.jsp").forward(req,response);
    	}
    	
    	
    	/*if(fs.getResult(Integer.parseInt(Results)) != null)
    	{
    		//send to client
    		
    	}
    	else{
    		//response.sendRequest("Re
    	}*/
    }

    //out.flush();
    
  //response.sendRedirect("Home.jsp");
    
    //session.setMaxInactiveInterval(5);
    //response.setContentType("text/plain");
   // PrintWriter out = response.getWriter();
    
    
    /*if (session.isNew()) {
      count++;
    }
    out.println("This site has been accessed " + count + " times.");*/
  }

  
  @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
	// TODO Auto-generated method stub
	doGet(req, resp);
}



  
  public void destroy() {
    super.destroy();
    
    try {
      dao.save(count);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

} 

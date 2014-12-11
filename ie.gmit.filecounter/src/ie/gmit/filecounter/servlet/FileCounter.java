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
  private FibService fs = new FibService(); 

  
	
  int count;
  private FileMaj dao;
  
  /*@Override
  public void init() throws ServletException {
    dao = new FileMaj();
    try {
		  RemoteFibonacci remote = new Fibonacci(1099);
		  LocateRegistry.createRegistry(1099);
		  Naming.rebind("Remote", remote);
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	  //user input
  }*/
//    try {
//      count = dao.getCount();
//    } catch (Exception e) {
//      getServletContext().log("An exception occurred in FileCounter", e);
//      throw new ServletException("An exception occurred in FileCounter"
//          + e.getMessage());
//    }
//  }

  @Override
  protected void doGet(HttpServletRequest req,
      HttpServletResponse response) throws ServletException, IOException {
	  
	  
	  /*int maximumRe = Integer.parseInt(req.getParameter("jobNum"));
	  int noRe = fs.add(maximumRe);
	  String type = req.getParameter("Input");
	  
	  try {
		  RemoteFibonacci remote = (RemoteFibonacci )Naming.lookup("rmi://localhost:1099/remote");//Instantiate the chat server
		  //String fibRes = String.valueOf(remote.getFibRequest(Integer.valueOf(type)));
			Naming.rebind("ChatServer-1.0", remote); //Bind it to the local RMIRegistry
			System.out.println("************************************");
			System.out.println("*          RMI Chat Server         *");
			System.out.println("************************************");
			System.out.println("Server ready!");
	} catch (Exception e) {
		// TODO: handle exception
	}
	  */
	  
	  fs = new FibService();
	  
	  
    
    // Set the session valid for 5 secs
    String rType = req.getParameter("request-type").toString();
    if(rType.equals("Add")){
    	String jobNum = "";
    	jobNum += fs.add(Integer.parseInt(req.getParameter("jobNum")));
    	//response.sendRedirect("FibJob.jsp");
    	//response.getOutputStream().print(jobNum);
    	req.setAttribute("jobNum", jobNum);
    	req.setAttribute("timer", 10);
    	req.setAttribute("request-type", "Poll");
    	req.getRequestDispatcher("FibJob.jsp").forward(req,response);
    }
    else if(rType.equals("Poll")){
    	String jobNum = "";
    	//response.getOutputStream().print(jobNum);
    	jobNum += fs.add(Integer.parseInt(req.getParameter("jobNum")));
    	response.sendRedirect("Result.jsp");
    	if(fs.getResult(Integer.parseInt(jobNum)) != null)
    	{
    		//send to client
    	}
    	else{
    		//response.sendRequest("Re
    	}
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

package ie.gmit.filecounter.servlet;

import ie.gmit.FibService;
import ie.gmit.Fibonacci;
import ie.gmit.filecounter.maj.FileMaj;

import java.io.IOException;
import java.io.PrintWriter;

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

  @Override
  protected void doGet(HttpServletRequest req,
      HttpServletResponse response) throws ServletException, IOException {
    
    HttpSession session = req.getSession(true);
    // Set the session valid for 5 secs
    String rType = req.getParameter("Request-Type");
    if(rType.equals("Add")){
    	String jobNumber = "";
    	jobNumber += fs.add(Integer.parseInt(req.getParameter("max")));
    	response.getOutputStream().print(jobNumber);
    }
    else if(rType.equals("Poll")){
    	String jobNumber = "";
    	response.getOutputStream().print(jobNumber);
    	jobNumber += fs.add(Integer.parseInt(req.getParameter("jobNumber")));
    	
    	if(fs.getResult(Integer.parseInt(jobNumber)) != null)
    	{
    		//send to client
    	}
    	else{
    		//response.sendRequest("Re
    	}
    }
    //out.flush();
    
    session.setMaxInactiveInterval(5);
    response.setContentType("text/plain");
    PrintWriter out = response.getWriter();
    
    
    if (session.isNew()) {
      count++;
    }
    out.println("This site has been accessed " + count + " times.");
  }

  
  @Override
  public void init() throws ServletException {
    dao = new FileMaj();
    try {
      count = dao.getCount();
    } catch (Exception e) {
      getServletContext().log("An exception occurred in FileCounter", e);
      throw new ServletException("An exception occurred in FileCounter"
          + e.getMessage());
    }
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

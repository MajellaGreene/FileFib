<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<Header><title> Fibonacci Request   </title></Header>
	</head>	

<meta http-equiv="refresh" content="10">
	
	<body>	<form action="FileCounter">				
			 <input type="Hidden" name="request-type" value="Poll">
			  <label> Job Number - ${ jobNum } </label><br>
			  <label> Timer - <%request.getAttribute("time");%></label><br>
			  <label> Page will refresh in 10 seconds </label>	
			  </form>		
	</body>	
</html>

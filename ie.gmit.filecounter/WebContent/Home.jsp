<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  
	pageEncoding="ISO-8859-1" session = "true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title> My first JSP   </title>
	</head>	
	<body>		
		<form action="FileCounter" method="get">			
			 Fibonacci Sequence Length ---
			 <% session.setAttribute("request-type" , "Add"); %>
			 <br>Enter Number between 1 - 100 : <br>
			<input type="text" name="max" size="20px">
			<input type="submit" value="submit">						
		</form>		
	</body>	
</html>

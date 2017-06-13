package com.accenture;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*@SuppressWarnings("serial")
@WebServlet("/someservlet/*")	*/	
@SuppressWarnings("serial")
//public class SomeServlet extends HttpServlet {
@WebServlet("/SomeServlet")
public class SomeServlet extends HttpServlet 
{
	Model model = new Model();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   /* String text = "ye hu haha";
	   
	    response.setContentType("text/plain");  // Set content type of the response so that jQuery knows what it can expect.
	    response.setCharacterEncoding("UTF-8"); // You want world domination, huh?
	    response.getWriter().write(text);       // Write response body.
	
	    request.setAttribute("id", text);
	    
	    String temp="nothing";*/
	    
		 String jspInput=(String)request.getParameter("state");;
		String javaOutput="";
		
	   
	   try {
	
		javaOutput = model.SearchFiveUserName(jspInput);
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
	
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
	

		e.printStackTrace();
	}
	   
	   
	   System.out.println(jspInput);
	   
	   PrintWriter out = response.getWriter();
	   out.print(javaOutput);
	   
	    System.out.println("in SomeServlet Class");
	}
	
}

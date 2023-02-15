package com.madhu.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/third")
public class ThirdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	     String pqty = request.getParameter("pqty");
	    // String semail = request.getParameter("semail");
	     
//	     HttpSession session = request.getSession(false);
//	     session.setAttribute("smobile", smobile);
//	     session.setAttribute("semail", semail);
	     
	     Cookie cookie3 = new Cookie("pqty",pqty);
	     response.addCookie(cookie3);
	     
	     Cookie[] cookies = request.getCookies();
	     String pname = cookies[0].getValue();
	     String pprice = cookies[1].getValue();
	     
	     
	     
	     System.out.println(request.getRequestedSessionId());
	     response.setContentType("text/html");
	     PrintWriter writer = response.getWriter();
	     writer.println("<html><head><title>Output</title></head>");
	     writer.println("<body bgcolor='lightgreen'>" );
	     writer.println("<h1 style='color:red;text-align:center;'>Registration form</h1>");
	     writer.println("<table border='1'>");
	     writer.println("<center>");
	     writer.println("<tr><th>Name</th><th>Value</th></tr>");
	     
	     writer.println("<tr><td>PName</td><td>"+pname+"</td></tr>");
	     writer.println("<tr><td>PPrice</td><td>"+pprice+"</td></tr>");
	     writer.println("<tr><td>PQuantity</td><td>"+pqty+"</td></tr>");
	     
	     writer.println("<form method='post' action='./storeindb'>");
	     writer.println("<tr><td><input type='submit' value='Register'/></td></tr>");
	     writer.println("</form>");
	     writer.println("</center>");
	     writer.println("</table></body</html>");
	     writer.close();
	     
	     
	     
		}
	
}

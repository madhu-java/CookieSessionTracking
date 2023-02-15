package com.madhu.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/second")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pprice = request.getParameter("pprice");
		//String sdesg = request.getParameter("sdesg");
		HttpSession session = request.getSession(false);	
//		session.setAttribute("squal", squal);
//		session.setAttribute("sdesg", sdesg);
		Cookie cookie2 = new Cookie("pprice", pprice);
		response.addCookie(cookie2);
		
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("./form3.html");
		requestDispatcher.forward(request, response);
		
	}
	

}
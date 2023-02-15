package com.madhu.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.madhu.JdbcUtil.JdbcUtil;

@WebServlet("/storeindb")
public class RegisterInDB extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PreparedStatement prepareStatement = null;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		writer.println("storing in db");
		HttpSession session = request.getSession(false);
		try {
			Connection connection = JdbcUtil.getJdbcConnection();
			String sqlInsertQuery = "insert into products(`pname`,`price`,`qty`) values(?,?,?)";
Cookie[] cookies = request.getCookies();
System.out.println("cookies[]:"+cookies);
String pname= cookies[0].getValue();
String pprice= cookies[1].getValue();
String pqty= cookies[2].getValue();
System.out.println("pname:"+pname+":Pprice:"+pprice+":pqty:"+pqty);
			if (connection != null) {
				prepareStatement = connection.prepareStatement(sqlInsertQuery);
			}
			if (prepareStatement != null) {
				prepareStatement.setString(1, pname);
				prepareStatement.setInt(2,  Integer.valueOf(pprice));
				prepareStatement.setInt(3, Integer.valueOf(pqty));
			}
			if (prepareStatement != null) {
				int rowsAffected = prepareStatement.executeUpdate();
				RequestDispatcher requestDispatcher = null;

				if (rowsAffected == 1) {
					requestDispatcher = request.getRequestDispatcher("./success.html");
					requestDispatcher.forward(request, response);
				}else {
					requestDispatcher = request.getRequestDispatcher("./failure.html");
					requestDispatcher.forward(request, response);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}

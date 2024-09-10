package vn.javaweb1.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/hello", "/hi"})
public class HelloWorld extends HttpServlet {

	private static final long serialVersionUID = -8546357904918713493L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// Step1: Nhận request
		req.setCharacterEncoding("utf-8");

		String name = req.getParameter("ten");
		String year = req.getParameter("nam");

		// Step2: Xử lý request
		String namey = name + " " + year;

		// Step3: Trả về Response
		resp.setContentType("text/html");
		resp.setCharacterEncoding("utf-8");
//		PrintWriter out = resp.getWriter();
//		out.println(namey);
			
		req.setAttribute("fname", name);
        req.setAttribute("lname", year);
		
		PrintWriter printW = resp.getWriter();
		printW.println(name + " "+ year);
		
		RequestDispatcher rd = req.getRequestDispatcher("/views/test.jsp");
        rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// Step1: Nhận request
		req.setCharacterEncoding("utf-8");

		String name = req.getParameter("ten");
		String year = req.getParameter("nam");

		// Step2: Xử lý request
		String namey = name + " " + year;

		// Step3: Trả về Response
		resp.setContentType("text/html");
		resp.setCharacterEncoding("utf-8");
		PrintWriter out = resp.getWriter();
		out.println(namey);
	}
}

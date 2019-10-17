package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Actor;
import sql.Connect;

@WebServlet("/create")
public class CreateServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		getServletContext().getRequestDispatcher("/create.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String name = (String)request.getParameter("name");
			String lastname = (String)request.getParameter("lastname");
			String gender = (String)request.getParameter("gender");
			Actor actor = new Actor(name, lastname, gender);
			Connect.insert(actor);
			response.sendRedirect(request.getContextPath() + "/dann");
		} catch (Exception ex) {

			getServletContext().getRequestDispatcher("/create.jsp").forward(request, response);
			response.sendRedirect("dann");
		}
	}
}
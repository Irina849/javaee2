package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Actor;
import sql.Connect;
 

 
@WebServlet("/edit")
public class EditServlet extends HttpServlet {
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
 
        
            int id = Integer.parseInt(request.getParameter("id"));
            Actor actor = Connect.selectOne(id);
            if(actor!=null) {
                request.setAttribute("actor", actor);
                getServletContext().getRequestDispatcher("/edit.jsp").forward(request, response);
            }
    }
     
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
 
        
            int id = Integer.parseInt(request.getParameter("id"));
            String firstname = (String)request.getParameter("firstname");
            String lastname = (String)request.getParameter("lastname");
            String gender = (String)request.getParameter("gender");
            Actor actor = new Actor(id,firstname, lastname, gender);
            Connect.update(actor);
            response.sendRedirect(request.getContextPath() + "/dann");
        
        
    }
}
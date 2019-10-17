package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sql.Connect;
 

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
     
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
         
        
            int id = Integer.parseInt(request.getParameter("id"));          Connect.delete(id);
            response.sendRedirect(request.getContextPath() + "/dann");
        
       
    }
}
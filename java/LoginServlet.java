package com.WebApplication1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

            try {
                response.setContentType("text/html");
                PrintWriter out = response.getWriter();
                
                String n=request.getParameter("username");
                String p=request.getParameter("userpass");
                
                if(LoginDao.validate(n, p)){
                    if(p.equals("vibhor"))
                {
                    System.out.println("Login succesfull");
                    RequestDispatcher rd=request.getRequestDispatcher("index-parking1.html");
			rd.forward(request,response);
                }
                    else if(p.equals("tanish")){
                    RequestDispatcher rd=request.getRequestDispatcher("index-parking.html");
                    rd.forward(request,response);
                }
                }
                else{
                   PrintWriter ut = response.getWriter();  
response.setContentType("text/html");  
out.println("<script type=\"text/javascript\">");  
out.println("alert('INVALID USERNAME AND PASSWORD');");  
out.println("</script>");
                    RequestDispatcher rd=request.getRequestDispatcher("login.html");
                    rd.include(request,response);
                }
                
                out.close();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
	}

}

package servlets;

import models.AccountService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.User;

/**
 *
 * @author joekim
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
       
        String action = request.getParameter("action");
        if (action != null && action.equals("logout")) {
            session.removeAttribute("loginUser");
            request.setAttribute("result", "You have successfully logged out.");
        }
        
           if (session.getAttribute("loginUser") != null) {
             response.sendRedirect("home");
           } else {
             getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
           } 
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        request.setAttribute("username", username);
        request.setAttribute("password", password);
        
        if (username == null || username.equals("") || password == null || password.equals("")) {
            request.setAttribute("result", "Please enter username and password");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            return;
        }
        
        AccountService as = new AccountService();
        User loginUser = as.login(username, password);
        
        if (loginUser == null) {
            request.setAttribute("result", "Invalid login");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            return;
        }else {
            HttpSession session = request.getSession();
            session.setAttribute("loginUser", loginUser);
            response.sendRedirect("home");
        }
        
    }

}

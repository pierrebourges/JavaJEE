package ynov.m1.bourges_pierre.projetbanque.Controleur;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/langue")
public class Langue extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String langue = req.getParameter("form_langues");
        String url = req.getParameter("url");
        req.getSession().setAttribute("langue", langue);
        if(langue != null){
//            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/classes/WEB-INF/views/login.jsp");
//            dispatcher.forward(req, resp);
            resp.sendRedirect(req.getContextPath() + url);
        }
    }
}

package ynov.m1.bourges_pierre.projetbanque.Controleur;

import ynov.m1.bourges_pierre.projetbanque.Manager.UtilisateurManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import ynov.m1.bourges_pierre.projetbanque.Modele.Utilisateur;

public class login extends HttpServlet {

    private static final Logger logger = LogManager.getLogger(login.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/classes/WEB-INF/views/login.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String mdp = req.getParameter("mdp");
        String langue = req.getParameter("form_langues");
        req.setAttribute("langue", langue);

        Utilisateur utilisateur = UtilisateurManager.loadUtilisateurByLoginAndPassword(login, mdp);
        if (utilisateur == null){
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/classes/WEB-INF/views/login.jsp");
            dispatcher.forward(req, resp);
        }else {
            req.getSession().setAttribute("utilisateur", utilisateur);
            req.getSession().setMaxInactiveInterval(2*60);
            resp.sendRedirect(req.getContextPath() + "/comptes");
        }

        if(langue != null){
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/classes/WEB-INF/views/login.jsp");
        }
    }
}

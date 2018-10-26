package ynov.m1.bourges_pierre.projetbanque.Controleur;

import ynov.m1.bourges_pierre.projetbanque.Manager.MDPManager;
import ynov.m1.bourges_pierre.projetbanque.Manager.UtilisateurManager;
import ynov.m1.bourges_pierre.projetbanque.Modele.Utilisateur;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/changemdp")
public class ChangeMDP extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/classes/WEB-INF/views/changeMDP.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String newMdp = req.getParameter("newmdp");
        String secondMdp = req.getParameter("secondmdp");
        String ancienMdp = req.getParameter("ancienmdp");
        Utilisateur utilisateur = (Utilisateur) req.getSession().getAttribute("utilisateur");


        if(ancienMdp.equals(utilisateur.getPassword())){
            if(newMdp.equals(secondMdp)){
                if(MDPManager.checkMdp(newMdp)){
                    utilisateur.setPassword(newMdp);
                    req.getSession().setAttribute("utilisateur", utilisateur);
                    UtilisateurManager.updateUtilisateur(utilisateur);
                    resp.sendRedirect(req.getContextPath() + "/comptes");
                }else {
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/classes/WEB-INF/views/changeMDP.jsp");

                    req.setAttribute("errorCondtionMdp", true);
                    dispatcher.forward(req, resp);
                }
            }else{
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/classes/WEB-INF/views/changeMDP.jsp");

                req.setAttribute("errorSecondMdp", true);
                dispatcher.forward(req, resp);
            }
        }else{
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/classes/WEB-INF/views/changeMDP.jsp");

            req.setAttribute("errorOldMdp", true);
            dispatcher.forward(req, resp);
        }
    }
}


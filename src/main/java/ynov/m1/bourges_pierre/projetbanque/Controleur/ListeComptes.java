package ynov.m1.bourges_pierre.projetbanque.Controleur;

import ynov.m1.bourges_pierre.projetbanque.Manager.CompteManager;
import ynov.m1.bourges_pierre.projetbanque.Manager.UtilisateurManager;
import ynov.m1.bourges_pierre.projetbanque.Modele.Compte;
import ynov.m1.bourges_pierre.projetbanque.Modele.Utilisateur;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/comptes")
public class ListeComptes extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/classes/WEB-INF/views/comptes.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Utilisateur utilisateur = (Utilisateur) req.getSession().getAttribute("utilisateur");

        Integer type_compte = Integer.parseInt(req.getParameter("type_compte"));
        Compte compte = new Compte();
        compte.setSolde(0);
        compte.setId_type_compte(type_compte);
        compte.setUnUtilisateur(utilisateur);
        compte.setDate_creation(new Date());

        CompteManager.saveCompte(compte);

        utilisateur = UtilisateurManager.loadUtilisateurByLoginAndPassword(utilisateur.getLogin(), utilisateur.getPassword());
        req.getSession().setAttribute("utilisateur", utilisateur);
        resp.sendRedirect(req.getContextPath() + "/comptes");
    }
}

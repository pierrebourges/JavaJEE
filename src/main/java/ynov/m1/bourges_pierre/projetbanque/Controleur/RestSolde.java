package ynov.m1.bourges_pierre.projetbanque.Controleur;

import ynov.m1.bourges_pierre.projetbanque.Manager.CompteManager;
import ynov.m1.bourges_pierre.projetbanque.Modele.Compte;
import ynov.m1.bourges_pierre.projetbanque.Modele.Utilisateur;

import javax.json.Json;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/rest")
public class RestSolde extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        Compte compte = CompteManager.findCompteById(id);
        String json = "{ \"id\" : " + id + ", \"solde\" : " + compte.getSolde() + ", }";

        resp.setContentType("application/json");
        resp.getWriter().print(json);
        resp.getWriter().flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}

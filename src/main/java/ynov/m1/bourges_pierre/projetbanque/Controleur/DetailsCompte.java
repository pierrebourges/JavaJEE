package ynov.m1.bourges_pierre.projetbanque.Controleur;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import ynov.m1.bourges_pierre.projetbanque.Manager.CompteManager;
import ynov.m1.bourges_pierre.projetbanque.Manager.TransactionManager;
import ynov.m1.bourges_pierre.projetbanque.Manager.UtilisateurManager;
import ynov.m1.bourges_pierre.projetbanque.Modele.Compte;
import ynov.m1.bourges_pierre.projetbanque.Modele.Transaction;
import ynov.m1.bourges_pierre.projetbanque.Modele.Utilisateur;

import javax.json.Json;
import javax.json.JsonObject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Date;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import org.json.JSONObject;

@WebServlet("/detailsCompte")
public class DetailsCompte extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idCompte = req.getParameter("idCompte");
        URL url = new URL("http://localhost:8080/rest?id="+idCompte);
        BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
        String str = "";
        while (null != (str = br.readLine())){
            JSONObject json = new JSONObject(str);
            req.setAttribute("solde",json.get("solde"));
        }

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/classes/WEB-INF/views/detailsCompte.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Utilisateur utilisateur = (Utilisateur) req.getSession().getAttribute("utilisateur");

        Compte compteSource = new Compte();
        Float montant = Float.valueOf(req.getParameter("montant"));
        Float montantAbsolu = Math.abs(montant);
        Integer compteDest = Integer.valueOf(req.getParameter("compteId"));
        Integer compteSourceId = Integer.valueOf(req.getParameter("idSource"));
        String libelle = req.getParameter("libelle");

        for (Compte compte : utilisateur.getComptes()){
            if(compte.getId_compte() == compteSourceId){
                compteSource = compte;
            }
        }

        Compte compteDestination = CompteManager.findCompteById(Integer.parseInt(req.getParameter("compteId")));
        if(compteDestination != null){
            compteDestination.setSolde(compteDestination.getSolde() + Float.parseFloat(req.getParameter("montant")));
            CompteManager.updateCompte(compteDestination);

            if(compteSource.getSolde() >= montantAbsolu){
                Float soldeUpdate = compteSource.getSolde() - montantAbsolu;
                compteSource.setSolde(soldeUpdate);
                CompteManager.updateCompte(compteSource);

                JsonObject jsonTransaction = Json.createObjectBuilder()
                        .add("compte_destination", compteDest)
                        .add("compte_source", compteSourceId)
                        .add("montant", montantAbsolu)
                        .add("lebelle", libelle)
                        .add("date", String.valueOf(new Date()))
                        .build();

                HttpClient httpClient = HttpClientBuilder.create().build();
                HttpPost post = new HttpPost("http://localhost:8080/resttransaction");
                StringEntity entity = new StringEntity(String.valueOf(jsonTransaction), ContentType.APPLICATION_FORM_URLENCODED);
                post.setEntity(entity);
                HttpResponse postResponse = httpClient.execute(post);
                System.out.println(postResponse.getStatusLine().getStatusCode());

//                TransactionManager.saveTransaction(transaction);
            }else {
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/classes/WEB-INF/views/detailsCompte.jsp");

                req.setAttribute("errorMessageMontant", "errorMontant");
                dispatcher.forward(req, resp);
            }

        }else {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/classes/WEB-INF/views/detailsCompte.jsp");

            req.setAttribute("errorMessageDestination", "errorDest");
            dispatcher.forward(req, resp);
        }




        utilisateur = UtilisateurManager.loadUtilisateurByLoginAndPassword(utilisateur.getLogin(), utilisateur.getPassword());
        req.getSession().setAttribute("utilisateur", utilisateur);
        resp.sendRedirect(req.getContextPath() + "/detailsCompte?idCompte="+req.getParameter("idSource"));
    }
}

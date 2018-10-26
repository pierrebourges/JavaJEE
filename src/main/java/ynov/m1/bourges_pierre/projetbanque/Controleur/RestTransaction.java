package ynov.m1.bourges_pierre.projetbanque.Controleur;

import org.json.JSONObject;
import ynov.m1.bourges_pierre.projetbanque.Manager.CompteManager;
import ynov.m1.bourges_pierre.projetbanque.Manager.TransactionManager;
import ynov.m1.bourges_pierre.projetbanque.Modele.Compte;
import ynov.m1.bourges_pierre.projetbanque.Modele.Transaction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet("/resttransaction")
public class RestTransaction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Transaction transaction = new Transaction();

        List<String> list = new ArrayList<String>(req.getParameterMap().keySet());

        for(String json : list){
            JSONObject jsonObject = new JSONObject(json);
            transaction.setCompte_destination(jsonObject.getInt("compte_destination"));
            transaction.setCompte_source(jsonObject.getInt("compte_source"));
            transaction.setDate(new Date());
            transaction.setMontant(jsonObject.getFloat("montant"));
            transaction.setLebelle(jsonObject.getString("lebelle"));

            Compte compte = CompteManager.findCompteById(jsonObject.getInt("compte_source"));
            transaction.setCompte(compte);

            TransactionManager.saveTransaction(transaction);
        }

//        transaction.setCompte_destination();
//        transaction.setCompte_source();
//        transaction.setDate();
//        transaction.setMontant();
//        transaction.setLebelle();
//
//        TransactionManager.saveTransaction(transaction);
    }
}

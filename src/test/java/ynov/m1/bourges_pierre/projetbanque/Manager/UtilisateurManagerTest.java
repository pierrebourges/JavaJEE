package ynov.m1.bourges_pierre.projetbanque.Manager;

import org.junit.jupiter.api.Test;
import ynov.m1.bourges_pierre.projetbanque.Modele.Compte;
import ynov.m1.bourges_pierre.projetbanque.Modele.Transaction;
import ynov.m1.bourges_pierre.projetbanque.Modele.Utilisateur;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TimeZone;

import static org.junit.jupiter.api.Assertions.assertEquals;


class UtilisateurManagerTest {

    @Test
    void saveUtilisateur() throws ParseException {
        Utilisateur rekkles = new Utilisateur();
        rekkles.setPrenom("Martin");
        rekkles.setNom("Larsson");
        rekkles.setAddress("20 rue Gambetta");
        SimpleDateFormat isoFormat = new SimpleDateFormat("dd-MM-yyyy");
        isoFormat.setTimeZone(TimeZone.getTimeZone("UTC+2"));
        Date uDate = isoFormat.parse("20-09-1996");
        rekkles.setDate_naissance(uDate);
        rekkles.setEmail("rekkles@gmail.com");
        rekkles.setLogin("rekkles");
        rekkles.setPassword("mdp");
        rekkles.setPhone("0652456535");

        UtilisateurManager.saveUtilisateur(rekkles);
    }

    @Test
    void loadUtilisateurById() throws ParseException {
        Utilisateur rekkles = new Utilisateur();
        rekkles.setPrenom("Martin");
        rekkles.setNom("Larsson");
        rekkles.setAddress("20 rue Gambetta");
        SimpleDateFormat isoFormat = new SimpleDateFormat("dd-MM-yyyy");
        isoFormat.setTimeZone(TimeZone.getTimeZone("UTC+2"));
        Date uDate = isoFormat.parse("20-09-1996");
        rekkles.setDate_naissance(uDate);
        rekkles.setEmail("rekkles@gmail.com");
        rekkles.setLogin("rekkles");
        rekkles.setPhone("0652456535");
        rekkles.setPassword("mdp");
        rekkles.setId_utilisateur(1);


        assertEquals(UtilisateurManager.loadUtilisateurById(1).getLogin(), rekkles.getLogin());
    }

    @Test
    void loadUtilisateurByLoginAndPasswordTest() throws ParseException {
        Utilisateur rekkles = new Utilisateur();
        rekkles.setPrenom("Martin");
        rekkles.setNom("Larsson");
        rekkles.setAddress("20 rue Gambetta");
        SimpleDateFormat isoFormat = new SimpleDateFormat("dd-MM-yyyy");
        isoFormat.setTimeZone(TimeZone.getTimeZone("UTC+2"));
        Date uDate = isoFormat.parse("20-09-1996");
        rekkles.setDate_naissance(uDate);
        rekkles.setEmail("rekkles@gmail.com");
        rekkles.setLogin("rekkles");
        rekkles.setPhone("0652456535");
        rekkles.setPassword("mdp");
        rekkles.setId_utilisateur(1);

        assertEquals(UtilisateurManager.loadUtilisateurByLoginAndPassword("rekkles", "mdp").getLogin(), rekkles.getLogin());
    }

    @Test
    void saveUtilisateurCompteTest() throws ParseException {
        Utilisateur rekkles = new Utilisateur();
        Set<Compte> listComptes = new LinkedHashSet<Compte>();
        Transaction transaction = new Transaction();
        Set<Transaction> listTransactions = new LinkedHashSet<Transaction>();
        Compte dooku = new Compte();

        rekkles.setPrenom("Martin");
        rekkles.setNom("Larsson");
        rekkles.setAddress("20 rue Gambetta");
        SimpleDateFormat isoFormat = new SimpleDateFormat("dd-MM-yyyy");
        isoFormat.setTimeZone(TimeZone.getTimeZone("UTC+2"));
        Date uDate = isoFormat.parse("20-09-1996");
        rekkles.setDate_naissance(uDate);
        rekkles.setEmail("rekkles@gmail.com");
        rekkles.setLogin("rekkles");
        rekkles.setPhone("0652456535");
        rekkles.setPassword("mdp");

        dooku.setSolde(50);
        dooku.setUnUtilisateur(rekkles);

        listComptes.add(dooku);
        rekkles.setComptes(listComptes);

        transaction.setMontant(25);
        transaction.setCompte(dooku);

        listTransactions.add(transaction);
        dooku.setTransactions(listTransactions);

        UtilisateurManager.saveUtilisateur(rekkles);
    }

    @Test
    void updateUtilisateur() throws ParseException{
        Utilisateur utilisateur = UtilisateurManager.loadUtilisateurById(2);
        utilisateur.setPassword("test");

        UtilisateurManager.updateUtilisateur(utilisateur);

        Utilisateur secondUtilisateur = UtilisateurManager.loadUtilisateurById(2);

        assertEquals(secondUtilisateur.getPassword(), utilisateur.getPassword());
    }
}
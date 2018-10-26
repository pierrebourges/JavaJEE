package ynov.m1.bourges_pierre.projetbanque.Manager;

import ynov.m1.bourges_pierre.projetbanque.Modele.Compte;
import ynov.m1.bourges_pierre.projetbanque.Modele.Transaction;
import ynov.m1.bourges_pierre.projetbanque.Modele.Utilisateur;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;



import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;


public class UtilisateurManager  extends BaseManager{

    private static final Logger logger = LogManager.getLogger(UtilisateurManager.class);

    public static void saveUtilisateur(Utilisateur utilisateur){
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(utilisateur);
        em.getTransaction().commit();
    }

    public static Utilisateur loadUtilisateurById(Integer utilisateurId){
        EntityManager em = getEntityManager();
        Utilisateur utilisateur = em.find(Utilisateur.class, utilisateurId);
        return utilisateur;
    }

    public  static  Utilisateur loadUtilisateurByLoginAndPassword(String login, String password){
        EntityManager em = getEntityManager();
        TypedQuery<Utilisateur> query = em.createQuery("SELECT u FROM Utilisateur u WHERE u.login = '"+ login +
                "' and password = '" + password + "'", Utilisateur.class);
        if(query.getResultList().isEmpty()){
            return null;
        }
        Utilisateur utilisateur = query.getSingleResult();

        for (Compte compte : utilisateur.getComptes()){
            logger.trace(compte);
            for (Transaction trans : compte.getTransactions()){
            }
        }


        return utilisateur;
    }

    public static void deleteUtilisateur(Utilisateur utilisateur){
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.remove(utilisateur);
        em.getTransaction().commit();
    }

    public static void  updateUtilisateur(Utilisateur utilisateur){
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.merge(utilisateur);
        em.getTransaction().commit();
        logger.debug(utilisateur);
    }
}

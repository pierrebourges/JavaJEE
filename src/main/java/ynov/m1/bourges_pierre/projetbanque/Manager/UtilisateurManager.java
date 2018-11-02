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
        logger.info(em);
    }

    public static Utilisateur loadUtilisateurById(Integer utilisateurId){
        EntityManager em = getEntityManager();
        Utilisateur utilisateur = em.find(Utilisateur.class, utilisateurId);
        logger.info(utilisateur);
        return utilisateur;
    }

    public  static  Utilisateur loadUtilisateurByLoginAndPassword(String login, String password){
        EntityManager em = getEntityManager();
        TypedQuery<Utilisateur> query = em.createQuery("SELECT u FROM Utilisateur u WHERE u.login = '"+ login +
                "' and password = '" + password + "'", Utilisateur.class);
        if(query.getResultList().isEmpty()){
            logger.error("User not find login : " + login + " password : " + password);
            return null;
        }
        Utilisateur utilisateur = query.getSingleResult();
        logger.debug(utilisateur);

        return utilisateur;
    }

    public static void  updateUtilisateur(Utilisateur utilisateur){
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.merge(utilisateur);
        em.getTransaction().commit();
        logger.info(utilisateur);
    }
}

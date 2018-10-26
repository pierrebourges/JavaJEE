package ynov.m1.bourges_pierre.projetbanque.Manager;
import ynov.m1.bourges_pierre.projetbanque.Modele.Compte;

import ynov.m1.bourges_pierre.projetbanque.Modele.Compte;
import ynov.m1.bourges_pierre.projetbanque.Modele.Transaction;
import ynov.m1.bourges_pierre.projetbanque.Modele.Utilisateur;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class CompteManager extends BaseManager{
    private static final Logger logger = LogManager.getLogger(CompteManager.class);

    public static void saveCompte(Compte compte){
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(compte);
        em.getTransaction().commit();
        logger.debug(compte);
    }

    public static void  updateCompte(Compte compte){
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.merge(compte);
        em.getTransaction().commit();
        logger.debug(compte);
    }

    public static Compte findCompteById (Integer Id){
        EntityManager em = getEntityManager();
        TypedQuery<Compte> query = em.createQuery("SELECT c FROM Compte c WHERE c.id_compte = "+ Id , Compte.class);

        if (query.getResultList().isEmpty()){
            return null;
        }

        Compte compte = query.getSingleResult();

        return compte;
    }

}

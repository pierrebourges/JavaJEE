package ynov.m1.bourges_pierre.projetbanque.Manager;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import ynov.m1.bourges_pierre.projetbanque.Modele.Transaction;

import javax.persistence.EntityManager;

public class TransactionManager extends BaseManager {

    private static final Logger logger = LogManager.getLogger(TransactionManager.class);

    public static void saveTransaction(Transaction transaction){
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(transaction);
        em.getTransaction().commit();
        logger.debug(transaction);
    }
}

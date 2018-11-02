package ynov.m1.bourges_pierre.projetbanque.Manager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BaseManager {
    private static final String UNIT_NAME = "maBanque";
    private static EntityManagerFactory factory;
    private static final Logger logger = LogManager.getLogger(CompteManager.class);

    protected static EntityManagerFactory getEntityManagerFactory(){
        if(factory == null){
            factory = Persistence.createEntityManagerFactory(UNIT_NAME);
        }
        logger.debug(factory);
        return factory;
    }

    public static  void shutdown(){
        if (factory != null){
            factory.close();
        }
    }

    public static EntityManager getEntityManager(){
        EntityManagerFactory factory = getEntityManagerFactory();
        logger.error(factory);
        return factory.createEntityManager();
    }
}

package ynov.m1.bourges_pierre.projetbanque.Manager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MDPManager {
    private static final Logger logger = LogManager.getLogger(CompteManager.class);
    public static Boolean checkMdp(String mdp){
        String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[-:;|_/!.@#$%^&+=])(?=\\S+$).{8,}$";
        if (mdp.matches("(.*[À-ÿ].*)")){
            logger.error("La chaine de caractère contient des accens");
            return false;
        }

        if (mdp.matches(regex)) {
            logger.debug("Mot de passe valide");
            return true;
        }else {
            logger.error("Le mot de passe ne repond pas à toutes les condition");
            return false;
        }
    }
}

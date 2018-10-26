package ynov.m1.bourges_pierre.projetbanque.Manager;

public class MDPManager {
    public static Boolean checkMdp(String mdp){
        String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[-:;|_/!.@#$%^&+=])(?=\\S+$).{8,}$";
        if (mdp.matches("(.*[À-ÿ].*)")){
            return false;
        }

        if (mdp.matches(regex)) {
            return true;
        }else {
            return false;
        }
    }
}

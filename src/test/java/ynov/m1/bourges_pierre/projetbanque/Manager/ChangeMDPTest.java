package ynov.m1.bourges_pierre.projetbanque.Manager;

import org.junit.jupiter.api.Test;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ChangeMDPTest {
    @Test
    void wrongMdp8() throws ParseException{
        String mdp = "A=34567";

        assertEquals(false, MDPManager.checkMdp(mdp));
    }

    @Test
    void wrongMdpNumber() throws ParseException{
        String mdp = "Azertyuiop=";

        assertEquals(false, MDPManager.checkMdp(mdp));
    }

    @Test
    void wrongMdpMaj() throws ParseException{
        String mdp = "azertyuiop1=";

        assertEquals(false, MDPManager.checkMdp(mdp));
    }

    @Test
    void wrongMdpSpe() throws ParseException{
        String mdp = "Azertyuiop1";

        assertEquals(false, MDPManager.checkMdp(mdp));
    }

    @Test
    void wrongMdpAccent() throws ParseException{
        String mdp = "Azertyuiop1=é";

        assertEquals(false, MDPManager.checkMdp(mdp));
    }

    @Test
    void goodMdp() throws ParseException{
        String mdp = "Azertyuiop1-";

        assertEquals(true, MDPManager.checkMdp(mdp));
    }
}

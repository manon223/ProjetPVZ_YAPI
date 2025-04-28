package com.oxyl.epf.Classe;

import static org.junit.jupiter.api.Assertions.*;

public class PlanteTest {

    //@Test
    void testConstructeur1Plante(){
        Plante plante = new Plante("Plante test",100, 1, 20, 75,0.5, "effetTest", "CheminTest");
        assertEquals("Plante test", plante.getNom());
        assertEquals(100, plante.getPointDeVie());
        assertEquals(1, plante.getAttaqueParSeconde());
        assertEquals(20, plante.getDegatAttaque());
        assertEquals(75, plante.getCout());
        assertEquals(0.5, plante.getSoleilParSec());
        assertEquals("effetTest", plante.getEffet());
        assertEquals("CheminTest", plante.getCheminImage());
    }

    //@Test
    void testConstructeur2Plante(){
        Plante plante = new Plante();
        assertEquals("Plante Default", plante.getNom());
        assertEquals(100, plante.getPointDeVie());
        assertEquals(0.5, plante.getAttaqueParSeconde());
        assertEquals(10, plante.getDegatAttaque());
        assertEquals(50, plante.getCout());
        assertEquals(0.5, plante.getSoleilParSec());
        assertEquals("Aucun", plante.getEffet());
        assertEquals("Aucun", plante.getCheminImage());
    }
    //@Test
    void testConstructeur3Plante(){
        Plante plante1 = new Plante();
        Plante plante2 = new Plante(plante1);
        assertEquals("Plante Default", plante2.getNom());
        assertEquals(100, plante2.getPointDeVie());
        assertEquals(0.5, plante2.getAttaqueParSeconde());
        assertEquals(10, plante2.getDegatAttaque());
        assertEquals(50, plante2.getCout());
        assertEquals(0.5, plante2.getSoleilParSec());
        assertEquals("Aucun", plante2.getEffet());
        assertEquals("Aucun", plante2.getCheminImage());
    }
    //@Test
    void testConstructeur4Plante(){
        Plante plante = new Plante(1,"Plante test",100, 1, 20, 75,0.5, "effetTest", "CheminTest");
        assertEquals(1, plante.getId());
        assertEquals("Plante test", plante.getNom());
        assertEquals(100, plante.getPointDeVie());
        assertEquals(1, plante.getAttaqueParSeconde());
        assertEquals(20, plante.getDegatAttaque());
        assertEquals(75, plante.getCout());
        assertEquals(0.5, plante.getSoleilParSec());
        assertEquals("effetTest", plante.getEffet());
        assertEquals("CheminTest", plante.getCheminImage());
    }

    //@Test
    void testSettersGettersPlante(){
        Plante plante = new Plante();
        plante.setNom("Rose");
        plante.setPointDeVie(200);
        plante.setAttaqueParSeconde(3);
        plante.setDegatAttaque(25);
        plante.setCout(55);
        plante.setSoleilParSec(0.2);
        plante.setEffet("effetTest2");
        plante.setCheminImage("CheminTest2");

        assertEquals("Rose", plante.getNom());
        assertEquals(200, plante.getPointDeVie());
        assertEquals(3, plante.getAttaqueParSeconde());
        assertEquals(25, plante.getDegatAttaque());
        assertEquals(55, plante.getCout());
        assertEquals(0.2, plante.getSoleilParSec());
        assertEquals("effetTest2", plante.getEffet());
        assertEquals("CheminTest2", plante.getCheminImage());
    }
}

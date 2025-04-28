package com.oxyl.epf.Classe;

import static org.junit.jupiter.api.Assertions.*;

public class ZombieTest {

    //@Test
    void testConstructeur1Zombie(){
        Zombie zombie = new Zombie("Nom Zombie",100, 1, 20, 2,"CheminTestZ",1);
        assertEquals("Nom Zombie", zombie.getNom());
        assertEquals(100, zombie.getPointDeVie());
        assertEquals(1, zombie.getAttaqueParSeconde());
        assertEquals(20, zombie.getDegatAttaque());
        assertEquals(2, zombie.getVitesseDeplacement());
        assertEquals("CheminTestZ", zombie.getCheminImage());
        assertEquals(1, zombie.getIdMap());
    }
    //@Test
    void testConstructeur2Zombie(){
        Zombie zombie = new Zombie();
        assertEquals( "Zombie de base", zombie.getNom());
        assertEquals(100, zombie.getPointDeVie());
        assertEquals(0.5, zombie.getAttaqueParSeconde());
        assertEquals(10, zombie.getDegatAttaque());
        assertEquals(1.0, zombie.getVitesseDeplacement());
        assertEquals(" ", zombie.getCheminImage());
        assertEquals(1, zombie.getIdMap());
    }
    //@Test
    void testConstructeur3Zombie(){
        Zombie zombie1 = new Zombie();
        Zombie zombie2 = new Zombie(zombie1);
        assertEquals( "Zombie de base", zombie2.getNom());
        assertEquals(100, zombie2.getPointDeVie());
        assertEquals(0.5, zombie2.getAttaqueParSeconde());
        assertEquals(10, zombie2.getDegatAttaque());
        assertEquals(1.0, zombie2.getVitesseDeplacement());
        assertEquals(" ", zombie2.getCheminImage());
        assertEquals(1, zombie2.getIdMap());
    }

    //@Test
    void testSettersGettersZombie(){
        Zombie zombie = new Zombie();
        zombie.setNom("Violette");
        zombie.setPointDeVie(200);
        zombie.setAttaqueParSeconde(3);
        zombie.setDegatAttaque(25);
        zombie.setVitesseDeplacement(4);
        zombie.setCheminImage("CheminTestZ2");
        zombie.setIdMap(1);

        assertEquals("Violette", zombie.getNom());
        assertEquals(200, zombie.getPointDeVie());
        assertEquals(3, zombie.getAttaqueParSeconde());
        assertEquals(25, zombie.getDegatAttaque());
        assertEquals(4, zombie.getVitesseDeplacement());
        assertEquals("CheminTestZ2", zombie.getCheminImage());
        assertEquals(1, zombie.getIdMap());
    }
}

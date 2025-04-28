package com.oxyl.epf.Classe;

import static org.junit.jupiter.api.Assertions.*;

public class MapTest {

    //@Test
    void testConstructeur1Map(){
        Map map = new Map(4,5,"CheminTestMap");
        assertEquals(4, map.getLigne());
        assertEquals(5, map.getColonne());
        assertEquals("CheminTestMap", map.getCheminImage());
    }
    //@Test
    void testConstructeur2Map(){
        Map map = new Map(1, 4,5,"CheminTestMap");
        assertEquals(1, map.getId());
        assertEquals(5, map.getLigne());
        assertEquals(9, map.getColonne());
        assertEquals(" ", map.getCheminImage());
    }
   //@Test
    void testConstructeur3Map(){
        Map map = new Map();
        assertEquals(5, map.getLigne());
        assertEquals(9, map.getColonne());
        assertEquals(" ", map.getCheminImage());
    }
    //@Test
    void testConstructeur4Map(){
        Map map1 = new Map();
        Map map2 =new Map (map1);
        assertEquals(5, map2.getLigne());
        assertEquals(9, map2.getColonne());
        assertEquals(" ", map2.getCheminImage());
    }
    //@Test
    void testSettersGettersMap(){
        Map map = new Map();
        map.setLigne(5);
        map.setColonne(6);
        map.setCheminImage("CheminTestMap2");

        assertEquals(5, map.getLigne());
        assertEquals(6, map.getColonne());
        assertEquals("CheminTestMap2", map.getCheminImage());
    }
}

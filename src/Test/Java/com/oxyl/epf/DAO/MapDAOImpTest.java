package com.oxyl.epf.DAO;
import static org.junit.jupiter.api.Assertions.*;

import com.oxyl.epf.Classe.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

public class MapDAOImpTest {

    private JdbcTemplate JdbcTemplate;
    private MapDAOImp mapDAO;

    @BeforeEach
    public void setUp() {
        // Connexion à la base de données MySQL
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/pvz");  // Remplace par l'URL de ta base de données
        dataSource.setUsername("epf");  // Remplace par ton nom d'utilisateur MySQL
        dataSource.setPassword("mot_de_passe");  // Remplace par ton mot de passe MySQL

        JdbcTemplate = new JdbcTemplate(dataSource);
        mapDAO = new MapDAOImp(JdbcTemplate);
    }
    //@Test
    public void testCreateMap() {
        Map map = new Map(4,6,"image1");
        // Créer la plante dans la base de données
        mapDAO.createMap(map);
        //Vérifier si la plante a bien été insérée
        Map result = mapDAO.getMap(8);
        assertNotNull(result);
        assertEquals(map.getLigne(), result.getLigne());
        assertEquals(map.getColonne(), result.getColonne());
        assertEquals(map.getCheminImage(), result.getCheminImage());
    }
    //@Test
    public void testGetMap() {
        Map result = mapDAO.getMap(2);
        assertNotNull(result);
        assertEquals(6, result.getLigne());
        assertEquals(9, result.getColonne());
        assertEquals("images/map/gazon.png", result.getCheminImage());

    }
    //@Test
    public void testGetAllMap() {
        List<Map> liste_map = mapDAO.getAllMap();
        assertNotNull(liste_map);
        assertFalse(liste_map.isEmpty());

        assertEquals(5, liste_map.get(0).getLigne());
        assertEquals(9, liste_map.get(0).getColonne());
        assertEquals("images/map/gazon.png", liste_map.get(0).getCheminImage());

        assertEquals(6, liste_map.get(1).getLigne());
        assertEquals(9, liste_map.get(1).getColonne());
        assertEquals("images/map/gazon.png", liste_map.get(1).getCheminImage());

        assertEquals(4, liste_map.get(2).getLigne());
        assertEquals(8, liste_map.get(2).getColonne());
        assertEquals("images/map/gazon.png", liste_map.get(2).getCheminImage());

    }
    //@Test
    public void testDeleteMap(){
        Map map = mapDAO.getMap(3);
        assertNotNull(map);
        mapDAO.deleteMap(3);
        Map map_supp = null;
        try {
            map_supp = mapDAO.getMap(3);
        } catch (Exception e){
            assertNull(map_supp);
        }
    }
    //@Test
    public  void testUpdatePlante() {
        Map map = mapDAO.getMap(2);
        map.setColonne(8);
        mapDAO.updateMap(map);
        Map result = mapDAO.getMap(2);
        assertNotNull(result);
        assertEquals(6, result.getLigne());
        assertEquals(8, result.getColonne());
        assertEquals(" images/map/gazon.png", result.getCheminImage());
    }
}

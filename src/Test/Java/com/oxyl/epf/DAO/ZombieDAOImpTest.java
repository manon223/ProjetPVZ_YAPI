package com.oxyl.epf.DAO;
import static org.junit.jupiter.api.Assertions.*;

import com.oxyl.epf.Classe.Zombie;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

public class ZombieDAOImpTest {

    private JdbcTemplate JdbcTemplate;
    private ZombieDAOImp zombieDAO;

    @BeforeEach
    public void setUp() {
        // Connexion à la base de données MySQL
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/pvz");  // Remplace par l'URL de ta base de données
        dataSource.setUsername("epf");  // Remplace par ton nom d'utilisateur MySQL
        dataSource.setPassword("mot_de_passe");  // Remplace par ton mot de passe MySQL

        JdbcTemplate = new JdbcTemplate(dataSource);
        zombieDAO = new ZombieDAOImp(JdbcTemplate);
    }
    //@Test
    public void testCreateZombie(){
        Zombie zombie = new Zombie("Zombie 2", 150, 0.8, 10, 0.5,"image", 2);
        // Créer la plante dans la base de données
        zombieDAO.createZombie(zombie);
        //Vérifier si la plante a bien été insérée
        Zombie result = zombieDAO.getZombie(7);
        assertNotNull(result);
        assertEquals(zombie.getNom(), result.getNom());

    }
    //@Test
    public void testGetZombie() {
        Zombie result = zombieDAO.getZombie(5);
        assertNotNull(result);
        assertEquals("Football Zombie", result.getNom());
        assertEquals(250, result.getPointDeVie());
        assertEquals(0.90, result.getAttaqueParSeconde());
        assertEquals(12, result.getDegatAttaque());
        assertEquals(0.60, result.getVitesseDeplacement());
        assertEquals("images/zombie/football.png", result.getCheminImage());
        assertEquals(3, result.getIdMap());
    }
    //@Test
    public void testGetAllPlante() {
        List<Zombie> liste_zombies = zombieDAO.getAllZombie();
        assertNotNull(liste_zombies);
        assertFalse(liste_zombies.isEmpty());

        assertEquals("Zombie Cone", liste_zombies.get(1).getNom());
        assertEquals(200, liste_zombies.get(1).getPointDeVie());
        assertEquals(0.80, liste_zombies.get(1).getAttaqueParSeconde());
        assertEquals(10, liste_zombies.get(1).getDegatAttaque());
        assertEquals(0.45, liste_zombies.get(1).getVitesseDeplacement());
        assertEquals("images/zombie/conehead.png", liste_zombies.get(1).getCheminImage());
        assertEquals(1, liste_zombies.get(1).getIdMap());

        assertEquals("Football Zombie", liste_zombies.get(4).getNom());
        assertEquals(250, liste_zombies.get(4).getPointDeVie());
        assertEquals(0.9, liste_zombies.get(4).getAttaqueParSeconde());
        assertEquals(12, liste_zombies.get(4).getDegatAttaque());
        assertEquals(0.60, liste_zombies.get(4).getVitesseDeplacement());
        assertEquals("images/zombie/football.png", liste_zombies.get(4).getCheminImage());
        assertEquals(3, liste_zombies.get(4).getIdMap());
    }
    //@Test
    public void testDeleteZombie(){
        Zombie zombie = zombieDAO.getZombie(6);
        assertNotNull(zombie);
        zombieDAO.deleteZombie(6);
        Zombie zombie_supp = null;
        try {
            zombie_supp = zombieDAO.getZombie(7);
        } catch (Exception e){
            assertNull(zombie_supp);
        }
    }
    //@Test
    public  void testUpdatePlante(){
        Zombie zombie = zombieDAO.getZombie(6);
        zombie.setNom("Zombie 1");
        zombieDAO.updateZombie(zombie);
        Zombie result = zombieDAO.getZombie(6);

        assertEquals("Zombie 1", result.getNom());
        assertEquals(150, result.getPointDeVie());
        assertEquals(0.80, result.getAttaqueParSeconde());
        assertEquals(10, result.getDegatAttaque());
        assertEquals(0.50, result.getVitesseDeplacement());
        assertEquals("image", result.getCheminImage());
        assertEquals(2, result.getIdMap());

    }
    //@Test
    public  void testGetZombieMap(){
        List <Zombie> liste_zombies = zombieDAO.getZombieMap(2);
        assertNotNull(liste_zombies);
        assertFalse(liste_zombies.isEmpty());
        assertEquals("Runner Zombie", liste_zombies.get(0).getNom());
        assertEquals(80, liste_zombies.get(0).getPointDeVie());
        assertEquals(1.00, liste_zombies.get(0).getAttaqueParSeconde());
        assertEquals(8, liste_zombies.get(0).getDegatAttaque());
        assertEquals(0.70, liste_zombies.get(0).getVitesseDeplacement());
        assertEquals("images/zombie/runner.png", liste_zombies.get(0).getCheminImage());
        assertEquals(2, liste_zombies.get(0).getIdMap());

        assertEquals("Zombie 1", liste_zombies.get(1).getNom());
        assertEquals(150, liste_zombies.get(1).getPointDeVie());
        assertEquals(0.80, liste_zombies.get(1).getAttaqueParSeconde());
        assertEquals(10, liste_zombies.get(1).getDegatAttaque());
        assertEquals(0.50, liste_zombies.get(1).getVitesseDeplacement());
        assertEquals("image", liste_zombies.get(1).getCheminImage());
        assertEquals(2, liste_zombies.get(1).getIdMap());

    }
}

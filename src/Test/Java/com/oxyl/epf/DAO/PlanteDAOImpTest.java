package com.oxyl.epf.DAO;
import static org.junit.jupiter.api.Assertions.*;

import com.oxyl.epf.Classe.Plante;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

public class PlanteDAOImpTest {
    private JdbcTemplate JdbcTemplate;
    private PlanteDAOImp planteDAO;

    @BeforeEach
    public void setUp() {
        // Connexion à la base de données MySQL
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/pvz");  // Remplace par l'URL de ta base de données
        dataSource.setUsername("epf");  // Remplace par ton nom d'utilisateur MySQL
        dataSource.setPassword("mot_de_passe");  // Remplace par ton mot de passe MySQL

        JdbcTemplate = new JdbcTemplate(dataSource);
        planteDAO = new PlanteDAOImp(JdbcTemplate);
    }

    //@Test
    public void testCreatePlante() {
        Plante plante = new Plante("PlanteTest2", 150, 2.0, 25, 50,0.5, "normal", "image");
        // Créer la plante dans la base de données
        planteDAO.createPlante(plante);
        //Vérifier si la plante a bien été insérée
        Plante result = planteDAO.getPlante(24);
        assertNotNull(result);
        assertEquals(plante.getNom(), result.getNom());
    }
    //@Test
    public void testGetPlante() {
        Plante result = planteDAO.getPlante(2);
        assertNotNull(result);
        assertEquals("Pois Tireur ", result.getNom());
        assertEquals(150, result.getPointDeVie());
        assertEquals(1.50, result.getAttaqueParSeconde());
        assertEquals(20, result.getDegatAttaque());
        assertEquals(100, result.getCout());
        assertEquals(0.00, result.getSoleilParSec());
        assertEquals("normal", result.getEffet());
        assertEquals("images/plante/poistireur.png", result.getCheminImage());
    }
    //@Test
    public void testGetAllPlante() {
        List<Plante> liste_plantes = planteDAO.getAllPlante();
        assertNotNull(liste_plantes);
        assertFalse(liste_plantes.isEmpty());

        assertEquals("Pois Tireur", liste_plantes.get(1).getNom());
        assertEquals(150, liste_plantes.get(1).getPointDeVie());
        assertEquals(1.50, liste_plantes.get(1).getAttaqueParSeconde());
        assertEquals(20, liste_plantes.get(1).getDegatAttaque());
        assertEquals(100, liste_plantes.get(1).getCout());
        assertEquals(0.00, liste_plantes.get(1).getSoleilParSec());
        assertEquals("normal", liste_plantes.get(1).getEffet());
        assertEquals("images/plante/poistireur.png", liste_plantes.get(1).getCheminImage());

        assertEquals("Noix", liste_plantes.get(4).getNom());
        assertEquals(300, liste_plantes.get(4).getPointDeVie());
        assertEquals(0.00, liste_plantes.get(4).getAttaqueParSeconde());
        assertEquals(0, liste_plantes.get(4).getDegatAttaque());
        assertEquals(50, liste_plantes.get(4).getCout());
        assertEquals(0.00, liste_plantes.get(4).getSoleilParSec());
        assertEquals("normal", liste_plantes.get(4).getEffet());
        assertEquals("images/plante/noix.png", liste_plantes.get(4).getCheminImage());
    }

    //@Test
    public void testDeletePlante(){
        Plante plante = planteDAO.getPlante(25);
        assertNotNull(plante);
        planteDAO.deletePlante(25);
        Plante plante_supp = null;
        try {
            plante_supp = planteDAO.getPlante(25);
        } catch (Exception e){
            assertNull(plante_supp);
        }
    }

    //@Test
    public  void testUpdatePlante(){
        Plante plante = planteDAO.getPlante(24);
        plante.setNom("Plante NouveauNom");
        planteDAO.updatePlante(plante);
        Plante result = planteDAO.getPlante(24);
        assertNotNull(result);
        assertEquals("Plante NouveauNom", result.getNom());
        assertEquals(150, result.getPointDeVie());
        assertEquals(2.00, result.getAttaqueParSeconde());
        assertEquals(25, result.getDegatAttaque());
        assertEquals(50, result.getCout());
        assertEquals(0.50, result.getSoleilParSec());
        assertEquals("normal", result.getEffet());
        assertEquals("image", result.getCheminImage());
    }

}

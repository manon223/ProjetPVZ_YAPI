package com.oxyl.epf.DAO;
import com.oxyl.epf.Classe.Plante;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlanteDAOImp implements PlanteDAO {
    private final JdbcTemplate jdbcTemplate;

    //Constructeur
    public PlanteDAOImp(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate= jdbcTemplate;
    }

    private RowMapper<Plante> planteRowMapper = (rs, rowNum) -> new Plante(
            rs.getInt("id_plante"),
            rs.getString("nom"),
            rs.getInt("point_de_vie"),
            rs.getDouble("attaque_par_seconde"),
            rs.getInt("degat_attaque"),
            rs.getInt("cout"),
            rs.getDouble("soleil_par_seconde"),
            rs.getString("effet"),
            rs.getString("chemin_image")
    );

    @Override
    public void createPlante(Plante plante) {
        // La requête SQL pour insérer une nouvelle plante dans la base de données
        String sql = "INSERT INTO plante (nom, point_de_vie, attaque_par_seconde, degat_attaque, cout,soleil_par_seconde, effet, chemin_image) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, plante.getNom(), plante.getPointDeVie(), plante.getAttaqueParSeconde(), plante.getDegatAttaque(), plante.getCout(), plante.getSoleilParSec() ,plante.getEffet(), plante.getCheminImage());
    }

    @Override
    public Plante getPlante(int idPlante) {
        String sql = "SELECT * FROM plante WHERE id_plante = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{idPlante}, planteRowMapper);// (requête sql, paramètre à insérer dans requête, rowmapper qui convertit résultat requête en obket zombie
    }

    @Override
    public List<Plante> getAllPlante() {
        String sql ="SELECT * FROM Plante";
        return jdbcTemplate.query(sql, planteRowMapper);
    }

    @Override
    public void updatePlante(Plante plante1) {
        String sql ="UPDATE Plante SET nom = ?, point_de_vie = ?, attaque_par_seconde = ?, degat_attaque = ?, cout = ?, soleil_par_seconde = ?,  effet = ?, chemin_image = ? WHERE id_plante = ? ";
        jdbcTemplate.update(sql, plante1.getNom(), plante1.getPointDeVie(), plante1.getAttaqueParSeconde(), plante1.getDegatAttaque(), plante1.getCout(), plante1.getSoleilParSec() ,plante1.getEffet(), plante1.getCheminImage(), plante1.getId());
    }

    @Override
    public void deletePlante(int id) {
        String sql = "DELETE FROM plante WHERE id_plante = ?";
        jdbcTemplate.update(sql, id);
    }
}

package com.oxyl.epf.DAO;

import com.oxyl.epf.Classe.Map;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MapDAOImp implements MapDAO {
    private final JdbcTemplate jdbcTemplate;

    // Constructeur pour injecter JdbcTemplate
    public MapDAOImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // RowMapper pour convertir les résultats de la requête en objets Map
    private RowMapper<Map> mapRowMapper = (rs, rowNum) -> new Map(
            rs.getInt("id_map"),
            rs.getInt("ligne"),
            rs.getInt("colonne"),
            rs.getString("chemin_image")
    );

    // Méthode pour créer une nouvelle Map
    @Override
    public void createMap(Map map) {
        String sql = "INSERT INTO Map (ligne, colonne, chemin_image) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, map.getLigne(), map.getColonne(), map.getCheminImage());
    }

    // Méthode pour obtenir une Map par son id
    @Override
    public Map getMap(int idMap) {
        String sql = "SELECT * FROM Map WHERE id_map = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{idMap}, mapRowMapper);
    }

    // Méthode pour obtenir toutes les Maps
    @Override
    public List<Map> getAllMap() {
        String sql = "SELECT * FROM Map";
        return jdbcTemplate.query(sql, mapRowMapper);
    }

    // Méthode pour mettre à jour une Map
    @Override
    public void updateMap(Map map) {
        String sql = "UPDATE Map SET ligne = ?, colonne = ?, chemin_image = ? WHERE id_map = ?";
        jdbcTemplate.update(sql, map.getLigne(), map.getColonne(), map.getCheminImage(), map.getId());
    }

    // Méthode pour supprimer une Map
    @Override
    public void deleteMap(int id ) {
        String update_map_zombies = "UPDATE Zombie SET id_map = NULL WHERE id_map = ?";
        String sql = "DELETE FROM Map WHERE id_map = ?";

        jdbcTemplate.update(update_map_zombies, id);
        jdbcTemplate.update(sql, id);
    }
}


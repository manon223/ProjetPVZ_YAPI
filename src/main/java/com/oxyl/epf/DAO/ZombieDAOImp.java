package com.oxyl.epf.DAO;

import java.util.List;

import com.oxyl.epf.Classe.Zombie;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class ZombieDAOImp implements ZombieDAO {
    private final JdbcTemplate jdbcTemplate;

    //Constructeur
    public ZombieDAOImp(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate= jdbcTemplate;
    }
    private RowMapper<Zombie> zombieRowMapper = (rs, rowNum) -> new Zombie(
            rs.getInt("id_zombie"),
            rs.getString("nom"),
            rs.getInt("point_de_vie"),
            rs.getDouble("attaque_par_seconde"),
            rs.getInt("degat_attaque"),
            rs.getDouble("vitesse_de_deplacement"),
            rs.getString("chemin_image"),
            rs.getInt("id_map")
    );

    @Override
    public void createZombie(Zombie zombie) {
        String sql ="INSERT INTO Zombie (nom, point_de_vie, attaque_par_seconde, degat_attaque, vitesse_de_deplacement, chemin_image, id_map) VALUES (?, ?, ?, ?, ?, ?,?)";
        jdbcTemplate.update(sql, zombie.getNom(), zombie.getPointDeVie(), zombie.getAttaqueParSeconde(), zombie.getDegatAttaque(), zombie.getVitesseDeplacement(), zombie.getCheminImage(), zombie.getIdMap());
    }

    @Override
    public Zombie getZombie(int idZombie) {
        String sql = "SELECT * FROM Zombie WHERE id_zombie= ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{idZombie}, zombieRowMapper);// (requête sql, paramètre à insérer dans requête, rowmapper qui convertit résultat requête en obket zombie
    }

    @Override
    public List<Zombie> getAllZombie() {
        String sql ="SELECT * FROM Zombie";
        return jdbcTemplate.query(sql, zombieRowMapper);
    }

    @Override
    public void updateZombie(Zombie zombie1) {
        String sql ="UPDATE Zombie SET nom = ?, point_de_vie = ?, attaque_par_seconde = ?, degat_attaque = ?, vitesse_de_deplacement = ?, chemin_image = ?, id_map = ? WHERE id_zombie = ? ";
        jdbcTemplate.update(sql, zombie1.getNom(), zombie1.getPointDeVie(), zombie1.getAttaqueParSeconde(), zombie1.getDegatAttaque(), zombie1.getVitesseDeplacement(), zombie1.getCheminImage(), zombie1.getIdMap(), zombie1.getId());
    }

    @Override
    public void deleteZombie(int id) {
        String sql = "DELETE FROM Zombie WHERE id_zombie = ? ";
        jdbcTemplate.update(sql, id);
    }
    @Override
    public List<Zombie> getZombieMap(int idMap) {
        String sql = "SELECT * FROM Zombie WHERE id_map = ?";
        return jdbcTemplate.query(sql, new Object[]{idMap}, zombieRowMapper);
    }
}

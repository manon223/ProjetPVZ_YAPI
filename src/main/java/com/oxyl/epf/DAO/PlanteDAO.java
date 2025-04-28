package com.oxyl.epf.DAO;
import com.oxyl.epf.Classe.Plante;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlanteDAO {
    void createPlante(Plante plante);
    Plante getPlante(int idPlante);
    List<Plante> getAllPlante();
    void updatePlante(Plante plante);
    void deletePlante(int id);
}

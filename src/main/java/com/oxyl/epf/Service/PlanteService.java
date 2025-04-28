package com.oxyl.epf.Service;

import com.oxyl.epf.Classe.Plante;

import java.util.List;

public interface PlanteService {

    void creaPlante(Plante plante);
    Plante recupPlante(int idPlante);
    List<Plante> recupAllPlante();
    void modifPlante(Plante plante);
    void suppPlante(int id);
}

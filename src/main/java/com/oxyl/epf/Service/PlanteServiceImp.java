package com.oxyl.epf.Service;

import com.oxyl.epf.Classe.Plante;
import com.oxyl.epf.DAO.PlanteDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PlanteServiceImp implements PlanteService {
    @Autowired
    private final PlanteDAO planteDAO;

    //Constructeur
    public PlanteServiceImp(PlanteDAO planteDAO) {
        this.planteDAO = planteDAO;
    }

    @Override
    public void creaPlante(Plante plante) {
        planteDAO.createPlante(plante);
    }

    @Override
    public Plante recupPlante(int idPlante) {
        return planteDAO.getPlante(idPlante);
    }

    @Override
    public List<Plante> recupAllPlante() {
        return planteDAO.getAllPlante();
    }

    @Override
    public void modifPlante(Plante plante) {
        planteDAO.updatePlante(plante);
    }

    @Override
    public void suppPlante(int id) {
        planteDAO.deletePlante(id);
    }
}

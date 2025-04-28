package com.oxyl.epf.Controller;

import com.oxyl.epf.Classe.Plante;
import com.oxyl.epf.DTO.PlanteDTO;
import com.oxyl.epf.Service.PlanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plantes")
public class PlanteController {

    @Autowired
    private PlanteService planteService;

    public PlanteController(PlanteService planteService) {
        this.planteService = planteService;
    }

    //GET
    @GetMapping("{id}")
    public PlanteDTO getPlante(@PathVariable("id") int id) {
        Plante plante = planteService.recupPlante(id);
        return new PlanteDTO(
                plante.getId(),
                plante.getNom(),
                plante.getPointDeVie(),
                plante.getAttaqueParSeconde(),
                plante.getDegatAttaque(),
                plante.getCout(),
                plante.getSoleilParSec(),
                plante.getEffet(),
                plante.getCheminImage()
        );
    }

    //GET ALL
    @GetMapping
    public List<PlanteDTO> getAllPlantes() {
        return planteService.recupAllPlante().stream().map(plante -> new PlanteDTO(
                plante.getId(),
                plante.getNom(),
                plante.getPointDeVie(),
                plante.getAttaqueParSeconde(),
                plante.getDegatAttaque(),
                plante.getCout(),
                plante.getSoleilParSec(),
                plante.getEffet(),
                plante.getCheminImage()
        )).toList();
    }

    // Créer une plante
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createPlante(@RequestBody PlanteDTO planteDTO) {
        Plante plante = new Plante(
                planteDTO.getNom(),
                planteDTO.getPointDeVie(),
                planteDTO.getAttaqueParSeconde(),
                planteDTO.getDegatAttaque(),
                planteDTO.getCout(),
                planteDTO.getSoleilParSec(),
                planteDTO.getEffet(),
                planteDTO.getCheminImage()
        );
        planteService.creaPlante(plante);
    }

    // Modifier une plante
    @PutMapping("/{id}")
    public void updatePlante(@PathVariable("id") int id, @RequestBody PlanteDTO planteDTO) {
        Plante plante = new Plante(
                id,
                planteDTO.getNom(),
                planteDTO.getPointDeVie(),
                planteDTO.getAttaqueParSeconde(),
                planteDTO.getDegatAttaque(),
                planteDTO.getCout(),
                planteDTO.getSoleilParSec(),
                planteDTO.getEffet(),
                planteDTO.getCheminImage()
        );
        planteService.modifPlante(plante);
    }

    // Supprimer une plante
    @DeleteMapping("/{id}")
    public void deletePlante(@PathVariable("id") int id) {
        planteService.suppPlante(id);
    }

}

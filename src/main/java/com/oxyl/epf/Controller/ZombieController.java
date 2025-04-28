package com.oxyl.epf.Controller;

import com.oxyl.epf.Classe.Zombie;
import com.oxyl.epf.DTO.ZombieDTO;
import com.oxyl.epf.Service.ZombieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/zombies") //URL de base
public class ZombieController {

    @Autowired
    private ZombieService zombieService;

    public ZombieController(ZombieService zombieService) {
        this.zombieService = zombieService;
    }

    // Récupérer un zombie par son ID
    @GetMapping("/{id}")
    public ZombieDTO getZombieById(@PathVariable("id") int id) {
        Zombie zombie = zombieService.recupZombie(id);
        return new ZombieDTO(
                zombie.getId(),
                zombie.getNom(),
                zombie.getPointDeVie(),
                zombie.getAttaqueParSeconde(),
                zombie.getDegatAttaque(),
                zombie.getVitesseDeplacement(),
                zombie.getCheminImage(),
                zombie.getIdMap()
        );
    }

    // Récupérer tous les zombies
    @GetMapping
    public List<ZombieDTO> getAllZombies() {
        return zombieService.recupAllZombie().stream()
                .map(zombie -> new ZombieDTO(
                        zombie.getId(),
                        zombie.getNom(),
                        zombie.getPointDeVie(),
                        zombie.getAttaqueParSeconde(),
                        zombie.getDegatAttaque(),
                        zombie.getVitesseDeplacement(),
                        zombie.getCheminImage(),
                        zombie.getIdMap()))
                .toList();
    }

    // Créer un zombie
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createZombie(@RequestBody ZombieDTO zombieDTO) {
        Zombie zombie = new Zombie(
                zombieDTO.getNom(),  // L'ID est généralement généré par la BDD
                zombieDTO.getPointDeVie(),
                zombieDTO.getAttaqueParSeconde(),
                zombieDTO.getDegatAttaque(),
                zombieDTO.getVitesseDeplacement(),
                zombieDTO.getCheminImage(),
                zombieDTO.getIdMap()
        );
        zombieService.creaZombie(zombie);
    }

    // Modifier un zombie
    @PutMapping("/{id}")
    public void updateZombie(@PathVariable("id") int id, @RequestBody ZombieDTO zombieDTO) {
        Zombie zombie = new Zombie(
                id,  // Utilisation de l'ID dans la mise à jour
                zombieDTO.getNom(),
                zombieDTO.getPointDeVie(),
                zombieDTO.getAttaqueParSeconde(),
                zombieDTO.getDegatAttaque(),
                zombieDTO.getVitesseDeplacement(),
                zombieDTO.getCheminImage(),
                zombieDTO.getIdMap()
        );
        zombieService.modifZombie(zombie);
    }

    // Supprimer un zombie
    @DeleteMapping("/{id}")
    public void deleteZombie(@PathVariable("id") int id) {  // Récupérer le zombie à supprimer
        zombieService.suppZombie(id);
    }
}

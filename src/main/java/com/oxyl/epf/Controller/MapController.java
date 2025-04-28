package com.oxyl.epf.Controller;

import com.oxyl.epf.Classe.Map;
import com.oxyl.epf.DTO.MapDTO;
import com.oxyl.epf.Service.MapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/maps")
public class MapController {

    @Autowired
    private MapService mapService;

    public MapController(MapService mapService) {
        this.mapService = mapService;
    }

    // Récupérer une map par ID
    @GetMapping("/{id}")
    public MapDTO getMap(@PathVariable("id") int id) {
        Map map = mapService.recupMap(id);
        return new MapDTO(
                map.getId(),
                map.getLigne(),
                map.getColonne(),
                map.getCheminImage()
        );
    }

    // Récupérer toutes les maps
    @GetMapping
    public List<MapDTO> getAllMaps() {
        return mapService.recupAllMap().stream()
                .map(map -> new MapDTO(
                        map.getId(),
                        map.getLigne(),
                        map.getColonne(),
                        map.getCheminImage()
                ))
                .toList();
    }

    // Créer une map
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createMap(@RequestBody MapDTO mapDTO) {
        Map map = new Map(
                mapDTO.getLigne(),
                mapDTO.getColonne(),
                mapDTO.getCheminImage()
        );
        mapService.creaMap(map);
    }

    // Modifier une map
    @PutMapping("/{id}")
    public void updateMap(@PathVariable("id") int id, @RequestBody MapDTO mapDTO) {
        Map map = new Map(
                id,
                mapDTO.getLigne(),
                mapDTO.getColonne(),
                mapDTO.getCheminImage()
        );
        mapService.modifMap(map);
    }

    // Supprimer une map
    @DeleteMapping("/{id}")
    public void deleteMap(@PathVariable("id") int id) {
        mapService.suppMap(id);
    }
}

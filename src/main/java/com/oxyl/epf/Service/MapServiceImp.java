package com.oxyl.epf.Service;

import com.oxyl.epf.Classe.Map;
import com.oxyl.epf.DAO.MapDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MapServiceImp implements MapService {
    @Autowired
    private final MapDAO mapDAO;

    //Constructeur
    public MapServiceImp(MapDAO mapDAO) {
        this.mapDAO = mapDAO;
    }

    @Override
    public void creaMap(Map map) {
        mapDAO.createMap(map);
    }

    @Override
    public Map recupMap(int idMap) {
        return mapDAO.getMap(idMap);
    }

    @Override
    public List<Map> recupAllMap() {
        return mapDAO.getAllMap();
    }

    @Override
    public void modifMap(Map map) {
        mapDAO.updateMap(map);
    }

    @Override
    public void suppMap(int id) { mapDAO.deleteMap(id);}
}

package com.oxyl.epf.Service;
import com.oxyl.epf.Classe.Map;

import java.util.List;

public interface MapService {

    void creaMap(Map map);
    Map recupMap(int idMap);
    List<Map> recupAllMap();
    void modifMap(Map map);
    void suppMap(int id);

}

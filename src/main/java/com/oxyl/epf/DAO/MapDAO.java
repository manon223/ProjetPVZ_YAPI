package com.oxyl.epf.DAO;

import com.oxyl.epf.Classe.Map;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MapDAO {
    void createMap(Map map);
    Map getMap(int idMap);
    List<Map> getAllMap();
    void updateMap(Map map);
    void deleteMap(int id);
}

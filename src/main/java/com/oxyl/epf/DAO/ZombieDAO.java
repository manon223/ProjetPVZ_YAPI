package com.oxyl.epf.DAO;
import com.oxyl.epf.Classe.Zombie;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ZombieDAO {
    void createZombie(Zombie zombie);
    Zombie getZombie(int idZombie);
    List<Zombie> getAllZombie();
    void updateZombie(Zombie zombie);
    void deleteZombie(int id);
    List <Zombie> getZombieMap(int idMap);
}

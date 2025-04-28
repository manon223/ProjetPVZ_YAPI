package com.oxyl.epf.Service;

import com.oxyl.epf.Classe.Zombie;

import java.util.List;

public interface ZombieService {
    void creaZombie(Zombie zombie);
    Zombie recupZombie(int idZombie);
    List<Zombie> recupAllZombie();
    void modifZombie(Zombie zombie);
    void suppZombie(int id);
    List <Zombie> recupZombieMap(int idMap);

}

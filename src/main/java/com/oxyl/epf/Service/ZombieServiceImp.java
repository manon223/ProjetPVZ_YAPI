package com.oxyl.epf.Service;

import com.oxyl.epf.Classe.Zombie;
import com.oxyl.epf.DAO.ZombieDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZombieServiceImp implements ZombieService {
    @Autowired
    private final ZombieDAO zombieDAO;

    //Constructeur
    public ZombieServiceImp(ZombieDAO zombieDAO) {
        this.zombieDAO = zombieDAO;
    }

    @Override
    public void creaZombie(Zombie zombie) {
        zombieDAO.createZombie(zombie);
    }

    @Override
    public Zombie recupZombie(int idZombie) {
        return zombieDAO.getZombie(idZombie);
    }

    @Override
    public List<Zombie> recupAllZombie() {
        return zombieDAO.getAllZombie();
    }

    @Override
    public void modifZombie(Zombie zombie) {
        zombieDAO.updateZombie(zombie);
    }

    @Override
    public void suppZombie(int id) {
        zombieDAO.deleteZombie(id);
    }

    @Override
    public List<Zombie> recupZombieMap(int idMap) {
        return zombieDAO.getZombieMap(idMap);
    }
}

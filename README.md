# Plantes vs Zombies - Projet Java

Ce projet consiste à développer une API RESTful backend complète permettant la gestion des données liés aux
plantes, aux zombies et aux carts du jeu. 
L'API propose une interface CRUD pour gérer les entités du jeu.

## Technologies utilisées

- Java 21
- Tomcat
- MySQL
- JdbcTemplate
- Maven
- API Servlet : Jakarta Servlet API
- Format de données : JSON

L'API permet de gérer les données des plantes, des zombies et des cartes.

## Configuration de la Base de Donnée
On utilise MySQL pour stocker les données de nos entités. La connexion à la base de données est gérée via Spring JdbcTemplate.
Le fichier ``` DatabaseConfig``` définit deux beans:
- ``` DataSource``` pour la connexion à la BDD
- ``` JdbcTemplate ``` pour éxecuter les requêtes SQL

## Architecture générale 
Chaque entité suit une architecture en couches DAO/Service/Controller :
- **DTO**: transporte les données entre les couches
- **DAO (Interface)**: définit les opérations CRUD
- **Implémentation DAO**: contient les requêtes SQL
- **Service**: gère la logique métier
- **Controller**: expose les endpoints RESTful

## Entité : Zombie
L'entité Zombie représente les zombies du jeu. Chaque zombie a des attributs définits dans la classe ``` Zombie ```

```bash
    private int id;
    private String nom;
    private int pointDeVie;
    private double attaqueParSeconde;
    private int degatAttaque;
    private double vitesseDeplacement;
    private String cheminImage;
    private Integer idMap;
```

### Architecture adoptée
```ZombieDTO``` : Contient les attributs du zombie et transfère les données entre les couches

```ZombieDAO```:Définit les opérations CRUD 
- createZombie 
- getZombie(id)
- getAllZombie 
- updateZombie(id)
- deleteZombie(id)
- getZombieMap(id_map)

```ZombieDAOImp```: Implémente les reqêtes SQL pour MySQL grâce à ```JdbcTemplate```

```ZombieService``` : Contient la logique métier, ici il n'y en a pas

```ZombieController```:Expose les endpoints REST pour manipuler les zombies via HTTTP

## Entité : Plante
L'entité Plante représente les plantes du jeu. Chaque plantes a des attributs définits dans la classe ``` Plante ```

```bash
    private int id;
    private String nom;
    private int pointDeVie;
    private double attaqueParSeconde;
    private int degatAttaque;
    private int cout;
    private double soleilParSec;
    private String effet;
    private String cheminImage;
```

### Architecture adoptée
```PlanteDTO``` : Contient les attributs du zombie et transfère les données entre les couches

```PlanteDAO```:Définit les opérations CRUD
- createPlante()
- getPlante(id)
- getAllPlante()
- updatePlante(id)
- deletePlante(id)

```PlanteDAOImp```: Implémente les reqêtes SQL pour MySQL grâce à ```JdbcTemplate```

```PlanteService``` : Contient la logique métier, ici il n'y en a pas

```PlanteController```:Expose les endpoints REST pour manipuler les plantes via HTTTP

## Entité : Map
L'entité Plante représente les plantes du jeu. Chaque plantes a des attributs définits dans la classe ``` Plante ```

```bash
    private int id;
    private int ligne;
    private int colonne;
    private String cheminImage;
```

### Architecture adoptée
```MapDTO``` : Contient les attributs du zombie et transfère les données entre les couches

```MapDAO```:Définit les opérations CRUD
- createMap()
- getMap(id)
- getAllMap()
- updateMap(id)
- deleteMap(id)

```MapDAOImp```: Implémente les reqêtes SQL pour MySQL grâce à ```JdbcTemplate```
- **Choix technique:** lorsque on supprime une map on remplace tous zombies qui ont un id_map corespondant en modifiant : id_map = null
    ```bash
      // Méthode pour supprimer une Map
      @Override
      public void deleteMap(int id ) {
      String update_map_zombies = "UPDATE Zombie SET id_map = NULL WHERE id_map = ?";
      String sql = "DELETE FROM Map WHERE id_map = ?";
    
            jdbcTemplate.update(update_map_zombies, id);
            jdbcTemplate.update(sql, id);
      }
    ``` 

```MapService``` : Contient la logique métier, ici il n'y en a pas

```MapController```:Expose les endpoints REST pour manipuler les maps via HTTTP

## Endpoints de l'API
 ### Plantes
- ``` GET  /plantes ``` : Récupère toutes les plantes 
- ``` GET  /plantes/{id} ``` : Récupère une plante
- ``` POST  /plantes ``` : Crée une nouvelle plante 
- ``` PUT  /plantes/{id} ``` : Met à jour une plante existante
- ``` DELETE  /plantes/{id} ``` : Supprime une plante

### Zombies
- ``` GET  /zombies ``` : Récupère toutes les zombies
- ``` GET  /zombies/{id} ``` : Récupère un zombie
- ``` POST  /zombies ``` : Crée une nouvelle zombie
- ``` PUT  /zombies/{id} ``` : Met à jour un zombie existant
- ``` DELETE  /zombies/{id} ``` : Supprime un zombie

### Map
- ``` GET  /maps ``` : Récupère toutes les maps
- ``` GET  /maps/{id} ``` : Récupère une map
- ``` POST  /maps ``` : Crée une nouvelle map
- ``` PUT  /maps/{id} ``` : Met à jour une map existante
- ``` DELETE  /maps/{id} ``` : Supprime une map

## Fichiers de Configuration:

```web.xml ``` : Configure les servelts et les filtres pour gérer les requêtes HTTP

```spring-confg.xml ``` : Fournit une configuration Spring en utilisant des annontations pour scanner les composants, configurer les beans et activer Spring MVC

```CorsFilter ``` : Implémentation d'un filtre qui gère les en-têtes CORS pour permettre la communicatopn entre le backend et le frontend

```WebConfig ``` : Fournit une configuration Java pour personnaliser la gestion des CORS et la gestion des ressources statiques





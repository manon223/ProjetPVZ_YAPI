package com.oxyl.epf.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ZombieDTO {
    @JsonProperty("id_zombie")
    private int id;
    @JsonProperty("nom")
    private String nom;
    @JsonProperty("point_de_vie")
    private int pointDeVie;
    @JsonProperty("attaque_par_seconde")
    private double attaqueParSeconde;
    @JsonProperty("degat_attaque")
    private int degatAttaque;
    @JsonProperty("vitesse_de_deplacement")
    private double vitesseDeplacement;
    @JsonProperty("chemin_image")
    private String cheminImage;
    @JsonProperty("id_map")
    private Integer idMap;

    public ZombieDTO(int id, String nom, int pointDeVie, double attaqueParSeconde, int degatAttaque, double vitesseDeplacement, String cheminImage, Integer idMap){
        this.id=id;
        this.nom = nom;
        this.pointDeVie=pointDeVie;
        this.attaqueParSeconde=attaqueParSeconde;
        this.degatAttaque=degatAttaque;
        this.vitesseDeplacement=vitesseDeplacement;
        this.cheminImage=cheminImage;
        this.idMap=idMap;
    }
    public ZombieDTO(){

    }

    //get
    public int getId(){
        return id;
    }
    public int getIdMap(){
        return idMap;
    }
    public String getNom(){
        return nom;
    }
    public int getPointDeVie(){
        return pointDeVie;
    }
    public double getAttaqueParSeconde(){
        return attaqueParSeconde;
    }
    public int getDegatAttaque(){
        return degatAttaque;
    }
    public double getVitesseDeplacement(){
        return vitesseDeplacement;
    }
    public String getCheminImage(){
        return cheminImage;
    }

    //Set
    public void setId(int id) {this.id = id;}
    public void setIdMap(int idMap) {
        this.idMap = idMap;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPointDeVie(int pointDeVie) {
        this.pointDeVie = pointDeVie;
    }

    public void setAttaqueParSeconde(double attaqueParSeconde) {
        this.attaqueParSeconde = attaqueParSeconde;
    }

    public void setDegatAttaque(int degatAttaque) {
        this.degatAttaque = degatAttaque;
    }

    public void setVitesseDeplacement(double vitesseDeplacement) {
        this.vitesseDeplacement = vitesseDeplacement;
    }

    public void setCheminImage(String cheminImage) {
        this.cheminImage = cheminImage;
    }


}

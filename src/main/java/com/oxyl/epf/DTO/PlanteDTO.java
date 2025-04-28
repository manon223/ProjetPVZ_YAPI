package com.oxyl.epf.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PlanteDTO {
    @JsonProperty("id_plante")
    private int id;
    @JsonProperty("nom")
    private String nom;
    @JsonProperty("point_de_vie")
    private int pointDeVie;
    @JsonProperty("attaque_par_seconde")
    private double attaqueParSeconde;
    @JsonProperty("degat_attaque")
    private int degatAttaque;
    @JsonProperty("cout")
    private int cout;
    @JsonProperty("soleil_par_seconde")
    private double soleilParSec;
    @JsonProperty("effet")
    private String effet;
    @JsonProperty("chemin_image")
    private String cheminImage;

    //Constructeur
    public PlanteDTO(int id, String nom, int pointDeVie, double attaqueParSeconde, int degatAttaque, int cout, double soleilParSec, String effet, String cheminImage) {
        this.id = id;
        this.nom = nom;
        this.pointDeVie = pointDeVie;
        this.attaqueParSeconde = attaqueParSeconde;
        this.degatAttaque = degatAttaque;
        this.cout = cout;
        this.soleilParSec = soleilParSec;
        this.effet = effet;
        this.cheminImage = cheminImage;
    }
    public PlanteDTO(){

    }
    // Getters
    public int getId(){
        return id;
    }

    public String getNom() {
        return nom;
    }

    public int getPointDeVie() {
        return pointDeVie;
    }

    public double getAttaqueParSeconde() {
        return attaqueParSeconde;
    }

    public int getDegatAttaque() {
        return degatAttaque;
    }

    public int getCout() {
        return cout;
    }

    public String getEffet() {
        return effet;
    }

    public double getSoleilParSec() {
        return soleilParSec;
    }

    public String getCheminImage() {
        return cheminImage;
    }


    // Setters
    public void setId(int id) {this.id = id;}

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

    public void setCout(int cout) {
        this.cout = cout;
    }

    public void setSoleilParSec(double soleilParSec) {
        this.soleilParSec = soleilParSec;
    }

    public void setEffet(String effet) {
        this.effet = effet;
    }

    public void setCheminImage(String cheminImage) {
        this.cheminImage = cheminImage;
    }

}

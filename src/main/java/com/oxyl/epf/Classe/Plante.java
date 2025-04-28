package com.oxyl.epf.Classe;

public class Plante {
    private int id;
    private String nom;
    private int pointDeVie;
    private double attaqueParSeconde;
    private int degatAttaque;
    private int cout;
    private double soleilParSec;
    private String effet;
    private String cheminImage;

    //Constructeurs
    public Plante(String nom, int pointDeVie, double attaqueParSeconde, int degatAttaque, int cout, double soleilParSec, String effet, String cheminImage) {
        this.nom = nom;
        this.pointDeVie = pointDeVie;
        this.attaqueParSeconde = attaqueParSeconde;
        this.degatAttaque = degatAttaque;
        this.cout = cout;
        this.soleilParSec = soleilParSec;
        this.effet = effet;
        this.cheminImage = cheminImage;
    }
    public Plante(int id, String nom, int pointDeVie, double attaqueParSeconde, int degatAttaque, int cout, double soleilParSec, String effet, String cheminImage) {
        this.id =id;
        this.nom = nom;
        this.pointDeVie = pointDeVie;
        this.attaqueParSeconde = attaqueParSeconde;
        this.degatAttaque = degatAttaque;
        this.cout = cout;
        this.soleilParSec = soleilParSec;
        this.effet = effet;
        this.cheminImage = cheminImage;
    }
    public Plante(){
        this.nom = "Plante Default";
        this.pointDeVie = 100;
        this.attaqueParSeconde = 0.5;
        this.degatAttaque = 10;
        this.cout = 50;
        this.soleilParSec = 0.5;
        this.effet = "Aucun";
        this.cheminImage = "Aucun";
    }
    public Plante(Plante autrePlante) {
        this.nom = autrePlante.nom;
        this.pointDeVie = autrePlante.pointDeVie;
        this.attaqueParSeconde = autrePlante.attaqueParSeconde;
        this.degatAttaque = autrePlante.degatAttaque;
        this.cout = autrePlante.cout;
        this.soleilParSec = autrePlante.soleilParSec;
        this.effet = autrePlante.effet;
        this.cheminImage = autrePlante.cheminImage;
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


    public void setId(int id) {
        this.id = id;
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

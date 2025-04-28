package com.oxyl.epf.Classe;

public class Map {
    private int id;
    private int ligne;
    private int colonne;
    private String cheminImage;

    //Constructeurs
    public Map(int ligne, int colonne, String cheminImage ){
        this.ligne=ligne;
        this.colonne=colonne;
        this.cheminImage=cheminImage;
    }
    public Map(int id, int ligne, int colonne, String cheminImage ){
        this.id=id;
        this.ligne=ligne;
        this.colonne=colonne;
        this.cheminImage=cheminImage;
    }
    public Map(){
        this.ligne=5;
        this.colonne=9;
        this.cheminImage=" ";
    }
    public Map(Map autreMap) {
        this.ligne = autreMap.ligne;
        this.colonne = autreMap.colonne;
        this.cheminImage = autreMap.cheminImage;
    }

    // Getters
    public int getId() {
        return id;
    }
    public int getLigne() {
        return ligne;
    }
    public int getColonne() {
        return colonne;
    }
    public String getCheminImage() {
        return cheminImage;
    }

    // Setters
    public void setLigne(int ligne) {
        this.ligne = ligne;
    }
    public void setColonne(int colonne) {
        this.colonne = colonne;
    }
    public void setCheminImage(String cheminImage) {
        this.cheminImage = cheminImage;
    }

}

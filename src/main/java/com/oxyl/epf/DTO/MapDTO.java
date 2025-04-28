package com.oxyl.epf.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MapDTO {
    @JsonProperty("id_map")
    private int id;
    @JsonProperty("ligne")
    private int ligne;
    @JsonProperty("colonne")
    private int colonne;
    @JsonProperty("chemin_image")
    private String cheminImage;

    //Constructeur
    public MapDTO(int id, int ligne, int colonne, String cheminImage ){
        this.id=id;
        this.ligne=ligne;
        this.colonne=colonne;
        this.cheminImage=cheminImage;
    }
    public MapDTO(){

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

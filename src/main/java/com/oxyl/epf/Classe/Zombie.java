package com.oxyl.epf.Classe;



public class Zombie {
    private int id;
    private String nom;
    private int pointDeVie;
    private double attaqueParSeconde;
    private int degatAttaque;
    private double vitesseDeplacement;
    private String cheminImage;
    private Integer idMap;

    public Zombie(String nom, int pointDeVie, double attaqueParSeconde, int degatAttaque, double vitesseDeplacement, String cheminImage, Integer idMap){
        this.nom = nom;
        this.pointDeVie=pointDeVie;
        this.attaqueParSeconde=attaqueParSeconde;
        this.degatAttaque=degatAttaque;
        this.vitesseDeplacement=vitesseDeplacement;
        this.cheminImage=cheminImage;
        this.idMap=idMap;
    }
    public Zombie(int id, String nom, int pointDeVie, double attaqueParSeconde, int degatAttaque, double vitesseDeplacement, String cheminImage, Integer idMap){
        this.id=id;
        this.nom = nom;
        this.pointDeVie=pointDeVie;
        this.attaqueParSeconde=attaqueParSeconde;
        this.degatAttaque=degatAttaque;
        this.vitesseDeplacement=vitesseDeplacement;
        this.cheminImage=cheminImage;
        this.idMap=idMap;
    }

    public Zombie() {
        this.id = 0;
        this.nom = "Zombie de base";
        this.pointDeVie = 100;
        this.attaqueParSeconde = 0.5;
        this.degatAttaque = 10;
        this.vitesseDeplacement = 1.0;
        this.cheminImage = " ";
        this.idMap=1;
    }

    public Zombie(Zombie autreZombie) {
        this.id = autreZombie.id;
        this.idMap = autreZombie.idMap;
        this.nom = autreZombie.nom;
        this.pointDeVie = autreZombie.pointDeVie;
        this.attaqueParSeconde = autreZombie.attaqueParSeconde;
        this.degatAttaque = autreZombie.degatAttaque;
        this.vitesseDeplacement = autreZombie.vitesseDeplacement;
        this.cheminImage = autreZombie.cheminImage;
        this.idMap = autreZombie.idMap;
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
    //public void setId(int id) {
        //this.id = id;
    //}
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

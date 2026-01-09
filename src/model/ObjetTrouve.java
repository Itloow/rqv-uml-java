package model;

public class ObjetTrouve {

    private String type;
    private String marque;
    private String couleur;
    private String description;

    public ObjetTrouve(String type, String marque, String couleur, String description) {
        this.type = type;
        this.marque = marque;
        this.couleur = couleur;
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public String getMarque() {
        return marque;
    }

    public String getCouleur() {
        return couleur;
    }

    public String getDescription() {
        return description;
    }
}

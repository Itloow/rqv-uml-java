package model;

public class Declarant extends Utilisateur {

    private String numCNI;
    private String adresse;
    private String telephone;

    public Declarant(String nom, String prenom, String numCNI, String adresse, String telephone) {
        super(nom, prenom);
        this.numCNI = numCNI;
        this.adresse = adresse;
        this.telephone = telephone;
    }

    public String getNumCNI() {
        return numCNI;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getTelephone() {
        return telephone;
    }
}

package model;
import java.util.Objects;

public abstract class Utilisateur {
    protected String nom;
    protected String prenom;

    public Utilisateur(String nom, String prenom) {
        this.nom = Objects.requireNonNull(nom, "nom");
        this.prenom = Objects.requireNonNull(prenom, "prenom");
    }

    public String getNom() { return nom; }
    public String getPrenom() { return prenom; }
}
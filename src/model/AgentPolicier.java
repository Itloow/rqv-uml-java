package model;

public class AgentPolicier extends Utilisateur {

    private String matricule;
    private String motDePasse;

    public AgentPolicier(String nom, String prenom, String matricule, String motDePasse) {
        super(nom, prenom);
        this.matricule = matricule;
        this.motDePasse = motDePasse;
    }

    public String getMatricule() {
        return matricule;
    }

    public boolean sAuthentifier(String motDePasseSaisi) {
        return this.motDePasse != null && this.motDePasse.equals(motDePasseSaisi);
    }
}

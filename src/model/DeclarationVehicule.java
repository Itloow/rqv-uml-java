package model;

import java.util.Date;

public class DeclarationVehicule extends Declaration {

    private String matricule;
    private String modele;

    public DeclarationVehicule(Date dateVol, String heureVol, LieuVol lieuVol, RoleDeclarant roleDeclarant, String description, String couleur, String marque, String matricule, String modele) {

        super(dateVol, heureVol, lieuVol, roleDeclarant, description, couleur, marque);
        this.matricule = matricule;
        this.modele = modele;
    }

    public String getMatricule() {
        return matricule;
    }

    public String getModele() {
        return modele;
    }
}

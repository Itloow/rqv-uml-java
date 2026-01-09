package model;

import java.util.Date;

public class DeclarationVelo extends Declaration {

    private String numeroSerie;

    public DeclarationVelo(Date dateVol, String heureVol, LieuVol lieuVol, RoleDeclarant roleDeclarant, String description, String couleur, String marque, String numeroSerie) {
        super(dateVol, heureVol, lieuVol, roleDeclarant, description, couleur, marque);
        this.numeroSerie = numeroSerie;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }
}

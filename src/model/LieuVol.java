package model;

/**
 * Représente le lieu du vol.
 * (rue, ville, code postal + complément optionnel)
 */
public class LieuVol {

    private final String rue;
    private final String ville;
    private final String codePostal;

    public LieuVol(String rue, String ville, String codePostal) {
        this.rue = rue;
        this.ville = ville;
        this.codePostal = codePostal;
    }

    public String getRue() { return rue; }
    public String getVille() { return ville; }
    public String getCodePostal() { return codePostal; }
}

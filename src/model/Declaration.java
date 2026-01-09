package model;

import java.util.Date;

public abstract class Declaration {

    protected int id;
    protected Date dateCreation;
    protected Date dateDerniereModif;
    protected Date dateResolution;

    protected Date dateVol;
    protected String heureVol;
    protected LieuVol lieuVol;

    protected EtatDeclaration etat;
    protected RoleDeclarant roleDeclarant;

    protected String description;
    protected String couleur;
    protected String marque;

    public Declaration(Date dateVol, String heureVol, LieuVol lieuVol, RoleDeclarant roleDeclarant, String description, String couleur, String marque) {

        this.dateVol = dateVol;
        this.heureVol = heureVol;
        this.lieuVol = lieuVol;

        this.roleDeclarant = roleDeclarant;

        this.description = description;
        this.couleur = couleur;
        this.marque = marque;

        this.dateCreation = new Date();
        this.dateDerniereModif = new Date();
        this.etat = EtatDeclaration.BROUILLON; // devient ENREGISTREE quand on valide/sauvegarde
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public Date getDateCreation() { return dateCreation; }
    public Date getDateDerniereModif() { return dateDerniereModif; }
    public Date getDateResolution() { return dateResolution; }

    public EtatDeclaration getEtat() { return etat; }
    public RoleDeclarant getRoleDeclarant() { return roleDeclarant; }

    public String getDescription() { return description; }
    public String getCouleur() { return couleur; }
    public String getMarque() { return marque; }

    /**
     * Modifie la déclaration (on met à jour la description).
     */
    public void editer(String nouvellesInfos) {
        this.description = nouvellesInfos;
        this.dateDerniereModif = new Date();
    }

    /**
     * Sauvegarde/valide la déclaration (passe en ENREGISTREE).
     */
    public void validerSauvegarde() {
        this.etat = EtatDeclaration.ENREGISTREE;
        this.dateDerniereModif = new Date();
    }

    /**
     * Marque la déclaration comme résolue (véhicule retrouvé).
     */
    public void marquerResolue() {
        this.etat = EtatDeclaration.RESOLUE;
        this.dateResolution = new Date();
        this.dateDerniereModif = new Date();
    }
}

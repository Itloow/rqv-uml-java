package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RQV {
    private Date dateRapport;
    private List<Declaration> listeNouvelles;
    private List<Declaration> listeModifiees;
    private List<Declaration> listeResolues;

    public RQV(Date dateRapport) {
        this.dateRapport = dateRapport;
        this.listeNouvelles = new ArrayList<>();
        this.listeModifiees = new ArrayList<>();
        this.listeResolues = new ArrayList<>();
    }

    public Date getDateRapport() {
        return dateRapport;
    }

    public List<Declaration> getListeNouvelles() {
        return listeNouvelles;
    }

    public List<Declaration> getListeModifiees() {
        return listeModifiees;
    }

    public List<Declaration> getListeResolues() {
        return listeResolues;
    }

    public void ajouterNouvelle(Declaration d) { listeNouvelles.add(d); }
    public void ajouterModifiee(Declaration d) { listeModifiees.add(d); }
    public void ajouterResolue(Declaration d) { listeResolues.add(d); }

    public void afficherRapport() {
        System.out.println("\n========== RAPPORT QUOTIDIEN DE VEILLE ==========");
        System.out.println("Date: " + dateRapport);
        System.out.println("\nNouvelles déclarations: " + listeNouvelles.size());
        System.out.println("Déclarations modifiées: " + listeModifiees.size());
        System.out.println("Déclarations résolues: " + listeResolues.size());
        System.out.println("=================================================\n");
    }
}

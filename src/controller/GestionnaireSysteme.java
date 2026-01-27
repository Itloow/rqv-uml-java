package controller;

import model.*;
import pattern_observer.ISujet;
import pattern_observer.IObservateur;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GestionnaireSysteme implements ISujet {

    private List<Declaration> declarations;
    private List<ObjetTrouve> objetsTrouves;
    private List<IObservateur> observateurs;
    private List<Notification> notifications;

    private int nextId;

    public GestionnaireSysteme() {
        this.declarations = new ArrayList<>();
        this.objetsTrouves = new ArrayList<>();
        this.observateurs = new ArrayList<>();
        this.notifications = new ArrayList<>();
        this.nextId = 1;
    }

    public void creerDeclaration(Declaration d, Declarant u) {
        d.validerSauvegarde();
        d.setId(nextId++);
        declarations.add(d);
        enregistrerObs(d);  // On ajoute la déclaration comme observateur
    }

    public RQV genererRQV(Date date) {
        RQV rqv = new RQV(date);

        for (Declaration d : declarations) {
            if (d.getDateCreation().equals(date)) {
                rqv.ajouterNouvelle(d);
            } else if (d.getDateDerniereModif().equals(date)) {
                rqv.ajouterModifiee(d);
            }

            if (d.getDateResolution() != null && d.getDateResolution().equals(date)) {
                rqv.ajouterResolue(d);
            }
        }

        return rqv;
    }

    public void ajouterObjetTrouve(ObjetTrouve o) {
        objetsTrouves.add(o);
        notifierObs(o);  // Déclenche le patron Observer
    }

    /**
     * Ajoute un observateur à la liste.
     */
    public void enregistrerObs(IObservateur o) {
        observateurs.add(o);
    }

    /**
     * Retire un observateur de la liste.
     */
    public void supprimerObs(IObservateur o) {
        observateurs.remove(o);
    }

    /**
     * Notifie les observateurs dont la déclaration correspond à l'objet trouvé.
     */
    public void notifierObs(ObjetTrouve objet) {
        for (IObservateur o : observateurs) {
            Declaration d = (Declaration) o;
            if (d.correspondA(objet)) {
                o.update(objet);
            }
        }
    }

    public List<Declaration> getDeclarations() { return declarations; }
    public List<ObjetTrouve> getObjetsTrouves() { return objetsTrouves; }
    public List<Notification> getNotifications() { return notifications; }
}
package controller;

import model.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GestionnaireSysteme {

    private List<Declaration> declarations;
    private List<ObjetTrouve> objetsTrouves;
    private List<Notification> notifications;

    private int nextId;

    public GestionnaireSysteme() {
        this.declarations = new ArrayList<>();
        this.objetsTrouves = new ArrayList<>();
        this.notifications = new ArrayList<>();
        this.nextId = 1;
    }

    public void creerDeclaration(Declaration d, Declarant u) {
        d.validerSauvegarde();
        d.setId(nextId++);
        declarations.add(d);
    }

    public RQV genererRQV(Date date) {
        RQV rqv = new RQV(date);

        for (Declaration d : declarations) {
            // Version simple : comparaison directe (date + heure)
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
    }

    public List<Declaration> getDeclarations() { return declarations; }
    public List<ObjetTrouve> getObjetsTrouves() { return objetsTrouves; }
    public List<Notification> getNotifications() { return notifications; }
}

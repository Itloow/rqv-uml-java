package controller;

import model.*;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class GestionnaireSystemeTest {

    /**
     * FakeDeclaration permet de contrôler les dates (creation/modif/resolution)
     * pour tester genererRQV() qui compare avec Date.equals().
     */
    private static class FakeDeclaration extends Declaration {
        public FakeDeclaration(Date dateCreation, Date dateDerniereModif, Date dateResolution) {
            super(new Date(), "10:00", new LieuVol("Rue A", "Toulouse", "31000"), RoleDeclarant.VICTIME, "desc", "noir", "marque");

            // on force les dates pour le test
            this.dateCreation = dateCreation;
            this.dateDerniereModif = dateDerniereModif;
            this.dateResolution = dateResolution;
        }
    }

    @Test
    void creerDeclaration_attribue_un_id_et_stocke_la_declaration() {
        GestionnaireSysteme gs = new GestionnaireSysteme();

        Declarant declarant = new Declarant("Martin", "Lea", "CNI123", "Adresse", "0600000000");
        DeclarationVehicule d = new DeclarationVehicule(new Date(), "14:00", new LieuVol("Rue A", "Toulouse", "31000"), RoleDeclarant.VICTIME, "Voiture volée", "Noir", "Peugeot", "AA-123-BB", "208");

        gs.creerDeclaration(d, declarant);

        assertEquals(1, gs.getDeclarations().size());
        assertEquals(1, d.getId());
        assertEquals(EtatDeclaration.ENREGISTREE, d.getEtat());
    }

    @Test
    void genererRQV_remplit_les_listes_selon_les_dates() {
        GestionnaireSysteme gs = new GestionnaireSysteme();

        Date dateRapport = new Date(0);      // 01/01/1970 00:00:00
        Date autreDate = new Date(1000);     // 01/01/1970 00:00:01

        // nouvelle : dateCreation == dateRapport
        FakeDeclaration nouvelle = new FakeDeclaration(dateRapport, autreDate, null);

        // modifiée : dateCreation != dateRapport ET dateDerniereModif == dateRapport
        FakeDeclaration modifiee = new FakeDeclaration(autreDate, dateRapport, null);

        // résolue : dateResolution == dateRapport
        FakeDeclaration resolue = new FakeDeclaration(autreDate, autreDate, dateRapport);

        gs.getDeclarations().add(nouvelle);
        gs.getDeclarations().add(modifiee);
        gs.getDeclarations().add(resolue);

        RQV rqv = gs.genererRQV(dateRapport);

        assertEquals(1, rqv.getListeNouvelles().size());
        assertEquals(1, rqv.getListeModifiees().size());
        assertEquals(1, rqv.getListeResolues().size());
    }

    @Test
    void ajouterObjetTrouve_ajoute_dans_la_liste() {
        GestionnaireSysteme gs = new GestionnaireSysteme();

        ObjetTrouve o = new ObjetTrouve("Vélo", "Decathlon", "Noir", "VTT");
        gs.ajouterObjetTrouve(o);

        assertEquals(1, gs.getObjetsTrouves().size());
        assertEquals("Decathlon", gs.getObjetsTrouves().get(0).getMarque());
    }
}


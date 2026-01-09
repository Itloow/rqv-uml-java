package model;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class RQVTest {

    @Test
    void ajouter_dans_les_listes_change_les_tailles() {
        RQV rqv = new RQV(new Date());

        // On utilise des vraies classes concrètes (pas besoin de Fake)
        DeclarationVehicule d1 = new DeclarationVehicule(
                new Date(), "10:00",
                new LieuVol("Rue A", "Toulouse", "31000"),
                RoleDeclarant.VICTIME,
                "Voiture volée", "Noir", "Peugeot",
                "AA-123-BB", "208"
        );

        DeclarationVelo d2 = new DeclarationVelo(
                new Date(), "11:00",
                new LieuVol("Rue B", "Toulouse", "31000"),
                RoleDeclarant.TEMOIN,
                "Vélo volé", "Rouge", "Decathlon",
                "SERIE-001"
        );

        rqv.ajouterNouvelle(d1);
        rqv.ajouterModifiee(d2);
        rqv.ajouterResolue(d1);

        assertEquals(1, rqv.getListeNouvelles().size());
        assertEquals(1, rqv.getListeModifiees().size());
        assertEquals(1, rqv.getListeResolues().size());
    }

    @Test
    void afficherRapport_ecrit_un_resume_avec_les_bonnes_valeurs() {
        RQV rqv = new RQV(new Date());

        rqv.ajouterNouvelle(new DeclarationVehicule(
                new Date(), "10:00",
                new LieuVol("Rue A", "Toulouse", "31000"),
                RoleDeclarant.VICTIME,
                "Voiture volée", "Noir", "Peugeot",
                "AA-123-BB", "208"
        ));

        // Capture de la sortie console
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream old = System.out;
        System.setOut(new PrintStream(out));

        try {
            rqv.afficherRapport();
        } finally {
            System.setOut(old);
        }

        String s = out.toString();
        assertTrue(s.contains("RAPPORT QUOTIDIEN DE VEILLE"));
        assertTrue(s.contains("Nouvelles déclarations: 1"));
        assertTrue(s.contains("Déclarations modifiées: 0"));
        assertTrue(s.contains("Déclarations résolues: 0"));
    }
}

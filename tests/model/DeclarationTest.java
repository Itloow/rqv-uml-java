package model;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class DeclarationTest {

    // Petite classe concrète juste pour pouvoir instancier Declaration (car abstract)
    private static class FakeDeclaration extends Declaration {
        public FakeDeclaration(Date dateVol, String heureVol, LieuVol lieuVol,
                               RoleDeclarant roleDeclarant,
                               String description, String couleur, String marque) {
            super(dateVol, heureVol, lieuVol, roleDeclarant, description, couleur, marque);
        }
    }

    @Test
    void editer_modifie_description_et_met_a_jour_dateDerniereModif() throws InterruptedException {
        FakeDeclaration d = new FakeDeclaration(
                new Date(), "10:30",
                new LieuVol("Rue A", "Toulouse", "31000"),
                RoleDeclarant.VICTIME,
                "Ancienne", "Noir", "Peugeot"
        );

        Date before = d.getDateDerniereModif();
        Thread.sleep(5); // petit délai pour s'assurer que la date change

        d.editer("Nouvelle description");

        assertEquals("Nouvelle description", d.getDescription());
        assertTrue(d.getDateDerniereModif().after(before));
    }

    @Test
    void validerSauvegarde_passe_enregistree() {
        FakeDeclaration d = new FakeDeclaration(
                new Date(), "10:30",
                new LieuVol("Rue A", "Toulouse", "31000"),
                RoleDeclarant.TEMOIN,
                "Desc", "Bleu", "Renault"
        );

        d.validerSauvegarde();

        assertEquals(EtatDeclaration.ENREGISTREE, d.getEtat());
    }

    @Test
    void marquerResolue_passe_resolue_et_definit_dateResolution() {
        FakeDeclaration d = new FakeDeclaration(
                new Date(), "10:30",
                new LieuVol("Rue A", "Toulouse", "31000"),
                RoleDeclarant.VICTIME_ET_TEMOIN,
                "Desc", "Blanc", "VW"
        );

        d.marquerResolue();

        assertEquals(EtatDeclaration.RESOLUE, d.getEtat());
        assertNotNull(d.getDateResolution());
    }
}

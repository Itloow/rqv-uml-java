import controller.GestionnaireSysteme;
import model.*;

import java.util.Date;

public class Main {

    public static void main(String[] args) {

        System.out.println("=== JEUX DE TEST ===\n");

        // Création du gestionnaire
        GestionnaireSysteme gs = new GestionnaireSysteme();

        // Création d'un déclarant
        Declarant declarant = new Declarant("Martin", "Lea", "CNI123", "Adresse", "0600000000");

        // Création d'un lieu de vol
        LieuVol lieu = new LieuVol("Rue A", "Toulouse", "31000");

        // Création d'une déclaration de vélo volé
        DeclarationVelo d1 = new DeclarationVelo(new Date(), "14:00", lieu, RoleDeclarant.VICTIME, "Mon vélo volé devant la fac", "Rouge", "Decathlon", "SN12345");

        // Création d'une déclaration de véhicule volé
        DeclarationVehicule d2 = new DeclarationVehicule(new Date(), "10:00", lieu, RoleDeclarant.VICTIME, "Voiture volée", "Noir", "Peugeot", "AA-123-BB", "208");

        // On enregistre les déclarations
        gs.creerDeclaration(d1, declarant);
        gs.creerDeclaration(d2, declarant);

        System.out.println("Déclarations créées : " + gs.getDeclarations().size());
        System.out.println();

        // TEST 1 : Objet trouvé qui correspond à d1
        System.out.println("--- Test 1 : On trouve un vélo Rouge Decathlon ---");
        ObjetTrouve o1 = new ObjetTrouve("Vélo", "Decathlon", "Rouge", "VTT trouvé près de la gare");
        gs.ajouterObjetTrouve(o1);
        System.out.println();

        // TEST 2 : Objet trouvé qui ne correspond à rien
        System.out.println("--- Test 2 : On trouve un vélo Bleu Giant (aucune correspondance) ---");
        ObjetTrouve o2 = new ObjetTrouve("Vélo", "Giant", "Bleu", "Vélo trouvé au parc");
        gs.ajouterObjetTrouve(o2);
        System.out.println("Pas de notification (normal)\n");

        // TEST 3 : Objet trouvé qui correspond à d2
        System.out.println("--- Test 3 : On trouve une voiture Noir Peugeot ---");
        ObjetTrouve o3 = new ObjetTrouve("Voiture", "Peugeot", "Noir", "Voiture retrouvée sur un parking");
        gs.ajouterObjetTrouve(o3);
        System.out.println();

        System.out.println("=== FIN DES TESTS ===");
        System.out.println("Nb objets trouvés : " + gs.getObjetsTrouves().size());
    }
}
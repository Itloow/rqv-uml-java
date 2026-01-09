import controller.GestionnaireSysteme;
import model.*;

import java.util.Date;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        GestionnaireSysteme gs = new GestionnaireSysteme();

        Declarant declarant = new Declarant("Martin", "Lea", "CNI123", "Adresse", "0600000000");
        AgentPolicier agent = new AgentPolicier("Dupont", "Alex", "A001", "secret");

        System.out.println("Auth agent (bon mdp) : " + agent.sAuthentifier("secret"));

        LieuVol lieu = new LieuVol("Rue A", "Toulouse", "31000");

        DeclarationVehicule d1 = new DeclarationVehicule(new Date(), "10:00", lieu, RoleDeclarant.VICTIME, "Voiture volée", "Noir", "Peugeot", "AA-123-BB", "208");

        gs.creerDeclaration(d1, declarant);

        RQV rqv = gs.genererRQV(d1.getDateCreation());
        rqv.afficherRapport();

        d1.marquerResolue();

        RQV rqv2 = gs.genererRQV(d1.getDateResolution());
        rqv2.afficherRapport();

        ObjetTrouve o1 = new ObjetTrouve("Vélo", "Decathlon", "Rouge", "VTT trouvé");
        gs.ajouterObjetTrouve(o1);

        System.out.println("Nb objets trouvés : " + gs.getObjetsTrouves().size());
    }
}

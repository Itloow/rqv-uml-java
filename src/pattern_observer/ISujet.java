package pattern_observer;

import model.ObjetTrouve;

// Interface Sujet du patron Observer, le GestionnaireSysteme va l'implémenter
public interface ISujet {

    // Ajoute un observateur à la liste
    void enregistrerObs(IObservateur o);

    // Retire un observateur de la liste
    void supprimerObs(IObservateur o);

    // Notifie tous les observateurs quand un objet est trouvé
    void notifierObs(ObjetTrouve objet);
}
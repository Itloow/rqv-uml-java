package pattern_observer;

import model.ObjetTrouve;

//Interface pour le patron Observer, les déclarations vont implémenter cette interface pour être notifiées
public interface IObservateur {

    // Méthode appelée quand un objet trouvé correspond
    void update(ObjetTrouve objet);
}
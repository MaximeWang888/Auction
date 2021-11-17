package fabriques;

import encheres.interfaces.IUtilisateur;
import encheres.interfaces.fabriques.IFabriqueUtilisateur;
import utilisateurs.Client;
import utilisateurs.Employe;
import utilisateurs.Responsable;

/**
 * Modelise une fabrique d'un utilisateur.
 * @author  Martin-Deep Daryl, Maxime Wang
 * @version 1.0
 */
public class FabriqueUtilisateur implements IFabriqueUtilisateur {

    @Override
    public IUtilisateur fabriqueUtilisateur(String type, String nomUtilisateur) {

        if (nomUtilisateur == null)
            throw new IllegalArgumentException("Le nom utilisateur n'est pas defini");

        switch (type) {

            case "client": {
                return new Client(nomUtilisateur);
            }
            case "employe" : {
                return new Employe(nomUtilisateur, new FabriqueBien());
            }
            case "responsable" : {
                return new Responsable(nomUtilisateur);
            }
            default:
                throw new IllegalArgumentException("Type n'est pas defini");

        }
    }

}

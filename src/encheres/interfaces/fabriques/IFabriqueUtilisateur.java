package encheres.interfaces.fabriques;

import encheres.interfaces.IUtilisateur;

/**
 * L'interface d'une fabrique d'un utilisateur.
 * @author  Martin-Dipp Daryl, Maxime Wang
 * @version 1.0
 */
public interface IFabriqueUtilisateur {

    /**
     * Permet de fabriquer des utilisateurs
     * @param type le type d'utilisateur
     * @param nomUtilisateur le nom d'utilisateur
     * @return
     */
    IUtilisateur fabriqueUtilisateur(String type, String nomUtilisateur);

}

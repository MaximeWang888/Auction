package encheres.interfaces.fabriques;

import encheres.interfaces.IUtilisateur;

public interface IFabriqueUtilisateur {

    /**
     * Permet de fabriquer des utilisateurs
     * @param type le type d'utilisateur
     * @param nomUtilisateur le nom d'utilisateur
     * @return
     */
    IUtilisateur fabriqueUtilisateur(String type, String nomUtilisateur);

}

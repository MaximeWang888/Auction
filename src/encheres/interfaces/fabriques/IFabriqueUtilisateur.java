package encheres.interfaces.fabriques;

import encheres.interfaces.IUtilisateur;

public interface IFabriqueUtilisateur {

    IUtilisateur fabriqueUtilisateur(String type, String nomUtilisateur);

}

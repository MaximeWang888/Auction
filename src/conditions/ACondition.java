package conditions;

import encheres.interfaces.IBien;
import encheres.interfaces.ICondition;

/**
 * Modélise une condition de l'enchere d'un bien
 * @author  Martin-Deep Daryl, Maxime Wang
 * @version 1.0
 */
public abstract class ACondition implements ICondition {

    /**
     * Represente un bien
     */
    private IBien bien;

    /**
     * Constructeur d'une condition à partir d'un bien
     * @param bien le bien
     */
    public ACondition(IBien bien) {
        this.bien = bien;
    }

    /**
     * Permet de connaître le bien
     * @return le bien
     */
    public IBien getBien() {
        return bien;
    }

}

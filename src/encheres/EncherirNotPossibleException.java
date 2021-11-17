package encheres;

/**
 * L'erreur envoye lorsque l'encherissement d'un bien est impossible.
 * @author  Martin-Deep Daryl, Maxime Wang
 * @version 1.0
 */
public class EncherirNotPossibleException extends Exception{

    /**
     * Message d'erreur lorsque qu'un encherissement est impossible
     * @param errorMessage le message de l'erreur
     */
    public EncherirNotPossibleException(String errorMessage) {
        super(errorMessage);
    }
}

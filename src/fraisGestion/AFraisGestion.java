package fraisGestion;

public abstract class AFraisGestion implements IFraisGestion {
    public static IFraisGestion fraisGestionActuel() {
        return new FraisGestion10et5();
    }
}

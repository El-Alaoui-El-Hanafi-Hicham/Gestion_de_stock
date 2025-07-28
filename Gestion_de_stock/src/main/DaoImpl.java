package main;

public class DaoImpl implements IDao {
    @Override
    public double getData() {
        /*
         * Version simple qui retourne une valeur statique
         * En réalité, on pourrait se connecter à une base de données
         */
        return 10;
    }
}
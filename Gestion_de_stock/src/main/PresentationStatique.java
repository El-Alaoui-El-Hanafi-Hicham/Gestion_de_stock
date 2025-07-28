package main;

public class PresentationStatique {
    public static void main(String[] args) {
        IDao dao = new DaoImpl();
        MetierImpl metier = new MetierImpl();
        metier.setDao(dao);
        System.out.println("Résultat: " + metier.calcul());
    }
}
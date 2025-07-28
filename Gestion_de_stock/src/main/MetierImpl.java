package main;

public class MetierImpl implements IMetier {
    private IDao dao; // Couplage faible

    @Override
    public double calcul() {
        double data = dao.getData();
        return data * 10;
    }

    public void setDao(IDao dao) {
        this.dao = dao;
    }
}
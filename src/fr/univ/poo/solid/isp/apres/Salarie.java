package fr.univ.poo.solid.isp.apres;

public class Salarie implements Payable, Pointable, EligibleConges {
    private final String nom;
    private final double salaireBase;
    private int heures = 0, joursConges = 25;

    public Salarie(String nom, double salaireBase) {
        this.nom = nom; this.salaireBase = salaireBase;
    }
    public String getNom() { return nom; }
    public double calculerSalaireMensuel() { return salaireBase * 0.95; }
    public void pointer(int h) { heures += h; }
    public void poserConges(int jours) { joursConges -= jours; }
}

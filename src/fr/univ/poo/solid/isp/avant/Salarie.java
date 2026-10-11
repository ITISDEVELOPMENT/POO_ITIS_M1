package fr.univ.poo.solid.isp.avant;

public class Salarie implements Collaborateur {
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

    // Un salarié ne facture pas... mais on DOIT écrire la méthode
    public double emettreFacture(int jours) {
        throw new UnsupportedOperationException();
    }
}

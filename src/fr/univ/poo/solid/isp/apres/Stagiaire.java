package fr.univ.poo.solid.isp.apres;

public class Stagiaire implements Payable, Pointable {
    private final String nom;
    private int heures = 0;

    public Stagiaire(String nom) { this.nom = nom; }
    public String getNom() { return nom; }
    public double calculerSalaireMensuel() { return 650.0; } // gratification
    public void pointer(int h) { heures += h; }
}

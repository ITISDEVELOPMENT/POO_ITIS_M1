package fr.univ.poo.solid.lsp.apres;

public class Salarie implements Remunerable {
    private final String nom;
    private final double salaireBase;
    private double primes = 0;

    public Salarie(String nom, double salaireBase) {
        this.nom = nom;
        this.salaireBase = salaireBase;
    }

    @Override public String getNom() { return nom; }

    @Override public void verserPrime(double montant) { primes += montant; }

    @Override public double calculerSalaireNet() {
        return (salaireBase + primes) * 0.95;
    }
}

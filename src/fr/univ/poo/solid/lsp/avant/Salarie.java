package fr.univ.poo.solid.lsp.avant;

public class Salarie {
    protected final String nom;
    protected double salaireBase;
    protected double primes = 0;

    public Salarie(String nom, double salaireBase) {
        this.nom = nom;
        this.salaireBase = salaireBase;
    }

    public void verserPrime(double montant) { primes += montant; }

    public double calculerSalaireNet() {
        return (salaireBase + primes) * 0.95;
    }

    public String getNom() { return nom; }
}

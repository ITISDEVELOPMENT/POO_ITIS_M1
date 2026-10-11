package fr.univ.poo.solid.isp.apres;

public class Freelance implements Facturable {
    private final String nom;
    private final double tauxJournalier;

    public Freelance(String nom, double tauxJournalier) {
        this.nom = nom; this.tauxJournalier = tauxJournalier;
    }
    public String getNom() { return nom; }
    public double emettreFacture(int jours) { return jours * tauxJournalier; }
}

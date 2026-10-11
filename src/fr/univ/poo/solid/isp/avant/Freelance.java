package fr.univ.poo.solid.isp.avant;

public class Freelance implements Collaborateur {
    private final String nom;
    private final double tauxJournalier;

    public Freelance(String nom, double tauxJournalier) {
        this.nom = nom; this.tauxJournalier = tauxJournalier;
    }
    public String getNom() { return nom; }
    public double emettreFacture(int jours) { return jours * tauxJournalier; }

    // Trois méthodes inutiles, "pour faire plaisir au compilateur"
    public double calculerSalaireMensuel() { return 0; }   // mensonge silencieux
    public void pointer(int h) { }                         // ne fait rien
    public void poserConges(int j) {
        throw new UnsupportedOperationException();
    }
}

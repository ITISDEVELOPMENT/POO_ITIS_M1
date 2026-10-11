package fr.univ.poo.refactoring.inscriptions.refactore;

/** Extract Class : uniquement les règles de calcul. */
public class CalculFraisInscription {
    private static final double REDUCTION_BOURSIER = 0.5;
    private static final double REDUCTION_FIDELITE = 0.1;
    private static final double PLAFOND            = 2000;
    private static final double TAUX_REMBOURSEMENT = 0.8;

    public double calculer(DemandeInscription d) {
        double montant = d.cursus().tarifDeBase(d.nbCours());
        montant = appliquerReductionBoursier(montant, d);
        montant = appliquerReductionFidelite(montant, d);
        return plafonner(montant);
    }

    public double calculerRemboursement(Cursus cursus, int nbCours) {
        return cursus.tarifDeBase(nbCours) * TAUX_REMBOURSEMENT;
    }

    private double appliquerReductionBoursier(double montant, DemandeInscription d) {
        return d.boursier() ? montant * (1 - REDUCTION_BOURSIER) : montant;
    }

    private double appliquerReductionFidelite(double montant, DemandeInscription d) {
        return d.anneesInscription() > 1 ? montant * (1 - REDUCTION_FIDELITE) : montant;
    }

    private double plafonner(double montant) {
        return Math.min(montant, PLAFOND);
    }
}

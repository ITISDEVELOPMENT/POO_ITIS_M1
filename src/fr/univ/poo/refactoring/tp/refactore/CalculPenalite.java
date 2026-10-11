package fr.univ.poo.refactoring.tp.refactore;

public class CalculPenalite {
    private static final int    JOURS_DE_GRACE         = 2;
    private static final double COEFFICIENT_ENSEIGNANT = 0.5;
    private static final double PLAFOND                = 15;

    public double calculer(Emprunt emprunt) {
        double penalite = joursFacturables(emprunt.joursRetard())
                        * emprunt.type().tarifJournalier();
        if (emprunt.enseignant()) penalite *= COEFFICIENT_ENSEIGNANT;
        return Math.min(penalite, PLAFOND);
    }

    private int joursFacturables(int joursRetard) {
        return Math.max(0, joursRetard - JOURS_DE_GRACE);
    }
}

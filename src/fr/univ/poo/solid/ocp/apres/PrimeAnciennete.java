package fr.univ.poo.solid.ocp.apres;

/** OUVERT à l'extension : une règle complexe ajoutée sans rien modifier. */
public class PrimeAnciennete implements RegleSalaire {
    private final int annees;

    public PrimeAnciennete(int annees) {
        this.annees = annees;
    }

    @Override
    public double calculer(double salaire) {
        double taux = Math.min(annees * 0.01, 0.15); // 1 % par an, max 15 %
        return salaire * (1 + taux);
    }
}

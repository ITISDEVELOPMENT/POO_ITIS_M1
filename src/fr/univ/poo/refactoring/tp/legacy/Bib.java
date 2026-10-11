package fr.univ.poo.refactoring.tp.legacy;

/** Code legacy du TP : pénalités de retard de la bibliothèque. */
public class Bib {
    // calcule la pénalité et l'affiche
    public double pen(String t, int j, boolean e, String nom) {
        double p = 0;
        if (j > 2) {
            if (t.equals("LIVRE")) p = (j - 2) * 0.5;
            else if (t.equals("DVD")) p = (j - 2) * 1.0;
            else if (t.equals("REVUE")) p = (j - 2) * 0.2;
        }
        if (e) p = p / 2;
        if (p > 15) p = 15;
        System.out.println(nom + " doit " + p + " €");
        return p;
    }

    public double tarifJour(String t) {
        if (t.equals("LIVRE")) return 0.5;
        else if (t.equals("DVD")) return 1.0;
        else if (t.equals("REVUE")) return 0.2;
        return 0;
    }
}

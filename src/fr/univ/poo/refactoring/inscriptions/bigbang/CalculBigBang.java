package fr.univ.poo.refactoring.inscriptions.bigbang;

/** Réécriture "big bang" sans tests : le comportement a changé (plafond trop tôt). */
public class CalculBigBang {

    public double calculer(String type, int nbCours, boolean boursier, int annee) {
        double prix = switch (type) {
            case "L" -> nbCours * 180;
            case "M" -> nbCours * 250;
            default  -> 380;
        };
        prix = Math.min(prix, 2000);     // plafond appliqué trop tôt !
        if (boursier)  prix *= 0.5;
        if (annee > 1) prix *= 0.9;
        return prix;
    }
}

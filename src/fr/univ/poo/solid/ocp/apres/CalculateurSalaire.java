package fr.univ.poo.solid.ocp.apres;

import java.util.List;

/** FERMÉ à la modification : cette classe ne changera plus. */
public class CalculateurSalaire {

    public double appliquer(double salaire, RegleSalaire regle) {
        return regle.calculer(salaire);
    }

    public double appliquerTout(double salaire, List<RegleSalaire> regles) {
        double resultat = salaire;
        for (RegleSalaire r : regles) {
            resultat = r.calculer(resultat);
        }
        return resultat;
    }
}

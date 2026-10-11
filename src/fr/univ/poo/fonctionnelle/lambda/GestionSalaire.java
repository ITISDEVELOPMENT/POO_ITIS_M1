package fr.univ.poo.fonctionnelle.lambda;

public class GestionSalaire {
    public static double appliquerRegle(double salaire, RegleSalaireLambda regle) {
        return regle.calculerSalaire(salaire);
    }
}

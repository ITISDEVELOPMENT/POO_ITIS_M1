package fr.univ.poo.fonctionnelle.lambda;

public class SalaireRetenu implements RegleSalaire {
    @Override
    public double calculerSalaire(double salaire) {
        return salaire * 0.95;
    }
}

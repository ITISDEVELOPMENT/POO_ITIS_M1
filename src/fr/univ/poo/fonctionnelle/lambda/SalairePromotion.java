package fr.univ.poo.fonctionnelle.lambda;

public class SalairePromotion implements RegleSalaire{
    @Override
    public double calculerSalaire(double salaire) {
        return salaire*1.10;
    }
}

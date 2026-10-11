package fr.univ.poo.fonctionnelle.lambda;

public class SalaireAugmentation implements RegleSalaire{
    @Override
    public double calculerSalaire(double salaire) {
        return salaire + 500;
    }
}

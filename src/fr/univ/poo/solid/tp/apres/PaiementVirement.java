package fr.univ.poo.solid.tp.apres;

public class PaiementVirement implements MoyenPaiement {
    public void payer(double m) { System.out.println("Virement : " + m + " €"); }
}

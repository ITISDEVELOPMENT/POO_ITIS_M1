package fr.univ.poo.solid.tp.apres;

public class PaiementCarte implements MoyenPaiement {
    public void payer(double m) { System.out.println("Carte : " + m + " €"); }
}

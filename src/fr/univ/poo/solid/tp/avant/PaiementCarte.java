package fr.univ.poo.solid.tp.avant;

public class PaiementCarte implements Paiement {
    public void payerParCarte(double m) { System.out.println("Carte : " + m); }
    public void payerParVirement(double m) { throw new UnsupportedOperationException(); }
    public void payerEnEspeces(double m) { throw new UnsupportedOperationException(); }
}

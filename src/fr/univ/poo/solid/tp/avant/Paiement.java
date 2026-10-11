package fr.univ.poo.solid.tp.avant;

public interface Paiement {
    void payerParCarte(double montant);
    void payerParVirement(double montant);
    void payerEnEspeces(double montant);
}

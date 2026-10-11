package fr.univ.poo.solid.tp.apres;

public class CalculateurCommande {
    private static final double FRAIS_LIVRAISON = 8;

    public double total(double montant, TarifClient tarif) {
        return tarif.appliquer(montant) + FRAIS_LIVRAISON;
    }
}

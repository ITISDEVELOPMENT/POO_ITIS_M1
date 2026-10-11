package fr.univ.poo.solid.tp.apres;

/** ISP + LSP : une seule méthode, tenue par tous. */
@FunctionalInterface
public interface MoyenPaiement {
    void payer(double montant);
}

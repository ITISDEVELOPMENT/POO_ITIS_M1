package fr.univ.poo.solid.lsp.apres;

/** Ce que seuls les salariés savent faire. */
public interface Remunerable extends MembrePersonnel {
    void verserPrime(double montant);
    double calculerSalaireNet();
}

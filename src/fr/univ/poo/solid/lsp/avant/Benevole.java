package fr.univ.poo.solid.lsp.avant;

/** SANS LSP : "un bénévole est un salarié qui n'est pas payé"... vraiment ? */
public class Benevole extends Salarie {

    public Benevole(String nom) { super(nom, 0); }

    @Override
    public void verserPrime(double montant) {
        throw new UnsupportedOperationException("Pas de prime");
    }

    @Override
    public double calculerSalaireNet() {
        throw new UnsupportedOperationException("Pas de salaire");
    }
}

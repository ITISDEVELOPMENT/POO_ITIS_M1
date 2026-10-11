package fr.univ.poo.solid.tp.apres;

/** OCP : un tarif = une Lambda. */
@FunctionalInterface
public interface TarifClient {
    double appliquer(double montant);
}

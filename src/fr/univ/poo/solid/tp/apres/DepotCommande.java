package fr.univ.poo.solid.tp.apres;

/** DIP : abstraction du stockage. */
@FunctionalInterface
public interface DepotCommande {
    void sauvegarder(Commande c, double total);
}

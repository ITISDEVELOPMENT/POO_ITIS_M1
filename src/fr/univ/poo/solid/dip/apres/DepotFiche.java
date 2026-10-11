package fr.univ.poo.solid.dip.apres;

/** Abstraction définie par le métier. */
@FunctionalInterface
public interface DepotFiche {
    void enregistrer(String identifiant, String contenu);
}

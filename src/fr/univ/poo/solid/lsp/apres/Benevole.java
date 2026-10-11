package fr.univ.poo.solid.lsp.apres;

/** Un bénévole ne promet que ce qu'il sait faire. */
public class Benevole implements MembrePersonnel {
    private final String nom;

    public Benevole(String nom) { this.nom = nom; }

    @Override public String getNom() { return nom; }
}

package fr.univ.poo.cleancode.kiss.avant;

/** Solution 2 : architecture disproportionnée (interface + fabrique + réflexion). */
public interface RegleMention {
    boolean accepte(int note);
    String libelle();
}

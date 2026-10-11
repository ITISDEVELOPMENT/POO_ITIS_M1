package fr.univ.poo.cleancode.kiss.apres;

import fr.univ.poo.cleancode.Etudiant;

/** KISS : la règle écrite telle que le métier l'énonce. */
public class CalculMention {
    private static final int TRES_BIEN  = 16;
    private static final int BIEN       = 14;
    private static final int ASSEZ_BIEN = 12;

    public String mention(int note) {
        if (note < 0 || note > 20) {
            throw new IllegalArgumentException("Note invalide : " + note);
        }
        if (note < Etudiant.NOTE_ADMISSION) return "-";
        if (note >= TRES_BIEN)  return "Très bien";
        if (note >= BIEN)       return "Bien";
        if (note >= ASSEZ_BIEN) return "Assez bien";
        return "Passable";
    }
}

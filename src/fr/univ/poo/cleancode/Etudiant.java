package fr.univ.poo.cleancode;

/**
 * Record du fil rouge Clean Code (version finale : DRY + TP).
 * Les versions "avant" n'utilisent pas estAdmis() : elles réécrivent la règle.
 */
public record Etudiant(String nom, String filiere, int note) {

    // Source unique de vérité : la seule ligne à modifier (DRY)
    public static final int NOTE_ADMISSION = 10;

    public boolean estAdmis() {
        return note >= NOTE_ADMISSION;
    }

    public boolean appartientA(String filiereRecherchee) {
        return filiere.equals(filiereRecherchee);
    }
}

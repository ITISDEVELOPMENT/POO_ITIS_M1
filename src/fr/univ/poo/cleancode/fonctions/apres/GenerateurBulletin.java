package fr.univ.poo.cleancode.fonctions.apres;

import fr.univ.poo.cleancode.Etudiant;

/** AVEC fonctions courtes : une fonction = une chose = un niveau d'abstraction. */
public class GenerateurBulletin {

    // Niveau "quoi" : se lit comme un sommaire
    public String genererBulletin(Etudiant e) {
        validerNote(e.note());
        return formater(e, determinerDecision(e.note()),
                           determinerMention(e.note()));
    }

    private void validerNote(int note) {
        if (note < 0 || note > 20) {
            throw new IllegalArgumentException("Note invalide : " + note);
        }
    }

    private String determinerDecision(int note) {
        return note >= 10 ? "ADMIS" : "AJOURNÉ";
    }

    String determinerMention(int note) {
        if (note < 10) return "-";
        if (note >= 16) return "Très bien";
        if (note >= 14) return "Bien";
        if (note >= 12) return "Assez bien";
        return "Passable";
    }

    private String formater(Etudiant e, String decision, String mention) {
        return """
               ========== BULLETIN ==========
               Étudiant : %s
               Filière  : %s
               Note     : %d/20
               Décision : %s
               Mention  : %s
               """.formatted(e.nom(), e.filiere(), e.note(), decision, mention);
    }
}

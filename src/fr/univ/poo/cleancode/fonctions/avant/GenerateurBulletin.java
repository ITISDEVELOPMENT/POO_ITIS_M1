package fr.univ.poo.cleancode.fonctions.avant;

import fr.univ.poo.cleancode.Etudiant;

/** SANS fonctions courtes : 30 lignes, 4 tâches, un argument booléen. */
public class GenerateurBulletin {

    public void genererBulletin(Etudiant e, boolean afficher) {
        if (e.note() < 0 || e.note() > 20) {
            throw new IllegalArgumentException("Note invalide : " + e.note());
        }
        String decision;
        String mention;
        if (e.note() >= 10) {
            decision = "ADMIS";
            if (e.note() >= 16) mention = "Très bien";
            else if (e.note() >= 14) mention = "Bien";
            else if (e.note() >= 12) mention = "Assez bien";
            else mention = "Passable";
        } else {
            decision = "AJOURNÉ";
            mention = "-";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("========== BULLETIN ==========\n");
        sb.append("Étudiant : ").append(e.nom()).append("\n");
        sb.append("Filière  : ").append(e.filiere()).append("\n");
        sb.append("Note     : ").append(e.note()).append("/20\n");
        sb.append("Décision : ").append(decision).append("\n");
        sb.append("Mention  : ").append(mention).append("\n");
        sb.append("==============================\n");
        if (afficher) {
            System.out.println(sb);
        }
    }
}

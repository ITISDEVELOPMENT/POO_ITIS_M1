package fr.univ.poo.refactoring.inscriptions.legacy;

/** Code legacy du fil rouge : neuf code smells (voir le cours). */
public class Inscr {

    // calcule le montant de l'inscription, l'affiche et envoie le mail
    public double calc(String nom, String type, int nbCours,
                       boolean boursier, int annee, String email) {
        double t = 0;
        // calcul du prix
        if (type.equals("L")) { t = nbCours * 180; }
        else if (type.equals("M")) { t = nbCours * 250; }
        else if (type.equals("D")) { t = 380; }
        if (boursier) { t = t - t * 0.5; }
        if (annee > 1) { t = t - t * 0.1; }   // fidélité
        if (t > 2000) t = 2000;               // plafond
        // affichage
        System.out.println("Inscription de " + nom + " : " + t + " €");
        // envoi du mail
        System.out.println("Mail à " + email + " : vous devez " + t + " €");
        return t;
    }

    // remboursement en cas d'annulation
    public double calcRemb(String type, int nbCours) {
        double t = 0;
        if (type.equals("L")) { t = nbCours * 180; }
        else if (type.equals("M")) { t = nbCours * 250; }
        else if (type.equals("D")) { t = 380; }
        return t * 0.8;
    }

    // ancienne version, ne plus utiliser
    public double calcOld(String type, int nbCours) {
        return nbCours * 150;
    }
}

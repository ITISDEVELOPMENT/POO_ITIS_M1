package fr.univ.poo.refactoring;

import fr.univ.poo.refactoring.inscriptions.bigbang.CalculBigBang;
import fr.univ.poo.refactoring.inscriptions.legacy.Inscr;
import fr.univ.poo.refactoring.inscriptions.refactore.CalculFraisInscription;
import fr.univ.poo.refactoring.inscriptions.refactore.Cursus;
import fr.univ.poo.refactoring.inscriptions.refactore.DemandeInscription;
import fr.univ.poo.refactoring.inscriptions.refactore.ServiceInscription;
import fr.univ.poo.refactoring.tp.legacy.Bib;
import fr.univ.poo.refactoring.tp.refactore.CalculPenalite;
import fr.univ.poo.refactoring.tp.refactore.Emprunt;
import fr.univ.poo.refactoring.tp.refactore.TypeDocument;

/** Cours « Refactoring » : legacy, réécriture big bang et version refactorée. */
public class DemoRefactoring {

    private record Cas(String type, Cursus cursus, int nbCours, boolean boursier, int annee) {}

    public static void executer() {
        Inscr legacy = new Inscr();
        CalculBigBang bigBang = new CalculBigBang();
        CalculFraisInscription refactore = new CalculFraisInscription();

        Cas[] cas = {
                new Cas("L", Cursus.LICENCE, 5, true, 2),
                new Cas("M", Cursus.MASTER, 4, false, 3),
                new Cas("M", Cursus.MASTER, 10, false, 1),
                new Cas("D", Cursus.DOCTORAT, 1, false, 1),
                new Cas("M", Cursus.MASTER, 10, true, 1)       // le cas piège
        };

        System.out.println("--- Comportement : legacy / big bang / refactoré ---");
        java.io.PrintStream sortie = System.out;
        for (Cas c : cas) {
            System.setOut(new java.io.PrintStream(java.io.OutputStream.nullOutputStream()));
            double l = legacy.calc("X", c.type(), c.nbCours(), c.boursier(), c.annee(), "x@u.fr");
            System.setOut(sortie);
            double b = bigBang.calculer(c.type(), c.nbCours(), c.boursier(), c.annee());
            double r = refactore.calculer(new DemandeInscription("X", "x@u.fr", c.cursus(),
                    c.nbCours(), c.boursier(), c.annee()));
            System.out.printf("%-9s %2d cours boursier=%-5s année=%d : %7.1f | %7.1f%s | %7.1f%n",
                    c.cursus(), c.nbCours(), c.boursier(), c.annee(), l, b, l == b ? " " : "!", r);
        }
        System.out.println("Remboursement Licence 5 cours : " + legacy.calcRemb("L", 5)
                + " / " + refactore.calculerRemboursement(Cursus.LICENCE, 5));      // 720.0

        System.out.println("--- Service refactoré ---");
        new ServiceInscription().inscrire(
                new DemandeInscription("Alice", "alice@univ.fr", Cursus.LICENCE, 5, true, 2));

        System.out.println("--- TP bibliothèque : legacy / refactoré ---");
        Bib bib = new Bib();
        CalculPenalite penalite = new CalculPenalite();
        Object[][] emprunts = {{TypeDocument.LIVRE, 10, false}, {TypeDocument.DVD, 20, false},
                {TypeDocument.DVD, 20, true}, {TypeDocument.REVUE, 2, false}, {TypeDocument.REVUE, 12, false}};
        for (Object[] e : emprunts) {
            TypeDocument type = (TypeDocument) e[0];
            int jours = (int) e[1];
            boolean enseignant = (boolean) e[2];
            double avant = bib.pen(type.name(), jours, enseignant, type + " " + jours + " j");
            double apres = penalite.calculer(new Emprunt("X", type, jours, enseignant));
            System.out.println("   refactoré : " + apres + (avant == apres ? " (identique)" : " (DIFFÉRENT)"));
        }
    }

    public static void main(String[] args) {
        executer();
    }
}

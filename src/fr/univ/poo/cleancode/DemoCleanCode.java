package fr.univ.poo.cleancode;

import java.util.List;

/** Cours « Clean Code » : nommage, fonctions courtes, DRY, KISS, YAGNI. */
public class DemoCleanCode {

    public static void executer() {
        List<Etudiant> promo = Promotion.exemple();
        List<Object[]> promoBrute = promo.stream()
                .map(e -> new Object[]{e.nom(), e.filiere(), e.note()})
                .toList();

        System.out.println("--- Nommage ---");
        System.out.println("avant : " + new fr.univ.poo.cleancode.nommage.avant.Gest().calc(promoBrute, 10));
        System.out.println("après : " + new fr.univ.poo.cleancode.nommage.apres.ServiceAdmission()
                .nomsDesAdmis(promo, 10));

        System.out.println("--- Fonctions courtes ---");
        Etudiant chloe = new Etudiant("Chloe", "IBI", 17);
        Etudiant david = new Etudiant("David", "DEV", 11);
        new fr.univ.poo.cleancode.fonctions.avant.GenerateurBulletin().genererBulletin(david, true);
        System.out.println(new fr.univ.poo.cleancode.fonctions.apres.GenerateurBulletin().genererBulletin(chloe));

        System.out.println("--- DRY : même résultat, une seule règle ---");
        System.out.println("taux avant : " + new fr.univ.poo.cleancode.dry.avant.ServiceStatistiques().tauxReussite(promo));
        System.out.println("taux après : " + new fr.univ.poo.cleancode.dry.apres.ServiceStatistiques().tauxReussite(promo));
        System.out.println("export     : " + new fr.univ.poo.cleancode.dry.apres.ServiceExport().ligne(chloe));

        System.out.println("--- KISS ---");
        System.out.println("astucieux(13) : " + new fr.univ.poo.cleancode.kiss.avant.MentionAstucieuse().mention(13));
        try {
            new fr.univ.poo.cleancode.kiss.avant.MentionAstucieuse().mention(21);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("astucieux(21) : " + e.getClass().getSimpleName());
        }
        try {
            System.out.println("factory(15)   : " + new fr.univ.poo.cleancode.kiss.avant.MentionFactory().mention(15));
        } catch (Exception e) {
            System.out.println("factory : " + e);
        }
        System.out.println("simple(15)    : " + new fr.univ.poo.cleancode.kiss.apres.CalculMention().mention(15));

        System.out.println("--- YAGNI ---");
        var avant = new fr.univ.poo.cleancode.yagni.avant.ExportateurNotes(
                fr.univ.poo.cleancode.yagni.avant.ExportateurNotes.Format.CSV,
                fr.univ.poo.cleancode.yagni.avant.ExportateurNotes.Langue.FR, false, ";");
        System.out.println(avant.exporter(promo.subList(0, 2)));
        System.out.println(new fr.univ.poo.cleancode.yagni.apres.ExportCsvNotes().exporter(promo.subList(0, 2)));

        System.out.println("--- TP ---");
        System.out.println("avant : " + new fr.univ.poo.cleancode.tp.avant.Mgr().proc(promoBrute, "IBI", true, 0));
        var stats = new fr.univ.poo.cleancode.tp.apres.StatistiquesPromotion();
        System.out.printf("après : moyenne des admis IBI = %.2f%n", stats.moyenneDesAdmis(promo, "IBI"));  // 13.67
        System.out.println("après : nombre d'admis = " + stats.nombreAdmis(promo));                        // 5
    }

    public static void main(String[] args) {
        executer();
    }
}

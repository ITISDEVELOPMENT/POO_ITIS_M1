package fr.univ.poo.solid;

import java.util.List;

/** Cours « Les principes SOLID » : chaque principe, avant puis après. */
public class DemoSolid {

    static void srp() {
        Employe alice = new Employe("Alice", "alice@ent.fr", 3000);
        System.out.println("--- SRP avant : une classe fait tout ---");
        var gestion = new fr.univ.poo.solid.srp.avant.GestionPaie();
        System.out.println(gestion.genererFiche(alice));
        gestion.enregistrer(alice);
        gestion.envoyerMail(alice);
        System.out.println("--- SRP après : une classe par responsabilité ---");
        new fr.univ.poo.solid.srp.apres.ServicePaie().traiter(alice);
    }

    static void ocp() {
        System.out.println("--- OCP avant : switch ---");
        var avant = new fr.univ.poo.solid.ocp.avant.CalculateurSalaire();
        System.out.println("PROMOTION : " + avant.calculer(3000, "PROMOTION"));
        System.out.println("PRIME : " + avant.calculer(3000, "PRIME"));
        try {
            avant.calculer(3000, "ANCIENETE");          // faute de frappe
        } catch (IllegalArgumentException e) {
            System.out.println("Erreur à l'exécution : " + e.getMessage());
        }

        System.out.println("--- OCP après : interface + Lambda ---");
        var calc = new fr.univ.poo.solid.ocp.apres.CalculateurSalaire();
        fr.univ.poo.solid.ocp.apres.RegleSalaire promotion = s -> s * 1.10;
        fr.univ.poo.solid.ocp.apres.RegleSalaire prime = s -> s + 500;
        fr.univ.poo.solid.ocp.apres.RegleSalaire retenue = s -> s * 0.95;
        fr.univ.poo.solid.ocp.apres.RegleSalaire anciennete = s -> s * 1.03;
        System.out.println("promotion               : " + calc.appliquer(3000, promotion));
        System.out.println("ancienneté (Lambda)     : " + calc.appliquer(3000, anciennete));   // 3090.0
        System.out.println("promotion+prime+retenue : " + calc.appliquerTout(3000,
                List.of(promotion, prime, retenue))); // 3610.0000000000005 (arrondi double)
        System.out.println("PrimeAnciennete(5)      : " + calc.appliquer(3000,
                new fr.univ.poo.solid.ocp.apres.PrimeAnciennete(5))); // 3150.0
    }

    static void lsp() {
        System.out.println("--- LSP avant : le bénévole casse le traitement ---");
        List<fr.univ.poo.solid.lsp.avant.Salarie> personnel = List.of(
                new fr.univ.poo.solid.lsp.avant.Salarie("Alice", 3000),
                new fr.univ.poo.solid.lsp.avant.Salarie("Ona", 3500),
                new fr.univ.poo.solid.lsp.avant.Benevole("Bob"),
                new fr.univ.poo.solid.lsp.avant.Salarie("Chloé", 2800),
                new fr.univ.poo.solid.lsp.avant.Salarie("Eddy", 4000));
        try {
            new fr.univ.poo.solid.lsp.avant.ServiceRH().verserPrimeFinAnnee(personnel);
        } catch (UnsupportedOperationException e) {
            System.out.println("Exception : " + e.getMessage() + " (Chloé et Eddy n'est jamais traitée)");
        }

        System.out.println("--- LSP après : hiérarchie corrigée ---");
        var rh = new fr.univ.poo.solid.lsp.apres.ServiceRH();
        var alice = new fr.univ.poo.solid.lsp.apres.Salarie("Alice", 3000);
        var chloe = new fr.univ.poo.solid.lsp.apres.Salarie("Chloé", 2800);
        var eddy = new fr.univ.poo.solid.lsp.apres.Salarie("Eddy", 4000);
        var ona = new fr.univ.poo.solid.lsp.apres.Salarie("Ona", 4500);
        //var xv = new fr.univ.poo.solid.lsp.apres.Benevole("Ona");
        rh.verserPrimeFinAnnee(List.of(eddy, alice, chloe, ona));                                    // 3040.0 / 2850.0
        rh.envoyerVoeux(List.of(alice, new fr.univ.poo.solid.lsp.apres.Benevole("Bob"), chloe, ona));
    }

    static void isp() {
        System.out.println("--- ISP avant : bug silencieux du freelance ---");
        var salaire = new fr.univ.poo.solid.isp.avant.Salarie("Alice", 3000);
        System.out.println("salaire Alice: " + salaire.calculerSalaireMensuel());
        var freelance = new fr.univ.poo.solid.isp.avant.Freelance("Farid", 450);
        System.out.println("Salaire mensuel du freelance : " + freelance.calculerSalaireMensuel() +
                " (faux mais aucune erreur)");

        System.out.println("--- ISP après : interfaces par rôle ---");
        System.out.println("Masse salariale : " + fr.univ.poo.solid.isp.apres.ServicesRH.masseSalariale(List.of(
                new fr.univ.poo.solid.isp.apres.Salarie("Alice", 3000),
                new fr.univ.poo.solid.isp.apres.Stagiaire("Hugo"))));                         // 3500.0
        System.out.println("Factures (10 j) : " + fr.univ.poo.solid.isp.apres.ServicesRH.totalFactures(List.of(
                new fr.univ.poo.solid.isp.apres.Freelance("Farid", 450)), 10));               // 4500.0
    }

    static void dip() {
        Employe alice = new Employe("Alice", "alice@ent.fr", 3000);
        System.out.println("--- DIP avant : dépendances concrètes ---");
        new fr.univ.poo.solid.dip.avant.ServicePaie().traiter(alice);

        System.out.println("--- DIP après : abstractions injectées ---");
        fr.univ.poo.solid.dip.apres.RegleSalaire regle = s -> (s + 500) * 0.95;
        new fr.univ.poo.solid.dip.apres.ServicePaie(regle,
                new fr.univ.poo.solid.dip.apres.DepotFichier(),
                new fr.univ.poo.solid.dip.apres.NotificateurMail()).traiter(alice);

        new fr.univ.poo.solid.dip.apres.ServicePaie(regle,
                new fr.univ.poo.solid.dip.apres.DepotBaseDonnees(),
                new fr.univ.poo.solid.dip.apres.NotificateurSms()).traiter(alice);
    }

    static void tp() {
        System.out.println("--- TP avant ---");
        new fr.univ.poo.solid.tp.avant.GestionCommande().traiter("Alice", "alice@mail.fr", 100, "PREMIUM");
        System.out.println("--- TP après ---");
        fr.univ.poo.solid.tp.apres.TarifClient standard = m -> m * 1.20;
        fr.univ.poo.solid.tp.apres.TarifClient premium = m -> m * 0.90 * 1.20;
        fr.univ.poo.solid.tp.apres.TarifClient entreprise = m -> m;
        fr.univ.poo.solid.tp.apres.TarifClient etudiant = m -> m * 0.85 * 1.20;
        var service = new fr.univ.poo.solid.tp.apres.ServiceCommande(
                new fr.univ.poo.solid.tp.apres.CalculateurCommande(),
                new fr.univ.poo.solid.tp.apres.DepotFichierCommande(),
                new fr.univ.poo.solid.tp.apres.NotificateurMail());
        var c = new fr.univ.poo.solid.tp.apres.Commande("Alice", "alice@mail.fr", 100);
        var carte = new fr.univ.poo.solid.tp.apres.PaiementCarte();
        System.out.printf("STANDARD   %.2f%n", service.traiter(c, standard, carte));       // 128.00
        System.out.printf("PREMIUM    %.2f%n", service.traiter(c, premium, carte));        // 116.00
        System.out.printf("ENTREPRISE %.2f%n", service.traiter(c, entreprise,
                new fr.univ.poo.solid.tp.apres.PaiementVirement()));                       // 108.00
        System.out.printf("ÉTUDIANT   %.2f%n", service.traiter(c, etudiant, carte));       // 110.00
    }

    public static void executer() {
       //srp();
       // ocp();
       // lsp();
       //isp();
        // dip();
       // tp();
    }

    public static void main(String[] args) {
        executer();
    }
}

package fr.univ.poo.fonctionnelle.lambda;


public class DemoLamba {
    //public static double appliquerTraitement(double montant, TraitementCommande traitement) {
       // return traitement.traiter(montant);
    //}

    public static void main(String[] args) {
        double salaire = 3000;

        System.out.println("--- Solution classique (une classe par règle) ---");
        RegleSalaire regle = new SalairePromotion();
        System.out.println("Promotion   : " + regle.calculerSalaire(salaire));
        //System.out.printf("Salaire avec Promotion vaut : %.2f%n", regle.calculerSalaire(salaire));
        regle = new SalaireAugmentation();
        System.out.println("Salaire avec Prime : " + regle.calculerSalaire(salaire));
        regle = new SalaireRetenu();
        System.out.println("Salaire avec Retenue : " + regle.calculerSalaire(salaire));

        System.out.println("--- Avec des expressions Lambda ---");
        RegleSalaireLambda promotion = s -> s * 1.10;
        RegleSalaireLambda prime = s -> s + 500;
        RegleSalaireLambda retenue = s -> s * 0.95;
        System.out.println("Promotion   : " + promotion.calculerSalaire(salaire));
        System.out.println("Prime       : " + prime.calculerSalaire(salaire));
        System.out.println("Retenue     : " + retenue.calculerSalaire(salaire));

        System.out.println("--- Transmettre un comportement en paramètre ---");
        System.out.println("appliquerRegle Promotion : " + GestionSalaire.appliquerRegle(salaire, s -> s * 1.10));
        System.out.println("appliquerRegle Prime : " + GestionSalaire.appliquerRegle(salaire, s -> s + 500));
        
    }
}

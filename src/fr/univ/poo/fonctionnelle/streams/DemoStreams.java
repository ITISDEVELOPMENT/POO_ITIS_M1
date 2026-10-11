package fr.univ.poo.fonctionnelle.streams;
import java.util.*;
import java.util.stream.*;

public class DemoStreams {

    static void operateurBase(){
        List<Integer> nombres = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        System.out.println("--- Sans Streams : pairs x 2 ---");
        List<Integer> resultat = new ArrayList<>();
        for (Integer n : nombres) {
            if (n % 2 == 0) {
                resultat.add(n * 2);
            }
        }
        System.out.println("Liste Initiale:" + resultat);

        System.out.println("--- Avec Streams : filter + map + collect ---");
        List<Integer> ListeFinale = nombres.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * 2)
                .collect(Collectors.toList());
        System.out.println("Liste finale:" + ListeFinale);

        System.out.println("--- Streams : Operateur Distinct ---");
        List<Integer> distinctListe = Arrays.asList(1, 2, 2, 3, 3, 3, 4);
        List<Integer> listeSansDoublons = distinctListe.stream().distinct().collect(Collectors.toList());
        System.out.println("Liste Sans Doublons : " + listeSansDoublons);
        //System.out.println("distinct     : " + Stream.of(1, 2, 2, 3, 3, 3, 4).distinct().collect(Collectors.toList()));

        System.out.println("--- Streams : Operateur Sorted, Inverse Sorted, Skip, Limit ---");
        List<Integer> liste = Arrays.asList(5, 2, 8, 1, 3);
        System.out.println("Liste Trié       : " + liste.stream().sorted().collect(Collectors.toList()));
        System.out.println("sorted Trié Desc  : " + liste.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList()));
        System.out.println("skip/limit   : " + Stream.of(10, 20, 30, 40, 50, 60)
                .skip(2)
                .limit(3)
                .collect(Collectors.toList()));
        System.out.println("count pairs  : " + Stream.of(1, 2, 3, 4, 5, 6)
                .filter(n -> n % 2 == 0).count());
        System.out.println("findFirst    : " + Stream.of(1, 4, 6, 8)
                .filter(n -> n % 2 == 0).findFirst());

        List<Integer> ages = Arrays.asList(22, 17, 25, 30, 25, 19, 45, 16, 30, 28);
        boolean anyOver40   = ages.stream().anyMatch(n -> n > 40);
        boolean allAdults   = ages.stream().allMatch(n -> n >= 18);
        boolean noneOver50  = ages.stream().noneMatch(n -> n > 50);

        System.out.println("anyMatch(> 40)  : " + anyOver40);
        //System.out.println("anyMatch(> 40)  : " + ages.stream().anyMatch(a -> a > 40));
        System.out.println("allMatch(>= 18) : " + allAdults);
        System.out.println("noneMatch(> 50) : " + noneOver50);
    }

    static void correctionExercice() {

    }

    static void affichage(){
        List<Integer> nombres =  Arrays.asList(1, 2, 3, 4);
        Stream<Integer> s1 = nombres.stream();
        Stream<String> s2 = Stream.of("Java", "Python", "Go");

        int[] tableau = {1, 2, 3, 4};
        IntStream s3 = Arrays.stream(tableau);
        IntStream s4 = IntStream.range(1, 5);
        IntStream s5 = IntStream.rangeClosed(1, 5);

        s1.forEach(System.out::println);
        s2.forEach(System.out::println);
        s4.forEach(System.out::println);

        int somme = s3.sum();
        System.out.println("Somme Tableau: "+ somme);// 60

        // s4 (recréé) : somme de 1 à 4
        int total = IntStream.range(1, 7).sum();   // 10
        System.out.println("Somme Tableau: "+ total);

        List<String> etudiants = Arrays.asList("Alice", "Bob", "Charlie", "Diana", "Eve");
        System.out.println("--- Liste des etudiants ---");
        etudiants.stream().forEach(nom -> System.out.println(nom));

        System.out.println("--- Version raccourcie ---");
        etudiants.stream().forEach(System.out::println);

        System.out.println("--- Noms commencant par 'A' ou 'E' ---");
        etudiants.stream()
                .filter(nom -> nom.startsWith("A") || nom.startsWith("E"))
                .forEach(nom -> System.out.println("Etudiant : " + nom));
    }

    static void tableDeMultiplication(){
        System.out.println("--- Table de 7 ---");
        int nombre = 7;
        IntStream.rangeClosed(1, 10)
                .forEach(i -> System.out.println(nombre + " x " + i + " = " + (nombre * i)));
    }

    static void reductionNumeriques() {
        List<Integer> nombres = Arrays.asList(12, 7, 25, 3, 18, 30, 9);

        System.out.println("--- Réduction numérique ---");
        int somme = nombres.stream().mapToInt(Integer::intValue).sum();
        System.out.println("somme   : " + somme);

        System.out.println("moyenne : " + nombres.stream().mapToInt(Integer::intValue).average().orElse(0));
        System.out.println("min     : " + nombres.stream().mapToInt(Integer::intValue).min().getAsInt());
        System.out.println("max     : " + nombres.stream().mapToInt(Integer::intValue).max().getAsInt());

        int sommePairs = nombres.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(Integer::intValue).sum();
        System.out.println("somme des pairs : " + sommePairs);

        System.out.println("--- Operateur Reuce ---");
        List <Integer > nombres2 = Arrays.asList(1, 2, 3, 4, 5);
        List <String > mots = Arrays.asList("Java", "Stream", "Collectors", "API");
        List <Double > remises = Arrays.asList (0.90 , 0.80, 0.95);

        int factorielle = nombres2.stream().reduce(1, (a, b) -> a * b);
        System.out.println("Factorielle de 5! vaut = " + factorielle);

        Optional <String > plusLong = mots.stream()
                .reduce((a, b) -> a.length() >= b.length() ? a : b);
        plusLong.ifPresent( m -> System.out.println("Plus long mot:" + m));

        double prixFinal = 100 * remises.stream().
                reduce(1.0, (a, b) -> a * b);
        System.out.printf("Prix final : %.2f EUR%n", prixFinal);   // 68.40

        System.out.println("--- groupingBy / partitioningBy ---");
        List<String> mots2 = Arrays.asList("Java", "Stream", "API", "Lambda", "Collectors", "Map", "Filter", "Optional");
        System.out.println(mots2.stream().collect(Collectors.groupingBy(String::length)));
        System.out.println(Stream.of(12, 7, 25, 3, 18, 30, 9, 14)
                .collect(Collectors.partitioningBy(n -> n % 2 == 0)));

        System.out.println("--- Parallèle avec ordre ---");
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8).parallel().forEachOrdered(n -> System.out.print(n + " "));
        System.out.println();
    }

    static void exerciceNotes() {

    }

    static void useCasePromotion() {
        List<Etudiant> promo = List.of(
                new Etudiant("Alice", "IBI", 14), new Etudiant("Bob", "SBI", 9),
                new Etudiant("Chloe", "IBI", 17), new Etudiant("David", "DEV", 11),
                new Etudiant("Emma", "SBI", 8), new Etudiant("Farid", "DEV", 15),
                new Etudiant("Gina", "IBI", 10), new Etudiant("Hugo", "DEV", 6));

        System.out.println("--- Use case : résultats d'une promotion ---");

    }

    public static void main(String[] args) {
        //operateurBase();
        //correctionExercice();
        //affichage();
        //TableDeMultiplication();
        //reductionNumeriques();
        //exerciceNotes();
        //useCasePromotion();
    }
}

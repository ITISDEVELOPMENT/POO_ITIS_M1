package fr.univ.poo.cleancode;

import java.util.List;

/** Données du fil rouge (mêmes étudiants que le use case Streams). */
public final class Promotion {
    private Promotion() {}

    public static List<Etudiant> exemple() {
        return List.of(
                new Etudiant("Alice", "DEV", 14), new Etudiant("Bob", "SBI", 9),
                new Etudiant("Chloe", "IBI", 17), new Etudiant("David", "DEV", 11),
                new Etudiant("Emma", "SBI", 8), new Etudiant("Farid", "DEV", 15),
                new Etudiant("Gina", "IBI", 10), new Etudiant("Hugo", "DEV", 6));
    }
}

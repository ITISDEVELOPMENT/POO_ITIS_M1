package fr.univ.poo.cleancode.dry.avant;

import fr.univ.poo.cleancode.Etudiant;

public class ServiceBulletin {
    public String decision(Etudiant e) {
        return e.note() >= 10 ? "ADMIS" : "AJOURNÉ";      // règle n°1
    }
}

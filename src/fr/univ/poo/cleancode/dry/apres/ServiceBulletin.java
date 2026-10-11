package fr.univ.poo.cleancode.dry.apres;

import fr.univ.poo.cleancode.Etudiant;

public class ServiceBulletin {
    public String decision(Etudiant e) {
        return e.estAdmis() ? "ADMIS" : "AJOURNÉ";
    }
}

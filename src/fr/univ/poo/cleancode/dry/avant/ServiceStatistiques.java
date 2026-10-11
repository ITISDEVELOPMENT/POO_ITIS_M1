package fr.univ.poo.cleancode.dry.avant;

import fr.univ.poo.cleancode.Etudiant;

import java.util.List;

public class ServiceStatistiques {
    public double tauxReussite(List<Etudiant> promo) {
        long admis = 0;
        for (Etudiant e : promo) if (e.note() >= 10) admis++;   // règle n°2
        return 100.0 * admis / promo.size();
    }
}

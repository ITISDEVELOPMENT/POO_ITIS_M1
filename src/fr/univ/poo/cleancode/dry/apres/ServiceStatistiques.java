package fr.univ.poo.cleancode.dry.apres;

import fr.univ.poo.cleancode.Etudiant;

import java.util.List;

public class ServiceStatistiques {
    public double tauxReussite(List<Etudiant> promo) {
        long admis = promo.stream().filter(Etudiant::estAdmis).count();
        return 100.0 * admis / promo.size();
    }
}

package fr.univ.poo.solid.isp.apres;

import java.util.List;

/** Chaque service ne dépend que du rôle dont il a besoin. */
public class ServicesRH {

    public static double masseSalariale(List<? extends Payable> payables) {
        return payables.stream()
                       .mapToDouble(Payable::calculerSalaireMensuel)
                       .sum();
    }

    public static double totalFactures(List<? extends Facturable> prestataires, int jours) {
        return prestataires.stream()
                           .mapToDouble(f -> f.emettreFacture(jours))
                           .sum();
    }
}

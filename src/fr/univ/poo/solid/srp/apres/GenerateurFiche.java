package fr.univ.poo.solid.srp.apres;

import fr.univ.poo.solid.Employe;

/** Une seule raison de changer : le format de la fiche. */
public class GenerateurFiche {
    public String generer(Employe e, double net) {
        return "=== FICHE DE PAIE ===\n"
             + "Nom : " + e.nom() + "\n"
             + "Net : " + net + " €";
    }
}

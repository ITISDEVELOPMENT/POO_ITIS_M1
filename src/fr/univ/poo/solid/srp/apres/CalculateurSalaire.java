package fr.univ.poo.solid.srp.apres;

import fr.univ.poo.solid.Employe;

/** Une seule raison de changer : les règles RH. */
public class CalculateurSalaire {
    public double calculerNet(Employe e) {
        double brut = e.salaireBase() + 500;
        return brut * 0.95;
    }
}

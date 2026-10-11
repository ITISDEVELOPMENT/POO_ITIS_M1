package fr.univ.poo.solid.lsp.avant;

import java.util.List;

public class ServiceRH {

    // Écrit pour des Salarie : il leur fait confiance
    public void verserPrimeFinAnnee(List<Salarie> personnel) {
        for (Salarie s : personnel) {
            s.verserPrime(200);
            System.out.println(s.getNom() + " : " + s.calculerSalaireNet());
        }
    }
}

package fr.univ.poo.solid.lsp.apres;

import java.util.List;

public class ServiceRH {

    public void verserPrimeFinAnnee(List<? extends Remunerable> personnel) {
        for (Remunerable r : personnel) {
            r.verserPrime(200);
            System.out.println(r.getNom() + " : " + r.calculerSalaireNet());
        }
    }

    public void envoyerVoeux(List<? extends MembrePersonnel> membres) {
        membres.forEach(m -> System.out.println("Bonne année " + m.getNom()));
    }
}

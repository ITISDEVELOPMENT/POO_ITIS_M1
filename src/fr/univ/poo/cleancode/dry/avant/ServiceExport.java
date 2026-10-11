package fr.univ.poo.cleancode.dry.avant;

import fr.univ.poo.cleancode.Etudiant;

public class ServiceExport {
    public String ligne(Etudiant e) {
        return e.nom() + ";" + (e.note() >= 10 ? "OUI" : "NON");  // règle n°3
    }
}

package fr.univ.poo.cleancode.dry.apres;

import fr.univ.poo.cleancode.Etudiant;

public class ServiceExport {
    public String ligne(Etudiant e) {
        return e.nom() + ";" + (e.estAdmis() ? "OUI" : "NON");
    }
}

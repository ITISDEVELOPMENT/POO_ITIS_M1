package fr.univ.poo.cleancode.yagni.apres;

import fr.univ.poo.cleancode.Etudiant;

import java.util.List;
import java.util.stream.Collectors;

/** YAGNI : uniquement le besoin réel, un export CSV. */
public class ExportCsvNotes {
    private static final String ENTETE = "nom;filiere;note;admis";

    public String exporter(List<Etudiant> promo) {
        String lignes = promo.stream()
                .map(this::versLigneCsv)
                .collect(Collectors.joining("\n"));
        return ENTETE + "\n" + lignes;
    }

    private String versLigneCsv(Etudiant e) {
        return String.join(";", e.nom(), e.filiere(),
                String.valueOf(e.note()), e.estAdmis() ? "OUI" : "NON");
    }
}

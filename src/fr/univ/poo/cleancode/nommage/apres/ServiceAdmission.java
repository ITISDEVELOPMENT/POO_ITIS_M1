package fr.univ.poo.cleancode.nommage.apres;

import fr.univ.poo.cleancode.Etudiant;

import java.util.ArrayList;
import java.util.List;

/** AVEC bon nommage : le code se lit sans commentaire. */
public class ServiceAdmission {

    private static final int SEUIL_ABSENCES = 10;

    public List<String> nomsDesAdmis(List<Etudiant> promotion, int noteMinimale) {
        List<String> nomsAdmis = new ArrayList<>();
        for (Etudiant etudiant : promotion) {
            if (etudiant.note() >= noteMinimale) {
                nomsAdmis.add(etudiant.nom());
            }
        }
        return nomsAdmis;
    }

    public boolean depasseSeuilAbsences(int joursAbsence) {
        return joursAbsence > SEUIL_ABSENCES;
    }
}

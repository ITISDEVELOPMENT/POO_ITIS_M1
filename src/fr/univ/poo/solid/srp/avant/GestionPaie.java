package fr.univ.poo.solid.srp.avant;

import fr.univ.poo.solid.Employe;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

/** SANS SRP : quatre responsabilités, quatre raisons de changer. */
public class GestionPaie {

    // Responsabilité 1 : calcul métier (service RH)
    public double calculerSalaireNet(Employe e) {
        double brut = e.salaireBase() + 500;   // prime
        return brut * 0.95;                    // retenue 5 %
    }

    // Responsabilité 2 : mise en forme (comptabilité)
    public String genererFiche(Employe e) {
        return "=== FICHE DE PAIE ===\n"
             + "Nom : " + e.nom() + "\n"
             + "Net : " + calculerSalaireNet(e) + " €";
    }

    // Responsabilité 3 : persistance (infrastructure)
    // (fichier écrit dans le dossier temporaire pour ne pas polluer le projet)
    public void enregistrer(Employe e) {
        Path fichier = Path.of(System.getProperty("java.io.tmpdir"), e.nom() + ".txt");
        try (FileWriter fw = new FileWriter(fichier.toFile())) {
            fw.write(genererFiche(e));
        } catch (IOException ex) {
            System.out.println("Erreur d'écriture");
        }
    }

    // Responsabilité 4 : notification
    public void envoyerMail(Employe e) {
        System.out.println("Mail envoyé à " + e.email());
    }
}

package fr.univ.poo.solid.srp.apres;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

/** Une seule raison de changer : la technique de stockage. */
public class DepotFiche {
    public void enregistrer(String nomFichier, String contenu) {
        Path fichier = Path.of(System.getProperty("java.io.tmpdir"), nomFichier);
        try (FileWriter fw = new FileWriter(fichier.toFile())) {
            fw.write(contenu);
            System.out.println("Fiche enregistrée : " + fichier);
        } catch (IOException ex) {
            System.out.println("Erreur : " + ex.getMessage());
        }
    }
}

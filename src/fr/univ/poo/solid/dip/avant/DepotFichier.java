package fr.univ.poo.solid.dip.avant;

public class DepotFichier {
    public void enregistrer(String nomFichier, String contenu) {
        System.out.println("[Fichier] " + nomFichier + " <- " + contenu);
    }
}

package fr.univ.poo.solid.dip.apres;

public class DepotFichier implements DepotFiche {
    public void enregistrer(String id, String contenu) {
        System.out.println("[Fichier] " + id + ".txt <- " + contenu);
    }
}

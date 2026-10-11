package fr.univ.poo.solid.dip.apres;

public class DepotBaseDonnees implements DepotFiche {
    public void enregistrer(String id, String contenu) {
        System.out.println("[BDD] INSERT INTO fiches VALUES ('" + id + "', ...)");
    }
}

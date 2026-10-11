package fr.univ.poo.solid.tp.apres;

public class DepotFichierCommande implements DepotCommande {
    public void sauvegarder(Commande c, double total) {
        System.out.println("[commandes.txt] " + c.client() + ";" + total);
    }
}

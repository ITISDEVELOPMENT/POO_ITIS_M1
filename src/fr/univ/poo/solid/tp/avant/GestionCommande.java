package fr.univ.poo.solid.tp.avant;

/** Code du TP à refactorer : viole les cinq principes SOLID. */
public class GestionCommande {

    public double calculerTotal(double montant, String typeClient) {
        switch (typeClient) {
            case "STANDARD":   return montant * 1.20 + 8;
            case "PREMIUM":    return montant * 0.90 * 1.20 + 8;
            case "ENTREPRISE": return montant + 8;
            default: throw new IllegalArgumentException("Type inconnu");
        }
    }

    public void traiter(String client, String email, double montant, String typeClient) {
        double total = calculerTotal(montant, typeClient);
        new PaiementCarte().payerParCarte(total);
        // Fichier remplacé par un affichage pour la démo
        System.out.println("[commandes.txt] " + client + ";" + total);
        System.out.println("Mail à " + email + " : commande confirmée");
    }
}

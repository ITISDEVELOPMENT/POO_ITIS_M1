package fr.univ.poo.solid.tp.apres;

/** Orchestrateur : toutes les dépendances sont injectées (DIP). */
public class ServiceCommande {
    private final CalculateurCommande calculateur;
    private final DepotCommande depot;
    private final Notificateur notificateur;

    public ServiceCommande(CalculateurCommande calculateur,
                           DepotCommande depot, Notificateur notificateur) {
        this.calculateur = calculateur;
        this.depot = depot;
        this.notificateur = notificateur;
    }

    public double traiter(Commande c, TarifClient tarif, MoyenPaiement paiement) {
        double total = calculateur.total(c.montant(), tarif);
        paiement.payer(total);
        depot.sauvegarder(c, total);
        notificateur.notifier(c.email(), "Commande confirmée : " + total + " €");
        return total;
    }
}

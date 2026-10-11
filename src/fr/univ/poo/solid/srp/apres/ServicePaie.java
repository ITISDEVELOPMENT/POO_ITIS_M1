package fr.univ.poo.solid.srp.apres;

import fr.univ.poo.solid.Employe;

/** Orchestration : coordonne, mais ne fait aucun travail métier. */
public class ServicePaie {
    private final CalculateurSalaire calculateur = new CalculateurSalaire();
    private final GenerateurFiche generateur = new GenerateurFiche();
    private final DepotFiche depot = new DepotFiche();
    private final NotificateurMail notificateur = new NotificateurMail();

    public void traiter(Employe e) {
        double net = calculateur.calculerNet(e);
        String fiche = generateur.generer(e, net);
        depot.enregistrer(e.nom() + ".txt", fiche);
        notificateur.envoyer(e.email(), "Votre fiche de paie est disponible.");
    }
}

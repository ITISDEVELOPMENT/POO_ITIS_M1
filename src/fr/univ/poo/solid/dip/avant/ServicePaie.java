package fr.univ.poo.solid.dip.avant;

import fr.univ.poo.solid.Employe;

/** SANS DIP : le métier dépend directement de classes techniques. */
public class ServicePaie {

    // Dépendances CONCRÈTES créées en dur avec new
    private final DepotFichier depot = new DepotFichier();
    private final NotificateurMail notificateur = new NotificateurMail();

    public void traiter(Employe e) {
        double net = (e.salaireBase() + 500) * 0.95;
        String fiche = "Fiche de " + e.nom() + " : " + net + " €";
        depot.enregistrer(e.nom() + ".txt", fiche);
        notificateur.envoyerMail(e.email(), "Fiche disponible");
    }
}

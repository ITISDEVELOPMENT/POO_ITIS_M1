package fr.univ.poo.solid.dip.apres;

import fr.univ.poo.solid.Employe;

/** Haut niveau : ne connaît AUCUNE classe technique. */
public class ServicePaie {
    private final RegleSalaire regle;
    private final DepotFiche depot;
    private final Notificateur notificateur;

    // Injection par le constructeur
    public ServicePaie(RegleSalaire regle, DepotFiche depot, Notificateur notificateur) {
        this.regle = regle;
        this.depot = depot;
        this.notificateur = notificateur;
    }

    public double traiter(Employe e) {
        double net = regle.calculer(e.salaireBase());
        depot.enregistrer(e.nom(), "Fiche de " + e.nom() + " : " + net + " €");
        notificateur.notifier(e, "Votre fiche de paie est disponible.");
        return net;
    }
}

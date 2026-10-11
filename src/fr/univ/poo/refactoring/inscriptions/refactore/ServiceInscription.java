package fr.univ.poo.refactoring.inscriptions.refactore;

/** Orchestration et notification (prochaine étape : injection, voir le package di). */
public class ServiceInscription {
    private final CalculFraisInscription calcul = new CalculFraisInscription();

    public double inscrire(DemandeInscription demande) {
        double montant = calcul.calculer(demande);
        System.out.println("Inscription de " + demande.nom() + " : " + montant + " €");
        notifier(demande.email(), montant);
        return montant;
    }

    private void notifier(String email, double montant) {
        System.out.println("Mail à " + email + " : vous devez " + montant + " €");
    }
}

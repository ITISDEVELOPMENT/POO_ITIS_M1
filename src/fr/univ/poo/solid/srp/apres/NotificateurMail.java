package fr.univ.poo.solid.srp.apres;

/** Une seule raison de changer : le canal de notification. */
public class NotificateurMail {
    public void envoyer(String destinataire, String message) {
        System.out.println("Mail à " + destinataire + " : " + message);
    }
}

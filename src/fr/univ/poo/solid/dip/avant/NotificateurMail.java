package fr.univ.poo.solid.dip.avant;

public class NotificateurMail {
    public void envoyerMail(String destinataire, String message) {
        System.out.println("[Mail] " + destinataire + " : " + message);
    }
}

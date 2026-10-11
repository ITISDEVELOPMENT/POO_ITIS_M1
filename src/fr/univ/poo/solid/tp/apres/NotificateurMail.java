package fr.univ.poo.solid.tp.apres;

public class NotificateurMail implements Notificateur {
    public void notifier(String dest, String msg) {
        System.out.println("Mail à " + dest + " : " + msg);
    }
}

package fr.univ.poo.solid.dip.apres;

import fr.univ.poo.solid.Employe;

public class NotificateurSms implements Notificateur {
    public void notifier(Employe e, String message) {
        System.out.println("[SMS] " + e.nom() + " : " + message);
    }
}

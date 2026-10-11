package fr.univ.poo.solid.dip.apres;

import fr.univ.poo.solid.Employe;

@FunctionalInterface
public interface Notificateur {
    void notifier(Employe e, String message);
}

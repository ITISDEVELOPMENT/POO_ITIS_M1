package fr.univ.poo.solid.tp.apres;

/** DIP : abstraction de la notification. */
@FunctionalInterface
public interface Notificateur {
    void notifier(String destinataire, String message);
}

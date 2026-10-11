package fr.univ.poo.refactoring.inscriptions.refactore;

/** Introduce Parameter Object. */
public record DemandeInscription(String nom, String email, Cursus cursus,
                                 int nbCours, boolean boursier,
                                 int anneesInscription) {}

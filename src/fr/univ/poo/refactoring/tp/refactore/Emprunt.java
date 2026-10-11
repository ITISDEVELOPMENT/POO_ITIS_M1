package fr.univ.poo.refactoring.tp.refactore;

public record Emprunt(String emprunteur, TypeDocument type,
                      int joursRetard, boolean enseignant) {}

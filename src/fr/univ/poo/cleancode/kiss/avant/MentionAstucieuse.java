package fr.univ.poo.cleancode.kiss.avant;

/** Solution 1 : le code "astucieux". Une note de 21 provoque une exception. */
public class MentionAstucieuse {
    public String mention(int n) {
        return n < 10 ? "-" : new String[]{"Passable", "Passable", "Assez bien",
            "Assez bien", "Bien", "Bien", "Très bien", "Très bien", "Très bien",
            "Très bien", "Très bien"}[n - 10];
    }
}

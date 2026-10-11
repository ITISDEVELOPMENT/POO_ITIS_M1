package fr.univ.poo.cleancode.kiss.avant.mention;

import fr.univ.poo.cleancode.kiss.avant.RegleMention;

public class AssezBien implements RegleMention {
    public boolean accepte(int note) { return note >= 12 && note < 14; }
    public String libelle() { return "Assez bien"; }
}

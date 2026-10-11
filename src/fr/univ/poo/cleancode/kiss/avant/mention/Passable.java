package fr.univ.poo.cleancode.kiss.avant.mention;

import fr.univ.poo.cleancode.kiss.avant.RegleMention;

public class Passable implements RegleMention {
    public boolean accepte(int note) { return note >= 10 && note < 12; }
    public String libelle() { return "Passable"; }
}

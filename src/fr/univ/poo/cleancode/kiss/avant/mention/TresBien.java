package fr.univ.poo.cleancode.kiss.avant.mention;

import fr.univ.poo.cleancode.kiss.avant.RegleMention;

public class TresBien implements RegleMention {
    public boolean accepte(int note) { return note >= 16; }
    public String libelle() { return "Très bien"; }
}

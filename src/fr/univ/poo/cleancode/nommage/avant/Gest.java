package fr.univ.poo.cleancode.nommage.avant;

import java.util.ArrayList;
import java.util.List;

/** SANS bon nommage : il faut déchiffrer au lieu de lire. */
public class Gest {

    public List<String> calc(List<Object[]> l, int s) {
        List<String> r = new ArrayList<>();
        for (Object[] o : l) {
            int n = (int) o[2];
            if (n >= s && n > 0) {
                r.add((String) o[0]);
            }
        }
        return r;
    }

    public boolean chk(int d) {   // d = nombre de jours d'absence
        return d > 10;
    }
}

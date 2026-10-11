package fr.univ.poo.cleancode.tp.avant;

import java.util.List;

/** Code du TP à nettoyer : viole les cinq notions. */
public class Mgr {
    // TODO : export JSON, multi-langue, notifications push

    public double proc(List<Object[]> l, String f, boolean b, int mode) {
        double t = 0;
        int c = 0;
        for (Object[] o : l) {
            if (((String) o[1]).equals(f)) {
                if ((int) o[2] >= 10) {
                    t = t + (int) o[2];
                    c++;
                }
            }
        }
        double m = c == 0 ? 0 : t / c;
        if (b) System.out.println("Moyenne " + f + " : " + m);
        return m;
    }

    public int nbAdm(List<Object[]> l) {
        int c = 0;
        for (Object[] o : l) {
            if ((int) o[2] >= 10) {
                c++;
            }
        }
        return c;
    }
}

package fr.univ.poo.cleancode.kiss.avant;

import java.util.ArrayList;
import java.util.List;

/** 6 fichiers, de la réflexion et des exceptions vérifiées... pour 4 seuils. */
public class MentionFactory {
    private final List<RegleMention> regles = new ArrayList<>();

    public MentionFactory() throws Exception {
        for (String nom : List.of("TresBien", "Bien", "AssezBien", "Passable")) {
            regles.add((RegleMention) Class.forName("fr.univ.poo.cleancode.kiss.avant.mention." + nom)
                          .getDeclaredConstructor().newInstance());
        }
    }

    public String mention(int note) {
        for (RegleMention regle : regles) {
            if (regle.accepte(note)) {
                return regle.libelle();
            }
        }
        return "-";
    }
}

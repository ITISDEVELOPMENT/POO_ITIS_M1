package fr.univ.poo.cleancode.yagni.avant;

import fr.univ.poo.cleancode.Etudiant;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** SANS YAGNI : formats, langues, cache, compression... jamais utilisés. */
public class ExportateurNotes {
    public enum Format { CSV, XML, JSON, PDF }
    public enum Langue { FR, EN, ES }

    private final Map<String, String> cache = new HashMap<>();
    private final Format format;
    private final Langue langue;
    private final boolean compression;
    private final String separateur;

    public ExportateurNotes(Format format, Langue langue,
                            boolean compression, String separateur) {
        this.format = format; this.langue = langue;
        this.compression = compression; this.separateur = separateur;
    }

    public String exporter(List<Etudiant> promo) {
        switch (format) {
            case CSV:  return exporterCsv(promo);
            case XML:  throw new UnsupportedOperationException("TODO");
            case JSON: throw new UnsupportedOperationException("TODO");
            case PDF:  throw new UnsupportedOperationException("TODO");
        }
        return null;
    }

    private String exporterCsv(List<Etudiant> promo) {
        String cle = langue + "-" + compression + "-" + promo.hashCode();
        return cache.computeIfAbsent(cle, k -> {
            StringBuilder sb = new StringBuilder(langue == Langue.FR ? "nom;filiere;note" : "name;track;grade");
            for (Etudiant e : promo) {
                sb.append("\n").append(e.nom()).append(separateur)
                  .append(e.filiere()).append(separateur).append(e.note());
            }
            return sb.toString();
        });
    }
}

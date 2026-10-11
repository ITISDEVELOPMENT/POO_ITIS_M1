package fr.univ.poo.refactoring.tp.refactore;

public enum TypeDocument {
    LIVRE(0.5), DVD(1.0), REVUE(0.2);

    private final double tarifJournalier;

    TypeDocument(double tarifJournalier) {
        this.tarifJournalier = tarifJournalier;
    }

    public double tarifJournalier() { return tarifJournalier; }
}

package fr.univ.poo.refactoring.inscriptions.refactore;

/** Replace Type Code with Enum + Replace Conditional with Polymorphism. */
public enum Cursus {
    LICENCE(180), MASTER(250),
    DOCTORAT(380) {
        @Override public double tarifDeBase(int nbCours) { return prixUnitaire; } // forfait
    };

    protected final double prixUnitaire;

    Cursus(double prixUnitaire) { this.prixUnitaire = prixUnitaire; }

    public double tarifDeBase(int nbCours) { return prixUnitaire * nbCours; }
}

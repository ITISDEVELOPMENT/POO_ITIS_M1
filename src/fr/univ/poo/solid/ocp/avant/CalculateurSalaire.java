package fr.univ.poo.solid.ocp.avant;

/** SANS OCP : chaque nouvelle règle oblige à modifier ce switch. */
public class CalculateurSalaire {

    public double calculer(double salaire, String typeRegle) {
        switch (typeRegle) {
            case "PROMOTION": return salaire * 1.10;
            case "PRIME":     return salaire + 500;
            case "RETENUE":   return salaire * 0.95;
            default:
                throw new IllegalArgumentException("Règle inconnue : " + typeRegle);
        }
    }
}

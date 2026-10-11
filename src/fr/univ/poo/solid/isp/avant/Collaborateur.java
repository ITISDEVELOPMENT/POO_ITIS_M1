package fr.univ.poo.solid.isp.avant;

/** SANS ISP : interface « fourre-tout ». */
public interface Collaborateur {
    String getNom();
    double calculerSalaireMensuel();
    void pointer(int heures);
    void poserConges(int jours);
    double emettreFacture(int joursTravailles);
}

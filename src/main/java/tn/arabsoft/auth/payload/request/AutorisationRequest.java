package tn.arabsoft.auth.payload.request;

import java.sql.Date;

public class AutorisationRequest {
    private String matriculea;
    private Date heureSortie;
    private Date heureRetour;
    private String motif; // Updated to String
    private String duree;

    public AutorisationRequest() {
    }

    public AutorisationRequest(String matriculea, Date heureSortie, Date heureRetour, String motif, String duree) {
        this.matriculea = matriculea;
        this.heureSortie = heureSortie;
        this.heureRetour = heureRetour;
        this.motif = motif;
        this.duree = duree;
    }

    public String getMatriculea() {
        return matriculea;
    }

    public void setMatriculea(String matriculea) {
        this.matriculea = matriculea;
    }

    public Date getHeureSortie() {
        return heureSortie;
    }

    public void setHeureSortie(Date heureSortie) {
        this.heureSortie = heureSortie;
    }

    public Date getHeureRetour() {
        return heureRetour;
    }

    public void setHeureRetour(Date heureRetour) {
        this.heureRetour = heureRetour;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }
}

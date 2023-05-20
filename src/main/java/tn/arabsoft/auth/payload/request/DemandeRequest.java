package tn.arabsoft.auth.payload.request;

import java.sql.Blob;
import java.sql.Date;

public class DemandeRequest {
	private String matriculec;
	private Date dateDebut;
	private Date dateFin;
	private int duree;
	private String statut;
	private String Cause;
	private Long typeConge;
	private Date datedemande;
	private Blob pieceJointe;

	public Blob getPieceJointe() {
		return pieceJointe;
	}

	public void setPieceJointe(Blob pieceJointe) {
		this.pieceJointe = pieceJointe;
	}

	public DemandeRequest() {
		// TODO Auto-generated constructor stub
	}

	public DemandeRequest(String matriculec, Date dateDebut, Date dateFin, int duree, String statut, String cause, Long typeConge,
			Date datedemande) {
		super();
		this.matriculec = matriculec;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.duree = duree;
		this.statut = statut;
		this.Cause = cause;
		this.typeConge = typeConge;
		this.datedemande = datedemande;
	}

	public DemandeRequest(String matriculec, Date dateDebut, Date dateFin, int duree, String statut, String cause, Date datedemande) {
		super();
		this.matriculec = matriculec;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.duree = duree;
		this.statut = statut;
		this.Cause = cause;
		this.datedemande = datedemande;

	}

	public String getMatriculec() {
		return matriculec;
	}

	public void setMatriculec(String matriculec) {
		this.matriculec = matriculec;
	}

	public Date getDatedemande() {
		return datedemande;
	}

	public void setDatedemande(Date datedemande) {
		this.datedemande = datedemande;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public String getCause() {
		return Cause;
	}

	public void setCause(String cause) {
		Cause = cause;
	}

	public Long getTypeConge() {
		return typeConge;
	}

	public void setTypeConge(Long typeConge) {
		this.typeConge = typeConge;
	}
}

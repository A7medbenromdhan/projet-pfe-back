package tn.arabsoft.auth.entity;

import java.io.Serializable;
import java.sql.Blob;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name = "conge")
public class Conge implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idConge;

	private String matriculec;
	private Date dateDebut;
	private Date dateFin;
	private int duree;
	private String statut;
	private String Cause;
	private int soldeConge;
	private Date datedemande;
	private Blob pieceJointe;

	@JsonProperty(access = Access.WRITE_ONLY)
	@ManyToOne
	@JoinColumn(name = "idEmploye")
	private Personnel personnel;

	@JsonProperty(access = Access.WRITE_ONLY)
	@ManyToOne
	@JoinColumn(name = "idType")
	private TypeConge typeConge;

	public Conge() {
	}

	public Conge(String matriculec, Date dateDebut, Date dateFin, int duree, String statut, int soldeConge, String Cause,
			Date datedemande) {
		this.matriculec = matriculec;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.duree = duree;
		this.statut = statut;
		this.soldeConge = soldeConge;
		this.Cause = Cause;
		this.datedemande = datedemande;
	}

	public Conge(String matriculec, Date dateDebut, Date dateFin, int duree, String statut, String cause,
			Date datedemande) {
		this.matriculec = matriculec;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.duree = duree;
		this.statut = statut;
		this.Cause = cause;
		this.datedemande = datedemande;
	}

	public Long getIdConge() {
		return idConge;
	}

	public void setIdConge(Long idConge) {
		this.idConge = idConge;
	}

	public String getMatriculec() {
		return matriculec;
	}

	public void setCause(String cause) {
		Cause = cause;
	}

	public void setMatriculec(String matriculec) {
		this.matriculec = matriculec;
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
	public int getSoldeConge() {
		return soldeConge;
	}

	public void setSoldeConge(int soldeConge) {
		this.soldeConge = soldeConge;
	}

	public Date getDatedemande() {
		return datedemande;
	}

	public void setDatedemande(Date datedemande) {
		this.datedemande = datedemande;
	}

	public Blob getPieceJointe() {
		return pieceJointe;
	}

	public void setPieceJointe(Blob pieceJointe) {
		this.pieceJointe = pieceJointe;
	}

	public Personnel getPersonnel() {
		return personnel;
	}

	public void setPersonnel(Personnel personnel) {
		this.personnel = personnel;
	}

	public TypeConge getTypeConge() {
		return typeConge;
	}

	public void setTypeConge(TypeConge typeConge) {
		this.typeConge = typeConge;
	}

	
			
}
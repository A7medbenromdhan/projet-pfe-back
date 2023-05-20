package tn.arabsoft.auth.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Autorisation")
public class Autorisation implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAutorisation;
	private String matriculea;
	private Date HeureSortie;
	private Date HeureRetour;
	private String Motif; // Updated to String
	private String Duree;

	@ManyToOne
	@JoinColumn(name = "idEmploye")
	private Personnel personnel;

	public Autorisation() {
		// Default constructor without arguments
	}

	public Autorisation(String matriculea, Date heureSortie, Date heureRetour, String motif, String duree, Personnel personnel) {
		super();
		this.matriculea = matriculea;
		HeureSortie = heureSortie;
		HeureRetour = heureRetour;
		Motif = motif;
		Duree = duree;
		this.personnel = personnel;
	}

	public Autorisation(String matriculea, Date heureSortie, Date heureRetour, String motif, String duree) {
		super();
		this.matriculea = matriculea;
		HeureSortie = heureSortie;
		HeureRetour = heureRetour;
		Motif = motif;
		Duree = duree;
	}

	public String getMatriculea() {
		return matriculea;
	}

	public void setMatriculea(String matriculea) {
		this.matriculea = matriculea;
	}

	public Long getIdAutorisation() {
		return idAutorisation;
	}

	public void setIdAutorisation(Long idAutorisation) {
		this.idAutorisation = idAutorisation;
	}

	public Date getHeureSortie() {
		return HeureSortie;
	}

	public void setHeureSortie(Date heureSortie) {
		HeureSortie = heureSortie;
	}

	public Date getHeureRetour() {
		return HeureRetour;
	}

	public void setHeureRetour(Date heureRetour) {
		HeureRetour = heureRetour;
	}

	public String getMotif() {
		return Motif;
	}

	public void setMotif(String motif) {
		Motif = motif;
	}

	public String getDuree() {
		return Duree;
	}

	public void setDuree(String duree) {
		Duree = duree;
	}

	public Personnel getPersonnel() {
		return personnel;
	}

	public void setPersonnel(Personnel personnel) {
		this.personnel = personnel;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}

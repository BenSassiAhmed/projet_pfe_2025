package com.gpro.consulting.tiers.logistique.persistance.gc.reglement.entity;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.gpro.consulting.tiers.logistique.coordination.gc.IConstanteCommerciale;

/**
 * @author Wahid Gazzah
 * @since 01/07/2016
 *
 */
@Entity
@Table(name=IConstanteCommerciale.TABLE_GC_DETAILSREGLEMENT)
public class DetailsReglementEntity implements Serializable{

	private static final long serialVersionUID = -7596441048089968080L;

	@Id
	@SequenceGenerator(name="DETAILSREGLEMENT_ID_GENERATOR", sequenceName=IConstanteCommerciale.SEQUENCE_GC_DETAILSREGLEMENT, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DETAILSREGLEMENT_ID_GENERATOR")
    private Long id;
	
	@Column(name="NUM_PIECE")
	private String numPiece;
	
	@Column(name="BANQUE")
	private String banque;
	
	@Column(name="MONTANT")
	private Double montant;
	
	@Column(name="DATE_EMISSION")
	private Calendar dateEmission;
	
	@Column(name="DATE_ECHEANCE")
	private Calendar dateEcheance;
	
	@Column(name="REF_FACTURE")
	private String refFacture;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "TYPEREGLEMENT_ID")
	private TypeReglementEntity typeReglement;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "GC_REGLEMENT_ID")
	private ReglementEntity reglement;
	
	@Column(name="REGLE")
	private Boolean regle;
	
	@Column(name="OBSERVATION")
	private String observation;
	
	@Column(name="reference")
	private String reference;
	
	
	@Column(name="date_depot_banque")
	private Calendar dateDepotBanque;
	
	
	@Column(name="charge_banque")
	private Double chargeBanque;
	
	@Column(name="tva_banque")
	private Double tvaBanque;
	

	
	@Column(name="BANQUE_SOCIETE")
	private String banqueSociete;
	
	
	
	
	public String getBanqueSociete() {
		return banqueSociete;
	}

	public void setBanqueSociete(String banqueSociete) {
		this.banqueSociete = banqueSociete;
	}

	public Calendar getDateDepotBanque() {
		return dateDepotBanque;
	}

	public void setDateDepotBanque(Calendar dateDepotBanque) {
		this.dateDepotBanque = dateDepotBanque;
	}

	public Double getChargeBanque() {
		return chargeBanque;
	}

	public void setChargeBanque(Double chargeBanque) {
		this.chargeBanque = chargeBanque;
	}

	public Double getTvaBanque() {
		return tvaBanque;
	}

	public void setTvaBanque(Double tvaBanque) {
		this.tvaBanque = tvaBanque;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumPiece() {
		return numPiece;
	}

	public void setNumPiece(String numPiece) {
		this.numPiece = numPiece;
	}

	public String getBanque() {
		return banque;
	}

	public void setBanque(String banque) {
		this.banque = banque;
	}

	public Double getMontant() {
		return montant;
	}

	public void setMontant(Double montant) {
		this.montant = montant;
	}

	public Calendar getDateEmission() {
		return dateEmission;
	}

	public void setDateEmission(Calendar dateEmission) {
		this.dateEmission = dateEmission;
	}

	public Calendar getDateEcheance() {
		return dateEcheance;
	}

	public void setDateEcheance(Calendar dateEcheance) {
		this.dateEcheance = dateEcheance;
	}

	public String getRefFacture() {
		return refFacture;
	}

	public void setRefFacture(String refFacture) {
		this.refFacture = refFacture;
	}

	public TypeReglementEntity getTypeReglement() {
		return typeReglement;
	}

	public void setTypeReglement(TypeReglementEntity typeReglement) {
		this.typeReglement = typeReglement;
	}

	public ReglementEntity getReglement() {
		return reglement;
	}

	public void setReglement(ReglementEntity reglement) {
		this.reglement = reglement;
	}

	public Boolean getRegle() {
		return regle;
	}

	public void setRegle(Boolean regle) {
		this.regle = regle;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}
	
}

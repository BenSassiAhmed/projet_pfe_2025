package com.gpro.consulting.tiers.logistique.persistance.gc.achat.facture.entitie;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.gpro.consulting.tiers.logistique.coordination.gc.IConstanteCommerciale;
/**
 * 
 * The Class DocumentProduitEntity.
 * @author med
 */
@Entity
@Table(name=IConstanteCommerciale.TABLE_GC_DOCUMENTS_FACTUREACHAT)
public class DocumentFactureAchatEntity implements Serializable {

	/**
	 * 
	 */


	/** The Constant serialVersionUID. */



	/**
	 * 
	 */
	private static final long serialVersionUID = 2034485396594008302L;

	/** The id. */
	@Id
	@SequenceGenerator(name="DOCUMENT_FACTUREACHAT_ID_GENERATOR", sequenceName=IConstanteCommerciale.SEQUENCE_GC_DOC_FA_SEQ)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DOCUMENT_FACTUREACHAT_ID_GENERATOR")
	private Long id;

	/** The type document id. */
	@Column(name="com_typedoc_id")
	private Long typeDocumentId;
	
	/** The path. */
	@Column(name="path")
	private String path;

	/** The path. */
	@Column(name = "uid_document")
	private String uidDocument;
	
	/** The bl suppression. */
	@Column(name="bl_suppression")
	private boolean blSuppression;
	
	/** The date creation. */
	@Column(name="date_creation")
	private Calendar dateCreation;

	/** The date modification. */
	@Column(name="date_modification")
	private Calendar dateModification;

	/** The date suppression. */
	@Column(name="date_suppression")
	private Calendar dateSuppression;

	/** * many-to-one association to Produit*. */
	@ManyToOne
	@JoinColumn(name = "GC_FACTAchat_ID")
    private FactureAchatEntity factureAchat;


	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getId() {
		return id;
	}








	public FactureAchatEntity getFactureAchat() {
		return factureAchat;
	}








	public void setFactureAchat(FactureAchatEntity factureAchat) {
		this.factureAchat = factureAchat;
	}








	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the uidDocument
	 */
	public String getUidDocument() {
		return uidDocument;
	}


	/**
	 * @param uidDocument the uidDocument to set
	 */
	public void setUidDocument(String uidDocument) {
		this.uidDocument = uidDocument;
	}


	/**
	 * Gets the type document id.
	 *
	 * @return the type document id
	 */
	public Long getTypeDocumentId() {
		return typeDocumentId;
	}


	/**
	 * Sets the type document id.
	 *
	 * @param typeDocumentId the new type document id
	 */
	public void setTypeDocumentId(Long typeDocumentId) {
		this.typeDocumentId = typeDocumentId;
	}



	/**
	 * Gets the path.
	 *
	 * @return the path
	 */
	public String getPath() {
		return path;
	}


	/**
	 * Sets the path.
	 *
	 * @param path the new path
	 */
	public void setPath(String path) {
		this.path = path;
	}


	/**
	 * Checks if is bl suppression.
	 *
	 * @return true, if is bl suppression
	 */
	public boolean isBlSuppression() {
		return blSuppression;
	}


	/**
	 * Sets the bl suppression.
	 *
	 * @param blSuppression the new bl suppression
	 */
	public void setBlSuppression(boolean blSuppression) {
		this.blSuppression = blSuppression;
	}


	/**
	 * Gets the date creation.
	 *
	 * @return the date creation
	 */
	public Calendar getDateCreation() {
		return dateCreation;
	}


	/**
	 * Sets the date creation.
	 *
	 * @param dateCreation the new date creation
	 */
	public void setDateCreation(Calendar dateCreation) {
		this.dateCreation = dateCreation;
	}


	/**
	 * Gets the date modification.
	 *
	 * @return the date modification
	 */
	public Calendar getDateModification() {
		return dateModification;
	}


	/**
	 * Sets the date modification.
	 *
	 * @param dateModification the new date modification
	 */
	public void setDateModification(Calendar dateModification) {
		this.dateModification = dateModification;
	}


	/**
	 * Gets the date suppression.
	 *
	 * @return the date suppression
	 */
	public Calendar getDateSuppression() {
		return dateSuppression;
	}


	/**
	 * Sets the date suppression.
	 *
	 * @param dateSuppression the new date suppression
	 */
	public void setDateSuppression(Calendar dateSuppression) {
		this.dateSuppression = dateSuppression;
	}





	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	

	

}
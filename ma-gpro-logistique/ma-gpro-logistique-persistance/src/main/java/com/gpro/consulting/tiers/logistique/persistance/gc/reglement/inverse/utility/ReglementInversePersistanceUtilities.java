package com.gpro.consulting.tiers.logistique.persistance.gc.reglement.inverse.utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.gpro.consulting.tiers.logistique.coordination.gc.reglement.echeancier.ResultatRechecheDetailReglementElementValue;
import com.gpro.consulting.tiers.logistique.coordination.gc.reglement.value.DetailsReglementValue;
import com.gpro.consulting.tiers.logistique.coordination.gc.reglement.value.DocumentReglementValue;
import com.gpro.consulting.tiers.logistique.coordination.gc.reglement.value.ElementReglementValue;
import com.gpro.consulting.tiers.logistique.coordination.gc.reglement.value.ReglementValue;
import com.gpro.consulting.tiers.logistique.coordination.gc.reglement.value.ResultatRechecheElementReglementElementValue;
import com.gpro.consulting.tiers.logistique.coordination.gc.reglement.value.ResultatRechecheReglementElementValue;
import com.gpro.consulting.tiers.logistique.coordination.gc.reglement.value.TypeReglementValue;
import com.gpro.consulting.tiers.logistique.persistance.gc.reglement.entity.TypeReglementEntity;
import com.gpro.consulting.tiers.logistique.persistance.gc.reglement.inverse.entity.DetailsReglementInverseEntity;
import com.gpro.consulting.tiers.logistique.persistance.gc.reglement.inverse.entity.DocumentReglementInverseEntity;
import com.gpro.consulting.tiers.logistique.persistance.gc.reglement.inverse.entity.ElementReglementInverseEntity;
import com.gpro.consulting.tiers.logistique.persistance.gc.reglement.inverse.entity.ReglementInverseEntity;

/**
 * Mapping Class from DTO to Entity, and from Entity to DTO
 * 
 * @author Wahid Gazzah
 * @since 01/07/2016
 *
 */

public class ReglementInversePersistanceUtilities {
	
	private ReglementInversePersistanceUtilities(){
		
	}

	public static ReglementInverseEntity toEntity(ReglementValue dto) {
		
		ReglementInverseEntity entity = new ReglementInverseEntity();
		
		entity.setId(dto.getId());
		entity.setPartieIntId(dto.getPartieIntId());
		entity.setReference(dto.getReference());
		entity.setDate(dto.getDate());
		entity.setMontantTotal(dto.getMontantTotal());
		entity.setObservations(dto.getObservations());
		entity.setIdDepot(dto.getIdDepot());
		entity.setGroupeClientId(dto.getGroupeClientId());
		entity.setClientPassager(dto.getClientPassager());
		entity.setBoutiqueId(dto.getBoutiqueId());
		
		entity.setAjoutSpecial(dto.getAjoutSpecial());
		
		entity.setDeclarer(dto.getDeclarer());
		
	    if(dto.getListDetailsReglement() != null){
		     Set<DetailsReglementInverseEntity> list = new HashSet <DetailsReglementInverseEntity>();
		     for (DetailsReglementValue detailsReglementValue : dto.getListDetailsReglement()) {
		    	 DetailsReglementInverseEntity detailsReglementInverseEntity = toEntity(detailsReglementValue);
		    	 detailsReglementInverseEntity.setReglement(entity);
		    	 list.add(detailsReglementInverseEntity);
		    }
		     entity.setListDetailsReglement(list);
		}
	    
	    if(dto.getListElementReglement() != null){
		     Set<ElementReglementInverseEntity> list = new HashSet <ElementReglementInverseEntity>();
		     for (ElementReglementValue elementReglementValue : dto.getListElementReglement()) {
		    	 ElementReglementInverseEntity elementReglementInverseEntity = toEntity(elementReglementValue);
		    	 elementReglementInverseEntity.setReglement(entity);
		    	 list.add(elementReglementInverseEntity);
		    }
		     entity.setListElementReglement(list);
		}
	    
		/*** Liste Document reglement  */
		if (dto.getListDocReglement() != null) {
			Set<DocumentReglementInverseEntity> vListeDocuments = new HashSet<DocumentReglementInverseEntity>();
			for (DocumentReglementValue vDocumentValue : dto.getListDocReglement())
				 {
				DocumentReglementInverseEntity vDe = toEntity(vDocumentValue);
				vDe.setReglement(entity);
				vListeDocuments.add(vDe);
			}
			entity.setDocumentReglement(vListeDocuments);
		}
		
		return entity;
	}

	public static ReglementValue toValue(ReglementInverseEntity entity) {
		
		ReglementValue dto = new ReglementValue();
		
		dto.setId(entity.getId());
		dto.setPartieIntId(entity.getPartieIntId());
		dto.setReference(entity.getReference());
		dto.setDate(entity.getDate());
		dto.setMontantTotal(entity.getMontantTotal());
		dto.setObservations(entity.getObservations());
		dto.setIdDepot(entity.getIdDepot());		
		dto.setGroupeClientId(entity.getGroupeClientId());
		
		dto.setClientPassager(entity.getClientPassager());
		dto.setBoutiqueId(entity.getBoutiqueId());
		
		dto.setAjoutSpecial(entity.getAjoutSpecial());
		
		dto.setDeclarer(entity.isDeclarer());
		
	    if(entity.getListDetailsReglement() != null){
	    	List<DetailsReglementValue> list = new ArrayList <DetailsReglementValue>();
		     for (DetailsReglementInverseEntity detailsReglementInverseEntity : entity.getListDetailsReglement()) {
		    	 DetailsReglementValue detailsReglementValue = toValue(detailsReglementInverseEntity);
		    	 list.add(detailsReglementValue);
		    }
		     
		     Collections.sort(list);
		     dto.setListDetailsReglement(new TreeSet<>(list));
		}
	    
	    if(entity.getListElementReglement() != null){
	    	List<ElementReglementValue> list = new ArrayList <ElementReglementValue>();
		     for (ElementReglementInverseEntity detailsReglementInverseEntity : entity.getListElementReglement()) {
		    	 ElementReglementValue elementReglementValue = toValue(detailsReglementInverseEntity);
		    	 list.add(elementReglementValue);
		    }
		     
		     Collections.sort(list);
		     dto.setListElementReglement(new TreeSet<>(list));
		}
	    
	    
			/*** Liste Document reglement  */
			if (entity.getDocumentReglement()!= null) {
				Set<DocumentReglementValue> vListeDocuments = new HashSet<DocumentReglementValue>();
				for (DocumentReglementInverseEntity vDocumentEntity : entity
						.getDocumentReglement()) {
					DocumentReglementValue vDe = toValue(vDocumentEntity);
					vListeDocuments.add(vDe);
				}
				dto.setListDocReglement(vListeDocuments);
			}
	    
		return dto;
	}
	
	/** DocumentreglementEntite to DocumentReglementValue **/
	public static DocumentReglementValue toValue(
			DocumentReglementInverseEntity pDocumentProduitEntity) {
		DocumentReglementValue documentProduitValue = new DocumentReglementValue();
		documentProduitValue.setId(pDocumentProduitEntity.getId());
		documentProduitValue.setPath(pDocumentProduitEntity.getPath());
		// documentProduitValue.setProduitId(pDocumentProduitEntity.getProduitId());
		documentProduitValue.setUidDocument(pDocumentProduitEntity
				.getUidDocument());
		documentProduitValue.setTypeDocumentId(pDocumentProduitEntity
				.getTypeDocumentId());
		return documentProduitValue;
	}

	/** DocumentLivraisonVenteValue to DocumentLivraisonVenteEntite **/
	public static DocumentReglementInverseEntity toEntity(
			DocumentReglementValue pDocumentProduitValue) {
		DocumentReglementInverseEntity documentProduitEntity = new DocumentReglementInverseEntity();
		if (pDocumentProduitValue.getId() != null) {
			documentProduitEntity.setId(pDocumentProduitValue.getId());
		}
		documentProduitEntity.setPath(pDocumentProduitValue.getPath());
		// documentProduitEntity.setProduitId(pDocumentProduitValue.getProduitId());
		documentProduitEntity.setUidDocument(pDocumentProduitValue
				.getUidDocument());
		documentProduitEntity.setTypeDocumentId(pDocumentProduitValue
				.getTypeDocumentId());
		return documentProduitEntity;
	}

	public static List<ReglementValue> listToValue(List<ReglementInverseEntity> listEntity) {

		List<ReglementValue> list = new ArrayList<ReglementValue>();
		
		for(ReglementInverseEntity entity : listEntity){
			list.add(toValue(entity));
		}
		
		return list;
	}
	
	public static DetailsReglementInverseEntity toEntity(DetailsReglementValue dto) {
		
		DetailsReglementInverseEntity entity = new DetailsReglementInverseEntity();
		
		entity.setId(dto.getId());
		entity.setNumPiece(dto.getNumPiece());
		entity.setBanque(dto.getBanque());
		entity.setMontant(dto.getMontant());
		entity.setDateEmission(dto.getDateEmission());
		entity.setDateEcheance(dto.getDateEcheance());
		entity.setRefFacture(dto.getRefFacture());
		entity.setRegle(dto.getRegle());
		entity.setObservation(dto.getObservation());
		
		entity.setReference(dto.getReference());
		
		entity.setDateDepotBanque(dto.getDateDepotBanque());
		entity.setChargeBanque(dto.getChargeBanque());
		entity.setTvaBanque(dto.getTvaBanque());
		
		entity.setBanqueSociete(dto.getBanqueSociete());
		
		if(dto.getTypeReglementId() != null){
			TypeReglementEntity typeReglement = new TypeReglementEntity();
			typeReglement.setId(dto.getTypeReglementId());
			entity.setTypeReglement(typeReglement);
		}
		
		if(dto.getReglementId() != null){
			ReglementInverseEntity reglement = new ReglementInverseEntity();
			reglement.setId(dto.getReglementId());
			entity.setReglement(reglement);
		}
		
		
		return entity;
		
	}
	
	public static ElementReglementInverseEntity toEntity(ElementReglementValue dto) {
		
		ElementReglementInverseEntity entity = new ElementReglementInverseEntity();
		
		entity.setId(dto.getId());
		entity.setMontant(dto.getMontant());
		entity.setRefFacture(dto.getRefFacture());
		entity.setRefBL(dto.getRefBL());
		entity.setMontantDemande(dto.getMontantDemande());
		entity.setDateEcheance(dto.getDateEcheance());
		
		if(dto.getReglementId() != null){
			ReglementInverseEntity reglement = new ReglementInverseEntity();
			reglement.setId(dto.getReglementId());
			entity.setReglement(reglement);
		}
		
		return entity;
	}
	
	public static TypeReglementEntity toEntity(TypeReglementValue dto) {
		
		TypeReglementEntity entity = new TypeReglementEntity();
		
		entity.setId(dto.getId());
		entity.setDesignation(dto.getDesignation());
		entity.setaTerme(dto.getaTerme());
		
		entity.setPrefixe(dto.getPrefixe());
		
		entity.setRegle(dto.getRegle());
		
		return entity;
	}
	
	public static DetailsReglementValue toValue(DetailsReglementInverseEntity entity) {
		
		DetailsReglementValue dto = new DetailsReglementValue();
		
		dto.setId(entity.getId());

		dto.setNumPiece(entity.getNumPiece());
		dto.setBanque(entity.getBanque());
		dto.setMontant(entity.getMontant());
		dto.setDateEmission(entity.getDateEmission());
		dto.setDateEcheance(entity.getDateEcheance());
		dto.setRefFacture(entity.getRefFacture());
		dto.setRegle(entity.getRegle());
		dto.setObservation(entity.getObservation());
		
		dto.setReference(entity.getReference());
		
		
		dto.setDateDepotBanque(entity.getDateDepotBanque());
		dto.setChargeBanque(entity.getChargeBanque());
		dto.setTvaBanque(entity.getTvaBanque());
		
		dto.setBanqueSociete(entity.getBanqueSociete());
		
		
		if(entity.getReglement() != null){
			dto.setReglementId(entity.getReglement().getId());
		}
		
		if(entity.getTypeReglement() != null){
			dto.setTypeReglementId(entity.getTypeReglement().getId());
		}
		
		return dto;
		
	}
	
	public static ResultatRechecheDetailReglementElementValue toDetailResultatValue(
			DetailsReglementInverseEntity entity) {
		
		ResultatRechecheDetailReglementElementValue dto = new ResultatRechecheDetailReglementElementValue();
		dto.setId(entity.getId());
		dto.setNumPiece(entity.getNumPiece());
		dto.setBanque(entity.getBanque());
		dto.setMontant(entity.getMontant());
		dto.setDateEmission(entity.getDateEmission());
		dto.setDateEcheance(entity.getDateEcheance());
		dto.setRefFacture(entity.getRefFacture());
		dto.setRegle(entity.getRegle());
		dto.setObservation(entity.getObservation());
		
		dto.setReferenceDetReglement(entity.getReference());
		
		dto.setDateDepotBanque(entity.getDateDepotBanque());
		dto.setChargeBanque(entity.getChargeBanque());
		dto.setTvaBanque(entity.getTvaBanque());
		
		dto.setBanqueSociete(entity.getBanqueSociete());
		
		if(entity.getTypeReglement() != null){
			if(entity.getTypeReglement().getId() != null){
				dto.setTypeReglementId(entity.getTypeReglement().getId());
			}
		}
		if(entity.getReglement() != null){
			if(entity.getReglement().getId() != null){
				dto.setReglementId(entity.getReglement().getId());
			}
		}
			
		return dto;
	}
	public static ElementReglementValue toValue(ElementReglementInverseEntity entity) {
		
		ElementReglementValue dto = new ElementReglementValue();
		
		dto.setId(entity.getId());
		dto.setMontant(entity.getMontant());
		dto.setRefFacture(entity.getRefFacture());
		dto.setRefBL(entity.getRefBL());
		dto.setMontantDemande(entity.getMontantDemande());
		dto.setDateEcheance(entity.getDateEcheance());
		
		if(entity.getReglement() != null){
			dto.setReglementId(entity.getReglement().getId());
		}
		
		return dto;
	}
	
	public static TypeReglementValue toValue(TypeReglementEntity entity) {
		
		TypeReglementValue dto = new TypeReglementValue();
		
		dto.setId(entity.getId());
		dto.setDesignation(entity.getDesignation());
		dto.setaTerme(entity.getaTerme());
		
		dto.setPrefixe(entity.getPrefixe());
		
		dto.setRegle(entity.getRegle());
		return dto;
	}

	public static List<TypeReglementValue> toListValue(List<TypeReglementEntity> listEntity) {
		
		List<TypeReglementValue> list = new ArrayList<TypeReglementValue>();
		
		for(TypeReglementEntity entity : listEntity){
			list.add(toValue(entity));
		}
		
		return list;
	}
	
	public static ResultatRechecheReglementElementValue toResultatRechecheReglementElementValue(
			ReglementInverseEntity entity) {
		
		ResultatRechecheReglementElementValue dto = new ResultatRechecheReglementElementValue();
		
		dto.setId(entity.getId());
		dto.setPartieIntId(entity.getPartieIntId());
		dto.setReference(entity.getReference());
		dto.setDate(entity.getDate());
		dto.setMontantTotal(entity.getMontantTotal());
		
		
		dto.setGroupeClientId(entity.getGroupeClientId());
		
		dto.setDeclarer(entity.isDeclarer());
		
		return dto;
	}



	public static ResultatRechecheElementReglementElementValue toValueElementReglementAffichage(
			ElementReglementInverseEntity entity) {
		ResultatRechecheElementReglementElementValue dto = new ResultatRechecheElementReglementElementValue();
		
		dto.setId(entity.getId());
		dto.setMontant(entity.getMontant());
		dto.setRefFacture(entity.getRefFacture());
		dto.setRefBL(entity.getRefBL());
		dto.setMontantDemande(entity.getMontantDemande());
		dto.setDateEcheance(entity.getDateEcheance());
		
		if(entity.getReglement() != null){
			
			dto.setReglementId(entity.getReglement().getId());
			dto.setReference(entity.getReglement().getReference());
			dto.setDate(entity.getReglement().getDate());
			dto.setMontantTotal(entity.getReglement().getMontantTotal());
			dto.setPartieIntId(entity.getReglement().getPartieIntId());
			
			dto.setGroupeClientId(entity.getReglement().getGroupeClientId());
			
			dto.setDeclarer(entity.getReglement().isDeclarer());
			
		}
		
		
		return dto;
	}

	public static ResultatRechecheElementReglementElementValue toValueDetailsReglementAffichage(
			DetailsReglementInverseEntity entity) {

		ResultatRechecheElementReglementElementValue dto = new ResultatRechecheElementReglementElementValue();
		
		dto.setId(entity.getId());
		dto.setMontant(entity.getMontant());
		dto.setRefFacture(entity.getRefFacture());
		
		
		dto.setNumPiece(entity.getNumPiece());
		dto.setBanque(entity.getBanque());
		dto.setDateEmission(entity.getDateEmission());
		dto.setDateEcheance(entity.getDateEcheance());
		dto.setRegle(entity.getRegle());
		dto.setObservation(entity.getObservation());

		
		dto.setReferenceDetReglement(entity.getReference());
	
		
		dto.setDateDepotBanque(entity.getDateDepotBanque());
		dto.setChargeBanque(entity.getChargeBanque());
		dto.setTvaBanque(entity.getTvaBanque());
		dto.setBanqueSociete(entity.getBanqueSociete());
		
		if(entity.getReglement() != null){
			
			dto.setReglementId(entity.getReglement().getId());
			dto.setReference(entity.getReglement().getReference());
			dto.setDate(entity.getReglement().getDate());
			dto.setMontantTotal(entity.getReglement().getMontantTotal());
			dto.setPartieIntId(entity.getReglement().getPartieIntId());
			
			dto.setGroupeClientId(entity.getReglement().getGroupeClientId());
			
			dto.setDeclarer(entity.getReglement().isDeclarer());
			
		}
		
		
		return dto;
	}
	
	
}

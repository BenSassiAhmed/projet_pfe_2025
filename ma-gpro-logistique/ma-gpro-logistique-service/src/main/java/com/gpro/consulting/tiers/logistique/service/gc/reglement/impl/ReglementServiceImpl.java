package com.gpro.consulting.tiers.logistique.service.gc.reglement.impl;

import java.util.Calendar;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gpro.consulting.tiers.logistique.coordination.gc.reglement.validate.value.FactureNonRegleValue;
import com.gpro.consulting.tiers.logistique.coordination.gc.reglement.validate.value.LivraisonNonRegleValue;
import com.gpro.consulting.tiers.logistique.coordination.gc.reglement.validate.value.RefFactureAvoirNonRegleValue;
import com.gpro.consulting.tiers.logistique.coordination.gc.reglement.validate.value.RefFactureNonRegleValue;
import com.gpro.consulting.tiers.logistique.coordination.gc.reglement.validate.value.RefLivraisonNonRegleValue;
import com.gpro.consulting.tiers.logistique.coordination.gc.reglement.validate.value.ValidateReglementResultValue;
import com.gpro.consulting.tiers.logistique.coordination.gc.reglement.value.RechercheMulticritereReglementValue;
import com.gpro.consulting.tiers.logistique.coordination.gc.reglement.value.ReglementValue;
import com.gpro.consulting.tiers.logistique.coordination.gc.reglement.value.ResultatRechecheReglementValue;
import com.gpro.consulting.tiers.logistique.domaine.gc.reglement.IReglementDomaine;
import com.gpro.consulting.tiers.logistique.service.gc.reglement.IReglementService;

/**
 * implementation of {@link IReglementService}
 * 
 * @author Wahid Gazzah
 * @since 01/07/2016
 *
 */

@Service
@Transactional
public class ReglementServiceImpl implements IReglementService{

	private static final Logger logger = LoggerFactory.getLogger(ReglementServiceImpl.class);

	@Autowired
	private IReglementDomaine reglementDomaine;
	
	@Override
	public String create(ReglementValue reglement) {
		
		//logger.info("Delegating request to Domaine layer.");
		
		return reglementDomaine.create(reglement);
	}

	@Override
	public ReglementValue getById(Long id) {
		
		//logger.info("Delegating request id {} to Domaine layer.",id);
		
		return reglementDomaine.getById(id);
	}

	@Override
	public String update(ReglementValue reglement) {
		
		//logger.info("Delegating request to Domaine layer.");
		
		return reglementDomaine.update(reglement);
	}

	@Override
	public void delete(Long id) {
		
		//logger.info("Delegating request id {} to Domaine layer.",id);
		
		reglementDomaine.delete(id);
	}

	@Override
	public List<ReglementValue> getAll() {
		
		//logger.info("Delegating request to Domaine layer.");
		
		return reglementDomaine.getAll();
	}

	@Override
	public ResultatRechecheReglementValue rechercherMultiCritere(
			RechercheMulticritereReglementValue request) {
		
		return reglementDomaine.rechercherMultiCritere(request);
	}

	@Override
	public ValidateReglementResultValue validateByClientId(Long clientId) {
		
		//logger.info("Delegating request clientId {} to Domaine layer.",clientId);
		
		return reglementDomaine.validateByClientId(clientId);
	}

	
	@Override
	public List<ReglementValue> listeRefReglementCache() {
		
		//logger.info("Delegating request to Domaine layer.");
		
		return reglementDomaine.listeRefReglementCache();
	}
	
	@Override
	public List< RefFactureNonRegleValue>  getRefFactureNonRegleByClientId(Long clientId) {
		
		//logger.info("Delegating request clientId {} to Domaine layer.",clientId);
		
		return reglementDomaine.getRefFactureNonRegleByClientId(clientId);
	}
	
	@Override
	public List< RefLivraisonNonRegleValue> getRefBLNonRegleByClientId(Long clientId) {
		
		//logger.info("Delegating request clientId {} to Domaine layer.",clientId);
		
		return reglementDomaine.getRefBLNonRegleByClientId(clientId);
	}

	@Override
	public ValidateReglementResultValue validateByGroupeClientId(Long clientId) {
		return reglementDomaine.validateByGroupeClientId(clientId);
	}

	@Override
	public List<RefFactureNonRegleValue> getRefFactureNonRegleByGroupeId(Long groupeId) {
		// TODO Auto-generated method stub
		return reglementDomaine.getRefFactureNonRegleByGroupeId(groupeId);
	}

	@Override
	public List<RefLivraisonNonRegleValue> getRefBLNonRegleByGroupeId(Long groupeId) {
		// TODO Auto-generated method stub
		return reglementDomaine.getRefBLNonRegleByGroupeId(groupeId);
	}

	@Override
	public String getCurrentReference(Calendar instance, boolean b) {
		// TODO Auto-generated method stub
		return reglementDomaine.getCurrentReference(instance,b);
	}

	@Override
	public String getCurrentReferenceByDateAndDeclaree(Calendar date, boolean declarer, boolean increment) {
		// TODO Auto-generated method stub
		return reglementDomaine.getCurrentReferenceByDateAndDeclaree(date,declarer,increment);
	}

	@Override
	public List<RefFactureAvoirNonRegleValue> getRefFactureAvoirNonRegleByClientId(Long clientId) {
		// TODO Auto-generated method stub
		return reglementDomaine.getRefFactureAvoirNonRegleByClientId(clientId);
	}

	@Override
	public List<RefFactureAvoirNonRegleValue> getRefFactureAvoirNonRegleByGroupeId(Long groupeId) {
		// TODO Auto-generated method stub
		return reglementDomaine.getRefFactureAvoirNonRegleByGroupeId(groupeId);
	}

	
}

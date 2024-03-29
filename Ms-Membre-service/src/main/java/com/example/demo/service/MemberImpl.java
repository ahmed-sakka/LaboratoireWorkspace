package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.beans.EventBean;
import com.example.demo.beans.OutilBean;
import com.example.demo.beans.PublicationBean;
import com.example.demo.dao.EnseignantChercheurRepository;
import com.example.demo.dao.EtudiantRepository;
import com.example.demo.dao.EventMemberRepository;
import com.example.demo.dao.MemberRepository;
import com.example.demo.dao.MembrePublicationRepository;
import com.example.demo.dao.OutilMemebrRepository;
import com.example.demo.entities.EnseignantChercheur;
import com.example.demo.entities.Etudiant;
import com.example.demo.entities.EventMember;
import com.example.demo.entities.EventMemberId;
import com.example.demo.entities.Membre;
import com.example.demo.entities.MembrePubId;
import com.example.demo.entities.Membre_Publication;
import com.example.demo.entities.OutilMember;
import com.example.demo.entities.OutilMemberId;
import com.example.demo.proxies.EventProxy;
import com.example.demo.proxies.OutilProxy;
import com.example.demo.proxies.PublicationProxy;

@Service
public class MemberImpl implements IMemberService {
	@Autowired
	MemberRepository memberRepository;
	@Autowired
	EtudiantRepository etudiantRepository;
	@Autowired
	EnseignantChercheurRepository enseignantChercheurRepository;
	@Autowired
	MembrePublicationRepository membrePublicationRepository;
	@Autowired
	PublicationProxy publicationProxy;
	@Autowired
	private EventMemberRepository eventmemberRepository;
	@Autowired
	private OutilMemebrRepository outilMemberRepository;
	@Autowired
	EventProxy eventProxy;
	@Autowired
	OutilProxy outilProxy;



	public Membre addMember(Membre m) {
		memberRepository.save(m);
		return m;
	}

	public void deleteMember(Long id) {
		memberRepository.deleteById(id);
	}

	public Membre updateMember(Membre m) {
		return memberRepository.saveAndFlush(m);
	}

	public Membre findMember(Long id) {
		Membre m = (Membre) memberRepository.findById(id).get();
		return m;
	}

	public List<Membre> findAll() {
		return memberRepository.findAll();
	}

	public Membre findByCin(String cin) {
		return memberRepository.findByCin(cin);
	}

	public Membre findByEmail(String email) {
		return memberRepository.findByEmail(email);
	}

	public List<Membre> findByNom(String nom) {
		return memberRepository.findByNomStartingWith(nom);
	}

	public List<Etudiant> findByDiplome(String diplome) {
		return etudiantRepository.findByDiplome(diplome);
	}

	public List<EnseignantChercheur> findByGrade(String grade) {
		return enseignantChercheurRepository.findByGrade(grade);
	}

	public List<EnseignantChercheur> findByEtablissement(String etablissement) {
		return enseignantChercheurRepository.findByEtablissement(etablissement);
	}

	@Override
	public List<Etudiant> findAllEtudiants() {
		return etudiantRepository.findAll();
	}

	@Override
	public void affecterEncadrantToEtudiant(Long idetd, Long idens) {
		Etudiant etd = (Etudiant) memberRepository.findById(idetd).get();
		EnseignantChercheur ens = (EnseignantChercheur) memberRepository.findById(idens).get();
		etd.setEncadrant(ens);
		memberRepository.save(etd);
	}

	@Override
	public void affecterAuteurToPublication(Long idauteur, Long idpub) {
		Membre mbr = memberRepository.findById(idauteur).get();
		Membre_Publication mbs = new Membre_Publication();
		mbs.setAuteur(mbr);
		mbs.setId(new MembrePubId(idpub, idauteur));
		membrePublicationRepository.save(mbs);
	}

	@Override
	public List<PublicationBean> findPublicationParAuteur(Long idauteur) {
		List<PublicationBean> pubs = new ArrayList<>();
		List<Membre_Publication> idpubs = membrePublicationRepository.findWithAutheurId(idauteur);
		idpubs.forEach(s -> {
			System.out.println(s);
			pubs.add(publicationProxy.recupererUnePublication(s.getId().getPublication_id()).
					getContent());
		});
		return pubs;
	}



	

	@Override
	public void affecterEventToMember(Long idEvent, Long idMember) {

		EventMemberId id = new EventMemberId(idEvent, idMember);
		EventMember eventMmebr = new EventMember(id);
		eventmemberRepository.save(eventMmebr);

	}

	@Override
	public List<EventBean> findMemberEvents(Long idMember) {
		List<EventMember> eventsMember = eventmemberRepository.findwithMemberId(idMember);
		List<EventBean> events = new ArrayList<>();
		eventsMember.forEach(e -> {
			events.add(eventProxy.getEventById(e.getId().getEventId()));
		});
		return events;
	}

	@Override
	public void affecterOutilToMember(Long idOutil, Long idMember) {
		OutilMemberId id = new OutilMemberId(idOutil, idMember);
		OutilMember outilMember =new OutilMember(id);
		outilMemberRepository.save(outilMember);

	}

	@Override 
	public List<OutilBean> findMemberOutils(Long idMember) {
		
		List<OutilBean> outils = new ArrayList<OutilBean>();
		List<OutilMember> memberOutils = outilMemberRepository.findWithMemberId(idMember);
		memberOutils.forEach(outilMember -> {
			outils.add(outilProxy.recupererUneOutil(outilMember.getId().getOutilId()));
			
		});
		return outils;
	}

	@Override
	public List<Membre> findWithEventId(Long idevent) {
		List<EventMember> eventsMember = eventmemberRepository.findwithEventId(idevent);
		List<Membre> members =  new ArrayList<>();
		eventsMember.forEach(em -> {
			
			members.add( memberRepository.findById(em.getId().getMemberId()).get());
			
			
			
		});
		return members;
	}

	@Override
	public List<Membre> findWithPublicationId(Long idPub) {
		List<Membre_Publication> pubMember = membrePublicationRepository.findpubId(idPub);
		List<Membre> members =  new ArrayList<>();
		pubMember.forEach(em -> {
			
			members.add( memberRepository.findById(em.getId().getAuteur_id()).get());
			
			
			
		});
		return members;
	}

	@Override
	public List<Membre> findWithOutil(Long idOutil) {
		List<OutilMember> outilMember = outilMemberRepository.findoutilId(idOutil);
		List<Membre> members =  new ArrayList<>();
		outilMember.forEach(em -> {
			
			members.add(memberRepository.findById(em.getId().getMemberId()).get());
			
			
			
		});
		return members;
	}

	@Override
	public void deleteAffectationOutil(Long outilId) {
		this.outilMemberRepository.deleteByIdOutilId(outilId);
		
	}

	@Override
	public void deleteAffectationPublication(Long publicationId) {
		this.membrePublicationRepository.deleteByIdPublicationId(publicationId);
		
	}

	@Override
	public void deleteAffectationEvent(Long eventId) {
		this.eventmemberRepository.deleteByIdEventId(eventId);
		
	}

	@Override
	public void deleteAffectationOutil(Long outilId, Long idMember) {
		OutilMember outilMember = this.outilMemberRepository.findById(new OutilMemberId(outilId, idMember)).get();
		
		 outilMemberRepository.delete(outilMember);
		
	}

	@Override
	public void deleteAffectationPublication(Long publicationId, Long idMember) {
		Membre_Publication membrePublication = membrePublicationRepository.findById(new MembrePubId(publicationId, idMember)).get();	
		this.membrePublicationRepository.delete(membrePublication);
			
		
	}

	@Override
	public void deleteAffectationEvent(Long eventId, Long idMember) {
		
		 this.eventmemberRepository.findById(new EventMemberId(eventId, idMember)).ifPresent(x ->{ 
			 System.out.println("hello");
			 this.eventmemberRepository.delete(x);});
		
	}
		
	public List<EnseignantChercheur> findAllEnseignantChercheur() {
		return enseignantChercheurRepository.findAll();
	}

	@Override
	public List<Etudiant> findEnsStudent(Long id) {
	
		return this.etudiantRepository.findByEncadrantId(id);
	}

	
}

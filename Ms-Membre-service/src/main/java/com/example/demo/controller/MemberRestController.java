package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.beans.PublicationBean;
import com.example.demo.entities.EnseignantChercheur;
import com.example.demo.entities.Etudiant;
import com.example.demo.entities.Membre;
import com.example.demo.proxies.PublicationProxy;
import com.example.demo.service.IMemberService;

@RestController
public class MemberRestController {
	@Autowired
	IMemberService memberService;
	@Autowired
	PublicationProxy publicationProxy;


	@RequestMapping(value = "/membres", method = RequestMethod.GET)
	public List<Membre> findMembres() {
		return memberService.findAll();
	}

	@GetMapping(value = "/membres/{id}")
	public Membre findOneMemberById(@PathVariable Long id) {
		return memberService.findMember(id);
	}

	@GetMapping(value = "/membres/search/{cin}")
	public Membre findOneMemberByCin(@PathVariable String cin) {
		return memberService.findByCin(cin);
	}

	@GetMapping(value = "/membres/searchEmail/{email}")
	public Membre findOneMemberByEmail(@PathVariable String email) {
		return memberService.findByEmail(email);
	}

	@PostMapping(value = "/membres/enseignant")
	public Membre addMembre(@RequestBody EnseignantChercheur m) {
		return memberService.addMember(m);
	}
	@GetMapping(value = "/membres/enseignant")
	public List<EnseignantChercheur> findAllEnseignantChercheur() {
		return memberService.findAllEnseignantChercheur();
	}

	@PostMapping(value = "/membres/etudiant")
	public Membre addMembre(@RequestBody Etudiant e) {
		return memberService.addMember(e);
	}

	@DeleteMapping(value = "/membres/{id}")
	public void deleteMembre(@PathVariable Long id) {
		memberService.deleteMember(id);
	}

	@PutMapping(value = "/membres/etudiant/{id}")
	public Membre updateMembre(@PathVariable Long id, @RequestBody Etudiant p) {
		p.setId(id);
		return memberService.updateMember(p);
	}

	@PutMapping(value = "/membres/enseignant/{id}")
	public Membre updateMembre(@PathVariable Long id, @RequestBody EnseignantChercheur p) {
		p.setId(id);
		return memberService.updateMember(p);
	}

	@PutMapping(value = "/membres/etudiant/{idetd}/{idens}")
	public void affecterEncadrantToEtudiant(@PathVariable Long idetd, @PathVariable Long idens) {

		memberService.affecterEncadrantToEtudiant(idetd, idens);

	}

	@GetMapping("/membres/publications")
	public CollectionModel<PublicationBean> listerpublication() {
		return publicationProxy.listeDesPublications();

	}

	@GetMapping("/membres/publications/{id}")
	public EntityModel<PublicationBean> listerunepublication(@PathVariable Long id) {
		return publicationProxy.recupererUnePublication(id);

	}

	@GetMapping("/membres/publications/auteur/{id}")
	public List<PublicationBean> listerpublicationbymembre(@PathVariable(name = "id") Long idaut) {
		return memberService.findPublicationParAuteur(idaut);
	}

	@GetMapping("/membres/fullmember/{id}")
	public Membre findAFullMember(@PathVariable(name = "id") Long id) {
		Membre mbr = memberService.findMember(id);
		

		mbr.setPublications(memberService.findPublicationParAuteur(id));
		mbr.setEvents(memberService.findMemberEvents(id));
		mbr.setOutils(memberService.findMemberOutils(id));

		return mbr;
	}
	@GetMapping("/membres/affecterEvent/{idEvent}/{idMem}")

	public void affecterEvent(@PathVariable(name = "idEvent") Long idEvent,@PathVariable(name = "idMem") Long idMem)

	{

		memberService.affecterEventToMember(idEvent, idMem);

	}
	
	@GetMapping("/membres/affecterOutil/{idOutil}/{idMem}")

	public void affecterOutil(@PathVariable(name = "idOutil") Long idOutil,@PathVariable(name = "idMem") Long idMem)

	{

		memberService.affecterOutilToMember(idMem, idOutil);

	}
	
	@GetMapping("/membres/findWithEventId/{eventId}")
	public List<Membre>findWithEventId(@PathVariable(name="eventId") Long eventId){
		
		return memberService.findWithEventId(eventId);
		
		
	}
	@GetMapping("/membres/findWithPubId/{PubId}")
	public List<Membre>findWithPubId(@PathVariable(name="PubId") Long PubId){
		
		return memberService.findWithPublicationId(PubId);
		
		
	}
	
	@GetMapping("/membres/findWithoutilId/{outilId}")
	public List<Membre>findWithoutilId(@PathVariable(name="outilId") Long outilId){
		
		return memberService.findWithOutil(outilId);
		
		
	}

}
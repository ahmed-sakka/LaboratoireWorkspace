package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.example.demo.beans.PublicationBean;
import com.example.demo.entities.EnseignantChercheur;
import com.example.demo.entities.Etudiant;
import com.example.demo.entities.Membre;
import com.example.demo.proxies.PublicationProxy;
import com.example.demo.service.IMemberService;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class MsMembreServiceApplication implements CommandLineRunner {

	@Autowired
	IMemberService memberService;
	@Autowired
	PublicationProxy publicationProxy;
	

	public static void main(String[] args) {
		SpringApplication.run(MsMembreServiceApplication.class, args);
	}

	public void run(String... args) throws Exception {
/*
		memberService.addMember(new Etudiant());
		memberService.addMember(new Etudiant());
		memberService.addMember(new EnseignantChercheur());
		memberService.addMember(new EnseignantChercheur());
		// Update a Member
		Membre m = memberService.findMember(1L);
		m.setCv("cv1.pdf");
		m.setCin("123");
		m.setEmail("123@gmail.com");
		memberService.updateMember(m);
		memberService.affecterEncadrantToEtudiant(1L, 3L);
		memberService.affecterEncadrantToEtudiant(2L, 3L);
*/
		// Delete a Member
		// memberService.deleteMember(2L);

		/*
		 * EnseignantChercheur ens = (EnseignantChercheur) memberService.findMember(3L);
		 * List<Etudiant> etds = ens.getEtudiants(); etds.forEach((n) ->
		 * System.out.println(n.getId()));
		 */
/*
		PublicationBean p = publicationProxy.recupererUnePublication(1L).getContent();
		System.out.println(p);

		// affecter une publication à un auteur

		// 1-récupérer la publication par id en invoquant publication-service
		PublicationBean pub1 = publicationProxy.recupererUnePublication(1L).getContent();
		System.out.println(pub1.getTitre() + "  " + pub1.getId());
		PublicationBean pub2 = publicationProxy.recupererUnePublication(2L).getContent();
		System.out.println(pub2.getTitre() + "  " + pub2.getId());

		// 2- affecter pub à member
		memberService.affecterAuteurToPublication(1L, pub1.getId());
		memberService.affecterAuteurToPublication(2L, pub1.getId());
		memberService.affecterAuteurToPublication(1L, pub2.getId());

		// afficher le nombre de publication du membre 1
		List<PublicationBean> lstpubs = memberService.findPublicationParAuteur(1L);
		lstpubs.forEach(r -> System.out.println(r.toString()));
*/
	}

}

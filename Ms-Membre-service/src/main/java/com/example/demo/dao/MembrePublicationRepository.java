package com.example.demo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.MembrePubId;
import com.example.demo.entities.Membre_Publication;


@Transactional
@Repository
public interface MembrePublicationRepository extends JpaRepository<Membre_Publication, MembrePubId> {
	@Query("select m from Membre_Publication m where m.id.publicationId=:x")
	List<Membre_Publication> findpubId(@Param ("x") Long autId);
	@Query("select m from Membre_Publication m where m.id.auteur_id=:x")
	List<Membre_Publication> findWithAutheurId(@Param ("x") Long auteur_id);

	void deleteByIdPublicationId(Long pubId);
}

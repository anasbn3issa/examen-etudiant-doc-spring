package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entity.Document;


public interface DocRepository extends CrudRepository<Document, String> {
	@Query("SELECT d FROM Document d WHERE d.etudiant.matricule = ?1")
	List<Document>findDocsByEtudiant(Long matricule);

	/*@Query("DELETE d FROM Document d WHERE d.etudiant.matricule = ?1")
	List<Document>deleteDocsByEtudiant(Long matricule);*/
}

package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entity.Document;
import tn.esprit.spring.entity.Etudiant;

public interface EtudiantRepository extends CrudRepository<Etudiant, Long> {

}

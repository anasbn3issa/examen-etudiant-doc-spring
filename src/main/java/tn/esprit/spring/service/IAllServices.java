package tn.esprit.spring.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import tn.esprit.spring.entity.Document;
import tn.esprit.spring.entity.Etudiant;

public interface IAllServices {

	public void ajouterEtudiant (Etudiant etudiant);
	public void ajouterDoc (Document d);
	public void affecterDocumentEtudiant (String idDoc, Long matricule);
	public List<Document>findDocsByEtudiant( Long matricule);
	public void suppEtudiantAllDocs (Long matricule);
}

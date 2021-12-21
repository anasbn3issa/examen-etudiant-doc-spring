package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Document;
import tn.esprit.spring.entity.Etudiant;

import tn.esprit.spring.repository.DocRepository;
import tn.esprit.spring.repository.EtudiantRepository;

@Service
public class AllServices implements IAllServices{

	@Autowired
	EtudiantRepository etudiantRepository;
	@Autowired
	DocRepository docRepository;
	@Override
	public void ajouterEtudiant(Etudiant etudiant) {
		etudiantRepository.save(etudiant);		
	}
	@Override
	public void ajouterDoc(Document d) {
		docRepository.save(d);		
	}
	@Override
	public void affecterDocumentEtudiant(String idDoc, Long matricule) {
		Document doc = docRepository.findById(idDoc).orElse(null);
		Etudiant etudiant = etudiantRepository.findById(matricule).orElse(null);
		doc.setEtudiant(etudiant);
		docRepository.save(doc);
	}
	@Override
	public List<Document> findDocsByEtudiant(Long matricule) {
		return docRepository.findDocsByEtudiant(matricule);
	}
	@Override
	public void suppEtudiantAllDocs(Long matricule) {
		Etudiant e= etudiantRepository.findById(matricule).orElse(null);
		if (e!=null) {
			for(Document doc:e.getDocuments()) {
				docRepository.deleteById(doc.getIdDoc());
			}
			etudiantRepository.deleteById(matricule);
		}
		/*docRepository.deleteDocsByEtudiant(matricule);
		etudiantRepository.deleteById(matricule);*/

		
	}
	

}

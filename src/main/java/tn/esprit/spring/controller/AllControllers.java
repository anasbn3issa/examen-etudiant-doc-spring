package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import tn.esprit.spring.entity.Document;
import tn.esprit.spring.entity.Etudiant;
import tn.esprit.spring.service.IAllServices;

@RestController
@RequestMapping("/springexam")
@Api(tags= "All controllers")
public class AllControllers {
	@Autowired
	IAllServices service;
	
	@PostMapping("/add-etudiant")
	@ResponseBody
	public void ajouterEtudiant(@RequestBody Etudiant etudiant) {
		service.ajouterEtudiant(etudiant);
	}
	
	@PostMapping("/add-doc")
	@ResponseBody
	public void ajouterDoc(@RequestBody Document d) {
		service.ajouterDoc(d);
	}
	
	@PutMapping("/affect-doc-etudiant")
	@ResponseBody
	public void affecterDocumentEtudiant(String idDoc, Long matricule) {
		service.affecterDocumentEtudiant(idDoc, matricule);
	}
	
	@GetMapping("/get-docs/{matricule}")
	@ResponseBody
	public List<Document>findDocsByEtudiant(@PathVariable("matricule") Long matricule) {
		return service.findDocsByEtudiant(matricule);
	}
	
	@PutMapping("/delete-etudiant-and-his-docs/{matricule}")
	@ResponseBody
	public void suppEtudiantAllDocs(@PathVariable("matricule") Long matricule) {
		service.suppEtudiantAllDocs(matricule);
	}

	
}

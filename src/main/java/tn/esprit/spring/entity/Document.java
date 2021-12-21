package tn.esprit.spring.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Document {
	@Id
	private String idDoc;
	private String titre;
	private String auteur;
	private int nbPages;
	
	@Enumerated(EnumType.STRING)
	private typeDoc typeDoc; 
	
	@ManyToOne
	@Fetch(value=FetchMode.SELECT)
	@JoinColumn(name="matricule")
	private Etudiant etudiant;
}

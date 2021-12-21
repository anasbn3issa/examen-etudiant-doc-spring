package tn.esprit.spring.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Etudiant {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long matricule;
	private String prenom;
	private String nom;
	private String password;

	@Enumerated(EnumType.STRING)
	private typeEtudiant typeEtudiant;
	
	@OneToMany(mappedBy="etudiant")
	@JsonIgnore
	private Set<Document> documents;
}

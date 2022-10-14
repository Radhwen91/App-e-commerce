package com.esprit.examen.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import javax.persistence.OneToMany;


@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Client implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idClient")
	 Long idClient; // Clé primaire
	 String nom;
	 String prenom;
	 String email;
	 String password;
	@Temporal(TemporalType.DATE)
	 Date dateNaissance;
	@Enumerated(EnumType.STRING)
	 Profession profession;
	@Enumerated(EnumType.STRING)
	 CategorieClient categorieClient;
	@OneToMany(cascade = CascadeType.ALL)
	 List<Facture> Facture;




	public Client(String nom, String prenom,Date dateNaissance, String email, String password, 
			Profession profession, CategorieClient categorieClient) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password;
		this.dateNaissance = dateNaissance;
		this.profession = profession;
		this.categorieClient = categorieClient;
	}

	

}

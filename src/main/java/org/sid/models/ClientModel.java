package org.sid.models;

import java.time.LocalDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document
@NoArgsConstructor
@AllArgsConstructor

public class ClientModel {
	@Id
	String id;
	String nom;
	Boolean etudiant;
	LocalDate naissance;
}

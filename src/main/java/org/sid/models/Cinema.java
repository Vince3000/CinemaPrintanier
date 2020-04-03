package org.sid.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * @author vince
 *Model de cinéma
 */
@Data
@Document
@NoArgsConstructor
@AllArgsConstructor

public class Cinema {
	@Id
	private String id;
	private String nom;
	private String address;
	@DBRef
	private Salle salles;
}

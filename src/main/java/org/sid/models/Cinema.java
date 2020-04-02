package org.sid.models;

import java.util.ArrayList;
import java.util.List;

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
	String id;
	String nom;
	String address;
	@DBRef
	private List<Salle> Salle = new ArrayList<>();
}

package org.sid.models;

import java.time.LocalDateTime;
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
 *salle se référe à Salle
 */
@Data
@Document
@AllArgsConstructor
@NoArgsConstructor

public class Seance {
	@Id
	private String id;
	private LocalDateTime date;
	private String type;
	private int duree;
	private Salle salle;
	//@DBRef 	//Si possibilité d'etre utiliser plusieur fois
	private Film film;
	private  List<Assister> Client = new ArrayList<>();
}

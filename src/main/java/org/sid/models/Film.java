package org.sid.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document
@NoArgsConstructor
@AllArgsConstructor

public class Film {
	@Id
	String id;
	String titre;
	int duree_minute;
	int age_limite;
	String genre;
	String visa;
}

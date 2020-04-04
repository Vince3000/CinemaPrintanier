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
	private String id;
	private String titre;
	private int dureeMinute;
	private int ageLimite;
	private String genre;
	private String visa;
	private String Comm;
	private String note;
}

package org.sid.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document
@AllArgsConstructor
@NoArgsConstructor

public class SeanceModel {
	@Id
	String id;
	String film;
	LocalDate date;
	String type;
	int duree;
	@DBRef
	private List<AssisterModel> dbsalle = new ArrayList<>();
	@DBRef
	private List<FilmModel> dbfilm = new ArrayList<>();
}

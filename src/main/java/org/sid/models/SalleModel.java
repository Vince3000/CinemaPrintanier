package org.sid.models;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor

public class SalleModel {

	@Id
	String id;
	String nom;
	int place;
	@DBRef
	private List<SeanceModel> seance = new ArrayList<>();
}

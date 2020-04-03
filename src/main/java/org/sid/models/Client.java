package org.sid.models;

import java.time.LocalDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author vince
 *Client se référe à Assister
 */
@Data
@Document
@NoArgsConstructor
@AllArgsConstructor

public class Client {
	@Id
	private String id;
	private String nom;
	private boolean etudiant;
	private LocalDate naissance;
}

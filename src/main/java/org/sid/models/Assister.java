package org.sid.models;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author vince
 *salle se référe à Seance
 *client se référe à client
 *public assister permet l'ajout de client
 */
@Data
@Document
@NoArgsConstructor
@AllArgsConstructor

public class Assister {
	private float prix;
	@DBRef
	private Client client;
}

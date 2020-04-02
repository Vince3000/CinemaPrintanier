package org.sid.dto;

import java.util.List;

import org.sid.models.Cinema;
import org.sid.models.Salle;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CinemaDto {
	private Cinema cinema;
	private List<Salle> salles;	
}

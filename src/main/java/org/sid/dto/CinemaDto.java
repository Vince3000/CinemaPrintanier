package org.sid.dto;

import java.util.List;

import org.sid.models.CinemaModel;
import org.sid.models.SalleModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CinemaDto {

	private CinemaModel cinema;
	private List<SalleModel> salles;
	
}

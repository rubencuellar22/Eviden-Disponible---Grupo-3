package com.grupotres.back_personal_disponible.model.dto;

import java.io.Serializable;

import com.grupotres.back_personal_disponible.model.SkLenguage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SkLenguageDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idSklenguage;
	private String sklenguage;
	private String nivel;

    public SkLenguageDTO (SkLenguage skl) {
		this.setIdSklenguage(skl.getIdSklenguage());
		this.setSklenguage(skl.getSklenguage());
		this.setNivel(skl.getNivel());
    }
}

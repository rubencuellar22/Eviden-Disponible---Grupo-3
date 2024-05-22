package com.grupotres.back_personal_disponible.model.dto;

import java.io.Serializable;

import com.grupotres.back_personal_disponible.model.SkTechnology;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SkTechnologyDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idSkTechnology;
	private String sktechnology;
	private int nivel;

    public SkTechnologyDTO (SkTechnology skt) {
		this.setIdSkTechnology(skt.getIdSkTechnology());
		this.setSktechnology(skt.getSktechnology());
		this.setNivel(skt.getNivel());
    }
}

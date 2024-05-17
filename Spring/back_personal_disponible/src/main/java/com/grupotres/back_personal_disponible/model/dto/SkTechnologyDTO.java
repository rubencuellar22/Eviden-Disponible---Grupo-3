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

    public SkTechnologyDTO skTechnologyToSkTechnologyDTO(SkTechnology skt) {
		SkTechnologyDTO sktDTO = new SkTechnologyDTO();
		sktDTO.setIdSkTechnology(skt.getIdSkTechnology());
		sktDTO.setSktechnology(skt.getSktechnology());
		sktDTO.setNivel(skt.getNivel());
		return sktDTO;
    }
}

package com.grupotres.back_personal_disponible.model.dto;

import java.io.Serializable;

import com.grupotres.back_personal_disponible.model.SkMethod;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SkMethodDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idSkmethod;
	private String Skmethod;
	private int nivel;

    public SkMethodDTO skMethodToSkMethodDTO(SkMethod skm) {
		SkMethodDTO skmDTO = new SkMethodDTO();
		skmDTO.setIdSkmethod(skm.getIdSkmethod());
		skmDTO.setSkmethod(skm.getSkmethod());
		skmDTO.setNivel(skm.getNivel());
		return skmDTO;
    }
}

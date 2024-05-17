package com.grupotres.back_personal_disponible.model.dto;

import java.io.Serializable;

import com.grupotres.back_personal_disponible.model.SkBusSkill;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class SkBusSkillDTO implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idSkBusSkill;
    private String skBusSkill;
    private int nivel;

    public SkBusSkillDTO skBusSkillToSkBusSkillDTO(SkBusSkill skbs) {
        SkBusSkillDTO skbsDTO = new SkBusSkillDTO();
        skbsDTO.setIdSkBusSkill(skbs.getIdSkBusSkill());
        skbsDTO.setSkBusSkill(skbs.getSkBusSkill());
        skbsDTO.setNivel(skbs.getNivel());
        return skbsDTO;
    }

    // Constructor, getters y setters
}

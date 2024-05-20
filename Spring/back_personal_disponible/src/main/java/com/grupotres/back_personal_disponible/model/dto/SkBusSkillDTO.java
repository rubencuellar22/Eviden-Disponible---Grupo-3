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

    public SkBusSkillDTO (SkBusSkill skbs) {
        this.setIdSkBusSkill(skbs.getIdSkBusSkill());
        this.setSkBusSkill(skbs.getSkBusSkill());
        this.setNivel(skbs.getNivel());
    }

    // Constructor, getters y setters
}

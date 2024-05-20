package com.grupotres.back_personal_disponible.model.dto;

import java.io.Serializable;

import com.grupotres.back_personal_disponible.model.SkTechSkill;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SkTechSkillDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idSkTechSkill;
	private String skTechSkill;
	private int nivel;

    public SkTechSkillDTO (SkTechSkill skts) {
		this.setIdSkTechSkill(skts.getIdSkTechSkill());
		this.setSkTechSkill(skts.getSkTechSkill());
		this.setNivel(skts.getNivel());
    }
}

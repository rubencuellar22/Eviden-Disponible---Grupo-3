package com.grupotres.back_personal_disponible.model.dto;

import java.io.Serializable;

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
    private EmpleadoDTO empleado;
    private String skBusSkill;
    private int nivel;

    // Constructor, getters y setters
}

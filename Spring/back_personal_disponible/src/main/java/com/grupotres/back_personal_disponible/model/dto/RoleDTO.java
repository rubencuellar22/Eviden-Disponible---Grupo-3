package com.grupotres.back_personal_disponible.model.dto;

import java.io.Serializable;

import com.grupotres.back_personal_disponible.model.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long idRole;
	private String role;
	private int nivel;

    public RoleDTO(Role role) {
		this.setIdRole(role.getIdRole());
		this.setRole(role.getRole());
		this.setNivel(role.getNivel());
    }
}

package com.grupotres.back_personal_disponible.model.dto;

import java.io.Serializable;

import com.grupotres.back_personal_disponible.model.Grupo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GrupoDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long idGrupo;
    private String grupos;
    private String cc;
    private String grupo1;
    private String grupo2;
    private String grupo3;
    private String grupo4;

    public GrupoDTO(Grupo grupo) {
        this.setIdGrupo(grupo.getId_grupo());
        this.setGrupos(grupo.getGrupos());
        this.setCc(grupo.getCc());
        this.setGrupo1(grupo.getGrupo1());
        this.setGrupo2(grupo.getGrupo2());
        this.setGrupo3(grupo.getGrupo3());
        this.setGrupo4(grupo.getGrupo4());
    }
}

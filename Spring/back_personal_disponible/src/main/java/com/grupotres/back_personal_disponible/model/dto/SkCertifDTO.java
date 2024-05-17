package com.grupotres.back_personal_disponible.model.dto;

import java.io.Serializable;

import com.grupotres.back_personal_disponible.model.SkCertif;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SkCertifDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	 private int idSkCertif;
	    private String skCertif;
	    private boolean external;

    public SkCertifDTO skCertifToSkCertifDTO(SkCertif skc) {
		SkCertifDTO skcDTO = new SkCertifDTO();
		skcDTO.setIdSkCertif(skc.getIdSkCertif());
		skcDTO.setSkCertif(skc.getSkcertif());
		skcDTO.setExternal(skc.getExternal());
		return skcDTO;
    }
}

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

    public SkCertifDTO (SkCertif skc) {
		this.setIdSkCertif(skc.getIdSkCertif());
		this.setSkCertif(skc.getSkcertif());
		this.setExternal(skc.getExternal());
    }
}

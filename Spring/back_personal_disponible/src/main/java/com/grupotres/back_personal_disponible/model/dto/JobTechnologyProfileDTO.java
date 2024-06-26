package com.grupotres.back_personal_disponible.model.dto;

import java.io.Serializable;

import com.grupotres.back_personal_disponible.model.JobTechnologyProfile;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobTechnologyProfileDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idJobTechnologyProfile;
	private String jobTechnologyProfile;
	private int nivel;


    public JobTechnologyProfileDTO(JobTechnologyProfile jtp) {
		this.setIdJobTechnologyProfile(jtp.getIdJobTechnologyProfile());
		this.setJobTechnologyProfile(jtp.getJobTechnologyProfile());
		this.setNivel(jtp.getNivel());
    }
}


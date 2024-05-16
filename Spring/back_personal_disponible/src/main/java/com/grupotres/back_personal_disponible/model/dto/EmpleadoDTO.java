package com.grupotres.back_personal_disponible.model.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.grupotres.back_personal_disponible.model.Grupo;
import com.grupotres.back_personal_disponible.model.JobTechnologyProfile;
import com.grupotres.back_personal_disponible.model.Role;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmpleadoDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long gin;
    private String name;
    private String subgroup;
    private String status;
    private Date bench;
    private String das;
    private String ciudad;
    private String agrupacion;
    private String lineManager;
    private Double jornada;
    private String gcm;
    private String categoria;
    private int nivelgcm;
    private Double scr;
    private String n4;
    private String jobTechnology;
    private List<JobTechnologyProfileDTO> jobTechnologyProfiles;
    private String skills;
    private RoleDTO role;
    private boolean rlt;
    private List<SkLenguageDTO> skLenguages;
    private List<SkMethodDTO> skMethods;
    private List<SkTechSkillDTO> skTechSkills;
    private List<SkCertifDTO> skCertifs;
    private List<SkTechnologyDTO> skTechnologies;
    private List<SkBusSkillDTO> skBusSkills;

}

package com.grupotres.back_personal_disponible.model.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.grupotres.back_personal_disponible.model.*;

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
	private GrupoDTO grupo;
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

	public EmpleadoDTO(Empleado emp) {
        	this.setGin(emp.getGin());
        	this.setName(emp.getName());
        	this.setSubgroup(emp.getSubgroup());
        	this.setStatus(emp.getStatus());
        	this.setBench(emp.getBench());
        	this.setDas(emp.getDas());
        	this.setCiudad(emp.getCiudad());
        	this.setAgrupacion(emp.getAgrupacion());
        	this.setLineManager(emp.getLineManager());
        	this.setJornada(emp.getJornada());
        	this.setGcm(emp.getGcm());
        	this.setCategoria(emp.getCategoria());
        	this.setNivelgcm(emp.getNivelgcm());
        	this.setScr(emp.getScr());
			this.setGrupo(new GrupoDTO(emp.getGrupo()));
        	this.setN4(emp.getN4());
        	this.setJobTechnology(emp.getJobTechnology());
        	this.setSkills(emp.getSkills());
        	this.setRole(new RoleDTO(emp.getRole()));
        	this.setRlt(emp.isRlt());
        	this.setJobTechnologyProfiles(new ArrayList<JobTechnologyProfileDTO>());
        	for(JobTechnologyProfile jtp : emp.getJobTechnologyProfiles()) {
        		this.getJobTechnologyProfiles().add(new JobTechnologyProfileDTO(jtp));
        	}
        	this.setSkLenguages(new ArrayList<SkLenguageDTO>());
        	for(SkLenguage skl : emp.getSkLenguages()) {
        		this.getSkLenguages().add(new SkLenguageDTO(skl));
        	}
        	this.setSkMethods(new ArrayList<SkMethodDTO>());
        	for(SkMethod skm : emp.getSkMethods()) {
        		this.getSkMethods().add(new SkMethodDTO(skm));
        	}
        	this.setSkTechSkills(new ArrayList<SkTechSkillDTO>());
        	for(SkTechSkill skts : emp.getSkTechSkills()) {
        		this.getSkTechSkills().add(new SkTechSkillDTO(skts));
        	}
        	this.setSkCertifs(new ArrayList<SkCertifDTO>());
            for(SkCertif skc : emp.getSkCertifs()) {
                this.getSkCertifs().add(new SkCertifDTO(skc));
            }
            this.setSkTechnologies(new ArrayList<SkTechnologyDTO>());
            for(SkTechnology skt : emp.getSkTechnologies()) {
                this.getSkTechnologies().add(new SkTechnologyDTO(skt));
            }
            this.setSkBusSkills(new ArrayList<SkBusSkillDTO>());
            for(SkBusSkill skbs : emp.getSkBusSkills()) {
                this.getSkBusSkills().add(new SkBusSkillDTO(skbs));
            }

    }
}

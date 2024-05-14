package com.grupotres.back_personal_disponible.model;

import java.io.Serializable;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 * The persistent class for the empleado database table.
 * 
 */
@Entity
@NamedQuery(name="Empleado.findAll", query="SELECT e FROM Empleado e")
public class Empleado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int gin;
	private String name;
	private String subgroup;
	private String status;
	private Date bench;
	private String das;
	private String ciudad;
	private String agrupacion;
	@Column(name="line_manager")
	private String lineManager;
	private Double jornada;
	private String gcm;
	private String categoria;
	private int nivelgcm;
	private Double scr;
	@ManyToOne
	@JoinColumn(name="grupos")
	private Grupo grupo;
	@Column(name="n_4")
	private String n4;
	@Column(name="job_technology")
	private String jobTechnology;

	@OneToMany(mappedBy="empleado")
	private List<JobTechnologyProfile> jobTechnologyProfiles = new ArrayList<JobTechnologyProfile>();

	private String skills;

	@OneToOne(mappedBy="empleado")
	private Role role;

	private boolean rlt;

	@OneToMany(mappedBy="empleado")
	private List<SkLenguage> skLenguages  = new ArrayList<SkLenguage>();

	@OneToMany(mappedBy="empleado")
	private List<SkMethod> skMethods = new ArrayList<SkMethod>();

	@OneToMany(mappedBy="empleado")
	private List<SkTechSkill> skTechSkills = new ArrayList<SkTechSkill>();

	@OneToMany(mappedBy="empleado")
	private List<SkCertif> skCertifs = new ArrayList<SkCertif>();

	@OneToMany(mappedBy="empleado")
	private List<SkTechnology> skTechnologies = new ArrayList<SkTechnology>();

	@OneToMany(mappedBy="empleado")
	private List<SkBusSkill> skBusSkills = new ArrayList<SkBusSkill>();

	public Empleado() {
	}

	public int getGin() {
		return gin;
	}

	public void setGin(int gin) {
		this.gin = gin;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubgroup() {
		return subgroup;
	}

	public void setSubgroup(String subgroup) {
		this.subgroup = subgroup;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getBench() {
		return bench;
	}

	public void setBench(Date bench) {
		this.bench = bench;
	}

	public String getDas() {
		return das;
	}

	public void setDas(String das) {
		this.das = das;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getAgrupacion() {
		return agrupacion;
	}

	public void setAgrupacion(String agrupacion) {
		this.agrupacion = agrupacion;
	}

	public String getLineManager() {
		return lineManager;
	}

	public void setLineManager(String lineManager) {
		this.lineManager = lineManager;
	}

	public Double getJornada() {
		return jornada;
	}

	public void setJornada(Double jornada) {
		this.jornada = jornada;
	}

	public String getGcm() {
		return gcm;
	}

	public void setGcm(String gcm) {
		this.gcm = gcm;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public int getNivelgcm() {
		return nivelgcm;
	}

	public void setNivelgcm(int nivelgcm) {
		this.nivelgcm = nivelgcm;
	}

	public Double getScr() {
		return scr;
	}

	public void setScr(Double scr) {
		this.scr = scr;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public String getN4() {
		return n4;
	}

	public void setN4(String n4) {
		this.n4 = n4;
	}

	public String getJobTechnology() {
		return jobTechnology;
	}

	public void setJobTechnology(String jobTechnology) {
		this.jobTechnology = jobTechnology;
	}

	public List<JobTechnologyProfile> getJobTechnologyProfiles() {
		return jobTechnologyProfiles;
	}

	public void setJobTechnologyProfiles(List<JobTechnologyProfile> jobTechnologyProfiles) {
		this.jobTechnologyProfiles = jobTechnologyProfiles;
	}

	public void addJobTechnologyProfile(JobTechnologyProfile jobTechnologyProfile) {
		this.jobTechnologyProfiles.add(jobTechnologyProfile);
	}

	public void removeJobTechnologyProfile(JobTechnologyProfile jobTechnologyProfile) {
		this.jobTechnologyProfiles.remove(jobTechnologyProfile);
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public boolean isRlt() {
		return rlt;
	}

	public void setRlt(boolean rlt) {
		this.rlt = rlt;
	}

	public List<SkLenguage> getSkLenguages() {
		return skLenguages;
	}

	public void setSkLenguages(List<SkLenguage> skLenguages) {
		this.skLenguages = skLenguages;
	}

	public void addSklenguage(SkLenguage skLenguage) {
		this.skLenguages.add(skLenguage);
	}

	public void removeSklenguage(SkLenguage skLenguage) {
		this.skLenguages.remove(skLenguage);
	}

	public List<SkMethod> getSkMethods() {
		return skMethods;
	}

	public void setSkMethods(List<SkMethod> skMethods) {
		this.skMethods = skMethods;
	}

	public void addSkMethod(SkMethod skMethod) {
		this.skMethods.add(skMethod);
	}

	public void removeSkMethod(SkMethod skMethod) {
		this.skMethods.remove(skMethod);
	}

	public List<SkTechSkill> getSkTechSkills() {
		return skTechSkills;
	}

	public void setSkTechSkills(List<SkTechSkill> skTechSkills) {
		this.skTechSkills = skTechSkills;
	}

	public void addSkTechSkill(SkTechSkill skTechSkill) {
		this.skTechSkills.add(skTechSkill);
	}

	public void removeSkTechSkill(SkTechSkill skTechSkill) {
		this.skTechSkills.remove(skTechSkill);
	}

	public List<SkCertif> getSkCertifs() {
		return skCertifs;
	}

	public void setSkCertifs(List<SkCertif> skCertifs) {
		this.skCertifs = skCertifs;
	}

	public void addSkCertif(SkCertif skCertif) {
		this.skCertifs.add(skCertif);
	}

	public void removeSkCertif(SkCertif skCertif) {
		this.skCertifs.remove(skCertif);
	}

	public List<SkTechnology> getSkTechnologies() {
		return skTechnologies;
	}

	public void setSkTechnologies(List<SkTechnology> skTechnologies) {
		this.skTechnologies = skTechnologies;
	}

	public void addSkTechnology(SkTechnology skTechnology) {
		this.skTechnologies.add(skTechnology);
	}

	public void removeSkTechnology(SkTechnology skTechnology) {
		this.skTechnologies.remove(skTechnology);
	}

	public List<SkBusSkill> getSkBusSkills() {
		return skBusSkills;
	}

	public void setSkBusSkills(List<SkBusSkill> skBusSkills) {
		this.skBusSkills = skBusSkills;
	}

	public void addSkbusSkill(SkBusSkill skBusSkill) {
		this.skBusSkills.add(skBusSkill);
	}

	public void removeSkbusSkill(SkBusSkill skBusSkill) {
		this.skBusSkills.remove(skBusSkill);
	}

	@Override
	public String toString() {
		return "Empleado{" +
				"gin=" + gin +
				", name='" + name + '\'' +
				", subgroup='" + subgroup + '\'' +
				", status='" + status + '\'' +
				", bench=" + bench +
				", das='" + das + '\'' +
				", ciudad='" + ciudad + '\'' +
				", agrupacion='" + agrupacion + '\'' +
				", lineManager='" + lineManager + '\'' +
				", jornada=" + jornada +
				", gcm='" + gcm + '\'' +
				", categoria='" + categoria + '\'' +
				", nivelgcm=" + nivelgcm +
				", scr=" + scr +
				", grupo=" + grupo +
				", n4='" + n4 + '\'' +
				", jobTechnology='" + jobTechnology + '\'' +
				", jobTechnologyProfiles=" + jobTechnologyProfiles +
				", skills='" + skills + '\'' +
				", role=" + role +
				", rlt=" + rlt +
				", skLenguages=" + skLenguages +
				", skMethods=" + skMethods +
				", skTechSkills=" + skTechSkills +
				", skCertifs=" + skCertifs +
				", skTechnologies=" + skTechnologies +
				", skBusSkills=" + skBusSkills +
				'}';
	}
}
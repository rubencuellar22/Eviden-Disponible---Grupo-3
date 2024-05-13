package com.grupotres.back_personal_disponible.model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.math.BigDecimal;
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

	private String agrupacion;

	private String bench;

	private String categoria;

	private String cc;

	private String ccname;

	private String ciudad;

	private String das;

	private String gcm;

	private String group1;

	private String group2;

	private String group3;

	private String group4;

	@Column(name="job_technology")
	private String jobTechnology;

	@Column(name="jobtechnology_profile")
	private String jobtechnologyProfile;

	private BigDecimal jornada;

	@Column(name="line_manager")
	private String lineManager;

	@Column(name="n_4")
	private String n4;

	private String name;

	private int nivelgcm;

	private String rlt;

	private String role;

	private BigDecimal scr;

	
	private String skbusskills;

	
	private String skcertif;

	private String skills;

	private String sklanguages;

	
	private String skmethods;

	
	private String sktechnologies;

	
	private String sktechskills;

	private String status;

	private String subgroup;

	//bi-directional many-to-one association to Certificacion
	@OneToMany(mappedBy="empleado")
	private List<Certificacion> certificaciones;

	//bi-directional many-to-one association to Grupo
	@ManyToOne
	@JoinColumn(name="grupos")
	private Grupo grupo;

	//bi-directional many-to-one association to Idioma
	@OneToMany(mappedBy="empleado")
	private List<Idioma> idiomas;

	//bi-directional many-to-one association to JobTechnology
	@OneToMany(mappedBy="empleado")
	private List<JobTechnology> jobTechnologies;

	//bi-directional many-to-one association to JobTechnologyProfile
	@OneToMany(mappedBy="empleado")
	private List<JobTechnologyProfile> jobTechnologyProfiles;

	//bi-directional many-to-one association to Metodologia
	@OneToMany(mappedBy="empleado")
	private List<Metodologia> metodologias;

	//bi-directional many-to-one association to Rol
	@OneToMany(mappedBy="empleado")
	private List<Rol> roles;

	//bi-directional many-to-one association to SubSkill
	@OneToMany(mappedBy="empleado")
	private List<SubSkill> subSkills;

	//bi-directional many-to-one association to TechSkill
	@OneToMany(mappedBy="empleado")
	private List<TechSkill> techSkills;

	//bi-directional many-to-one association to Tecnologia
	@OneToMany(mappedBy="empleado")
	private List<Tecnologia> tecnologias;

	public Empleado() {
	}

	public int getGin() {
		return this.gin;
	}

	public void setGin(int gin) {
		this.gin = gin;
	}

	public String getAgrupacion() {
		return this.agrupacion;
	}

	public void setAgrupacion(String agrupacion) {
		this.agrupacion = agrupacion;
	}

	public String getBench() {
		return this.bench;
	}

	public void setBench(String bench) {
		this.bench = bench;
	}

	public String getCategoria() {
		return this.categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getCc() {
		return this.cc;
	}

	public void setCc(String cc) {
		this.cc = cc;
	}

	public String getCcname() {
		return this.ccname;
	}

	public void setCcname(String ccname) {
		this.ccname = ccname;
	}

	public String getCiudad() {
		return this.ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getDas() {
		return this.das;
	}

	public void setDas(String das) {
		this.das = das;
	}

	public String getGcm() {
		return this.gcm;
	}

	public void setGcm(String gcm) {
		this.gcm = gcm;
	}

	public String getGroup1() {
		return this.group1;
	}

	public void setGroup1(String group1) {
		this.group1 = group1;
	}

	public String getGroup2() {
		return this.group2;
	}

	public void setGroup2(String group2) {
		this.group2 = group2;
	}

	public String getGroup3() {
		return this.group3;
	}

	public void setGroup3(String group3) {
		this.group3 = group3;
	}

	public String getGroup4() {
		return this.group4;
	}

	public void setGroup4(String group4) {
		this.group4 = group4;
	}

	public String getJobTechnology() {
		return this.jobTechnology;
	}

	public void setJobTechnology(String jobTechnology) {
		this.jobTechnology = jobTechnology;
	}

	public String getJobtechnologyProfile() {
		return this.jobtechnologyProfile;
	}

	public void setJobtechnologyProfile(String jobtechnologyProfile) {
		this.jobtechnologyProfile = jobtechnologyProfile;
	}

	public BigDecimal getJornada() {
		return this.jornada;
	}

	public void setJornada(BigDecimal jornada) {
		this.jornada = jornada;
	}

	public String getLineManager() {
		return this.lineManager;
	}

	public void setLineManager(String lineManager) {
		this.lineManager = lineManager;
	}

	public String getN4() {
		return this.n4;
	}

	public void setN4(String n4) {
		this.n4 = n4;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNivelgcm() {
		return this.nivelgcm;
	}

	public void setNivelgcm(int nivelgcm) {
		this.nivelgcm = nivelgcm;
	}

	public String getRlt() {
		return this.rlt;
	}

	public void setRlt(String rlt) {
		this.rlt = rlt;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public BigDecimal getScr() {
		return this.scr;
	}

	public void setScr(BigDecimal scr) {
		this.scr = scr;
	}

	public String getSkbusskills() {
		return this.skbusskills;
	}

	public void setSkbusskills(String skbusskills) {
		this.skbusskills = skbusskills;
	}

	public String getSkcertif() {
		return this.skcertif;
	}

	public void setSkcertif(String skcertif) {
		this.skcertif = skcertif;
	}

	public String getSkills() {
		return this.skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public String getSklanguages() {
		return this.sklanguages;
	}

	public void setSklanguages(String sklanguages) {
		this.sklanguages = sklanguages;
	}

	public String getSkmethods() {
		return this.skmethods;
	}

	public void setSkmethods(String skmethods) {
		this.skmethods = skmethods;
	}

	public String getSktechnologies() {
		return this.sktechnologies;
	}

	public void setSktechnologies(String sktechnologies) {
		this.sktechnologies = sktechnologies;
	}

	public String getSktechskills() {
		return this.sktechskills;
	}

	public void setSktechskills(String sktechskills) {
		this.sktechskills = sktechskills;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSubgroup() {
		return this.subgroup;
	}

	public void setSubgroup(String subgroup) {
		this.subgroup = subgroup;
	}

	public List<Certificacion> getCertificaciones() {
		return this.certificaciones;
	}

	public void setCertificaciones(List<Certificacion> certificaciones) {
		this.certificaciones = certificaciones;
	}

	public Certificacion addCertificacione(Certificacion certificacione) {
		getCertificaciones().add(certificacione);
		certificacione.setEmpleado(this);

		return certificacione;
	}

	public Certificacion removeCertificacione(Certificacion certificacione) {
		getCertificaciones().remove(certificacione);
		certificacione.setEmpleado(null);

		return certificacione;
	}

	public Grupo getGrupo() {
		return this.grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public List<Idioma> getIdiomas() {
		return this.idiomas;
	}

	public void setIdiomas(List<Idioma> idiomas) {
		this.idiomas = idiomas;
	}

	public Idioma addIdioma(Idioma idioma) {
		getIdiomas().add(idioma);
		idioma.setEmpleado(this);

		return idioma;
	}

	public Idioma removeIdioma(Idioma idioma) {
		getIdiomas().remove(idioma);
		idioma.setEmpleado(null);

		return idioma;
	}

	public List<JobTechnology> getJobTechnologies() {
		return this.jobTechnologies;
	}

	public void setJobTechnologies(List<JobTechnology> jobTechnologies) {
		this.jobTechnologies = jobTechnologies;
	}

	public JobTechnology addJobTechnology(JobTechnology jobTechnology) {
		getJobTechnologies().add(jobTechnology);
		jobTechnology.setEmpleado(this);

		return jobTechnology;
	}

	public JobTechnology removeJobTechnology(JobTechnology jobTechnology) {
		getJobTechnologies().remove(jobTechnology);
		jobTechnology.setEmpleado(null);

		return jobTechnology;
	}

	public List<JobTechnologyProfile> getJobTechnologyProfiles() {
		return this.jobTechnologyProfiles;
	}

	public void setJobTechnologyProfiles(List<JobTechnologyProfile> jobTechnologyProfiles) {
		this.jobTechnologyProfiles = jobTechnologyProfiles;
	}

	public JobTechnologyProfile addJobTechnologyProfile(JobTechnologyProfile jobTechnologyProfile) {
		getJobTechnologyProfiles().add(jobTechnologyProfile);
		jobTechnologyProfile.setEmpleado(this);

		return jobTechnologyProfile;
	}

	public JobTechnologyProfile removeJobTechnologyProfile(JobTechnologyProfile jobTechnologyProfile) {
		getJobTechnologyProfiles().remove(jobTechnologyProfile);
		jobTechnologyProfile.setEmpleado(null);

		return jobTechnologyProfile;
	}

	public List<Metodologia> getMetodologias() {
		return this.metodologias;
	}

	public void setMetodologias(List<Metodologia> metodologias) {
		this.metodologias = metodologias;
	}

	public Metodologia addMetodologia(Metodologia metodologia) {
		getMetodologias().add(metodologia);
		metodologia.setEmpleado(this);

		return metodologia;
	}

	public Metodologia removeMetodologia(Metodologia metodologia) {
		getMetodologias().remove(metodologia);
		metodologia.setEmpleado(null);

		return metodologia;
	}

	public List<Rol> getRoles() {
		return this.roles;
	}

	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}

	public Rol addRole(Rol role) {
		getRoles().add(role);
		role.setEmpleado(this);

		return role;
	}

	public Rol removeRole(Rol role) {
		getRoles().remove(role);
		role.setEmpleado(null);

		return role;
	}

	public List<SubSkill> getSubSkills() {
		return this.subSkills;
	}

	public void setSubSkills(List<SubSkill> subSkills) {
		this.subSkills = subSkills;
	}

	public SubSkill addSubSkill(SubSkill subSkill) {
		getSubSkills().add(subSkill);
		subSkill.setEmpleado(this);

		return subSkill;
	}

	public SubSkill removeSubSkill(SubSkill subSkill) {
		getSubSkills().remove(subSkill);
		subSkill.setEmpleado(null);

		return subSkill;
	}

	public List<TechSkill> getTechSkills() {
		return this.techSkills;
	}

	public void setTechSkills(List<TechSkill> techSkills) {
		this.techSkills = techSkills;
	}

	public TechSkill addTechSkill(TechSkill techSkill) {
		getTechSkills().add(techSkill);
		techSkill.setEmpleado(this);

		return techSkill;
	}

	public TechSkill removeTechSkill(TechSkill techSkill) {
		getTechSkills().remove(techSkill);
		techSkill.setEmpleado(null);

		return techSkill;
	}

	public List<Tecnologia> getTecnologias() {
		return this.tecnologias;
	}

	public void setTecnologias(List<Tecnologia> tecnologias) {
		this.tecnologias = tecnologias;
	}

	public Tecnologia addTecnologia(Tecnologia tecnologia) {
		getTecnologias().add(tecnologia);
		tecnologia.setEmpleado(this);

		return tecnologia;
	}

	public Tecnologia removeTecnologia(Tecnologia tecnologia) {
		getTecnologias().remove(tecnologia);
		tecnologia.setEmpleado(null);

		return tecnologia;
	}

}
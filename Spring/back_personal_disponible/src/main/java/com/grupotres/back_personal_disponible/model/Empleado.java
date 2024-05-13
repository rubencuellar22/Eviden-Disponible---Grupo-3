package com.grupotres.back_personal_disponible.model;

import java.io.Serializable;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.ArrayList;
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

	private String ciudad;

	private String das;

	private String gcm;

	@Column(name="job_technology")
	private String jobTechnology;

	private BigDecimal jornada;

	@Column(name="line_manager")
	private String lineManager;

	@Column(name="n_4")
	private String n4;

	private String name;

	private int nivelgcm;

	private boolean rlt;

	private BigDecimal scr;

	private String skills;

	private String status;

	private String subgroup;

	//bi-directional many-to-one association to Certificacion
	@OneToMany(mappedBy="empleado")
	private List<Certificacion> certificaciones = new ArrayList<Certificacion>();

	//bi-directional many-to-one association to Grupo
	@ManyToOne
	@JoinColumn(name="grupos")
	private Grupo grupo;

	//bi-directional many-to-one association to Idioma
	@OneToMany(mappedBy="empleado")
	private List<Idioma> idiomas  = new ArrayList<Idioma>();

	//bi-directional many-to-one association to JobTechnology
	@OneToMany(mappedBy="empleado")
	private List<JobTechnology> jobTechnologies;

	//bi-directional many-to-one association to JobTechnologyProfile
	@OneToMany(mappedBy="empleado")
	private List<JobTechnologyProfile> jobTechnologyProfiles = new ArrayList<JobTechnologyProfile>();

	//bi-directional many-to-one association to Metodologia
	@OneToMany(mappedBy="empleado")
	private List<Metodologia> metodologias = new ArrayList<Metodologia>();

	//bi-directional many-to-one association to Rol
	@OneToOne(mappedBy="empleado")
	private Rol rol;

	//bi-directional many-to-one association to SubSkill
	@OneToMany(mappedBy="empleado")
	private List<BussSkill> bussSkills = new ArrayList<BussSkill>();

	//bi-directional many-to-one association to TechSkill
	@OneToMany(mappedBy="empleado")
	private List<TechSkill> techSkills = new ArrayList<TechSkill>();

	//bi-directional many-to-one association to Tecnologia
	@OneToMany(mappedBy="empleado")
	private List<Tecnologia> tecnologias = new ArrayList<Tecnologia>();

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

	public String getJobTechnology() {
		return this.jobTechnology;
	}

	public void setJobTechnology(String jobTechnology) {
		this.jobTechnology = jobTechnology;
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

	public boolean getRlt() {
		return this.rlt;
	}

	public void setRlt(boolean rlt) {
		this.rlt = rlt;
	}

	public BigDecimal getScr() {
		return this.scr;
	}

	public void setScr(BigDecimal scr) {
		this.scr = scr;
	}

	public String getSkills() {
		return this.skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
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

	public void addCertificacione(Certificacion certificacione) {
		getCertificaciones().add(certificacione);

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
		// idioma.setEmpleado(this); WARNING: This line is commented out because it causes a stack overflow error

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

	public void addJobTechnologyProfile(JobTechnologyProfile jobTechnologyProfile) {
		this.jobTechnologyProfiles.add(jobTechnologyProfile);
		// jobTechnologyProfile.setEmpleado(this); TODO: This line is commented out because it causes a stack overflow error
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

	public void addMetodologia(Metodologia metodologia) {
		getMetodologias().add(metodologia);
		// metodologia.setEmpleado(this); WARNING: This line is commented out because it causes a stack overflow error
	}

	public Metodologia removeMetodologia(Metodologia metodologia) {
		getMetodologias().remove(metodologia);
		metodologia.setEmpleado(null);

		return metodologia;
	}

	public Rol getRol() {
		return this.rol;
	}

	public void setRol(Rol role) {
		this.rol = role;
	}

	public List<BussSkill> getSubSkills() {
		return this.bussSkills;
	}

	public void setSubSkills(List<BussSkill> bussSkills) {
		this.bussSkills = bussSkills;
	}

	public void addBussSkill(BussSkill subSkill) {
		getSubSkills().add(subSkill);
		// subSkill.setEmpleado(this); WARNING: This line is commented out because it causes a stack overflow error
	}

	public BussSkill removeSubSkill(BussSkill subSkill) {
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

	public void addTechSkill(TechSkill techSkill) {
		getTechSkills().add(techSkill);
		// techSkill.setEmpleado(this); WARNING: This line is commented out because it causes a stack overflow error
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

	public void addTecnologia(Tecnologia tecnologia) {
		getTecnologias().add(tecnologia);
		// tecnologia.setEmpleado(this); WARNING: This line is commented out because it causes a stack overflow error
	}

	public Tecnologia removeTecnologia(Tecnologia tecnologia) {
		getTecnologias().remove(tecnologia);
		tecnologia.setEmpleado(null);

		return tecnologia;
	}

	@Override
	public String toString() {
		return "Empleado{" +
				"gin=" + gin + "\n" +
				", agrupacion='" + agrupacion + '\'' + "\n" +
				", bench='" + bench + '\'' + "\n" +
				", categoria='" + categoria + '\'' + "\n" +
				", ciudad='" + ciudad + '\'' + "\n" +
				", das='" + das + '\'' + "\n" +
				", gcm='" + gcm + '\'' + "\n" +
				", jobTechnology='" + jobTechnology + '\'' + "\n" +
				", jornada=" + jornada + "\n" +
				", lineManager='" + lineManager + '\'' + "\n" +
				", n4='" + n4 + '\'' + "\n" +
				", name='" + name + '\'' + "\n" +
				", nivelgcm=" + nivelgcm + "\n" +
				", rlt='" + rlt + '\'' + "\n" +
				", scr=" + scr + "\n" +
				", skills='" + skills + '\'' + "\n" +
				", status='" + status + '\'' + "\n" +
				", subgroup='" + subgroup + '\'' + "\n" +
				", certificaciones=" + certificaciones + "\n" +
				", grupo=" + grupo + "\n" +
				", idiomas=" + idiomas + "\n" +
				", jobTechnologies=" + jobTechnologies + "\n" +
				", jobTechnologyProfiles=" + jobTechnologyProfiles + "\n" +
				", metodologias=" + metodologias + "\n" +
				", rol=" + rol + "\n" +
				", bussSkills=" + bussSkills + "\n" +
				", techSkills=" + techSkills + "\n" +
				", tecnologias=" + tecnologias + "\n" +
				'}';
	}
}
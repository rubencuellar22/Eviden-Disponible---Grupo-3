package com.grupotres.back_personal_disponible.model;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the tech_skills database table.
 * 
 */
@Entity
@Table(name="tech_skills")
@NamedQuery(name="TechSkill.findAll", query="SELECT t FROM TechSkill t")
public class TechSkill implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_tech_skills")
	private int idTechSkills;

	private int nivel;

	@Lob
	@Column(name="tech_skills")
	private String techSkills;

	//bi-directional many-to-one association to Empleado
	@ManyToOne
	@JoinColumn(name="gin")
	private Empleado empleado;

	public TechSkill() {
	}

	public int getIdTechSkills() {
		return this.idTechSkills;
	}

	public void setIdTechSkills(int idTechSkills) {
		this.idTechSkills = idTechSkills;
	}

	public int getNivel() {
		return this.nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public String getTechSkills() {
		return this.techSkills;
	}

	public void setTechSkills(String techSkills) {
		this.techSkills = techSkills;
	}

	public Empleado getEmpleado() {
		return this.empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

}
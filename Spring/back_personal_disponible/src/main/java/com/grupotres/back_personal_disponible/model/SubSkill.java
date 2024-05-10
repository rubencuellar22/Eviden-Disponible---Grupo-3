package com.grupotres.back_personal_disponible.model;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the sub_skills database table.
 * 
 */
@Entity
@Table(name="sub_skills")
@NamedQuery(name="SubSkill.findAll", query="SELECT s FROM SubSkill s")
public class SubSkill implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_sub_skills")
	private int idSubSkills;

	private int nivel;

	@Lob
	@Column(name="sub_skills")
	private String subSkills;

	//bi-directional many-to-one association to Empleado
	@ManyToOne
	@JoinColumn(name="gin")
	private Empleado empleado;

	public SubSkill() {
	}

	public int getIdSubSkills() {
		return this.idSubSkills;
	}

	public void setIdSubSkills(int idSubSkills) {
		this.idSubSkills = idSubSkills;
	}

	public int getNivel() {
		return this.nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public String getSubSkills() {
		return this.subSkills;
	}

	public void setSubSkills(String subSkills) {
		this.subSkills = subSkills;
	}

	public Empleado getEmpleado() {
		return this.empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

}
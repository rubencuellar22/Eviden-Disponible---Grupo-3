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
	private int idTechSkill;

	private int nivel;

	@Lob
	@Column(name="tech_skills")
	private String techSkill;

	//bi-directional many-to-one association to Empleado
	@ManyToOne
	@JoinColumn(name="gin")
	private Empleado empleado;

	public TechSkill() {
	}

	public int getIdTechSkill() {
		return this.idTechSkill;
	}

	public void setIdTechSkill(int idTechSkill) {
		this.idTechSkill = idTechSkill;
	}

	public int getNivel() {
		return this.nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public String getTechSkill() {
		return this.techSkill;
	}

	public void setTechSkill(String techSkill) {
		this.techSkill = techSkill;
	}

	public Empleado getEmpleado() {
		return this.empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	@Override
	public String toString() {
		return "TechSkill{" +
				"idTechSkill=" + idTechSkill +
				", nivel=" + nivel +
				", techSkill='" + techSkill + '\'' +
				", empleado=" + empleado +
				'}';
	}
}
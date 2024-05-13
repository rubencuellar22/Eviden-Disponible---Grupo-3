package com.grupotres.back_personal_disponible.model;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the sub_skills database table.
 * 
 */
@Entity
@Table(name="buss_skills")
@NamedQuery(name="BussSkill.findAll", query="SELECT s FROM BussSkill s")
public class BussSkill implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_sub_skill")
	private int idBussSkill;

	private int nivel;

	@Lob
	@Column(name="buss_skill")
	private String bussSkill;

	//bi-directional many-to-one association to Empleado
	@ManyToOne
	@JoinColumn(name="gin")
	private Empleado empleado;

	public BussSkill() {
	}

	public int getIdBussSkill() {
		return this.idBussSkill;
	}

	public void setIdBussSkill(int idBussSkill) {
		this.idBussSkill = idBussSkill;
	}

	public int getNivel() {
		return this.nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public String getBussSkill() {
		return this.bussSkill;
	}

	public void setBussSkill(String bussSkill) {
		this.bussSkill = bussSkill;
	}

	public Empleado getEmpleado() {
		return this.empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	@Override
	public String toString() {
		return "BussSkill{" +
				"idBussSkill=" + idBussSkill +
				", nivel=" + nivel +
				", bussSkill='" + bussSkill + '\'' +
				", empleado=" + empleado +
				'}';
	}
}
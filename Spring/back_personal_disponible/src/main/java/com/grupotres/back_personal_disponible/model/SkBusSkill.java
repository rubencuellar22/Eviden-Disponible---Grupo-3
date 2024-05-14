package com.grupotres.back_personal_disponible.model;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the sub_skills database table.
 * 
 */
@Entity
@Table(name="SkBusSkill")
@NamedQuery(name="BusSkill.findAll", query="SELECT s FROM SkBusSkill s")
public class SkBusSkill implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_skbusskill")
	private int idSkBusSkill;

	@ManyToOne
	@JoinColumn(name="gin")
	private Empleado empleado;

	private String skBusSkill;
	private int nivel;

	public SkBusSkill() {
	}

	public int getIdSkBusSkill() {
		return idSkBusSkill;
	}

	public void setIdSkBusSkill(int idSkBusSkill) {
		this.idSkBusSkill = idSkBusSkill;
	}

	public String getSkBusSkill() {
		return skBusSkill;
	}

	public void setSkBusSkill(String skBusSkill) {
		this.skBusSkill = skBusSkill;
	}

	public int getNivel() {
		return this.nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public Empleado getEmpleado() {
		return this.empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	@Override
	public String toString() {
		return "SkBusSkill{" +
				"idSkBusSkill=" + idSkBusSkill +
				", empleado=" + empleado +
				", skBusSkill='" + skBusSkill + '\'' +
				", nivel=" + nivel +
				'}';
	}
}
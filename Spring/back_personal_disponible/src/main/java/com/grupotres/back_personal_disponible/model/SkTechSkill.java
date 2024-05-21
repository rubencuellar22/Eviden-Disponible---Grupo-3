package com.grupotres.back_personal_disponible.model;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the tech_skills database table.
 * 
 */
@Entity
@Table(name="sk_techskill")
@NamedQuery(name="SkTechSkill.findAll", query="SELECT t FROM SkTechSkill t")
public class SkTechSkill implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_sktechskill")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idSkTechSkill;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="gin")
	private Empleado empleado;

	@Column(name="sktechskill")
	private String skTechSkill;

	private int nivel;





	public SkTechSkill() {
	}

	public int getIdSkTechSkill() {
		return idSkTechSkill;
	}

	public void setIdSkTechSkill(int idSkTechSkill) {
		this.idSkTechSkill = idSkTechSkill;
	}

	public String getSkTechSkill() {
		return skTechSkill;
	}

	public void setSkTechSkill(String skTechSkill) {
		this.skTechSkill = skTechSkill;
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
		return "SkTechSkill{" +
				"idSkTechSkill=" + idSkTechSkill +
				", empleado=" + empleado +
				", skTechSkill='" + skTechSkill + '\'' +
				", nivel=" + nivel +
				'}';
	}
}
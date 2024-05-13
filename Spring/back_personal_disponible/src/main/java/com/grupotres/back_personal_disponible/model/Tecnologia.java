package com.grupotres.back_personal_disponible.model;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the tecnologias database table.
 * 
 */
@Entity
@Table(name="tecnologias")
@NamedQuery(name="Tecnologia.findAll", query="SELECT t FROM Tecnologia t")
public class Tecnologia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_tecnologias")
	private int idTecnologia;

	private int nivel;

	@Lob
	private String tecnologia;

	//bi-directional many-to-one association to Empleado
	@ManyToOne
	@JoinColumn(name="gin")
	private Empleado empleado;

	public Tecnologia() {
	}

	public int getIdTecnologia() {
		return this.idTecnologia;
	}

	public void setIdTecnologia(int idTecnologia) {
		this.idTecnologia = idTecnologia;
	}

	public int getNivel() {
		return this.nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public String getTecnologia() {
		return this.tecnologia;
	}

	public void setTecnologia(String tecnologia) {
		this.tecnologia = tecnologia;
	}

	public Empleado getEmpleado() {
		return this.empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	@Override
	public String toString() {
		return "Tecnologia{" +
				"idTecnologia=" + idTecnologia +
				", nivel=" + nivel +
				", tecnologia='" + tecnologia + '\'' +
				", empleado=" + empleado +
				'}';
	}
}
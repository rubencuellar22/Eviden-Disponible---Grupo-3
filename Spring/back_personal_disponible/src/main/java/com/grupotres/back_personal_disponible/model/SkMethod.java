package com.grupotres.back_personal_disponible.model;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the metodologias database table.
 * 
 */
@Entity
@Table(name="SkMethod")
@NamedQuery(name="SkMethod.findAll", query="SELECT m FROM SkMethod m")
public class SkMethod implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_skmethod")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idSkmethod;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="gin")
	private Empleado empleado;

	private String Skmethod;

	private int nivel;



	public SkMethod() {
	}

	public int getIdSkmethod() {
		return idSkmethod;
	}

	public void setIdSkmethod(int idSkmethod) {
		this.idSkmethod = idSkmethod;
	}

	public String getSkmethod() {
		return Skmethod;
	}

	public void setSkmethod(String skmethod) {
		Skmethod = skmethod;
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
		return "SkMethod{" +
				"idSkmethod=" + idSkmethod +
				", empleado=" + empleado +
				", Skmethod='" + Skmethod + '\'' +
				", nivel=" + nivel +
				'}';
	}
}
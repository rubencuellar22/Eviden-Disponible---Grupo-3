package com.grupotres.back_personal_disponible.model;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the role database table.
 * 
 */
@Entity
@Table(name="role")
@NamedQuery(name="Role.findAll", query="SELECT r FROM Role r")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_role")
	private int idRole;

	@OneToOne
	@JoinColumn(name="gin")
	private Empleado empleado;

	private String role;

	private int nivel;


	public Role() {
	}

	public int getIdRole() {
		return idRole;
	}

	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
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
		return "Role{" +
				"idRole=" + idRole +
				", empleado=" + empleado +
				", role='" + role + '\'' +
				", nivel=" + nivel +
				'}';
	}
}
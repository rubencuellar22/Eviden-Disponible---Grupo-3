package com.grupotres.back_personal_disponible.model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the grupo database table.
 * 
 */
@Entity
@NamedQuery(name="Grupo.findAll", query="SELECT g FROM Grupo g")
public class Grupo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_grupo;
	private String grupos;
	private String cc;
	private String grupo1;
	private String grupo2;
	private String grupo3;
	private String grupo4;

	//bi-directional many-to-one association to Empleado
	@OneToMany(mappedBy="grupo")
	private List<Empleado> empleados;

	public Grupo() {
	}

	public String getGrupos() {
		return this.grupos;
	}

	public void setGrupos(String grupos) {
		this.grupos = grupos;
	}

	public String getCc() {
		return this.cc;
	}

	public void setCc(String cc) {
		this.cc = cc;
	}

	public String getGrupo1() {
		return this.grupo1;
	}

	public void setGrupo1(String grupo1) {
		this.grupo1 = grupo1;
	}

	public String getGrupo2() {
		return this.grupo2;
	}

	public void setGrupo2(String grupo2) {
		this.grupo2 = grupo2;
	}

	public String getGrupo3() {
		return this.grupo3;
	}

	public void setGrupo3(String grupo3) {
		this.grupo3 = grupo3;
	}

	public String getGrupo4() {
		return this.grupo4;
	}

	public void setGrupo4(String grupo4) {
		this.grupo4 = grupo4;
	}

	public List<Empleado> getEmpleados() {
		return this.empleados;
	}

	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}

	public Long getId_grupo() {
		return id_grupo;
	}

	public void setId_grupo(Long id_grupo) {
		this.id_grupo = id_grupo;
	}

	public Empleado addEmpleado(Empleado empleado) {
		getEmpleados().add(empleado);
		empleado.setGrupo(this);

		return empleado;
	}

	public Empleado removeEmpleado(Empleado empleado) {
		getEmpleados().remove(empleado);
		empleado.setGrupo(null);

		return empleado;
	}

	@Override
	public String toString() {
		return "Grupo{" +
				"grupos='" + grupos + '\'' +
				", cc='" + cc + '\'' +
				", grupo1='" + grupo1 + '\'' +
				", grupo2='" + grupo2 + '\'' +
				", grupo3='" + grupo3 + '\'' +
				", grupo4='" + grupo4 + '\'' +
				", empleados=" + empleados +
				'}';
	}
}
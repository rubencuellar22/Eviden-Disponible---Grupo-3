package com.grupotres.back_personal_disponible.model;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the job_technology database table.
 * 
 */
@Entity
@Table(name="job_technology")
@NamedQuery(name="JobTechnology.findAll", query="SELECT j FROM JobTechnology j")
public class JobTechnology implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_job_technology")
	private int idJobTechnology;

	@Column(name="job_technology")
	private String jobTechnology;

	//bi-directional many-to-one association to Empleado
	@ManyToOne
	@JoinColumn(name="gin")
	private Empleado empleado;

	public JobTechnology() {
	}

	public int getIdJobTechnology() {
		return this.idJobTechnology;
	}

	public void setIdJobTechnology(int idJobTechnology) {
		this.idJobTechnology = idJobTechnology;
	}

	public String getJobTechnology() {
		return this.jobTechnology;
	}

	public void setJobTechnology(String jobTechnology) {
		this.jobTechnology = jobTechnology;
	}

	public Empleado getEmpleado() {
		return this.empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

}
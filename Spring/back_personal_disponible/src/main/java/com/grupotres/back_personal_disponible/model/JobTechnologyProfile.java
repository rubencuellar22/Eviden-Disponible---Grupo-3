package com.grupotres.back_personal_disponible.model;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the job_technology_profile database table.
 * 
 */
@Entity
@Table(name="job_technology_profile")
@NamedQuery(name="JobTechnologyProfile.findAll", query="SELECT j FROM JobTechnologyProfile j")
public class JobTechnologyProfile implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_job_technology_profile")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idJobTechnologyProfile;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="gin")
	private Empleado empleado;


	@Column(name="job_technology_profile")
	private String jobTechnologyProfile;

	private int nivel;


	public JobTechnologyProfile() {
	}

	public int getIdJobTechnologyProfile() {
		return this.idJobTechnologyProfile;
	}

	public void setIdJobTechnologyProfile(int idJobTechnologyProfile) {
		this.idJobTechnologyProfile = idJobTechnologyProfile;
	}

	public String getJobTechnologyProfile() {
		return this.jobTechnologyProfile;
	}

	public void setJobTechnologyProfile(String jobTechnologyProfile) {
		this.jobTechnologyProfile = jobTechnologyProfile;
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
		return "JobTechnologyProfile{" +
				"idJobTechnologyProfile=" + idJobTechnologyProfile +
				", empleado=" + empleado +
				", jobTechnologyProfile='" + jobTechnologyProfile + '\'' +
				", nivel=" + nivel +
				'}';
	}
}
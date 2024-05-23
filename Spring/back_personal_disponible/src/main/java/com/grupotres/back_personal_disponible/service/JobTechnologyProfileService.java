package com.grupotres.back_personal_disponible.service;
 
import java.util.List;
 
import com.grupotres.back_personal_disponible.model.Empleado;
 
public interface JobTechnologyProfileService {
	public List<Empleado> findEmpleadosByJobTechnologyProfile(String jobtechnologyprofile);
 
	public List<Empleado> findEmpleadosByJobTechnologyProfileAndLvl(String jobtechnologyprofile, String nivel);
 
}
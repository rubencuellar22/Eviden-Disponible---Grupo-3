package com.grupotres.back_personal_disponible.service;

import com.grupotres.back_personal_disponible.model.Empleado;

import java.util.List;

public interface SkMethodService {
	
    List<Empleado> findEmpleadoBySkMethod(String skMethod);
    
    List<Empleado> findEmpleadoBySkMethodAndLvl(String skMethod, int nivel);
    
}

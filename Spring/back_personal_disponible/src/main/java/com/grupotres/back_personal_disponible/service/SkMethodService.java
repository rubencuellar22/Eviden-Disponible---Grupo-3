package com.grupotres.back_personal_disponible.service;

import com.grupotres.back_personal_disponible.model.Empleado;
import com.grupotres.back_personal_disponible.model.SkMethod;

import java.util.List;

public interface SkMethodService {
	
    List<Empleado> findBySkMethod(String skMethod);
    
    List<Empleado> findBySkMethodAndNivel(String skMethod, int nivel);

    void saveAllSkMethods(List<SkMethod> empSkMethods);

    void deleteAllSkMethods();
    
	List<SkMethod> selectAllSkMethods();
    
}

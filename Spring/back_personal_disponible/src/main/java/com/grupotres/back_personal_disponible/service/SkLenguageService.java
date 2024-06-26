package com.grupotres.back_personal_disponible.service;
 
import java.util.List;
import org.springframework.stereotype.Service;
import com.grupotres.back_personal_disponible.model.Empleado;
import com.grupotres.back_personal_disponible.model.SkLenguage;
 
@Service
public interface SkLenguageService {
 
	public List<Empleado> findEmpleadosBySkLenguage(String sklenguage);
	
	public List<Empleado> findEmpleadosBySkLenguageAndLvl(String sklenguage,String nivel);
	
	List<SkLenguage> findByNombreContaining(String nombre);
	
    void saveAllSkLenguages(List<SkLenguage> empSkLenguages);

    void deleteAllSkLenguages();

	public List<SkLenguage> selectAllSkLenguages();
}
 
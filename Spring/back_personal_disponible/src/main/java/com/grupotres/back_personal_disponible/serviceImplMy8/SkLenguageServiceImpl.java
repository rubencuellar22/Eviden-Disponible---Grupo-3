package com.grupotres.back_personal_disponible.serviceImplMy8;
 
import java.util.ArrayList;
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.grupotres.back_personal_disponible.model.Empleado;
import com.grupotres.back_personal_disponible.model.SkLenguage;
import com.grupotres.back_personal_disponible.repository.SkLenguageRepository;
import com.grupotres.back_personal_disponible.service.SkLenguageService;
 
@Service
public class SkLenguageServiceImpl implements SkLenguageService {
 
	@Autowired
	private SkLenguageRepository skLenguageRepository;
 
	@Override
	public List<Empleado> findEmpleadosBySkLenguage(String sklenguage) {
		List<SkLenguage> skLenguages = skLenguageRepository.findBySkLenguage(sklenguage);
		List<Empleado> empleados = new ArrayList<Empleado>();
		for(SkLenguage skLenguage : skLenguages) {
			empleados.add(skLenguage.getEmpleado());
		}
		return empleados;
	}
 
	@Override
	public List<Empleado> findEmpleadosBySkLenguageAndLvl(String sklenguage, String nivel) {
		List<SkLenguage> skLenguages = skLenguageRepository.findBySkLenguageAndLvl(sklenguage,nivel);
		List<Empleado> empleados = new ArrayList<Empleado>();
		for(SkLenguage skLenguage : skLenguages) {
			empleados.add(skLenguage.getEmpleado());
		}
		return empleados;
	}
 
	
}
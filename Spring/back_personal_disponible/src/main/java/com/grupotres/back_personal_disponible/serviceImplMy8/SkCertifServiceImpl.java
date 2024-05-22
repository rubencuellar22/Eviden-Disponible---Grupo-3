package com.grupotres.back_personal_disponible.serviceImplMy8;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupotres.back_personal_disponible.model.Empleado;
import com.grupotres.back_personal_disponible.model.SkCertif;
import com.grupotres.back_personal_disponible.repository.SkCertifRepository;
import com.grupotres.back_personal_disponible.service.SkCertifService;

@Service
public class SkCertifServiceImpl implements SkCertifService {

    @Autowired
    private SkCertifRepository skCertifRepository;
    
    @Override
    public List<Empleado> findEmpleadosByCertifNombre(String skcertif) {
    	List<SkCertif> skCertifs = skCertifRepository.findBySkCertif(skcertif);
		List<Empleado> empleados = new ArrayList<Empleado>();
		for(SkCertif skCertif : skCertifs) {
			empleados.add(skCertif.getEmpleado());
		}
		return empleados;
    }

	@Override
	public List<Empleado> findEmpleadosByCertifNombreAndNivel(String nombre, int external) {
		 return skCertifRepository.findEmpleadosByCertifNombreAndNivel(nombre, external);
		    
	}
}

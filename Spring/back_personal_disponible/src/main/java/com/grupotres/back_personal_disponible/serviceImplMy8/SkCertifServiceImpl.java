package com.grupotres.back_personal_disponible.serviceImplMy8;

import java.util.List;

import com.grupotres.back_personal_disponible.model.SkCertif;
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
    public List<Empleado> findEmpleadosByCertifNombre(String nombreCertif) {
        return skCertifRepository.findEmpleadosByCertifNombre(nombreCertif);
    }

	@Override
	public List<Empleado> findEmpleadosByCertifNombreAndNivel(String nombre, int external) {
		 return skCertifRepository.findEmpleadosByCertifNombreAndNivel(nombre, external);
		    
	}
    
    @Override
    public void saveAllSkCertifs(List<SkCertif> empSkCertifs) {
        skCertifRepository.saveAll(empSkCertifs);
    }

    @Override
    public void deleteAllSkCertifs() {
        skCertifRepository.deleteAllInBatch();
    }

	@Override
	public List<SkCertif> selectAllSkCertifs() {
		return skCertifRepository.selectAllSkCertifs();
	}
}

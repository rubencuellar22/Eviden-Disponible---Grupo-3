package com.grupotres.back_personal_disponible.serviceImplMy8;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupotres.back_personal_disponible.model.Empleado;
import com.grupotres.back_personal_disponible.repository.EmpleadoRepository;
import com.grupotres.back_personal_disponible.service.EmpleadoService;


@Service
public class EmpleadoServiceImpl implements EmpleadoService{

	
	@Autowired
	EmpleadoRepository empleadoRepository;
	@Override
	public List<Empleado> findbyStatus(String status) {
		// TODO Auto-generated method stub
		return empleadoRepository.findbyStatus(status);
	}
	

}

package com.grupotres.back_personal_disponible.serviceImplMy8;

import java.math.BigDecimal;
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
	@Override
	public List<Empleado> findByBench(String bench) {
		// TODO Auto-generated method stub
		return empleadoRepository.findByBench(bench);
	}
	@Override
	public List<Empleado> findByCiudad(String ciudad) {
		// TODO Auto-generated method stub
		return empleadoRepository.findByCiudad(ciudad);
	}
	@Override
	public List<Empleado> findByJornada(BigDecimal jornada) {
		// TODO Auto-generated method stub
		return empleadoRepository.findByJornada(jornada);
	}
	@Override
	public List<Empleado> findbyN4(String n4) {
		return empleadoRepository.findbyN4(n4);
	}
	@Override
	public List<Empleado> findbyCategoria(String categoria) {
		// TODO Auto-generated method stub
		return empleadoRepository.findbyCategoria(categoria);
	}
	@Override
	public List<Empleado> findbyCcname(String ccname) {
		// TODO Auto-generated method stub
		return empleadoRepository.findbyCcname(ccname);
	}
	@Override
	public List<Empleado> findbyScr(BigDecimal scr) {
		// TODO Auto-generated method stub
		return empleadoRepository.findbyScr(scr);
	}
	

	
	
	
	
	

}

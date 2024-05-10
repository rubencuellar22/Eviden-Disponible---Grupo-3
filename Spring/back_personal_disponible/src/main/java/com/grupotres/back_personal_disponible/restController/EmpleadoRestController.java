package com.grupotres.back_personal_disponible.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupotres.back_personal_disponible.model.Empleado;
import com.grupotres.back_personal_disponible.repository.EmpleadoRepository;
import com.grupotres.back_personal_disponible.service.EmpleadoService;

@RestController
@RequestMapping("/empleado/")
@CrossOrigin(origins = "*")
public class EmpleadoRestController {
	
	@Autowired
	private EmpleadoRepository empleadoRepository;
	
	@Autowired 
	private EmpleadoService empleadoService;
	
	@GetMapping("todos")
	public List<Empleado> findAll(){
		
		return empleadoRepository.findAll();		
	}
	
	@GetMapping("status/{status}")
	public List<Empleado> findbyStatus(@PathVariable String status){
		return empleadoRepository.findbyStatus(status);
		
}
}
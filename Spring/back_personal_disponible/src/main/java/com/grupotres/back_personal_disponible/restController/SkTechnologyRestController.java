package com.grupotres.back_personal_disponible.restController;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupotres.back_personal_disponible.model.Empleado;
import com.grupotres.back_personal_disponible.model.dto.EmpleadoDTO;
import com.grupotres.back_personal_disponible.repository.SkTechnologyRepository;
import com.grupotres.back_personal_disponible.service.SkTechnologyService;


@RestController
@RequestMapping("/empleado/sk_technology/technology")
public class SkTechnologyRestController {
	@Autowired
    private SkTechnologyService skTechnologyService;
	
	
	 @GetMapping("/{nombre}")
	 public ResponseEntity<?> findEmpleadosByTechnology(@PathVariable String nombre){
		List<Empleado> empleados = skTechnologyService.findEmpleadosByTechnology(nombre);
		List<EmpleadoDTO> empleadosDTO = new ArrayList<EmpleadoDTO>();
		for (Empleado emp : empleados) {
			empleadosDTO.add(new EmpleadoDTO().empleadoToEmpleadoDTO(emp));
		}
		return ResponseEntity.ok(empleadosDTO);
	}
	 
	 @GetMapping("/{nombre}/{nivel}")
	 public ResponseEntity<?> findEmpleadosByTechnologyAndNivel(@PathVariable String nombre, @PathVariable Integer nivel){
		List<Empleado> empleados = skTechnologyService.findEmpleadosByTechnologyAndNivel(nombre, nivel);
		List<EmpleadoDTO> empleadosDTO = new ArrayList<EmpleadoDTO>();
		for (Empleado emp : empleados) {
			empleadosDTO.add(new EmpleadoDTO().empleadoToEmpleadoDTO(emp));
		}
		return ResponseEntity.ok(empleadosDTO);
	}
}

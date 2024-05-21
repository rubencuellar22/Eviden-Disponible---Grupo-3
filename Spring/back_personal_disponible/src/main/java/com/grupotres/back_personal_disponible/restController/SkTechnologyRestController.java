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
import com.grupotres.back_personal_disponible.service.SkTechnologyService;


@RestController
@RequestMapping("/empleado/skTechnology")
public class SkTechnologyRestController {
	
	@Autowired
    private SkTechnologyService skTechnologyService;
	
	 @GetMapping("/{technology}")
	 public ResponseEntity<?> getEmpleadosByTechnology(@PathVariable String nombre){
		List<Empleado> empleados = skTechnologyService.findEmpleadosByTechnology(nombre);
		List<EmpleadoDTO> empleadosDTO = new ArrayList<EmpleadoDTO>();
		for (Empleado emp : empleados) {
			empleadosDTO.add(new EmpleadoDTO(emp));
		}
		return ResponseEntity.ok(empleadosDTO);
	}
	 
	 @GetMapping("/{technology}/{nivel}")
	 public ResponseEntity<?> getEmpleadosByTechnologyAndLvl(@PathVariable String sktechnology, @PathVariable Integer nivel){
		List<Empleado> empleados = skTechnologyService.findEmpleadosByTechnologyAndLvl(sktechnology, nivel);
		List<EmpleadoDTO> empleadosDTO = new ArrayList<EmpleadoDTO>();
		for (Empleado emp : empleados) {
			empleadosDTO.add(new EmpleadoDTO(emp));
		}
		return ResponseEntity.ok(empleadosDTO);
	}
}

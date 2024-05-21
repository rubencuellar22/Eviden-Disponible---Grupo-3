package com.grupotres.back_personal_disponible.restController;


import com.grupotres.back_personal_disponible.model.Empleado;
import com.grupotres.back_personal_disponible.model.dto.EmpleadoDTO;
import com.grupotres.back_personal_disponible.service.SkMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/empleado/sk_methods")
public class SkMethodRestController {

	@Autowired
    private SkMethodService skMethodService;

    @GetMapping("/{skMethod}")
    public ResponseEntity<?> getEmpleadosBySkMethod(@PathVariable String skMethod){
		List<Empleado> empleados = skMethodService.findEmpleadoBySkMethod(skMethod);
		List<EmpleadoDTO> empleadosDTO = new ArrayList<EmpleadoDTO>();
		for (Empleado emp : empleados) {
			empleadosDTO.add(new EmpleadoDTO(emp));
		}
		return ResponseEntity.ok(empleadosDTO);
	}
    
    @GetMapping("/{skMethod}/{nivel}")
    public ResponseEntity<?>getEmpleadosBySkMethodAndLvl(@PathVariable String skMethod, @PathVariable Integer nivel){
		List<Empleado> empleados = skMethodService.findEmpleadoBySkMethodAndLvl(skMethod, nivel);
		List<EmpleadoDTO> empleadosDTO = new ArrayList<EmpleadoDTO>();
		for (Empleado emp : empleados) {
			empleadosDTO.add(new EmpleadoDTO(emp));
		}
		return ResponseEntity.ok(empleadosDTO);
	}
    
}

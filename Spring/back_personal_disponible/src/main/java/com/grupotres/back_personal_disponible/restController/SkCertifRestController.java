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
import com.grupotres.back_personal_disponible.repository.EmpleadoRepository;
import com.grupotres.back_personal_disponible.service.SkCertifService;


@RestController
@RequestMapping("/empleado/sk_certif/certif")
public class SkCertifRestController {
	
	@Autowired
    private EmpleadoRepository empleadoRepository;
	
	@Autowired
    private SkCertifService skCertifService;
	
	
	 @GetMapping("/{nombre}")
	 public ResponseEntity<?> findEmpleadosByCertifNombre(@PathVariable String nombre){
		List<Empleado> empleados = skCertifService.findEmpleadosByCertifNombre(nombre);
		List<EmpleadoDTO> empleadosDTO = new ArrayList<EmpleadoDTO>();
		for (Empleado emp : empleados) {
			empleadosDTO.add(new EmpleadoDTO().empleadoToEmpleadoDTO(emp));
		}
		return ResponseEntity.ok(empleadosDTO);
	}
	
}

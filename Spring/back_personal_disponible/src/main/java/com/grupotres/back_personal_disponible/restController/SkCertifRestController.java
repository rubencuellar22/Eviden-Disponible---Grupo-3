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
import com.grupotres.back_personal_disponible.service.SkCertifService;


@RestController
@RequestMapping("/empleado/skcertif")
public class SkCertifRestController {

	@Autowired
    private SkCertifService skCertifService;
	
	
	 @GetMapping("/{skcertif}")
	 public ResponseEntity<?> getEmpleadosByCertifNombre(@PathVariable String skcertif){
		List<Empleado> empleados = skCertifService.findEmpleadosBySkCertif(skcertif);
		List<EmpleadoDTO> empleadosDTO = new ArrayList<EmpleadoDTO>();
		for (Empleado emp : empleados) {
			empleadosDTO.add(new EmpleadoDTO(emp));
		}
		return ResponseEntity.ok(empleadosDTO);
	}
	 
	 @GetMapping("/{skcertif}/{external}")
	 public ResponseEntity<?> getEmpleadosByCertifNombreAndNivel(@PathVariable String skcertif, @PathVariable boolean external){
		List<Empleado> empleados = skCertifService.findEmpleadosBySkCertifAndExternal(skcertif, external);
		List<EmpleadoDTO> empleadosDTO = new ArrayList<EmpleadoDTO>();
		for (Empleado emp : empleados) {
			empleadosDTO.add(new EmpleadoDTO(emp));
		}
		return ResponseEntity.ok(empleadosDTO);
	}
	
}

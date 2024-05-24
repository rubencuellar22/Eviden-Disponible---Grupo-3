package com.grupotres.back_personal_disponible.restController;


import com.grupotres.back_personal_disponible.model.Empleado;
import com.grupotres.back_personal_disponible.model.SkMethod;
import com.grupotres.back_personal_disponible.model.dto.EmpleadoDTO;
import com.grupotres.back_personal_disponible.repository.EmpleadoRepository;
import com.grupotres.back_personal_disponible.service.EmpleadoService;
import com.grupotres.back_personal_disponible.service.SkMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/empleado/skMethod")
public class SkMethodRestController {

	@Autowired
    private EmpleadoRepository empleadoRepository;

	@Autowired
	private EmpleadoService empleadoService;
	
	@Autowired
    private SkMethodService skMethodService;

    @GetMapping("/{skMethod}")
    public ResponseEntity<?> findBySkMethod(@PathVariable String skMethod){
		List<Empleado> empleados = skMethodService.findBySkMethod(skMethod);
		List<EmpleadoDTO> empleadosDTO = new ArrayList<EmpleadoDTO>();
		for (Empleado emp : empleados) {
			empleadosDTO.add(new EmpleadoDTO(emp));
		}
		return ResponseEntity.ok(empleadosDTO);
	}
    
    @PostMapping("/{skMethod}")
	public ResponseEntity<?> findEmpleadosByCertifNombre(@PathVariable String skMethod, @RequestBody List<EmpleadoDTO> empleadosFiltradosDTO) {
	    List<EmpleadoDTO> empleadosDTOFiltrados = empleadoService.getEmpleadosBySkMethodFromList(empleadosFiltradosDTO, skMethod);
	    return ResponseEntity.ok(empleadosDTOFiltrados);
	}
    
    @GetMapping("/{skMethod}/{nivel}")
    public ResponseEntity<?> findBySkMethodAndNivel(@PathVariable String skMethod, @PathVariable Integer nivel){
		List<Empleado> empleados = skMethodService.findBySkMethodAndNivel(skMethod, nivel);
		List<EmpleadoDTO> empleadosDTO = new ArrayList<EmpleadoDTO>();
		for (Empleado emp : empleados) {
			empleadosDTO.add(new EmpleadoDTO(emp));
		}
		return ResponseEntity.ok(empleadosDTO);
	}
    
    @PostMapping("/{skMethod}/{nivel}")
	public ResponseEntity<?> findBySkMethodAndNivel(@PathVariable String skMethod, @PathVariable Integer nivel, @RequestBody List<EmpleadoDTO> empleadosFiltradosDTO) {
	    List<EmpleadoDTO> empleadosDTOFiltrados = empleadoService.getEmpleadosBySkMethodAndNivelFromList(empleadosFiltradosDTO, skMethod, nivel);
	    return ResponseEntity.ok(empleadosDTOFiltrados);
	}
    
}

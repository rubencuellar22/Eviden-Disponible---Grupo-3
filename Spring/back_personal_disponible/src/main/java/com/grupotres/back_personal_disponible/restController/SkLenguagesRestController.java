package com.grupotres.back_personal_disponible.restController;
 
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.grupotres.back_personal_disponible.model.Empleado;
import com.grupotres.back_personal_disponible.model.SkLenguage;
import com.grupotres.back_personal_disponible.model.dto.EmpleadoDTO;
import com.grupotres.back_personal_disponible.model.dto.SkLenguageDTO;
import com.grupotres.back_personal_disponible.service.EmpleadoService;
import com.grupotres.back_personal_disponible.service.SkLenguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
@RestController
@RequestMapping("/empleado/skLenguage")
@CrossOrigin(origins = "*")
public class SkLenguagesRestController {
 
	@Autowired
	private EmpleadoService empleadoService;
	
	@Autowired
	private SkLenguageService skLenguageService;
 
	@GetMapping("/todos")
    public ResponseEntity<List<SkLenguageDTO>> selectAllSkLenguages() {
        List<SkLenguage> skLenguages = skLenguageService.selectAllSkLenguages();
        List<SkLenguageDTO> skLenguagesDTO = new ArrayList<>();
        for (SkLenguage skLenguage : skLenguages) {
        	
            skLenguagesDTO.add(new SkLenguageDTO(skLenguage));
        }
        return ResponseEntity.ok(skLenguagesDTO);
    }
	
	@GetMapping("/{sklenguage}")
	public ResponseEntity<?>getEmpleadosBySkLenguage(@PathVariable String sklenguage) {
		List<Empleado> empleados = skLenguageService.findEmpleadosBySkLenguage(sklenguage);
		List<EmpleadoDTO> empleadosDTO = new ArrayList<EmpleadoDTO>();
		for (Empleado emp : empleados) {
			empleadosDTO.add(new EmpleadoDTO(emp));
		}
		return ResponseEntity.ok(empleadosDTO);
	}
	
	@PostMapping("/{sklenguage}")
	public ResponseEntity<?> findEmpleadosByCertifNombre(@PathVariable String sklenguage, @RequestBody List<EmpleadoDTO> empleadosFiltradosDTO) {
	    List<EmpleadoDTO> empleadosDTOFiltrados = empleadoService.getEmpleadosBySkLenguageFromList(empleadosFiltradosDTO, sklenguage);
	    return ResponseEntity.ok(empleadosDTOFiltrados);
	}
 
	@GetMapping("/{sklenguage}/{nivel}")
	public ResponseEntity<?>getSkLenguagesByLenguageAndLvl(@PathVariable String sklenguage, @PathVariable String nivel) {
		List<Empleado> empleados = skLenguageService.findEmpleadosBySkLenguageAndLvl(sklenguage, nivel);
		List<EmpleadoDTO> empleadosDTO = new ArrayList<EmpleadoDTO>();
		for (Empleado emp : empleados) {
			empleadosDTO.add(new EmpleadoDTO(emp));
		}
		return ResponseEntity.ok(empleadosDTO);
	}
	
	@PostMapping("/{sklenguage}/{nivel}")
	public ResponseEntity<?> getSkLenguagesByLenguageAndLvl(@PathVariable String sklenguage, @PathVariable String nivel, @RequestBody List<EmpleadoDTO> empleadosFiltradosDTO) {
	    List<EmpleadoDTO> empleadosDTOFiltrados = empleadoService.getEmpleadosBySkLenguageAndNivelFromList(empleadosFiltradosDTO, sklenguage, nivel);
	    return ResponseEntity.ok(empleadosDTOFiltrados);
	}
	
	 @GetMapping("/autocomplete")
	    public ResponseEntity<List<SkLenguageDTO>> autocomplete(@RequestBody String query) {
	        List<SkLenguage> skLenguages = skLenguageService.findByNombreContaining(query);
	        List<SkLenguageDTO> skLenguageDTOs = skLenguages.stream()
	                                                        .map(SkLenguageDTO::new)
	                                                        .collect(Collectors.toList());
	        return ResponseEntity.ok(skLenguageDTOs);
	    }
 
}
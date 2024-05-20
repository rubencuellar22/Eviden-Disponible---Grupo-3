package com.grupotres.back_personal_disponible.restController;

import java.util.ArrayList;
import java.util.List;

import com.grupotres.back_personal_disponible.model.Empleado;
import com.grupotres.back_personal_disponible.model.dto.EmpleadoDTO;
import com.grupotres.back_personal_disponible.model.dto.SkLenguageDTO;
import com.grupotres.back_personal_disponible.service.SkLenguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupotres.back_personal_disponible.model.SkLenguage;
import com.grupotres.back_personal_disponible.repository.SkLenguageRepository;


@RestController
@RequestMapping("/empleado/skLenguage")
public class SkLenguagesRestController {

	@Autowired
	private SkLenguageRepository skLenguageRepository;

	@Autowired
	private SkLenguageService skLenguageService;

	@GetMapping("sklenguage/{sklenguage}")
	public ResponseEntity<?> getEmpleadosBySkLenguage(@PathVariable String sklenguage) {
		List<Empleado> empleados = skLenguageService.findEmpleadosBySkLenguage(sklenguage);
		List<EmpleadoDTO> empleadosDTO = new ArrayList<EmpleadoDTO>();
		for (Empleado emp : empleados) {
			empleadosDTO.add(new EmpleadoDTO(emp));
		}
		return ResponseEntity.ok(empleadosDTO);
	}

	@GetMapping("sklenguage/{sklenguage}/{nivel}")
	public ResponseEntity<?>getSkLenguagesByLenguageAndLvl(@PathVariable String sklenguage, @PathVariable String nivel) {
		List<SkLenguage> sklanguages = skLenguageRepository.findBySkLenguageAndLvl(sklenguage, nivel);
		List<SkLenguageDTO> lenguageDTO = new ArrayList<SkLenguageDTO>();
		for (SkLenguage skl : sklanguages) {
			lenguageDTO.add(new SkLenguageDTO().skLenguageToSkLenguageDTO(skl));
		}
		return ResponseEntity.ok(lenguageDTO);
	}
	
}

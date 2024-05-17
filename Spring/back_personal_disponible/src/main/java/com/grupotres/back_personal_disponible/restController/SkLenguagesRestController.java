package com.grupotres.back_personal_disponible.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@GetMapping("/{sklenguage}")
	public List<SkLenguage> findEmpleadosBySkLenguage(@PathVariable String sklenguage){
		return skLenguageRepository.findBySkLenguage(sklenguage);
	}

	@GetMapping("/{sklenguage}/{nivel}")
	public List<SkLenguage> getSkLenguagesByLenguageAndLvl(@PathVariable String sklenguage, @PathVariable String nivel){
		return skLenguageRepository.findBySkLenguageAndLvl(sklenguage, nivel);
	}
	
}

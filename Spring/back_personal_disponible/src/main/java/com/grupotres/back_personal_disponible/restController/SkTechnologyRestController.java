package com.grupotres.back_personal_disponible.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupotres.back_personal_disponible.model.Empleado;
import com.grupotres.back_personal_disponible.repository.SkTechnologyRepository;
import com.grupotres.back_personal_disponible.service.SkTechnologyService;


@RestController
@RequestMapping("/empleado/sk_technology/technology")
public class SkTechnologyRestController {
	@Autowired
    private SkTechnologyService skTechnologyService;
	
	
	 @GetMapping("/{nombre}")
	    public List<Empleado> findEmpleadosByCertifNombre(@PathVariable String nombre) {
	        return skTechnologyService.findEmpleadosByTechnology(nombre);
	    }
}

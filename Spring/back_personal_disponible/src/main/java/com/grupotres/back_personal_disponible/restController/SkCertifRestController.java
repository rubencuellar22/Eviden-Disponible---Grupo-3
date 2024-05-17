package com.grupotres.back_personal_disponible.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupotres.back_personal_disponible.model.Empleado;
import com.grupotres.back_personal_disponible.service.SkCertifService;


@RestController
@RequestMapping("/empleado/sk_certif/certif")
public class SkCertifRestController {
	
	
	@Autowired
    private SkCertifService skCertifService;
	
	
	 @GetMapping("/{nombre}")
	    public List<Empleado> findEmpleadosByCertifNombre(@PathVariable String nombre) {
	        return skCertifService.findEmpleadosByCertifNombre(nombre);
	    }
	
}

package com.grupotres.back_personal_disponible.restController;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.grupotres.back_personal_disponible.model.Empleado;
import com.grupotres.back_personal_disponible.service.SkBussSkillService;


@RestController
@RequestMapping("/empleado/sk_bussskill/bussskill")
public class SkBussSkillRestController {
	@Autowired
    private SkBussSkillService skBussSkillService;
	
	
	 @GetMapping("/{nombre}")
	    public List<Empleado> findEmpleadosByBussSkill(@PathVariable String nombre) {
	        return skBussSkillService.findEmpleadosByBussSkill(nombre);
	    }
}

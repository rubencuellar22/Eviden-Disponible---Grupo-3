package com.grupotres.back_personal_disponible.restController;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.grupotres.back_personal_disponible.model.Empleado;
import com.grupotres.back_personal_disponible.model.SkLenguage;
import com.grupotres.back_personal_disponible.repository.EmpleadoRepository;
import com.grupotres.back_personal_disponible.repository.SkLenguageRepository;
import com.grupotres.back_personal_disponible.service.EmpleadoService;
import com.grupotres.back_personal_disponible.service.SkLenguageService;

@RestController
@RequestMapping("/empleado/")
@CrossOrigin(origins = "*")
public class EmpleadoRestController {
	
	@Autowired
	private EmpleadoRepository empleadoRepository;
	
	@Autowired
	private SkLenguageRepository skLenguageRepository;
	
	@Autowired
	private SkLenguageService skLenguageService;
	
	@GetMapping("todos")
	public List<Empleado> findAll(){
		
		return empleadoRepository.findAll();		
	}
	
	@GetMapping("status/{status}")
	public List<Empleado> findbyStatus(@PathVariable String status){
		return empleadoRepository.findbyStatus(status);
	}
	
	@GetMapping("bench/{bench}")
	public List<Empleado> findByBench(@PathVariable String bench) {
	    return empleadoRepository.findByBench(bench);
	}

	@GetMapping("ciudad/{ciudad}")
	public List<Empleado> findByCiudad(@PathVariable String ciudad) {
	    return empleadoRepository.findByCiudad(ciudad);
	}

	@GetMapping("jornada/{jornada}")
	public List<Empleado> findByJornada(@PathVariable BigDecimal jornada) {
	    return empleadoRepository.findByJornada(jornada);
	}
	
	@GetMapping("n4/{n4}")
	public List<Empleado> findbyN4(@PathVariable String n4) {
		return empleadoRepository.findbyN4(n4);
 
	}
	
	@GetMapping("categoria/{categoria}")
	public List<Empleado> findbyCategoria(@PathVariable String categoria){
		return empleadoRepository.findbyCategoria(categoria);
	}
	
	/*@GetMapping("ccname/{ccname}")
	public List<Empleado> findbyCcname(@PathVariable String ccname){
		return empleadoRepository.findbyCcname(ccname);
	}*/
	
	@GetMapping("scr/{scr}")
	public List<Empleado> findbyScr(@PathVariable BigDecimal scr) {
	    return empleadoRepository.findbyScr(scr);
	}
	
	/*@GetMapping("sklenguage/{sklenguage}")
	public List<SkLenguage> findByEmpleadoGinAndSklenguage(@RequestParam("gin") Integer gin, @RequestParam("sklenguage") String sklenguage) {
	    return skLenguageRepository.findByEmpleadoGinAndSklenguage(gin, sklenguage);
	}*/
	
	@GetMapping("sklenguage/{sklenguage}")
	public List<Empleado> getEmpleadosBySkLenguage(@PathVariable String sklenguage) {
	    return skLenguageService.findEmpleadosBySkLenguage(sklenguage);
	}

}

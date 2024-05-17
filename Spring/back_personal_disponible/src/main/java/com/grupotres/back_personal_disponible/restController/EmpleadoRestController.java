package com.grupotres.back_personal_disponible.restController;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.grupotres.back_personal_disponible.model.dto.EmpleadoDTO;
import com.grupotres.back_personal_disponible.model.dto.SkLenguageDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupotres.back_personal_disponible.model.Empleado;
import com.grupotres.back_personal_disponible.model.SkLenguage;
import com.grupotres.back_personal_disponible.repository.EmpleadoRepository;
import com.grupotres.back_personal_disponible.repository.SkLenguageRepository;
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
	
	@GetMapping()
	public ResponseEntity<?> findAll(){
		List<Empleado> empleados = empleadoRepository.findAll();
		List<EmpleadoDTO> empleadosDTO = new ArrayList<EmpleadoDTO>();
		for (Empleado emp : empleados) {
			empleadosDTO.add(new EmpleadoDTO().empleadoToEmpleadoDTO(emp));
		}
		return ResponseEntity.ok(empleadosDTO);
	}
	
	@GetMapping("status/{status}")
	public ResponseEntity<?> findByStatus(@PathVariable String status) {
	    List<Empleado> empleados = empleadoRepository.findbyStatus(status);
	    List<EmpleadoDTO> empleadosDTO = new ArrayList<EmpleadoDTO>();
	    for (Empleado emp : empleados) {
	        empleadosDTO.add(new EmpleadoDTO().empleadoToEmpleadoDTO(emp));
	    }
	    return ResponseEntity.ok(empleadosDTO);
	}
	
	@GetMapping("bench/{bench}")
    public ResponseEntity<?> findByBench(@PathVariable String bench) {
        try {
            // Define the date format expected in the path variable
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            // Parse the string to a Date object
            Date benchDate = dateFormat.parse(bench);

            // Find employees by the bench date
            List<Empleado> empleados = empleadoRepository.findByBench(benchDate);
            List<EmpleadoDTO> empleadosDTO = new ArrayList<>();
            for (Empleado emp : empleados) {
                empleadosDTO.add(new EmpleadoDTO().empleadoToEmpleadoDTO(emp));
            }
            return ResponseEntity.ok(empleadosDTO);
        } catch (ParseException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Invalid date format. Please use yyyy-MM-dd.");
        }
    }


	@GetMapping("ciudad/{ciudad}")
	public ResponseEntity<?> findByCiudad(@PathVariable String ciudad) {
	    List<Empleado> empleados = empleadoRepository.findByCiudad(ciudad);
	    List<EmpleadoDTO> empleadosDTO = new ArrayList<>();
	    for (Empleado emp : empleados) {
	        empleadosDTO.add(new EmpleadoDTO().empleadoToEmpleadoDTO(emp));
	    }
	    return ResponseEntity.ok(empleadosDTO);
	}

	@GetMapping("jornada/{jornada}")
	public ResponseEntity<?> findByJornada(@PathVariable BigDecimal jornada) {
	    List<Empleado> empleados = empleadoRepository.findByJornada(jornada);
	    List<EmpleadoDTO> empleadosDTO = new ArrayList<>();
	    for (Empleado emp : empleados) {
	        empleadosDTO.add(new EmpleadoDTO().empleadoToEmpleadoDTO(emp));
	    }
	    return ResponseEntity.ok(empleadosDTO);
	}
	
	@GetMapping("n4/{n4}")
	public ResponseEntity<?> findByN4(@PathVariable String n4) {
	    List<Empleado> empleados = empleadoRepository.findbyN4(n4);
	    List<EmpleadoDTO> empleadosDTO = new ArrayList<>();
	    for (Empleado emp : empleados) {
	        empleadosDTO.add(new EmpleadoDTO().empleadoToEmpleadoDTO(emp));
	    }
	    return ResponseEntity.ok(empleadosDTO);
	}
	
	@GetMapping("categoria/{categoria}")
	public ResponseEntity<?> findByCategoria(@PathVariable String categoria) {
	    List<Empleado> empleados = empleadoRepository.findbyCategoria(categoria);
	    List<EmpleadoDTO> empleadosDTO = new ArrayList<>();
	    for (Empleado emp : empleados) {
	        empleadosDTO.add(new EmpleadoDTO().empleadoToEmpleadoDTO(emp));
	    }
	    return ResponseEntity.ok(empleadosDTO);
	}
	
	/*@GetMapping("ccname/{ccname}")
	public List<Empleado> findbyCcname(@PathVariable String ccname){
		return empleadoRepository.findbyCcname(ccname);
	}*/
	
	@GetMapping("scr/{scr}")
	public ResponseEntity<?>findbyScr (@PathVariable BigDecimal scr) {
		List<Empleado> empleados = empleadoRepository.findbyScr(scr);
		List<EmpleadoDTO> empleadosDTO = new ArrayList<EmpleadoDTO>();
		for (Empleado emp : empleados) {
			empleadosDTO.add(new EmpleadoDTO().empleadoToEmpleadoDTO(emp));
		}
		return ResponseEntity.ok(empleadosDTO);
	}
	
	
	@GetMapping("sklenguage/{sklenguage}")
	public ResponseEntity<?>getEmpleadosBySkLenguage(@PathVariable String sklenguage) {
		List<SkLenguage> sklanguages = skLenguageRepository.findBySkLenguage(sklenguage);
		List<SkLenguageDTO> lenguageDTO = new ArrayList<SkLenguageDTO>();
		for (SkLenguage skl : sklanguages) {
			lenguageDTO.add(new SkLenguageDTO().skLenguageToSkLenguageDTO(skl));
		}
		return ResponseEntity.ok(lenguageDTO);
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

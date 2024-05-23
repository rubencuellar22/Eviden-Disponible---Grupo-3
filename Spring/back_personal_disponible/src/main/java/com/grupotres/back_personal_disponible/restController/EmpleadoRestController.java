package com.grupotres.back_personal_disponible.restController;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.grupotres.back_personal_disponible.model.dto.EmpleadoDTO;
import com.grupotres.back_personal_disponible.model.dto.SkLenguageDTO;


import com.grupotres.back_personal_disponible.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @Qualifier("empleadoServiceImpl")
    @Autowired
    private EmpleadoService empleadoService;


	@GetMapping()
	public ResponseEntity<?> findAll(){
		List<Empleado> empleados = empleadoRepository.findAll();
		List<EmpleadoDTO> empleadosDTO = new ArrayList<EmpleadoDTO>();
		for (Empleado emp : empleados) {
			empleadosDTO.add(new EmpleadoDTO(emp));
		}
		return ResponseEntity.ok(empleadosDTO);
	}
	
	@GetMapping("status/{status}")
	public ResponseEntity<?> findByStatus(@PathVariable String status) {
	    List<Empleado> empleados = empleadoRepository.findbyStatus(status);
	    List<EmpleadoDTO> empleadosDTO = new ArrayList<EmpleadoDTO>();
	    for (Empleado emp : empleados) {
	        empleadosDTO.add(new EmpleadoDTO(emp));
	    }
	    return ResponseEntity.ok(empleadosDTO);
	}

	@PostMapping("status/{status}")
	public ResponseEntity<?> findByStatus(@PathVariable String status, @RequestBody List<EmpleadoDTO> empleadosFiltradosDTO) {
		List<EmpleadoDTO> empleadosDTOFiltrados = empleadoService.getEmpleadosByStatusFromList(empleadosFiltradosDTO, status);
		return ResponseEntity.ok(empleadosDTOFiltrados);
	}
	
	 @GetMapping("/bench/{bench}")
	    public ResponseEntity<?> findByBench(@PathVariable String bench) {
	        try {
	            // Define the datetime format expected in the path variable, including microseconds
	            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSSSS");
	            // Parse the string to a Date object
	            Date benchDate = dateFormat.parse(bench);

	            // Debug: print the parsed date
	            System.out.println("Parsed bench date: " + benchDate);

	            // Find employees by the bench date and time
	            List<Empleado> empleados = empleadoRepository.findByBench(benchDate);

	            // Debug: print the size of the result
	            System.out.println("Number of employees found: " + empleados.size());

	            List<EmpleadoDTO> empleadosDTO = new ArrayList<>();
	            for (Empleado emp : empleados) {
	                empleadosDTO.add(new EmpleadoDTO(emp));
	            }
	            return ResponseEntity.ok(empleadosDTO);
	        } catch (ParseException e) {
	            e.printStackTrace();
	            return ResponseEntity.badRequest().body("Invalid date format. Please use yyyy-MM-dd HH:mm:ss.SSSSSS.");
	        }
	    }


	@GetMapping("ciudad/{ciudad}")
	public ResponseEntity<?> findByCiudad(@PathVariable String ciudad) {
	    List<Empleado> empleados = empleadoRepository.findByCiudad(ciudad);
	    List<EmpleadoDTO> empleadosDTO = new ArrayList<>();
	    for (Empleado emp : empleados) {
	        empleadosDTO.add(new EmpleadoDTO(emp));
	    }
	    return ResponseEntity.ok(empleadosDTO);
	}
	
	@PostMapping("ciudad/{ciudad}")
	public ResponseEntity<?> findByCiudad(@PathVariable String ciudad, @RequestBody List<EmpleadoDTO> empleadosFiltradosDTO) {
	    List<EmpleadoDTO> empleadosDTOFiltrados = empleadoService.getEmpleadosByCiudadFromList(empleadosFiltradosDTO, ciudad);
	    return ResponseEntity.ok(empleadosDTOFiltrados);
	}

	
	@GetMapping("jornada/{jornada}")
	public ResponseEntity<?> findByJornada(@PathVariable BigDecimal jornada) {
	    List<Empleado> empleados = empleadoRepository.findByJornada(jornada);
	    List<EmpleadoDTO> empleadosDTO = new ArrayList<>();
	    for (Empleado emp : empleados) {
	        empleadosDTO.add(new EmpleadoDTO(emp));
	    }
	    return ResponseEntity.ok(empleadosDTO);
	}
	
	@PostMapping("jornada/{jornada}")
	public ResponseEntity<?> findByJornada(@PathVariable String jornada, @RequestBody List<EmpleadoDTO> empleadosFiltradosDTO) {
		List<EmpleadoDTO> empleadosDTOFiltrados = empleadoService.getEmpleadosByJornadaFromList(empleadosFiltradosDTO, jornada);
		return ResponseEntity.ok(empleadosDTOFiltrados);
	}

	
	
	@GetMapping("groups/{groups}")
	public ResponseEntity<?> findByGroups(@PathVariable String groups) {
		List<Empleado> empleados = empleadoService.findbyGrupos(groups);
		List<EmpleadoDTO> empleadosDTO = new ArrayList<>();
		for (Empleado emp : empleados) {
			empleadosDTO.add(new EmpleadoDTO(emp));
		}
		return ResponseEntity.ok(empleadosDTO);
	}
	
	@PostMapping("groups/{groups}")
	public ResponseEntity<?> findByGroups(@PathVariable String groups, @RequestBody List<EmpleadoDTO> empleadosFiltradosDTO) {
		List<EmpleadoDTO> empleadosDTOFiltrados = empleadoService.getEmpleadosByGroupsFromList(empleadosFiltradosDTO, groups);
		return ResponseEntity.ok(empleadosDTOFiltrados);
	}
	
	
	@GetMapping("n4/{n4}")
	public ResponseEntity<?> findByN4(@PathVariable String n4) {
	    List<Empleado> empleados = empleadoRepository.findbyN4(n4);
	    List<EmpleadoDTO> empleadosDTO = new ArrayList<>();
	    for (Empleado emp : empleados) {
	        empleadosDTO.add(new EmpleadoDTO(emp));
	    }
	    return ResponseEntity.ok(empleadosDTO);
	}
	
	@PostMapping("n4/{n4}")
	public ResponseEntity<?> findByN4(@PathVariable String n4, @RequestBody List<EmpleadoDTO> empleadosFiltradosDTO) {
		List<EmpleadoDTO> empleadosDTOFiltrados = empleadoService.getEmpleadosByN4FromList(empleadosFiltradosDTO, n4);
		return ResponseEntity.ok(empleadosDTOFiltrados);
	}
	
	@GetMapping("categoria/{categoria}")
	public ResponseEntity<?> findByCategoria(@PathVariable String categoria) {
	    List<Empleado> empleados = empleadoRepository.findbyCategoria(categoria);
	    List<EmpleadoDTO> empleadosDTO = new ArrayList<>();
	    for (Empleado emp : empleados) {
	        empleadosDTO.add(new EmpleadoDTO(emp));
	    }
	    return ResponseEntity.ok(empleadosDTO);
	}
	
	@PostMapping("categoria/{categoria}")
	public ResponseEntity<?> findByCategoria(@PathVariable String categoria, @RequestBody List<EmpleadoDTO> empleadosFiltradosDTO) {
		List<EmpleadoDTO> empleadosDTOFiltrados = empleadoService.getEmpleadosByCategoriaFromList(empleadosFiltradosDTO, categoria);
		return ResponseEntity.ok(empleadosDTOFiltrados);
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
			empleadosDTO.add(new EmpleadoDTO(emp));
		}
		return ResponseEntity.ok(empleadosDTO);
	}
	
	@PostMapping("scr/{scr}")
		public ResponseEntity<?> findbyScr(@PathVariable String scr, @RequestBody List<EmpleadoDTO> empleadosFiltradosDTO) {
			List<EmpleadoDTO> empleadosDTOFiltrados = empleadoService.getEmpleadosByScrFromList(empleadosFiltradosDTO, scr);
			return ResponseEntity.ok(empleadosDTOFiltrados);
		}

}

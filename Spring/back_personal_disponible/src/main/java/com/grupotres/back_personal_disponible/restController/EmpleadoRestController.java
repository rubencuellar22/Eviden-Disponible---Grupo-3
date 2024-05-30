package com.grupotres.back_personal_disponible.restController;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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
	
	 @GetMapping("/status/todos")
	    public ResponseEntity<List<String>> findAllStatuses() {
	        List<String> statuses = empleadoRepository.findAllDistinctStatuses();
	        return ResponseEntity.ok(statuses);
	    }
	
	 @GetMapping("/bench/{bench}")
	 public ResponseEntity<?> findByBench(@PathVariable String bench) {
	     try {
	         // Define el formato de fecha y hora esperado en la variable de la URL, incluyendo microsegundos
	         SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSSSS");
	         // Parsea la cadena a un objeto Date
	         Date benchDate = dateFormat.parse(bench);

	         // Depuración: imprime la fecha parseada
	         System.out.println("Fecha bench parseada: " + benchDate);

	         // Encuentra empleados por la fecha bench
	         List<Empleado> empleados = empleadoRepository.findByBench(benchDate);

	         // Depuración: imprime el tamaño del resultado
	         System.out.println("Número de empleados encontrados: " + empleados.size());

	         List<EmpleadoDTO> empleadosDTO = new ArrayList<>();
	         for (Empleado emp : empleados) {
	             empleadosDTO.add(new EmpleadoDTO(emp));
	         }
	         return ResponseEntity.ok(empleadosDTO);
	     } catch (ParseException e) {
	         e.printStackTrace();
	         return ResponseEntity.badRequest().body("Formato de fecha no válido. Por favor, utiliza yyyy-MM-dd HH:mm:ss.SSSSSS.");
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
	
	 @GetMapping("/ciudad/todos")
	    public ResponseEntity<List<String>> findAllCiudades() {
	        List<String> ciudades = empleadoRepository.findAllDistinctCiudades();
	        return ResponseEntity.ok(ciudades);
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
	
	@GetMapping("/jornada/todos")
    public ResponseEntity<List<BigDecimal>> findAllJornadas() {
        List<BigDecimal> jornadas = empleadoRepository.findAllDistinctJornadas();
        return ResponseEntity.ok(jornadas);
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
	
	@GetMapping("groups/todos")
	public ResponseEntity<List<String>> findAllGroups() {
	    List<String> grupos = empleadoRepository.findAllDistinctGroups();
	    return ResponseEntity.ok(grupos);
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
	
	 @GetMapping("/n4/todos")
	    public ResponseEntity<List<String>> findAllN4s() {
	        List<String> n4s = empleadoRepository.findAllDistinctN4s();
	        return ResponseEntity.ok(n4s);
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
	
	 @GetMapping("/categoria/todos")
	    public ResponseEntity<List<String>> findAllCategorias() {
	        List<String> categorias = empleadoRepository.findAllDistinctCategorias();
	        return ResponseEntity.ok(categorias);
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
	
	 @GetMapping("/scr/todos")
	    public ResponseEntity<List<BigDecimal>> findAllScrs() {
	        List<BigDecimal> scrs = empleadoRepository.findAllDistinctScrs();
	        return ResponseEntity.ok(scrs);
	    }

	 
	 //querys autocomplete
	 @GetMapping("/autocomplete")
	    public ResponseEntity<List<String>> autocomplete(@RequestParam String query, @RequestParam String filterType) {
	        List<String> results;
	        switch (filterType) {
	            case "status":
	                results = empleadoRepository.findAllDistinctStatuses().stream()
	                    .filter(status -> status.toLowerCase().contains(query.toLowerCase()))
	                    .collect(Collectors.toList());
	                break;
	            case "bench":
	                // Implementar lógica específica para 'bench'
	                results = new ArrayList<>(); // Placeholder
	                break;
	            case "ciudad":
	                results = empleadoRepository.findAllDistinctCiudades().stream()
	                    .filter(ciudad -> ciudad.toLowerCase().contains(query.toLowerCase()))
	                    .collect(Collectors.toList());
	                break;
	            case "jornada":
	                results = empleadoRepository.findAllDistinctJornadas().stream()
	                    .filter(jornada -> jornada.toString().contains(query))
	                    .map(BigDecimal::toString)
	                    .collect(Collectors.toList());
	                break;
	            case "grupo":
	                results = empleadoRepository.findAllDistinctGroups().stream()
	                    .filter(group -> group.toLowerCase().contains(query.toLowerCase()))
	                    .collect(Collectors.toList());
	                break;
	            case "n4":
	                results = empleadoRepository.findAllDistinctN4s().stream()
	                    .filter(n4 -> n4.toLowerCase().contains(query.toLowerCase()))
	                    .collect(Collectors.toList());
	                break;
	            case "categoria":
	                results = empleadoRepository.findAllDistinctCategorias().stream()
	                    .filter(categoria -> categoria.toLowerCase().contains(query.toLowerCase()))
	                    .collect(Collectors.toList());
	                break;
	            case "scr":
	                results = empleadoRepository.findAllDistinctScrs().stream()
	                    .filter(scr -> scr.toString().contains(query))
	                    .map(BigDecimal::toString)
	                    .collect(Collectors.toList());
	                break;
	            default:
	                results = new ArrayList<>();
	        }
	        System.out.println("Results: " + results); // Mensaje de depuración
	        return ResponseEntity.ok(results);
	    }
	}
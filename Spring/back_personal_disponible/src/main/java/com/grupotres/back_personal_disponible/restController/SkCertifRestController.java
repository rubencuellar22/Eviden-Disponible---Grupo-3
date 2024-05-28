package com.grupotres.back_personal_disponible.restController;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupotres.back_personal_disponible.model.Empleado;
import com.grupotres.back_personal_disponible.model.SkCertif;
import com.grupotres.back_personal_disponible.model.dto.EmpleadoDTO;
import com.grupotres.back_personal_disponible.model.dto.SkCertifDTO;
import com.grupotres.back_personal_disponible.repository.EmpleadoRepository;
import com.grupotres.back_personal_disponible.service.EmpleadoService;
import com.grupotres.back_personal_disponible.service.SkCertifService;


@RestController
@RequestMapping("/empleado/skCertif/")
public class SkCertifRestController {
	
	@Autowired
    private EmpleadoRepository empleadoRepository;
	
	@Autowired
	private EmpleadoService empleadoService;
	
	@Autowired
    private SkCertifService skCertifService;
	
	@GetMapping("/todos")
    public ResponseEntity<List<SkCertifDTO>> selectAllSkCertifs() {
        List<SkCertif> skCertifs = skCertifService.selectAllSkCertifs();
        List<SkCertifDTO> skCertifsDTO = new ArrayList<>();
        for (SkCertif skCertif : skCertifs) {
            skCertifsDTO.add(new SkCertifDTO(skCertif));
        }
        return ResponseEntity.ok(skCertifsDTO);
    }
	
	 @GetMapping("/{nombre}")
	 public ResponseEntity<?> findEmpleadosByCertifNombre(@PathVariable String nombre){
		List<Empleado> empleados = skCertifService.findEmpleadosByCertifNombre(nombre);
		List<EmpleadoDTO> empleadosDTO = new ArrayList<EmpleadoDTO>();
		for (Empleado emp : empleados) {
			empleadosDTO.add(new EmpleadoDTO(emp));
		}
		return ResponseEntity.ok(empleadosDTO);
	 }
	 
	 @PostMapping("/{nombre}")
		public ResponseEntity<?> findEmpleadosByCertifNombre(@PathVariable String nombre, @RequestBody List<EmpleadoDTO> empleadosFiltradosDTO) {
		    List<EmpleadoDTO> empleadosDTOFiltrados = empleadoService.getEmpleadosBySkCertifFromList(empleadosFiltradosDTO, nombre);
		    return ResponseEntity.ok(empleadosDTOFiltrados);
	 }
	 
	 @GetMapping("/{nombre}/{external}")
	 public ResponseEntity<?> findEmpleadosByCertifNombreAndNivel(@PathVariable String nombre, @PathVariable Integer external){
		List<Empleado> empleados = skCertifService.findEmpleadosByCertifNombreAndNivel(nombre, external);
		List<EmpleadoDTO> empleadosDTO = new ArrayList<EmpleadoDTO>();
		for (Empleado emp : empleados) {
			empleadosDTO.add(new EmpleadoDTO(emp));
		}
		return ResponseEntity.ok(empleadosDTO);
	 }
	 
	 @PostMapping("/{nombre}/{external}")
		public ResponseEntity<?> findEmpleadosByCertifNombreAndNivel(@PathVariable String nombre, @PathVariable Integer external, @RequestBody List<EmpleadoDTO> empleadosFiltradosDTO) {
		    List<EmpleadoDTO> empleadosDTOFiltrados = empleadoService.getEmpleadosBySkCertifAndNivelFromList(empleadosFiltradosDTO, nombre, external);
		    return ResponseEntity.ok(empleadosDTOFiltrados);
	 }
	 
}

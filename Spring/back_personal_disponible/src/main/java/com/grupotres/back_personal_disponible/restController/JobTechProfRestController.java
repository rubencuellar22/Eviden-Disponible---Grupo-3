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
import com.grupotres.back_personal_disponible.model.JobTechnologyProfile;
import com.grupotres.back_personal_disponible.model.dto.EmpleadoDTO;
import com.grupotres.back_personal_disponible.model.dto.JobTechnologyProfileDTO;
import com.grupotres.back_personal_disponible.service.EmpleadoService;
import com.grupotres.back_personal_disponible.service.JobTechnologyProfileService;

@RestController
@RequestMapping("/empleado/jobTechnologyProfile")
public class JobTechProfRestController {
    
    @Autowired
    private EmpleadoService empleadoService;
    
    @Autowired
    private JobTechnologyProfileService jobTechnologyProfileService;
    
    @GetMapping("/todos")
    public ResponseEntity<List<JobTechnologyProfileDTO>> selectAllJobTechnologyProfile() {
        List<JobTechnologyProfile> jobProfiles = jobTechnologyProfileService.selectAllJobTechnologyProfile();
        List<JobTechnologyProfileDTO> jobProfilesDTO = new ArrayList<>();
        for (JobTechnologyProfile jobProfile : jobProfiles) {
            jobProfilesDTO.add(new JobTechnologyProfileDTO(jobProfile));
        }
        return ResponseEntity.ok(jobProfilesDTO);
    }
    
    @GetMapping("/{jobTechnologyProfile}")
    public ResponseEntity<?> findByJobTechnologyProfile(@PathVariable String jobTechnologyProfile) {
        List<Empleado> empleados = jobTechnologyProfileService.findByJobTechnologyProfile(jobTechnologyProfile);
        List<EmpleadoDTO> empleadosDTO = new ArrayList<>();
        for (Empleado emp : empleados) {
            empleadosDTO.add(new EmpleadoDTO(emp));
        }
        return ResponseEntity.ok(empleadosDTO);
    }

    @PostMapping("/{jobTechnologyProfile}")
    public ResponseEntity<?> findByJobTechnologyProfile(@PathVariable String jobTechnologyProfile, @RequestBody List<EmpleadoDTO> empleadosFiltradosDTO) {
        List<EmpleadoDTO> empleadosDTOFiltrados = empleadoService.getEmpleadosByJobTechProfileFromList(empleadosFiltradosDTO, jobTechnologyProfile);
        return ResponseEntity.ok(empleadosDTOFiltrados);
    }
    
    @GetMapping("/{jobTechnologyProfile}/{nivel}")
    public ResponseEntity<?> findByJobTechnologyProfileAndLvl(@PathVariable String jobTechnologyProfile, @PathVariable Integer nivel) {
        List<Empleado> empleados = jobTechnologyProfileService.findByJobTechnologyProfileAndLvl(jobTechnologyProfile, nivel);
        List<EmpleadoDTO> empleadosDTO = new ArrayList<>();
        for (Empleado emp : empleados) {
            empleadosDTO.add(new EmpleadoDTO(emp));
        }
        return ResponseEntity.ok(empleadosDTO);
    }
    
    @PostMapping("/{jobTechnologyProfile}/{nivel}")
    public ResponseEntity<?> findByJobTechnologyProfileAndLvl(@PathVariable String jobTechnologyProfile, @PathVariable Integer nivel, @RequestBody List<EmpleadoDTO> empleadosFiltradosDTO) {
        List<EmpleadoDTO> empleadosDTOFiltrados = empleadoService.getEmpleadosByJobTechProfileAndLvlFromList(empleadosFiltradosDTO, jobTechnologyProfile, nivel);
        return ResponseEntity.ok(empleadosDTOFiltrados);
    }
}

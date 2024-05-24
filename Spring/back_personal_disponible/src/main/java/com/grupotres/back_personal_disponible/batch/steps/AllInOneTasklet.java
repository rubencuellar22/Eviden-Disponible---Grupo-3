package com.grupotres.back_personal_disponible.batch.steps;

import com.grupotres.back_personal_disponible.model.*;
import com.grupotres.back_personal_disponible.service.*;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class AllInOneTasklet implements Tasklet {

    @Autowired
    private ResourceLoader resourceLoader;

    @Autowired
    private GrupoService grupoService;

    @Autowired
    private EmpleadoService empleadoService;

    @Autowired
    private JobTechnologyProfileService jobTechnologyProfileService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private SkLenguageService skLenguageService;

    @Autowired
    private SkMethodService skMethodService;

    @Autowired
    private SkTechSkillService skTechSkillService;

    @Autowired
    private SkCertifService skCertifService;

    @Autowired
    private SkTechnologyService skTechnologyService;

    @Autowired
    private SkBussSkillService skBusSkillService;


    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        Reader reader = null;
        while (true) {
            try {
                reader = new FileReader("src/main/resources/files/personal_disponible.csv");
                if (reader != null) {
                    break;
                }
            }catch (Exception e){
                System.out.println("Error al leer el archivo");
            }

        }



        CSVParser parser = new CSVParserBuilder()
                .withSeparator('§')
                .build();

        CSVReader csvReader = new CSVReaderBuilder(reader)
                .withCSVParser(parser)
                .withSkipLines(1)
                .build();

        List<Empleado> empleadoList = new ArrayList<>();
        String[] actualLine;

        while ((actualLine = csvReader.readNext()) != null) {
            System.out.println(Arrays.toString(actualLine));
            Empleado emp = new Empleado();
            emp.setGin(Long.parseLong(actualLine[0]));
            emp.setName(actualLine[1]);
            emp.setSubgroup(actualLine[2]);
            emp.setStatus(actualLine[3]);
           

            emp.setBench(((actualLine[4].isEmpty()) || (actualLine[4].isBlank()) ? null : new SimpleDateFormat("M/d/yyyy").parse(actualLine[4])));
            emp.setDas(actualLine[5]);
            emp.setCiudad(actualLine[6]);
            emp.setLineManager(actualLine[7]);
            emp.setJornada(Double.parseDouble(actualLine[8]));
            emp.setGcm(actualLine[9]);
            emp.setCategoria(actualLine[10]);
            emp.setNivelgcm(Integer.parseInt(actualLine[11]));
            emp.setScr(Double.parseDouble(actualLine[12]));

            Grupo grupo = new Grupo();
            grupo.setCc(actualLine[14]);
            grupo.setGrupo1(actualLine[15]);
            grupo.setGrupo2(actualLine[16]);
            grupo.setGrupo3(actualLine[17]);
            grupo.setGrupo4(actualLine[18]);
            grupo.setGrupos(actualLine[14] + " | " + actualLine[15] + " | " + actualLine[16] + " | " + actualLine[17] + " | " + actualLine[18]);
            emp.setGrupo(grupo);

            emp.setN4(actualLine[19]);
            emp.setAgrupacion(actualLine[20]);
            emp.setJobTechnology(actualLine[21]);

            String[] jobTechnologyProfilesArray = actualLine[22].split("/");
            for (String jobTechnologyProfileString : jobTechnologyProfilesArray) {
                JobTechnologyProfile jobTechnologyProfile = new JobTechnologyProfile();
                String[] parts = jobTechnologyProfileString.split("\\[");
                jobTechnologyProfile.setJobTechnologyProfile(parts[0].trim());
                if (parts.length > 1) {
                    String level = parts[1].replaceAll("\\D+", "");
                    if (!level.isEmpty()) {
                        jobTechnologyProfile.setNivel(Integer.parseInt(level));
                    }
                }
                emp.addJobTechnologyProfile(jobTechnologyProfile);
            }

            emp.setSkills(actualLine[23]);

            Role rol = new Role();
            String[] rolArray = actualLine[24].split("\\[");
            rol.setRole(rolArray[0].trim());
            if (rolArray.length > 1) {
                String level = rolArray[1].replaceAll("\\D+", "");
                if (!level.isEmpty()) {
                    rol.setNivel(Integer.parseInt(level));
                }
            }
            emp.setRole(rol);

            emp.setRlt(actualLine[25].equals("YES"));

            String[] sklanguages = actualLine[26].split("\\|");
            for (String sklanguageString : sklanguages) {
                String[] parts = sklanguageString.split("\\(");
                SkLenguage idioma = new SkLenguage();
                idioma.setSklenguage(parts[0].trim());
                if (parts.length > 1) {
                    String level = parts[1].replaceAll("\\)", "");
                    if (!level.isEmpty()) {
                        idioma.setNivel(level.trim());
                    }
                }
                emp.addSklenguage(idioma);
            }

            String[] skmethods = actualLine[27].split("\\|");
            for (String skmethodString : skmethods) {
                SkMethod metodo = new SkMethod();
                int lastParenthesisIndex = skmethodString.lastIndexOf("(");
                if (lastParenthesisIndex != -1) {
                    String methodName = skmethodString.substring(0, lastParenthesisIndex).trim();
                    String level = skmethodString.substring(lastParenthesisIndex).replaceAll("[()]", "").trim();
                    metodo.setSkmethod(methodName);
                    if (!level.isEmpty()) {
                        metodo.setNivel(Integer.parseInt(level));
                    }
                } else {
                    metodo.setSkmethod(skmethodString.trim());
                }
                emp.addSkMethod(metodo);
            }

            String[] sktechskills = actualLine[28].split("\\|");
            for (String sktechskillString : sktechskills) {
                SkTechSkill skTechSkill = new SkTechSkill();
                int lastParenthesisIndex = sktechskillString.lastIndexOf("(");
                if (lastParenthesisIndex != -1) {
                    String techSkillName = sktechskillString.substring(0, lastParenthesisIndex).trim();
                    String level = sktechskillString.substring(lastParenthesisIndex).replaceAll("[()]", "").trim();
                    skTechSkill.setSkTechSkill(techSkillName);
                    if (!level.isEmpty()) {
                        skTechSkill.setNivel(Integer.parseInt(level));
                    }
                } else {
                    skTechSkill.setSkTechSkill(sktechskillString.trim());
                }
                emp.addSkTechSkill(skTechSkill);
            }

            if (actualLine[29].isEmpty() || actualLine[29].isBlank()){

            } else {
                String[] skcertif = actualLine[29].split("\\|");
                for (String skcertifString : skcertif) {
                    SkCertif certificacion = new SkCertif();
                    int lastParenthesisIndex = skcertifString.lastIndexOf("(");
                    if (lastParenthesisIndex != -1) {
                        String certName = skcertifString.substring(0, lastParenthesisIndex).trim();
                        String external = skcertifString.substring(lastParenthesisIndex).replaceAll("[()]", "").trim();
                        certificacion.setSkcertif(certName);
                        certificacion.setExternal(external.equals("External"));
                    } else {
                        certificacion.setSkcertif(skcertifString.trim());
                        certificacion.setExternal(false);
                    }
                    emp.addSkCertif(certificacion);
                }
            }

            String[] sktechnologies = actualLine[30].split("\\|");
            for (String sktechnologyString : sktechnologies) {
                SkTechnology tecnologia = new SkTechnology();
                int lastParenthesisIndex = sktechnologyString.lastIndexOf("(");
                if (lastParenthesisIndex != -1) {
                    String techName = sktechnologyString.substring(0, lastParenthesisIndex).trim();
                    String level = sktechnologyString.substring(lastParenthesisIndex).replaceAll("[()]", "").trim();
                    tecnologia.setSktechnology(techName);
                    if (!level.isEmpty()) {
                        tecnologia.setNivel(Integer.parseInt(level));
                    }
                } else {
                    tecnologia.setSktechnology(sktechnologyString.trim());
                }
                emp.addSkTechnology(tecnologia);
            }

            // Index 31 out of bounds for length 31
            if (actualLine.length > 31) {

                String[] skbusskills = actualLine[31].split("\\|");
                for (String skbusskillString : skbusskills) {
                    SkBusSkill habilidadNegocio = new SkBusSkill();
                    int lastParenthesisIndex = skbusskillString.lastIndexOf("(");
                    if (lastParenthesisIndex != -1) {
                        String bussSkillName = skbusskillString.substring(0, lastParenthesisIndex).trim();
                        String level = skbusskillString.substring(lastParenthesisIndex).replaceAll("[()]", "").trim();
                        habilidadNegocio.setSkBusSkill(bussSkillName);
                        if (!level.isEmpty()) {
                            habilidadNegocio.setNivel(Integer.parseInt(level));
                        }
                    } else {
                        habilidadNegocio.setSkBusSkill(skbusskillString.trim());
                    }
                    emp.addSkbusSkill(habilidadNegocio);
                }
            }
            empleadoList.add(emp);
        }

        csvReader.close();
        reader.close();

        List<Grupo> grupoList = new ArrayList<>();

        for (Empleado emp : empleadoList) {
            grupoList.add(emp.getGrupo());
        }

        for (Grupo grupo : grupoList) {
            if (grupoList.stream()
                    .noneMatch(grupoExistente -> grupoExistente.getGrupos().equals(grupo.getGrupos()))) {
                grupoList.add(grupo);
            }
        }

        Set<String> uniqueGrupos = grupoList.stream()
                .map(Grupo::getGrupos)
                .collect(Collectors.toSet());

        List<Grupo> uniqueGrupoList = grupoList.stream()
                .filter(grupo -> uniqueGrupos.remove(grupo.getGrupos()))
                .toList();

        grupoService.saveAllGroups(uniqueGrupoList);

        for (Empleado empleado : empleadoList) {
            empleado.setGrupo(uniqueGrupoList.stream()
                    .filter(grupo -> grupo.getGrupos().equals(empleado.getGrupo().getGrupos()))
                    .findFirst()
                    .orElse(null));
        }

        empleadoService.saveAllEmpleados(empleadoList);

        List<Empleado> empleadoListFinal = empleadoService.getAllEmpleados();

        for (Empleado empleado : empleadoList) {
            Empleado empleadoFinal = empleadoListFinal.stream()
                    .filter(emp -> emp.getGin().equals(empleado.getGin()))
                    .findFirst()
                    .orElse(null);

            List<JobTechnologyProfile> empJobTechnologyProfiles = empleado.getJobTechnologyProfiles();
            for (JobTechnologyProfile jobTechnologyProfile : empJobTechnologyProfiles) {
                jobTechnologyProfile.setEmpleado(empleadoFinal);
            }
            jobTechnologyProfileService.saveAllJobTechnologyProfiles(empJobTechnologyProfiles);

            assert empleadoFinal != null;
            Role empRole = roleService.getRoleById(empleadoFinal.getRole().getIdRole());
            if (!roleService.existsRoleForEmp(empleadoFinal.getGin())) {
                empRole.setEmpleado(empleadoFinal);
                roleService.saveRole(empRole);
            } else {
                roleService.deleteRole(empRole);
            }


            List<SkLenguage> empSkLenguages = empleado.getSkLenguages();
            for (SkLenguage skLenguage : empSkLenguages) {
                skLenguage.setEmpleado(empleadoFinal);
            }
            skLenguageService.saveAllSkLenguages(empSkLenguages);

            List<SkMethod> empSkMethods = empleado.getSkMethods();
            for (SkMethod skMethod : empSkMethods) {
                skMethod.setEmpleado(empleadoFinal);
            }
            skMethodService.saveAllSkMethods(empSkMethods);

            List<SkTechSkill> empSkTechSkills = empleado.getSkTechSkills();
            for (SkTechSkill skTechSkill : empSkTechSkills) {
                skTechSkill.setEmpleado(empleadoFinal);
            }
            skTechSkillService.saveAllSkTechSkills(empSkTechSkills);

            List<SkCertif> empSkCertifs = empleado.getSkCertifs();
            for (SkCertif skCertif : empSkCertifs) {
                skCertif.setEmpleado(empleadoFinal);
            }
            skCertifService.saveAllSkCertifs(empSkCertifs);

            List<SkTechnology> empSkTechnologies = empleado.getSkTechnologies();
            for (SkTechnology skTechnology : empSkTechnologies) {
                skTechnology.setEmpleado(empleadoFinal);
            }
            skTechnologyService.saveAllSkTechnologies(empSkTechnologies);

            List<SkBusSkill> empSkBussSkills = empleado.getSkBusSkills();
            for (SkBusSkill skBusSkill : empSkBussSkills) {
                skBusSkill.setEmpleado(empleadoFinal);
            }
            skBusSkillService.saveAllSkBusSkills(empSkBussSkills);
        }

        return RepeatStatus.FINISHED;
    }
}

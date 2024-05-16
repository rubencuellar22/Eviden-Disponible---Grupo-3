package com.grupotres.back_personal_disponible.restController;

import com.grupotres.back_personal_disponible.model.*;
import com.grupotres.back_personal_disponible.service.EmpleadoService;
import com.grupotres.back_personal_disponible.serviceImplMy8.EmpleadoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

@RestController()
@RequestMapping("/persistenciaDB/")
public class PersistenciaDBController {

    @Autowired
    private EmpleadoServiceImpl empleadoService;

    @PostMapping("persistir")
    public Empleado persistir(@RequestBody String csv) throws ParseException {
        // CSV HEAD: GIN,NAME,SUBGROUP,STATUS,BENCH,DAS,CIUDAD,LINE_MANAGER,JORNADA,GCM,CATEGORIA,NIVELGCM,SCR,CC,CCNAME,GROUP1,GROUP2,GROUP3,GROUP4,N_4,AGRUPACION,Job Technology,JobTechnology Profile,SKILLs,ROLE,RLT,SKLANGUAGES,SKMETHODS,SKTECHSKILLS,SKCERTIF,SKTECHNOLOGIES,SKBUSSKILLS
        // EJ CSV: 2,Nombre_2,A2,AVAILABLE,4/1/2024,A000002,Sevilla,Manager_27,100,AD02,A3GEN2,2,18.45,ES755K0E41,AMS LDC SEV ATOS IT,DIGITAL,AMS,Practice AMS Direct,Practice AMS General,Nombre_N_4_03,,BAU,Java_EE,Java/J2EE,APPLICATION DEVELOPER [2 Junior],,English (B1/B2 Intermediate)|Spanish (C2 Mastery),SCRUM (2),Application Development (2)|Agile Processes & Methodologies (2)|Web Development (2)|Software Design (1)|Microservices/API (1)|Test Automation (1),Cambridge First English (FCE) (External),Angular (2)|JavaScript (2)|MS Office 365 (2)|MS Visual Studio Code (3)|MongoDB (2)|TypeScript (2)|Python (1)|Eclipse (3)|Java EE (J2EE) 8 (2)|MySQL (2)|Cypress (Testing Framework) (1)|Ionic Framework (2)|JPA (2)|NetBeans (3),Presentation Skills (1)
        String[] csvArray = csv.split(",");
        Empleado emp = new Empleado();
        emp.setGin(Long.parseLong(csvArray[0]));
        emp.setName(csvArray[1]);
        emp.setSubgroup(csvArray[2]);
        emp.setStatus(csvArray[3]);
        emp.setBench(new SimpleDateFormat("M/d/yyyy").parse(csvArray[4]));
        emp.setDas(csvArray[5]);
        emp.setCiudad(csvArray[6]);
        emp.setLineManager(csvArray[7]);
        emp.setJornada(Double.parseDouble(csvArray[8]));
        emp.setGcm(csvArray[9]);
        emp.setCategoria(csvArray[10]);
        emp.setNivelgcm(Integer.parseInt(csvArray[11]));
        emp.setScr(Double.parseDouble(csvArray[12]));

        Grupo grupo = new Grupo();
        grupo.setCc(csvArray[14]);
        grupo.setGrupo1(csvArray[15]);
        grupo.setGrupo2(csvArray[16]);
        grupo.setGrupo3(csvArray[17]);
        grupo.setGrupo4(csvArray[18]);
        grupo.setGrupos(csvArray[14] + " | " + csvArray[15] + " | " + csvArray[16] + " | " + csvArray[17] + " | " + csvArray[18]);
        emp.setGrupo(grupo);

        emp.setN4(csvArray[19]);
        emp.setAgrupacion(csvArray[20]);
        emp.setJobTechnology(csvArray[21]);

        String[] jobTechnologyProfilesArray = csvArray[22].split("/");
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

        emp.setSkills(csvArray[23]);

        Role rol = new Role();
        String[] rolArray = csvArray[24].split("\\[");
        System.out.println(Arrays.toString(rolArray));
        rol.setRole(rolArray[0].trim());
        if (rolArray.length > 1) {
            String level = rolArray[1].replaceAll("\\D+", "");
            if (!level.isEmpty()) {
                rol.setNivel(Integer.parseInt(level));
            }
        }
        emp.setRole(rol);

        emp.setRlt(csvArray[25].equals("YES"));

        String[] sklanguages = csvArray[26].split("\\|");
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

        String[] skmethods = csvArray[27].split("\\|");
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

        String[] sktechskills = csvArray[28].split("\\|");
        for (String sktechskillString : sktechskills) {
            String[] parts = sktechskillString.split("\\(");
            SkTechSkill skillTecnico = new SkTechSkill();
            skillTecnico.setSkTechSkill(parts[0].trim());
            if (parts.length > 1) {
                String level = parts[1].replaceAll("\\)", "");
                if (!level.isEmpty()) {
                    skillTecnico.setNivel(Integer.parseInt(level.trim()));
                }
            }
            emp.addSkTechSkill(skillTecnico);
        }

        if (csvArray[29].isEmpty() || csvArray[29].isBlank()){

        } else {
            String[] skcertif = csvArray[29].split("\\|");
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

        String[] sktechnologies = csvArray[30].split("\\|");
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
        if (csvArray.length > 31) {

            String[] skbusskills = csvArray[31].split("\\|");
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
        System.out.println(emp);
        empleadoService.createEmpleado(emp);
        return emp;
    }
}

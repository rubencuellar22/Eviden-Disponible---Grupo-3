package com.grupotres.back_personal_disponible.restController;

import com.grupotres.back_personal_disponible.model.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@RestController()
@RequestMapping("/persistenciaDB/")
public class PersistenciaDBController {
    @PostMapping("persistir")
    public Empleado persistir(@RequestBody String csv) {
        // CSV HEAD: GIN,NAME,SUBGROUP,STATUS,BENCH,DAS,CIUDAD,LINE_MANAGER,JORNADA,GCM,CATEGORIA,NIVELGCM,SCR,CC,CCNAME,GROUP1,GROUP2,GROUP3,GROUP4,N_4,AGRUPACION,Job Technology,JobTechnology Profile,SKILLs,ROLE,RLT,SKLANGUAGES,SKMETHODS,SKTECHSKILLS,SKCERTIF,SKTECHNOLOGIES,SKBUSSKILLS
        // EJ CSV: 2,Nombre_2,A2,AVAILABLE,4/1/2024,A000002,Sevilla,Manager_27,100,AD02,A3GEN2,2,18.45,ES755K0E41,AMS LDC SEV ATOS IT,DIGITAL,AMS,Practice AMS Direct,Practice AMS General,Nombre_N_4_03,,BAU,Java_EE,Java/J2EE,APPLICATION DEVELOPER [2 Junior],,English (B1/B2 Intermediate)|Spanish (C2 Mastery),SCRUM (2),Application Development (2)|Agile Processes & Methodologies (2)|Web Development (2)|Software Design (1)|Microservices/API (1)|Test Automation (1),Cambridge First English (FCE) (External),Angular (2)|JavaScript (2)|MS Office 365 (2)|MS Visual Studio Code (3)|MongoDB (2)|TypeScript (2)|Python (1)|Eclipse (3)|Java EE (J2EE) 8 (2)|MySQL (2)|Cypress (Testing Framework) (1)|Ionic Framework (2)|JPA (2)|NetBeans (3),Presentation Skills (1)
        String[] csvArray = csv.split(",");
        Empleado emp = new Empleado();
        emp.setGin(Integer.parseInt(csvArray[0]));
        emp.setName(csvArray[1]);
        emp.setSubgroup(csvArray[2]);
        emp.setStatus(csvArray[3]);
        emp.setBench(csvArray[4]);
        emp.setDas(csvArray[5]);
        emp.setCiudad(csvArray[6]);
        emp.setLineManager(csvArray[7]);
        emp.setJornada(BigDecimal.valueOf(Double.parseDouble(csvArray[8])));
        emp.setGcm(csvArray[9]);
        emp.setCategoria(csvArray[10]);
        emp.setNivelgcm(Integer.parseInt(csvArray[11]));
        emp.setScr(BigDecimal.valueOf(Double.parseDouble(csvArray[12])));

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

        Rol rol = new Rol();
        String[] rolArray = csvArray[24].split("\\[");
        System.out.println(Arrays.toString(rolArray));
        rol.setRole(rolArray[0].trim());
        if (rolArray.length > 1) {
            String level = rolArray[1].replaceAll("\\D+", "");
            if (!level.isEmpty()) {
                rol.setNivel(Integer.parseInt(level));
            }
        }
        emp.setRol(rol);

        emp.setRlt(csvArray[25].equals("YES"));

        String[] sklanguages = csvArray[26].split("\\|");
        for (String sklanguageString : sklanguages) {
            String[] parts = sklanguageString.split("\\(");
            Idioma idioma = new Idioma();
            idioma.setIdioma(parts[0].trim());
            if (parts.length > 1) {
                String level = parts[1].replaceAll("\\)", "");
                if (!level.isEmpty()) {
                    idioma.setNivel(level.trim());
                }
            }
            emp.addIdioma(idioma);
        }

        String[] skmethods = csvArray[27].split("\\|");
        for (String skmethodString : skmethods) {
            Metodologia metodo = new Metodologia();
            int lastParenthesisIndex = skmethodString.lastIndexOf("(");
            if (lastParenthesisIndex != -1) {
                String methodName = skmethodString.substring(0, lastParenthesisIndex).trim();
                String level = skmethodString.substring(lastParenthesisIndex).replaceAll("[()]", "").trim();
                metodo.setMetodologia(methodName);
                if (!level.isEmpty()) {
                    metodo.setNivel(Integer.parseInt(level));
                }
            } else {
                metodo.setMetodologia(skmethodString.trim());
            }
            emp.addMetodologia(metodo);
        }

        String[] sktechskills = csvArray[28].split("\\|");
        for (String sktechskillString : sktechskills) {
            String[] parts = sktechskillString.split("\\(");
            TechSkill skillTecnico = new TechSkill();
            skillTecnico.setTechSkill(parts[0].trim());
            if (parts.length > 1) {
                String level = parts[1].replaceAll("\\)", "");
                if (!level.isEmpty()) {
                    skillTecnico.setNivel(Integer.parseInt(level.trim()));
                }
            }
            emp.addTechSkill(skillTecnico);
        }

        String[] skcertif = csvArray[29].split("\\|");
        for (String skcertifString : skcertif) {
            Certificacion certificacion = new Certificacion();
            int lastParenthesisIndex = skcertifString.lastIndexOf("(");
            if (lastParenthesisIndex != -1) {
                String certName = skcertifString.substring(0, lastParenthesisIndex).trim();
                String external = skcertifString.substring(lastParenthesisIndex).replaceAll("[()]", "").trim();
                certificacion.setCertificacion(certName);
                certificacion.setExternal(external.equals("External"));
            } else {
                certificacion.setCertificacion(skcertifString.trim());
                certificacion.setExternal(false);
            }
            emp.addCertificacione(certificacion);
        }

        String[] sktechnologies = csvArray[30].split("\\|");
        for (String sktechnologyString : sktechnologies) {
            Tecnologia tecnologia = new Tecnologia();
            int lastParenthesisIndex = sktechnologyString.lastIndexOf("(");
            if (lastParenthesisIndex != -1) {
                String techName = sktechnologyString.substring(0, lastParenthesisIndex).trim();
                String level = sktechnologyString.substring(lastParenthesisIndex).replaceAll("[()]", "").trim();
                tecnologia.setTecnologia(techName);
                if (!level.isEmpty()) {
                    tecnologia.setNivel(Integer.parseInt(level));
                }
            } else {
                tecnologia.setTecnologia(sktechnologyString.trim());
            }
            emp.addTecnologia(tecnologia);
        }

        // Index 31 out of bounds for length 31
        if (csvArray.length > 31) {

            String[] skbusskills = csvArray[31].split("\\|");
            for (String skbusskillString : skbusskills) {
                BussSkill habilidadNegocio = new BussSkill();
                int lastParenthesisIndex = skbusskillString.lastIndexOf("(");
                if (lastParenthesisIndex != -1) {
                    String bussSkillName = skbusskillString.substring(0, lastParenthesisIndex).trim();
                    String level = skbusskillString.substring(lastParenthesisIndex).replaceAll("[()]", "").trim();
                    habilidadNegocio.setBussSkill(bussSkillName);
                    if (!level.isEmpty()) {
                        habilidadNegocio.setNivel(Integer.parseInt(level));
                    }
                } else {
                    habilidadNegocio.setBussSkill(skbusskillString.trim());
                }
                emp.addBussSkill(habilidadNegocio);
            }


        }
        System.out.println(emp);
        return emp;
    }
}

import { Grupo } from './Grupo/grupo';
import { Role } from './role/role';
import { SkBusSkill } from './SkBusSkill/sk-bus-skill';
import { SkCertif } from './SkCertif/sk-certif';
import { SkLanguages } from './SkLanguages/sk-languages';
import { SkMethod } from './SkMethod/sk-method';
import { SkTechSkill } from './SkTechSkill/sk-tech-skill';
import { SkTechnology } from './SkTechnology/sk-technology';
import { JobTechnologyProfile } from './JobTechnologyProfile/job-technology-profile';


export class Empleado {
    gin: number;
  name: string;
  subgroup: string;
  status: string;
  bench: Date;
  das: string;
  ciudad: string;
  agrupacion: string;
  lineManager: string;
  jornada: number;
  gcm: string;
  categoria: string;
  nivelgcm: number;
  scr: number;
  grupo: Grupo;
  n4: string;
  jobTechnology: string;
  jobTechnologyProfiles: JobTechnologyProfile[];
  skills: string;
  role: Role;
  rlt: boolean;
  skLenguages: SkLanguages[];
  skMethods: SkMethod[];
  skTechSkills: SkTechSkill[];
  skCertifs: SkCertif[];
  skTechnologies: SkTechnology[];
  skBusSkills: SkBusSkill[];
}

import { Grupo } from './grupo';
import { JobTechnologyProfile } from './job-technology-profile';
import { Role } from './role';
import { SkBusSkill } from './sk-bus-skill';
import { SkCertif } from './sk-certif';
import { SkLanguages } from './sk-languages';
import { SkMethod } from './sk-method';
import { SkTechSkill } from './sk-tech-skill';
import { SkTechnology } from './sk-technology';


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

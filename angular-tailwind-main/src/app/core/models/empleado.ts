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
  gin: number = 0;
  name: string = '';
  subgroup: string = '';
  status: string = '';
  bench: Date = new Date();
  das: string = '';
  ciudad: string = '';
  agrupacion: string = '';
  lineManager: string = '';
  jornada: number = 0;
  gcm: string = '';
  categoria: string = '';
  nivelgcm: number = 0;
  scr: number = 0;
  grupo: Grupo = new Grupo();
  n4: string = '';
  jobTechnology: string = '';
  jobTechnologyProfiles: JobTechnologyProfile[] = [];
  skills: string = '';
  role: Role = new Role();
  rlt: boolean = false;
  skLanguages: SkLanguages[] = [];
  skMethods: SkMethod[] = [];
  skTechSkills: SkTechSkill[] = [];
  skCertifs: SkCertif[] = [];
  skTechnologies: SkTechnology[] = [];
  skBusSkills: SkBusSkill[] = [];
}

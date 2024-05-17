import { Empleado } from './empleado';

export interface JobTechnologyProfile {
  idJobTechnologyProfile: number;
  empleado: Empleado;
  jobTechnologyProfile: string;
  nivel: number;
}
import { Empleado } from "../empleado";

export class JobTechnologyProfile {
    idJobTechnologyProfile: number;
    empleado: Empleado;
    jobTechnologyProfile: string;
    nivel: number;

    constructor(
        idJobTechnologyProfile: number,
        empleado: Empleado,
        jobTechnologyProfile: string,
        nivel: number
    ) {
        this.idJobTechnologyProfile = idJobTechnologyProfile;
        this.empleado = empleado;
        this.jobTechnologyProfile = jobTechnologyProfile;
        this.nivel = nivel;
    }
}

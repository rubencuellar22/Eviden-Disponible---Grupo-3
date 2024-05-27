import { Empleado } from "../empleado";

export class SkTechSkill {
  idSkTechSkill: number;
  empleado: Empleado;
  skTechSkill: string;
  nivel: number;

  constructor(
    idSkTechSkill: number,
    empleado: Empleado,
    skTechSkill: string,
    nivel: number
  ) {
    this.idSkTechSkill = idSkTechSkill;
    this.empleado = empleado;
    this.skTechSkill = skTechSkill;
    this.nivel = nivel;
  }
}

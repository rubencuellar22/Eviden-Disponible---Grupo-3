export class SkBusSkills {
  id_skbusskill: number;
  ginEmpleado: number;
  skBusSkill: string;
  nivel: number;

  constructor(
    id_skbusskill: number,
    ginEmpleado: number,
    skBusSkill: string,
    nivel: number
  ) {
    this.id_skbusskill = id_skbusskill;
    this.ginEmpleado = ginEmpleado;
    this.skBusSkill = skBusSkill;
    this.nivel = nivel;
  }
}

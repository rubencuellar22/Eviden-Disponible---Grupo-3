export class SkBusSkill {
  id_skbusskill: number;
  ginEmpleado: number;
  skbusskill: string;
  nivel: number;

  constructor(
    id_skbusskill: number,
    ginEmpleado: number,
    skbusskill: string,
    nivel: number
  ) {
    this.id_skbusskill = id_skbusskill;
    this.ginEmpleado = ginEmpleado;
    this.skbusskill = skbusskill;
    this.nivel = nivel;
  }
}

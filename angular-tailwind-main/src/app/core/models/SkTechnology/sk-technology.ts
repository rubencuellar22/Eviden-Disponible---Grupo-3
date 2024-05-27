export class SkTechnology {
  id_sktechnology: number;
  ginEmpleado: number;
  sktechnology: string;
  nivel: number;

  constructor(
    id_sktechnology: number,
    ginEmpleado: number,
    sktechnology: string,
    nivel: number
  ) {
    this.id_sktechnology = id_sktechnology;
    this.ginEmpleado = ginEmpleado;
    this.sktechnology = sktechnology;
    this.nivel = nivel;
  }
}

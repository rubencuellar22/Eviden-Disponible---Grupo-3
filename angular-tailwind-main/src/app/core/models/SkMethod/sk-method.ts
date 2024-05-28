export class SkMethod {
  id_skmethod: number;
  ginEmpleado: number;
  skmethod: string;
  nivel: number;

  constructor(
    id_skmethod: number,
    ginEmpleado: number,
    skmethod: string,
    nivel: number
  ) {
    this.id_skmethod = id_skmethod;
    this.ginEmpleado = ginEmpleado;
    this.skmethod = skmethod;
    this.nivel = nivel;
  }
}

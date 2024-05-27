export class SkLanguages {
  id_sklanguage: number;
  ginEmpleado: number;
  sklanguage: string;
  nivel: string;

  constructor(
    id_sklanguage: number,
    ginEmpleado: number,
    sklanguage: string,
    nivel: string
  ) {
    this.id_sklanguage = id_sklanguage;
    this.ginEmpleado = ginEmpleado;
    this.sklanguage = sklanguage;
    this.nivel = nivel;
  }
}

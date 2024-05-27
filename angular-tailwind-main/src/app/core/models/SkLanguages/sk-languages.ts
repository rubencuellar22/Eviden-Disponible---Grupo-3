export class SkLanguages {
  id_sklanguage: number;
  ginEmpleado: number;
  sklenguage: string;
  nivel: string;

  constructor(
    id_sklanguage: number,
    ginEmpleado: number,
    sklenguage: string,
    nivel: string
  ) {
    this.id_sklanguage = id_sklanguage;
    this.ginEmpleado = ginEmpleado;
    this.sklenguage = sklenguage;
    this.nivel = nivel;
  }
}

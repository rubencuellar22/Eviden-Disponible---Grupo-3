export class Grupo {
  id_grupo: number;
  grupo1: string;
  grupo2: string;
  grupo3: string;
  grupo4: string;
  grupos: string;
  cc: string;

  constructor(
    id_grupo: number = 0,
    grupo1: string = '',
    grupo2: string = '',
    grupo3: string = '',
    grupo4: string = '',
    grupos: string = '',
    cc: string = ''
  ) {
    this.id_grupo = id_grupo;
    this.grupo1 = grupo1;
    this.grupo2 = grupo2;
    this.grupo3 = grupo3;
    this.grupo4 = grupo4;
    this.grupos = grupos;
    this.cc = cc;
  }

  toString(): string {
    return `${this.grupo1}, ${this.grupo2}, ${this.grupo3}, ${this.grupo4}, ${this.grupos}, ${this.cc}`;
  }
}

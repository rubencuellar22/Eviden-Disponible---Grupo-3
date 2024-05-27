export class Grupo {
    id_grupo: number;
  grupo1: string;
  grupo2: string;
  grupo3: string;
  grupo4: string;
  grupos: string;
  cc: string;

  
  toString(): string {
    return `${this.grupo1}, ${this.grupo2}, ${this.grupo3}, ${this.grupo4}, ${this.grupos}, ${this.cc}`;
  }
  
}


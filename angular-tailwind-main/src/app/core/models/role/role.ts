export class Role {
  id_role: number;
  ginEmpleado: number;
  role: string;
  nivel: number;

  constructor(
    id_role: number,
    ginEmpleado: number,
    role: string,
    nivel: number
  ) {
    this.id_role = id_role;
    this.ginEmpleado = ginEmpleado;
    this.role = role;
    this.nivel = nivel;
  }
}

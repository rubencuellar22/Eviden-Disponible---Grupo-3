export class Role {
  id_role: number;
  ginEmpleado: number;
  role: string;
  nivel: number;

  constructor(id_role: number = 0, ginEmpleado: number = 0, role: string = '', nivel: number = 0) {
    this.id_role = id_role;
    this.ginEmpleado = ginEmpleado;
    this.role = role;
    this.nivel = nivel;
  }
}

export class SkCertif {
  id_skcertif: number;
  ginEmpleado: number;
  skcertif: string;
  external: boolean;

  constructor(
    id_skcertif: number,
    ginEmpleado: number,
    skcertif: string,
    external: boolean
  ) {
    this.id_skcertif = id_skcertif;
    this.ginEmpleado = ginEmpleado;
    this.skcertif = skcertif;
    this.external = external;
  }
}

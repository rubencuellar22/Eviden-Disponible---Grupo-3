export class SkCertifs {
  id_skcertif: number;
  ginEmpleado: number;
  skCertif: string;
  external: boolean;

  constructor(
    id_skcertif: number,
    ginEmpleado: number,
    skCertif: string,
    external: boolean
  ) {
    this.id_skcertif = id_skcertif;
    this.ginEmpleado = ginEmpleado;
    this.skCertif = skCertif;
    this.external = external;
  }
}

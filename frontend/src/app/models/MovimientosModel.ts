import {CuentaModel} from "./CuentaModel";
import {CiudadesModel} from "./CiudadesModel";

export interface MovimientosModel {
  movId?: number,
  cueId?: CuentaModel,
  movFecha?: Date,
  movTipo?: string,
  movValor?: number,
  ciuId?: CiudadesModel,

  [key: string]: any;
}

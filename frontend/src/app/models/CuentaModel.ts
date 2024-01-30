import {ClienteModel} from "./ClienteModel";
import {CiudadesModel} from "./CiudadesModel";

export interface CuentaModel {
  cueId?: number,
  cueTipo?: string,
  cueNumero?: string,
  cueSaldo?: number,
  cliId?: ClienteModel,
  ciuId?: CiudadesModel,

  [key: string]: any;
}

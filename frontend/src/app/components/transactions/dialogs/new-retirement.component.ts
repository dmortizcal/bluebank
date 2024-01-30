import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {ApiRestService} from "../../../services/api-rest.service";
import {CuentaModel} from "../../../models/CuentaModel";
import {CiudadesModel} from "../../../models/CiudadesModel";
import {MovimientosModel} from "../../../models/MovimientosModel";

@Component({
  selector: 'app-new-retirement',
  templateUrl: './new-retirement.component.html',
})
export class NewRetirementComponent implements OnInit {
  movimiento: MovimientosModel
  listCiudad?: CiudadesModel[]

  constructor(public dialogRef: MatDialogRef<NewRetirementComponent>,
              @Inject(MAT_DIALOG_DATA) public data: CuentaModel,
              private apiRest: ApiRestService) {
    this.movimiento = {
      cueId: this.data,
      movFecha: new Date(),
      movTipo: "R"
    }
  }

  listCities() {
    this.apiRest.get('ciudades').then(
      (data: any) => {
        this.listCiudad = data as CiudadesModel[];
      }).catch(err => {
      console.log(err)
    }).catch(error => {
      console.log(error)
    })
  }
  save() {
    this.apiRest.post('movimientos/retiro', this.movimiento).then(
      (data: any) => {
        this.dialogRef.close();
      }).catch(err => {
      console.log(err)
    }).catch(error => {
      console.log(error)
    })
  }

  cancel() {
    this.dialogRef.close();
  }

  ngOnInit(): void {
    this.listCities()
  }
}

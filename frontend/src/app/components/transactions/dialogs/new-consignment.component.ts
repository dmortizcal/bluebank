import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {ApiRestService} from "../../../services/api-rest.service";
import {CuentaModel} from "../../../models/CuentaModel";
import {MovimientosModel} from "../../../models/MovimientosModel";
import {CiudadesModel} from "../../../models/CiudadesModel";

@Component({
  selector: 'app-new-consignment',
  templateUrl: './new-consignment.component.html',
})
export class NewConsignmentComponent implements OnInit {
  movimiento: MovimientosModel
  listCiudad?: CiudadesModel[]

  constructor(public dialogRef: MatDialogRef<NewConsignmentComponent>,
              @Inject(MAT_DIALOG_DATA) public data: CuentaModel,
              private apiRest: ApiRestService) {
    this.movimiento = {
      cueId: this.data,
      movFecha: new Date(),
      movTipo: "C"
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

  cancel() {
    this.dialogRef.close();
  }

  ngOnInit(): void {
    this.listCities()
  }

}

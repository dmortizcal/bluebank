import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {ClienteModel} from "../../../models/ClienteModel";
import {ApiRestService} from "../../../services/api-rest.service";
import {CuentaModel} from "../../../models/CuentaModel";
import {CiudadesModel} from "../../../models/CiudadesModel";

@Component({
  selector: 'app-new-account-dialog',
  templateUrl: './new-account-dialog.component.html'
})
export class NewAccountDialogComponent implements OnInit {
  cuenta: CuentaModel
  listCiudad?: CiudadesModel[]

  constructor(
    public dialogRef: MatDialogRef<NewAccountDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: ClienteModel,
    private apiRest: ApiRestService,
  ) {
    this.cuenta = {}
  }

  ngOnInit(): void {
    this.cuenta = {
      cueTipo: this.data.cliTipo == "P" ? "A" : "C",
      cliId: this.data,
      cueSaldo: 0
    }

    this.listCities()
  }

  cancel(): void {
    this.dialogRef.close();
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
    console.log(this.cuenta)
    this.apiRest.post("cuenta", this.cuenta).then((data: any) => {
      this.dialogRef.close();
    }).catch(err => {
      console.log(err)
    }).catch(error => {
      console.log(error)
    })
  }
}

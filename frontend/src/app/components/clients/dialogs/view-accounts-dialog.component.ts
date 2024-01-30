import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {ClienteModel} from "../../../models/ClienteModel";
import {CuentaModel} from "../../../models/CuentaModel";
import {ApiRestService} from "../../../services/api-rest.service";

@Component({
  selector: 'app-view-accounts-dialog',
  templateUrl: './view-accounts-dialog.component.html'
})
export class ViewAccountsDialogComponent implements OnInit {
  displayedColumns: string[] = ['tipo', 'numero', 'saldo', 'ciudad']
  cuentas: CuentaModel[] = []

  constructor(
    public dialogRef: MatDialogRef<ViewAccountsDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: ClienteModel,
    private apiRest: ApiRestService,
  ) {
  }

  typeAccount(type: string) {
    switch (type) {
      case 'A': {
        return 'Ahorros'
        break;
      }
      case 'C': {
        return 'Corriente'
        break;
      }
      default: {
        return 'No conocido'
        break;
      }
    }
  }

  cancel(): void {
    this.dialogRef.close();
  }

  ngOnInit(): void {
    this.getAccounts()
  }

  getAccounts() {
    this.apiRest.get(`cuenta/allByClient/${this.data.cliId}`).then(
      (data: any) => {
        this.cuentas = data as CuentaModel[];
      }).catch(err => {
      console.log(err)
    }).catch(error => {
      console.log(error)
    })
  }
}

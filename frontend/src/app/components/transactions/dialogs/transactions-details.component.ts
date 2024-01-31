import {Component, Inject} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {ApiRestService} from "../../../services/api-rest.service";
import {MovimientosModel} from "../../../models/MovimientosModel";
import {CuentaModel} from "../../../models/CuentaModel";

@Component({
  selector: 'app-transactions-details',
  templateUrl: './transactions-details.component.html'
})
export class TransactionsDetailsComponent {
  displayedColumns: string[] = ['fecha', 'valor']
  movimientos: MovimientosModel[] = []

  constructor(public dialogRef: MatDialogRef<TransactionsDetailsComponent>,
              @Inject(MAT_DIALOG_DATA) public data: CuentaModel,
              private apiRest: ApiRestService,) {
  }

  cancel(): void {
    this.dialogRef.close();
  }

  getMovements() {
    this.apiRest.get(`movimientos/allByAccount/${this.data.cueId}`).then(
      (data: any) => {
        console.log(data)
        this.movimientos = data as MovimientosModel[];
      }).catch(err => {
      console.log(err)
    }).catch(error => {
      console.log(error)
    })
  }

  ngOnInit(): void {
    this.getMovements()
  }
}

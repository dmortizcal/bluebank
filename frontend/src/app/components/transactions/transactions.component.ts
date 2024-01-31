import {Component, OnInit} from '@angular/core';
import {CuentaModel} from "../../models/CuentaModel";
import {ApiRestService} from "../../services/api-rest.service";
import {ClienteModel} from "../../models/ClienteModel";
import {NewAccountDialogComponent} from "../clients/dialogs/new-account-dialog.component";
import {NewRetirementComponent} from "./dialogs/new-retirement.component";
import {MatDialog} from "@angular/material/dialog";
import {NewConsignmentComponent} from "./dialogs/new-consignment.component";
import {MovimientosModel} from "../../models/MovimientosModel";
import {ViewAccountsDialogComponent} from "../clients/dialogs/view-accounts-dialog.component";
import {TransactionsDetailsComponent} from "./dialogs/transactions-details.component";

@Component({
  selector: 'app-transactions',
  templateUrl: './transactions.component.html',
  styleUrls: ['./transactions.component.scss']
})
export class TransactionsComponent implements OnInit {
  cuentas: CuentaModel[] = []
  movimiento: MovimientosModel

  constructor(private apiRest: ApiRestService, public dialog: MatDialog) {
    this.movimiento = {};
  }

  getAllAccounts() {
    this.apiRest.get('cuenta').then(
      (data: any) => {
        this.cuentas = data as CuentaModel[];
      }).catch(err => {
      console.log(err)
    }).catch(error => {
      console.log(error)
    })
  }

  typeAccount(type?: string) {
    switch (type) {
      case 'A': {
        return 'Ahorros'
      }
      case 'C': {
        return 'Corriente'
      }
      default: {
        return 'No conocido'
      }
    }
  }

  newRetirement(elemt: CuentaModel) {
    const dialogRef = this.dialog.open(NewRetirementComponent, {
      data: elemt,
    });

    dialogRef.afterClosed().subscribe(result => {
      this.movimiento = result;
      this.saveMovement('retiro')
    });
  }

  newConsignment(elemt: CuentaModel) {
    const dialogRef = this.dialog.open(NewConsignmentComponent, {
      data: elemt,
    });

    dialogRef.afterClosed().subscribe(result => {
      this.movimiento = result;
      console.log(result)
      this.saveMovement('consignacion')
    });
  }

  saveMovement(url: String) {
    this.apiRest.post(`movimientos/${url}`, this.movimiento).then(
      (data: any) => {
        this.ngOnInit();
      }).catch(err => {
      console.log(err)
    }).catch(error => {
      console.log(error)
    })
  }

  viewMovement(elemt: CuentaModel) {
    const dialogRef = this.dialog.open(TransactionsDetailsComponent, {
      data: elemt,
    });
  }

  ngOnInit(): void {
    this.getAllAccounts()
  }
}

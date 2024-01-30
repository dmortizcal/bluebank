import {Component, OnInit} from '@angular/core';
import {CuentaModel} from "../../models/CuentaModel";
import {ApiRestService} from "../../services/api-rest.service";
import {ClienteModel} from "../../models/ClienteModel";
import {NewAccountDialogComponent} from "../clients/dialogs/new-account-dialog.component";
import {NewRetirementComponent} from "./dialogs/new-retirement.component";
import {MatDialog} from "@angular/material/dialog";
import {NewConsignmentComponent} from "./dialogs/new-consignment.component";

@Component({
  selector: 'app-transactions',
  templateUrl: './transactions.component.html',
  styleUrls: ['./transactions.component.scss']
})
export class TransactionsComponent implements OnInit {
  cuentas: CuentaModel[] = []

  constructor(private apiRest: ApiRestService, public dialog: MatDialog) {
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

  newRetirement(elemt: CuentaModel) {
    const dialogRef = this.dialog.open(NewRetirementComponent, {
      data: elemt,

    });
  }

  newConsignment(elemt: CuentaModel) {
    const dialogRef = this.dialog.open(NewConsignmentComponent, {
      data: elemt,

    });
  }

  ngOnInit(): void {
    this.getAllAccounts()
  }
}

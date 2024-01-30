import {Component, Inject, OnInit} from '@angular/core';
import {ApiRestService} from "../../services/api-rest.service";
import {ClienteModel} from "../../models/ClienteModel";
import {MatDialog} from "@angular/material/dialog";
import {NewClientDialog} from "./dialogs/new_client_dialog";
import {ViewAccountsDialogComponent} from "./dialogs/view-accounts-dialog.component";
import {NewAccountDialogComponent} from "./dialogs/new-account-dialog.component";

@Component({
  selector: 'app-clients',
  templateUrl: './clients.component.html',
  styleUrls: ['./clients.component.scss']
})
export class ClientsComponent implements OnInit {
  displayedColumns: string[] = ['nombre', 'tipo', 'telefono', 'acciones']
  clientes: ClienteModel[]
  cliente: ClienteModel = {}

  ngOnInit(): void {
    this.getClientes()
  }

  constructor(private apiRest: ApiRestService,
              public dialog: MatDialog) {
    this.clientes = []
  }

  addAccounts(elemt: ClienteModel) {
    const dialogRef = this.dialog.open(NewAccountDialogComponent, {
      data: elemt,

    });
  }

  viewAccounts(elemt: ClienteModel) {
    const dialogRef = this.dialog.open(ViewAccountsDialogComponent, {
      data: elemt,
    });
  }

  newClient() {
    const dialogRef = this.dialog.open(NewClientDialog, {
      data: {},
    });

    dialogRef.afterClosed().subscribe(result => {
      this.cliente = result;
      this.saveClient()
    });
  }

  saveClient() {
    this.apiRest.post("cliente", this.cliente).then((data: any) => {
      this.getClientes()
    }).catch(err => {
      console.log(err)
    }).catch(error => {
      console.log(error)
    })
  }

  typeClient(type: string) {
    switch (type) {
      case 'P': {
        return 'Persona'
        break;
      }
      case 'E': {
        return 'Empresa'
        break;
      }
      default: {
        return 'No conocido'
        break;
      }
    }
  }

  getClientes() {
    this.apiRest.get('cliente').then(
      (data: any) => {
        this.clientes = data as ClienteModel[];
      }).catch(err => {
      console.log(err)
    }).catch(error => {
      console.log(error)
    })
  }

}


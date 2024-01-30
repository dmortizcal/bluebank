import {Component, Inject} from "@angular/core";
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {ClienteModel} from "../../../models/ClienteModel";

@Component({
  selector: 'new_client_dialog',
  templateUrl: './new_client_dialog.html',
})

export class NewClientDialog {

  constructor(
    public dialogRef: MatDialogRef<NewClientDialog>,
    @Inject(MAT_DIALOG_DATA) public data: ClienteModel,
  ) {
  }

  cancel(): void {
    this.dialogRef.close();
  }
}

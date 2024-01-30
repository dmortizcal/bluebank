import {Component, OnInit} from '@angular/core';
import {ApiRestService} from "../../services/api-rest.service";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {
  message?: String

  ngOnInit(): void {
    this.loadWelcomeMessage()
  }

  constructor(private apiRest: ApiRestService) {
  }

  loadWelcomeMessage() {
    this.apiRest.get('').then(
      (data: any) => {
        console.log(data)
        this.message = data;
      }).catch(err => {
      console.log(err)
    }).catch(error => {
      console.log(error)
    })
  }

}

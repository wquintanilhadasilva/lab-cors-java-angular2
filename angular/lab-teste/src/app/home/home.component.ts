import { HomeService } from './../services/home.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  msg: string;
  valorGet: string;

  constructor(private service: HomeService) {}

  ngOnInit() {
  }

  execGetMethod() {
    this.msg = 'UAU!! QUE BELUZAAAA';

    this.service.getMessage().subscribe( r => this.valorGet = r.message);
  }

}



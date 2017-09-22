import { Injectable } from '@angular/core';
import { RequestOptions, RequestMethod, Headers  } from '@angular/http';
import { Usuario } from './../domain/usuario';

@Injectable()
export class RestService {
  private user: Usuario;
  constructor() {}

  public init(u: Usuario) {
    this.user = u;
  }

  public getUrl() {
    return 'http://nrwwedsonsi:8080/TestFilters/api/demo/';
  }

  public getHeaders(): RequestOptions {
    const username = this.user.nome;
    const password = this.user.senha;
    const headers = new Headers();

    // Basic YWRtaW5AbG9jYWxob3N0OmFkbWlu
    // Basic YWRtaW5AbG9jYWxob3N0OmFkbWlu'
    // dXN1YXJpb0BlbWFpbC5jb206YWRtaW4=
    console.log(btoa(username + ':' + password));

    headers.set('Authorization', 'Basic ' + btoa(username + ':' + password));
    headers.set('Access-Control-Allow-Origin', '*');
    headers.set('Content-Type', 'application/*+json');
    console.log(headers);
    return new RequestOptions({ headers: headers });
  }

}

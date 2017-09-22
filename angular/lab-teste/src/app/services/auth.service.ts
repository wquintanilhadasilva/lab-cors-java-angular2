import { Observable } from 'rxjs/Observable';
import { Injectable, EventEmitter, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Http } from '@angular/http';

import { RestService } from './rest.service';
import { Usuario } from './../domain/usuario';

@Injectable()
export class AuthService implements OnInit {

  private loginKey = 'isLoggedIn';
  private loginKeyValueTrue = 'true';
  private loginKeyValueFalse = 'false';

  usuarioAutenticadoEmiter = new EventEmitter<boolean>();

  constructor(private router: Router, private config: RestService, private http: Http) { }

  ngOnInit(): void {
  }

  fazerLogin(usuario: Usuario) {

    this.config.init(usuario);

    console.log('fazerLogin')
    console.log(usuario);

    if (!this.checkNullOrEmpty(usuario)) {
      // this.http.get(this.config.getUrl() + 'login', this.config.getHeaders())
      this.http.get(this.config.getUrl() + 'login')
        .map(response => response.json())
        .subscribe(r => {
          console.log(r);
          this.loginKey = r.message;
          sessionStorage.setItem(this.loginKey, this.loginKeyValueTrue);
          this.usuarioAutenticadoEmiter.emit(true);
          this.router.navigate(['/home']);

        });
    } else {
      console.log('NÃO vai logar');
      sessionStorage.setItem(this.loginKey, this.loginKeyValueFalse);
      this.usuarioAutenticadoEmiter.emit(false);
      this.router.navigate(['/']);
    }

  }

  checkNullOrEmpty(usuario: Usuario): boolean {

    if (usuario === null) {
      return true;
    }

    if (usuario.nome === null || usuario.nome === '') {
      return true;
    }

    if (usuario.senha === null || usuario.senha === '') {
      return true;
    }

    return false;

  }

  usuarioEstaAutenticado(): boolean {
    const logado = sessionStorage.getItem(this.loginKey);
    return logado === this.loginKeyValueTrue ? true : false;
  }

}

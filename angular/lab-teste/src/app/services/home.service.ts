import { Observable } from 'rxjs/Observable';
import { Http } from '@angular/http';
import { RestService } from './rest.service';
import { Injectable } from '@angular/core';

@Injectable()
export class HomeService {

  constructor(private config: RestService, private http: Http) { }

  public getMessage(): Observable<any> {
    return this.http.get(this.config.getUrl() + 'get-method').map( r => r.json());
  }

}

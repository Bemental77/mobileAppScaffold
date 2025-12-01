// Paste into src/app/services/greet.service.ts in an Angular app
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({ providedIn: 'root' })
export class GreetService {
  constructor(private http: HttpClient) {}

  greetJava(name: string): Observable<any> {
    return this.http.get(`/api/greet`, { params: { name } });
  }

  greetPhp(name: string): Observable<any> {
    return this.http.get(`/php/rest/greet`, { params: { name } });
  }
}
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  redirectUrl=''
  isMentor:boolean=false
  isStudent:boolean=false
  loggedIn:boolean=false;
  username:String;
  constructor(private httpClient: HttpClient,private router:Router) { }

  authenticate(username, password):Observable<any> {
    const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(username + ':' + password) });
    console.log(headers);
    return this.httpClient.get('http://localhost:9800/authenticate', { headers });
  }
  logOut(){
    this.loggedIn=false;
    this.isStudent=false;
    this.isMentor=false;
    this.username=null
    this.router.navigate(['/home']);

  }
}

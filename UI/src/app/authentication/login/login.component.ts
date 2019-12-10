import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  isLoginValid = true;
  
  constructor(private authenticationService: AuthenticationService,private router:Router) { }

  ngOnInit() {
  }
  onSubmit(form: NgForm){
    const username = form.value.username;
    const password = form.value.password;
    console.log(username+" "+password);
    this.authenticationService.authenticate(username,password).subscribe((data)=>{
      console.log(data);
      this.authenticationService.loggedIn=true
      if(data.Role=='Mentor'){
          this.authenticationService.isMentor=true  
          this.authenticationService.username=data.Username;
          this.router.navigate(['/profile']);
      }
      else if(data.Role=='Student'){
          this.authenticationService.isStudent=true
          this.authenticationService.username=data.Username;
          this.router.navigate(['/studentdetails']);
      }
    });

  }

}

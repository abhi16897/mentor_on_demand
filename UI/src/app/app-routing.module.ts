import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { MentorRegisterComponent } from './authentication/mentor-register/mentor-register.component';
import { LoginComponent } from './authentication/login/login.component';
import { StudentRegistrationComponent } from './authentication/student-registration/student-registration.component';
import { ApprovalComponent } from './approval/approval.component';
import { HomeComponent } from './home/home.component';


const routes: Routes = [];

@NgModule({
  imports: [RouterModule.forRoot([  {
    path: 'home',
    component: HomeComponent
  },
  {
    path: 'approve',
    component: ApprovalComponent
  },
  {
    path: 'student',
    component: StudentRegistrationComponent
  },
  {
    path: 'mentor',
    component: MentorRegisterComponent
  },
  {
    path: 'login',
    component: LoginComponent
  }])],
  exports: [RouterModule]
})
export class AppRoutingModule { }

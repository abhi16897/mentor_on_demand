import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { StudentRegistrationComponent } from './authentication/student-registration/student-registration.component'
import { RouterModule } from '@angular/router';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { MentorRegisterComponent } from './authentication/mentor-register/mentor-register.component';
import { LoginComponent } from './authentication/login/login.component';
import { HomeComponent } from './home/home.component';
import { TechnologyComponent } from './technology/technology.component';
import { ApprovalComponent } from './approval/approval.component';
import { MentorInfoComponent } from './home/mentor-info/mentor-info.component';
import { MentorEditComponent } from './home/mentor-edit/mentor-edit.component';
import { MentorListComponent } from './home/mentor-list/mentor-list.component';
import { ProfileComponent } from './profile/profile.component';
import { StudentComponent } from './student/student.component';
import { StudentApprovalComponent } from './student-approval/student-approval.component';
@NgModule({
  declarations: [
    AppComponent,
    StudentRegistrationComponent,
    MentorRegisterComponent,
    LoginComponent,
    HomeComponent,
    TechnologyComponent,
    ApprovalComponent,
    MentorInfoComponent,
    MentorEditComponent,
    MentorListComponent,
    ProfileComponent,
    StudentComponent,
    StudentApprovalComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
    RouterModule.forRoot([
      {
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
      }, {
        path: 'profile',
        component: ProfileComponent
      },
      {
        path:'studentdetails',
        component:StudentComponent
      },{
        path:'studentApprove',
        component:StudentApprovalComponent
      }
    ])
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

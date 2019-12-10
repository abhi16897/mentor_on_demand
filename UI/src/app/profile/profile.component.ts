import { Component, OnInit } from '@angular/core';
import { MentorDetailsService } from '../services/mentor-details.service';
import { AuthenticationService } from '../services/authentication.service';
import { skills } from '../home/skills';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
    detail:skills
  constructor(private mentorDetailService:MentorDetailsService,private authService:AuthenticationService) { }

  ngOnInit() {
      this.mentorDetailService.getMentorDetail(this.authService.username).subscribe((data)=>{
        console.log(data);
         this.detail=data
      });
  }
}

import { Component, OnInit } from '@angular/core';
import { Training } from '../approval/Training';
import { MentorDetailsService } from '../services/mentor-details.service';
import { AuthenticationService } from '../services/authentication.service';

@Component({
  selector: 'app-mentor-progress',
  templateUrl: './mentor-progress.component.html',
  styleUrls: ['./mentor-progress.component.css']
})
export class MentorProgressComponent implements OnInit {
  training:Training[]
  contents:String[]
  constructor(private mentoDetailService:MentorDetailsService,private authService:AuthenticationService) { }

  ngOnInit() {
      this.fetchData();
  }
  submit(content:String){
    this.mentoDetailService.updateProgress(this.authService.username,'A').subscribe((data)=>{
      console.log(data);
      this.fetchData();
    });
  }
  fetchData(){
    this.mentoDetailService.getCurrentMentorCourses(this.authService.username).subscribe((data)=>{
      console.log(data);
      this.training=data;
    });
    this.mentoDetailService.getTableOfContents(this.authService.username,'A').subscribe((data)=>{
      console.log(data)
      this.contents=data
    });
  }
}

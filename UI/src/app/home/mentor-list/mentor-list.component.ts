import { Component, OnInit } from '@angular/core';
import { MentorDetailsService } from 'src/app/services/mentor-details.service';
import { skills } from '../skills';

@Component({
  selector: 'app-mentor-list',
  templateUrl: './mentor-list.component.html',
  styleUrls: ['./mentor-list.component.css']
})
export class MentorListComponent implements OnInit {
  mentorDetails:skills[]
  originalList:skills[];
  constructor(private mentordetailsService:MentorDetailsService) { }
  ngOnInit() {
    this.mentordetailsService.getAllmentorDetails().subscribe((data)=>{
        console.log(data);
        this.mentorDetails=data;
    });
    this.mentordetailsService.getSubject().subscribe((data)=>{
      this.originalList = [...data]; 
      this.mentorDetails=[...data];
    });
    this.mentordetailsService.filter.subscribe((obj: { name: string })=>{
      if (obj.name !== '') { 
        const result = this.originalList.filter(prod => prod.technologies.name.toLowerCase().includes(obj.name.toLowerCase()));
        this.mentorDetails = result ? result : [];
      } else { 
        this.mentorDetails = [...this.originalList];
      }
    });

  }

}

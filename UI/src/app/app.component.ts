import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { skills } from './home/skills';
import { MentorDetailsService } from './services/mentor-details.service';
import { AuthenticationService } from './services/authentication.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'iiht';
  filteredList: skills[];
  originalLists: skills[];
  searchKey: String
  constructor(private router: Router, private mentorDetailSerivces: MentorDetailsService, private authService: AuthenticationService) {

  }
  ngOnInit() {
    this.router.navigate(['/home']);
    this.mentorDetailSerivces.getAllmentorDetails().subscribe((data) => {
      this.originalLists = data;
    });
    this.filteredList = this.originalLists;
  }
  search(event: any) {
    this.filteredList = this.originalLists.filter(food => food.technologies.name.toLocaleLowerCase().includes(this.searchKey.toLocaleLowerCase()));
    this.mentorDetailSerivces.getSubject().next(this.filteredList);
  }

  isMentor() {
    return this.authService.isMentor;
  }
  isStudent() {
    return this.authService.isStudent;
  }
  isLoggedIn() {
    return this.authService.loggedIn;
  }
    
}

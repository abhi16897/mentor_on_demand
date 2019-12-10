import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { skills } from '../home/skills';
import { Observable, Subject } from 'rxjs';
import { Technology } from '../home/Technology';
import { Training } from '../approval/Training';


@Injectable({
  providedIn: 'root'
})
export class MentorDetailsService {
  filter = new Subject();
  private subject = new Subject<skills[]>();
  constructor(private httpClient: HttpClient) { }

  getAllmentorDetails(): Observable<any> {
    return this.httpClient.get<skills[]>('http://localhost:9804/details');
  }
  getSubject(): Subject<skills[]> {
    return this.subject;
  }
  getMentorDetail(username:String):Observable<any>{
    return this.httpClient.get<skills[]>('http://localhost:9804/details/mentor/'+username);
  }
  book(studentName:String,mentoName:String,technologyName:number){
        return this.httpClient.post('http://localhost:9805/proposal/'+studentName+"/"+mentoName+"/"+technologyName,null);
  }

  getMentorRequests(mentorName:String,status:String):Observable<any>{
    return this.httpClient.get('http://localhost:9805/proposal/mentor/'+mentorName+"/"+status)
  }

  update(id:number,status:String){
    return this.httpClient.put('http://localhost:9805/proposal/'+id+"/"+status,null);
  }

  getStudentRequests(studentName:String):Observable<any>{
    return this.httpClient.get('http://localhost:9805/proposal/student/'+studentName)
  }
  // getAllTechnologies(){
  //   return this.httpClient.get('http://localhost:9805/proposal/student/'+)
  // }
  getCurrentCourses(username:String):Observable<any>{
    return this.httpClient.get<Training[]>('http://localhost:9806/training/student/current/'+username);
  }
  getCurrentMentorCourses(username:String):Observable<any>{
    return this.httpClient.get<Training[]>('http://localhost:9806/training/mentor/current/'+username);
  }
  getTableOfContents(username:String,status:String):Observable<any>{
    return this.httpClient.get<String[]>('http://localhost:9806/training/contents/'+username+"/"+status);
  }
  updateProgress(username:String,status:String):Observable<any>{
    return this.httpClient.put('http://localhost:9806/training/progress/'+username+"/"+status,null);
  }
}

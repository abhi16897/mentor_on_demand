import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';

@Component({
  selector: 'app-mentor-edit',
  templateUrl: './mentor-edit.component.html',
  styleUrls: ['./mentor-edit.component.css']
})
export class MentorEditComponent implements OnInit {
  form:FormGroup
  constructor() { 
  }

  ngOnInit() {
    this.form=new FormGroup({

    });
  }

}

import { Component, OnInit, OnDestroy } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-home',
  imports: [FormsModule],
  templateUrl: './home.html',
  styleUrl: './home.scss',
})
export class Home implements OnInit, OnDestroy {
  portalName = "Student Course Portal";
  isPortalActive = true;

  message = '';
  searchTerm = '';
  availableCoursesCount = 0;

  ngOnInit(){
    this.availableCoursesCount = 12;

    console.log("Home Component Initialized - Courses Loaded");
  }

  onEnrollClick(){
    this.message = "Enrollment Opened !";
  }

  ngOnDestroy(){
    console.log("Home Component Destroyed");
  }
}

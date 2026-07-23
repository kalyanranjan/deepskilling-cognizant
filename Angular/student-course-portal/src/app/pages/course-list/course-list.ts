import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CourseCard } from '../../components/course-card/course-card';

@Component({
  selector: 'app-course-list',
  imports: [CommonModule, CourseCard],
  templateUrl: './course-list.html',
  styleUrl: './course-list.scss',
})
export class CourseList {
  selectedCourseId: number | null = null;

  courses = [
    { id: 1, name: 'Angular', code: 'A01', credits: 3 },
    { id: 2, name: 'Java', code: 'J01', credits: 4 },
    { id: 3, name: 'Spring Boot', code: 'S01', credits: 4 },
    { id: 4, name: 'MySQL', code: 'M01', credits: 3 },
    { id: 5, name: 'Docker', code: 'D01', credits: 3 }
  ];

  onEnroll(courseId: number) {
    console.log("Enrolling In Course: " + courseId);
    this.selectedCourseId = courseId;
  }
}

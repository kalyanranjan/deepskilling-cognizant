import { Component, Input, Output, EventEmitter, OnChanges, SimpleChanges } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-course-card',
  imports: [CommonModule],
  templateUrl: './course-card.html',
  styleUrl: './course-card.scss',
})
export class CourseCard implements OnChanges {

  @Input() course!: { id: number, name: string, code: string, credits: number };

  @Output() enrollRequested = new EventEmitter<number>();

  ngOnChanges(changes: SimpleChanges){
    if(changes['course']){
      const previous = changes['course'].previousValue;
      const current = changes['course'].currentValue;

      console.log("Previous Course Data: ", previous);
      console.log("Current Course Data: ", current);
    }
  }
}

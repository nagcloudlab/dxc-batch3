import {Component, EventEmitter, Output} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-review-form',
  templateUrl: './review-form.component.html',
  styleUrls: ['./review-form.component.css']
})
export class ReviewFormComponent {

  reviewForm!: FormGroup;
  @Output()
  newReview:EventEmitter<any>=new EventEmitter<any>()

  constructor(private formBuilder: FormBuilder) {
  }

  ngOnInit(): void {
    this.reviewForm= this.formBuilder.group({
      author: ['', Validators.required],
      stars: ['5', Validators.required],
      body: ['', Validators.required]
    })
  }

  handleSubmit(event:SubmitEvent){
    if(this.reviewForm.valid){
      event.preventDefault();
      this.newReview.emit(this.reviewForm.value)
      this.reviewForm.reset()
    }
  }

}

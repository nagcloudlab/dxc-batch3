import { Injectable } from '@angular/core';
import Review from "../model/Review";

@Injectable({
  providedIn: 'root'
})
export class ReviewsService {

  constructor() { }

  getReviews(productId: number):Array<Review> {
    return [
      {author: "Who-1", stars: 3, body: "I love this product"},
      {author: "Who-2", stars: 1, body: "I hate this product"},
    ]
  }

}

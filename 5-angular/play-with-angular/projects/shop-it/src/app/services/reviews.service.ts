import { Injectable } from '@angular/core';
import Review from "../model/Review";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class ReviewsService {

  constructor(private httpClient:HttpClient) { }

  getReviews(productId: number):Observable<Array<Review>> {
    return this.httpClient.get<Array<Review>>(`http://localhost:8080/api/v1/${productId}/reviews`)
  }

  postNewReview(productId:number,review: Review):Observable<Review> {
    return this.httpClient.post<Review>(`http://localhost:8080/api/v1/${productId}/reviews`,review)
  }

}

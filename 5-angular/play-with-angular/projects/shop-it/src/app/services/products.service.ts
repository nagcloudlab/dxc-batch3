import {Injectable} from '@angular/core';
import Product from "../model/Product";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class ProductsService {

  constructor(private httpClient: HttpClient) {
  }

  getProducts(): Observable<Product[]> {

    // fetch("http://localhost:8080/api/v1/products")
    //   .then(response => response.json())
    //   .then(products => {
    //     console.log(products)
    //   });

    return this.httpClient.get<Product[]>("http://localhost:8080/api/v1/products")

  }


}

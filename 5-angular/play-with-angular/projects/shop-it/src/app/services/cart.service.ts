import { Injectable } from '@angular/core';
import  {Observable,Subject,BehaviorSubject,ReplaySubject} from 'rxjs'
import CartLine from "../model/CartLine";

@Injectable({
  providedIn: 'root'
})
export class CartService {

  private cart: Array<CartLine> = []
  cart$:Subject<Array<CartLine>> = new Subject<Array<CartLine>>() // Observable stream

  constructor() { }

  addToCart(product: any) {
    this.cart.push(product)
    this.cart$.next(this.cart)
  }
  getCart() {
    return this.cart
  }

}

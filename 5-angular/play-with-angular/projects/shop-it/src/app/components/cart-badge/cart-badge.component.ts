import {Component, Input} from '@angular/core';
import {CartService} from "../../services/cart.service";

@Component({
  selector: 'app-cart-badge',
  templateUrl: './cart-badge.component.html',
  styleUrls: ['./cart-badge.component.css']
})
export class CartBadgeComponent {

  cartCount: number=0;

  constructor(private cartService: CartService) {
  }

  ngOnInit() {
    this.cartService.cart$
      .subscribe({
        next: cart => {
          this.cartCount = cart.length;
        }
      })
  }

}

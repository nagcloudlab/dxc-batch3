import {
  AfterViewInit,
  Component,
  ElementRef,
  Input,
  OnChanges,
  OnDestroy,
  OnInit,
  SimpleChanges,
  ViewChild
} from '@angular/core';
import {CartService} from "../../services/cart.service";
import CartLine from "../../model/CartLine";

@Component({
  selector: 'app-cart-view',
  templateUrl: './cart-view.component.html',
  styleUrls: ['./cart-view.component.css']
})
export class CartViewComponent implements OnChanges, OnInit, OnDestroy,AfterViewInit {

  @ViewChild("cbody") cardBody!:ElementRef

  cart: Array<CartLine> = []

  time: string = ""
  interval: any


  constructor(private cartService: CartService) {
    console.log("CartViewComponent->constructor")
    // why we need ? todo one-time initialization
  }

  ngOnChanges(changes: SimpleChanges) {
    console.log("CartViewComponent->ngOnChanges")
    console.log(changes)
    // why we need? todo any side-effect when component receives new input properties
  }

  ngOnInit() {
    console.log("CartViewComponent->ngOnInit")
    console.log(this.cardBody)
    // why we need? todo one-time initialization based initial input properties
    // this.interval = setInterval(() => {
    //   this.time = new Date().toLocaleTimeString()
    // }, 1000)
    this.cart=this.cartService.getCart()
    this.cartService.cart$
      .subscribe({
        next: (cart) => {
          this.cart = cart
        }
      })

  }

  ngOnDestroy() {
    console.log("CartViewComponent->ngOnDestroy")
    // why we need? todo one-time destruction
    clearInterval(this.interval)
  }

  ngAfterViewInit() {
    console.log("CartViewComponent->ngAfterViewInit")
    console.log(this.cardBody)
  }


}

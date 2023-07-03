import {Component, EventEmitter, Input, Output} from '@angular/core';
import {CartService} from "../../services/cart.service";
import {ProductsService} from "../../services/products.service";
import {ReviewsService} from "../../services/reviews.service";
import Product from "../../model/Product";
import Review from "../../model/Review";

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent {

  @Input() product!: Product;
  @Output() buy = new EventEmitter<any>();
  currentTab = 1;

  // dependency injection
  constructor(private cartService:CartService,
              private reviewsService:ReviewsService) {
  }

  reviews: Array<Review> = [];

  isTabSelected(tabIndex: number) {
    return this.currentTab === tabIndex
  }

  handleTabChange(event: MouseEvent, tabIndex: number) {
    this.currentTab = tabIndex
    if(this.currentTab === 3){
      this.reviews=this.reviewsService.getReviews(this.product.id)
    }
  }

  handleBuy() {
    //this.buy.emit(this.product)
    this.cartService.addToCart(this.product)
  }

}

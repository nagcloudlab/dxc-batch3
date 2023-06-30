import {Component, EventEmitter, Output} from '@angular/core';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent {


  products = [
    {
      id: 1,
      name: 'Laptop',
      price: 100000,
      currencyCode:'INR',
      makeDate:Date.now(),
      description: 'Laptop description',
      isAvailable: true,
      imagePath: "assets/images/Laptop.png"
    },
    {
      id: 2,
      name: 'Mobile',
      price: 200,
      currencyCode:'INR',
      makeDate:Date.now(),
      description: 'Mobile description',
      isAvailable: true,
      imagePath: "assets/images/Mobile.png"
    }
  ]

  @Output() buy = new EventEmitter<any>();

  handleBuy(event: any) {
    this.buy.emit(event);
  }


}

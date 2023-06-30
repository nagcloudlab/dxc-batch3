import { Component } from '@angular/core';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent {


  products=[
    {
      id: 1,
      name: 'Laptop',
      price: 100,
      description: 'Laptop description',
      isAvailable: false,
      imagePath: "assets/images/Laptop.png"
    },
    {
      id: 2,
      name: 'Mobile',
      price: 200,
      description: 'Mobile description',
      isAvailable: true,
      imagePath:"assets/images/Mobile.png"
    }
  ]


}

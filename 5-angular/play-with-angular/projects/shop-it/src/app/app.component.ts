import {Component} from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'shop-it';

  product = {
    id: 1,
    name: 'Laptop',
    description: 'New laptop',
    price: 1000.00,
    quantity: 0,
  }

}

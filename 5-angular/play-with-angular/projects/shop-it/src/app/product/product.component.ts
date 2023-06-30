import {Component, Input} from '@angular/core';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent {

  @Input() product:any;
  currentTab=1;

  reviews:any[]=[
    {author:"Who-1",stars:3,body:"I love this product"},
    {author:"Who-2",stars:1,body:"I hate this product"},
  ];

  handleTabChange(event:MouseEvent,tabIndex:number){
    this.currentTab=tabIndex
  }
  isTabSelected(tabIndex:number){
    return this.currentTab===tabIndex
  }

}

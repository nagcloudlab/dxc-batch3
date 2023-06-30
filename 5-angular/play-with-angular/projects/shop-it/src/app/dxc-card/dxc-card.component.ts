import {AfterContentInit, Component, ContentChild, ElementRef} from '@angular/core';

@Component({
  selector: 'app-dxc-card',
  templateUrl: './dxc-card.component.html',
  styleUrls: ['./dxc-card.component.css']
})
export class DxcCardComponent implements AfterContentInit{

  @ContentChild("plist") productList!: ElementRef;

  ngAfterContentInit() {
    console.log('DxcCardComponent ngAfterContentInit');
    console.log(this.productList);
  }

}

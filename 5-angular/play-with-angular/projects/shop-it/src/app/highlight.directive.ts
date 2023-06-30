import {Directive, ElementRef, HostListener} from '@angular/core';

@Directive({
  selector: '[appHighlight]'
})
export class HighlightDirective {

  constructor(private ele: ElementRef) {
  }

  @HostListener('mouseover')
  mouseOver() {
    this.ele.nativeElement.style.backgroundColor = "yellow";
  }

  @HostListener('mouseout')
  mouseOut() {
    this.ele.nativeElement.style.backgroundColor = "white";
  }

}

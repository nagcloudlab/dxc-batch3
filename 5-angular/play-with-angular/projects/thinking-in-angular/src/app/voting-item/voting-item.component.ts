import {Component, EventEmitter, Input, Output} from '@angular/core';

@Component({
  selector: 'app-voting-item',
  templateUrl: './voting-item.component.html',
  styleUrls: ['./voting-item.component.css']
})
export class VotingItemComponent {

  @Input() item: string='Unknown';
  @Output() vote: EventEmitter<object> = new EventEmitter<object>();

  handleLike(){
    this.vote.emit({item:this.item,type:'like'});
  }
  handleDislike(){
    this.vote.emit({item:this.item,type:'dislike'});
  }

}

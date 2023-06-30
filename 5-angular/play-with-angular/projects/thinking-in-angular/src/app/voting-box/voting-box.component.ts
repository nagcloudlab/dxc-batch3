import {Component} from '@angular/core';

@Component({
  selector: 'app-voting-box',
  templateUrl: './voting-box.component.html',
  styleUrls: ['./voting-box.component.css']
})
export class VotingBoxComponent {

  items = [
    "React.js",
    "Angular.js",
    "Vue.js",
  ]

  votingLines: any = []

  handleVote(event: any) {
    let {item, type} = event
    let votingLine = this.votingLines.find((line: any) => line.item === item);
    if (votingLine) {
      if (type === 'like') {
        votingLine.likes++;
      } else {
        votingLine.dislikes++;
      }
    } else {
      let newVotingLine = {item, likes: 0, dislikes: 0}
      if (type === 'like') {
        newVotingLine.likes++;
      } else {
        newVotingLine.dislikes++;
      }
      this.votingLines.push(newVotingLine)
    }
  }

}

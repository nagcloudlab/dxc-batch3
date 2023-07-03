import {Component} from '@angular/core';

@Component({
  selector: 'app-customer-form',
  templateUrl: './customer-form.component.html',
  styleUrls: ['./customer-form.component.css']
})
export class CustomerFormComponent {


  customerModel: any = {
    firstName: '',
    lastName: '',
  }

  loadCustomer(){
    this.customerModel = {
      firstName: 'Nagabhushanam',
      lastName: 'N',
    }
  }

  handleSubmit(event: SubmitEvent, formModel: any) {
    // console.log(event)
    console.log(formModel)
    console.log(this.customerModel)
  }

}

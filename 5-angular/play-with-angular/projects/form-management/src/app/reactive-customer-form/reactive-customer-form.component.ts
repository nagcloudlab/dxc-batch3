import {Component} from '@angular/core';
import {FormArray, FormBuilder, FormGroup, Validators} from "@angular/forms";
import {emailDomainValidator} from "../validators/my-validators";

@Component({
  selector: 'app-reactive-customer-form',
  templateUrl: './reactive-customer-form.component.html',
  styleUrls: ['./reactive-customer-form.component.css']
})
export class ReactiveCustomerFormComponent {

  customerForm!:FormGroup;

  constructor(private fb:FormBuilder) {
  }




  ngOnInit(): void {

    this.customerForm = this.fb.group({
      firstName: ['Nag', [Validators.required,Validators.minLength(3)]],
      lastName: ['N', Validators.required],
      email: ['nag@mail.com', [Validators.required, Validators.email,emailDomainValidator("dxc.com")]],
      mobile: [''],
      noti: ['email'],
      addressFormArray: this.fb.array([])
    })

    this.customerForm
      .valueChanges
      .subscribe({
        next: (value) => {
          console.log(value)
        }
      })
    this.customerForm
      .statusChanges
      .subscribe({
        next: (status) => {
          console.log(status)
        }
      })

    let firstNameControl=this.customerForm.controls['firstName']
    firstNameControl.valueChanges
      .subscribe({
        next: (value) => {
          console.log(value)
        }
      })
    firstNameControl.statusChanges
     .subscribe({
       next: (status) => {
          console.log(status)
        }
     })

  }

  handleNotiChange(notiType:string){
    if(notiType!=='email'){
      this.customerForm.get("mobile")!
        .setValidators([Validators.required,Validators.pattern('^[0-9]{10}$')])
    }
    this.customerForm.get("mobile")!
      .updateValueAndValidity()
  }

  createAddressFormGroup(): FormGroup {
    return this.fb.group({
      street: ['', [Validators.required, Validators.minLength(3)]],
      city: ['', [Validators.required, Validators.minLength(3)]],
      state: ['', [Validators.required, Validators.minLength(3)]],
      zip: ['', [Validators.required, Validators.minLength(3)]],
      country: ['', [Validators.required, Validators.minLength(3)]]
    })
  }

  get addressFormArray() {
    return this.customerForm.get('addressFormArray') as FormArray;
  }

  handleNewAddress() {
    this.addressFormArray.push(this.createAddressFormGroup());
  }
  handleRemoveAddress(index: number) {
    this.addressFormArray.removeAt(index);
  }

  loadCustomer(){
    this.customerForm.patchValue({
      firstName: 'Nagabhushanam',
      lastName: 'N',
    })
  }

  handleSubmit(event: SubmitEvent) {
    console.log(this.customerForm.value)
  }

}

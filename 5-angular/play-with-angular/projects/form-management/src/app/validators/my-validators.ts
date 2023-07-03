import {AbstractControl} from "@angular/forms";


export function emailDomainValidator(domainName: string) {
  return function (control: AbstractControl) {
    let controlValue = control.value;
    let parts=controlValue.split("@");
    if(parts[1]==domainName){
      return null;
    }else{
      return {
        message: `Email domain ${parts[1]} is not valid`,
        type: "email"
      };
    }

  }
}

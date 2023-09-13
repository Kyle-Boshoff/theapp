import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {

  formLogin: FormGroup;

  errorMessage:string="";

  constructor(private userService:UserService,private formBuilder:FormBuilder,private router:Router){
    this.formLogin = this.formBuilder.group({
      email: ["", [Validators.required]],
      password: ["", [Validators.required]],
    });
    
  }

  logIn(){
    this.userService.login(this.formLogin.value).subscribe(
      data=>{
        this.errorMessage="";
        
        if (data !== null) {
          
          this.userService.setUserData(data);
          this.router.navigateByUrl("/dashboard");
        }
      
    },error=>{
      this.errorMessage=error.error;
      this.router.navigateByUrl("/login");
    })
  }

}

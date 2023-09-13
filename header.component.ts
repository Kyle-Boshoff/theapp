import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent {
  loggedInUser: any;
  userObject: any;

  constructor(private userService:UserService,private router:Router){}


  ngAfterViewInit(): void {
   
    this.loggedInUser = this.userService.getUserData();
    this.userObject = JSON.parse(this.loggedInUser)[0];  
  }
  ngOnInit(): void {
    this.loggedInUser = this.userService.getUserData();
    this.userObject = JSON.parse(this.loggedInUser)[0];
  }

  logOut(){
    this.userService.deleteUserData();
    this.router.navigateByUrl("/login");
  }
}

import { Location } from '@angular/common';
import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent  implements OnInit, AfterViewInit{
  formAdd: FormGroup;

  title = 'teamConfigurationFrontEnd';
  users:any;
  view:string="users";
  selectedUserID:number=0;


  action:string="";

  addUserData: any= {
    "email": "",
    "name": "",
    "password": "",
    "surname": "",
    "team": 0
    }

  displayedColumns: string[] = ['Name', 'Surname', 'Email','Team','Edit'];
  teams: any;
  loggedInUser: any;
  userObject: any;

  constructor(private userService:UserService,private formBuilder:FormBuilder,private router:Router,private location:Location){
    this.formAdd = this.formBuilder.group({
      name: ["", [Validators.required]],
      email: ["", [Validators.required]],
      surname: ["", [Validators.required]],
      password: ["", [Validators.required]],
      team: ["", [Validators.required]],
    });

  }
  ngAfterViewInit(): void {

    this.loggedInUser = this.userService.getUserData();
    this.userObject = JSON.parse(this.loggedInUser)[0];

  }
  ngOnInit(): void {

    this.getUsers();
    this.getTeams();
    this.loggedInUser = this.userService.getUserData();
    this.userObject = JSON.parse(this.loggedInUser)[0];

  }


  getUsers(){
    this.userService.getUsers().subscribe(data=>{
      this.users= data;
    })
  }

  getTeams(){
    this.userService.getTeams().subscribe(data=>{
      this.teams= data;

    })
  }

  changeView(){
   if (this.view == "users") {
   this.view = "addNew"

   }else{
   this.view = "users"
   }
  }

  save(){
    const value = this.formAdd.value;

    this.addUserData= value;


   this.userService.createUser(this.addUserData).subscribe(data=>{


   },error=>{
    console.log(error.message);

   });


   this.location.historyGo();
  }

  updateUserData(id:number){
  this.action='';
  this.userService.updateUser(id,this.formAdd.value).subscribe(data=>{

  })
  this.selectedUserID =0;
  this.formAdd = this.formBuilder.group({
    name: ["", [Validators.required]],
    email: ["", [Validators.required]],
    surname: ["", [Validators.required]],
    password: ["", [Validators.required]],
    team: ["", [Validators.required]],
  });
  this.location.historyGo();
  }

  updateUser(element:any){
    this.selectedUserID =element.id;

    this.view = "addNew";
    this.action="update";
    this.formAdd.get("name")?.setValue(element.name);
    this.formAdd.get("surname")?.setValue(element.surname);
    this.formAdd.get("email")?.setValue(element.email);
    this.formAdd.get("password")?.setValue(element.password);
    this.formAdd.get("team")?.setValue(element.team);
  }

  deleteUser(id:number){
  this.userService.deleteUser(id).subscribe(data=>{


  });

  this.location.historyGo();
  }
}

import { Injectable } from '@angular/core';
import{HttpClient} from '@angular/common/http';
import { throwIfEmpty } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private userData:any;

  constructor(private http:HttpClient) { }

  getUsers(){
    return this.http.get(`http://localhost:8080/getUsers`);
  }

  getTeams(){
    return this.http.get(`http://localhost:8080/getTeams`);
  }

  createUser(data:any){
    return this.http.post(`http://localhost:8080/addUser`,data)
  }

  updateUser(id:number,data:any){
    return this.http.put(`http://localhost:8080/updateUser/${id}`,data)
  }

  deleteUser(id:number){
    return this.http.delete(`http://localhost:8080/deleteUser/${id}`)
  }

  login(data:any){
    return this.http.post(`http://localhost:8080/login`,data)
  }

  getUserData(){
   return localStorage.getItem("userInformation");
  }

  setUserData(user:any){
   this.userData = user;
   localStorage.setItem("userInformation", JSON.stringify(this.userData));
  }

  deleteUserData(){
    localStorage.removeItem("userInformation");
  }
}

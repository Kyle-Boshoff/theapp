import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './auth/login/login.component';
import { DashboardComponent } from './pages/dashboard/dashboard.component';

const routes: Routes = [
  {
    path:"",
    redirectTo:"dashboard",
    pathMatch: 'full'

  },
  {
  path:"dashboard",
  component:DashboardComponent,

},
{
  path:"login",
  component:LoginComponent,

},


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
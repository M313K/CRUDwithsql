import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminComponent } from './update/update.component';
import { HomeComponent } from './add/add.component';
import { LoginComponent } from './login/login.component';
import { UserComponent } from './read&delete/read&delete.component';
const routes: Routes = [
  {path:'login', component: LoginComponent},
  {path:'add', component: HomeComponent},
  {path:'update/:id', component: AdminComponent},
  {path: 'readAll', component: UserComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AboutComponent } from 'src/app/about/about.component';
import { CountryListComponent } from 'src/app/country-list/country-list.component';

const routes: Routes = [
  {path: 'countrylist', component: CountryListComponent},
  //Por defecto, redirigimos a la lista de paises
  {path: '', redirectTo: 'countrylist', pathMatch: 'full'},  
  {path: 'about', component: AboutComponent}  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

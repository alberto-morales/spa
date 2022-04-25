import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Country } from '../../model/country/country';
import { CountryService } from '../../service/country/country.service';

@Component({
  selector: 'app-country-list',
  templateUrl: './country-list.component.html',
  styleUrls: ['./country-list.component.css']
})
export class CountryListComponent implements OnInit {

  countries!: Country[]

  constructor(
    //Inyectamos el UserService que hemos importado
    private countryService : CountryService,
    private router: Router
  ) { }

  //De la documentación: A lifecycle hook that is called after Angular 
  //has initialized all data-bound properties of a directive.
  ngOnInit(): void {
    this.getCountries();
  }

  private getCountries(){
    //Utilizamos el servicio inyectado para encontrar los usuarios
    this.countryService.findAllCountries().subscribe(
      //Arrow function, funcion anónima similar a expersiones Lambda
      countryData => {this.countries = countryData}
    );
  }  

}

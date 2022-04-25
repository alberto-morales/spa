import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Country } from '../../model/country/country';

@Injectable({
  providedIn: 'root'
})
export class CountryService {

  //Endpoint del Backend
  private backendURL: string = "http://localhost:8080/countries";  

  constructor(
    //HttpClient para proporcionar métodos que reciben datos del backend
    private httpClient: HttpClient    
  ) { }

  //Methods
  //Para cada uno de ellos usamos uno de los métodos request HTTP
  //GET
  findAllCountries(): Observable<Country[]>{
    return this.httpClient.get<Country[]>(`${this.backendURL}`);
  }

}

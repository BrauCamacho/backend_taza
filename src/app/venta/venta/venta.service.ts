import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class VentaService {
  private API_SERVER = "http://localhost:8080/venta/";

  constructor(private httpClient: HttpClient) { }

  public getAllVentas(): Observable<any>{
    return this.httpClient.get(this.API_SERVER);
  }

  public saveVenta (persona:any): Observable<any>{
    return this.httpClient.post(this.API_SERVER,persona);
  }
}

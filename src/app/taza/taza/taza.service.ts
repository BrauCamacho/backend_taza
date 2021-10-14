import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class TazaService {
  private API_SERVER = "http://localhost:8080/taza/";
  constructor(private httpClient: HttpClient) {}

  public getAllTazas(): Observable<any>{
    return this.httpClient.get(this.API_SERVER);
  }

  public saveTaza (persona:any): Observable<any>{
    return this.httpClient.post(this.API_SERVER,persona);
  }

  public deleteTaza(id):Observable<any>{
    return this.httpClient.delete(this.API_SERVER + "delete/"+id);
  }
}

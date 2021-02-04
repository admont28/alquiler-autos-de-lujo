import { Injectable } from '@angular/core';
import { HttpService } from '@core-service/http.service';
import { environment } from 'src/environments/environment';
import { Cliente } from '../model/cliente';

@Injectable({
  providedIn: 'root'
})
export class ClienteService {

  constructor(protected http: HttpService) { }

  public crear(cliente: Cliente) {
    console.log("Servicio crear cliente");
    return this.http.doPost<Cliente, boolean>(`${environment.endpoint}/clientes`, cliente, this.http.optsName('crear clientes'));
  }

  public actualizar(cliente: Cliente) {
    console.log("Servicio actualizar cliente");
    return this.http.doPut<Cliente, boolean>(`${environment.endpoint}/clientes`, cliente, this.http.optsName('actualizar clientes'));
  }

  public eliminar(cliente: Cliente) {
    return this.http.doDelete<boolean>(`${environment.endpoint}/clientes/${cliente.id}`, this.http.optsName('eliminar clientes'));
  } 
  
}
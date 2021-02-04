import { Injectable } from '@angular/core';
import { HttpService } from '@core-service/http.service';
import { environment } from 'src/environments/environment';
import { Auto } from '../model/auto';

@Injectable({
  providedIn: 'root'
})
export class AutoService {

  constructor(protected http: HttpService) {}

  public consultar() {
    return this.http.doGet<Auto[]>(`${environment.endpoint}/autos`, this.http.optsName('consultar autos'));
  }

  public crear(auto: Auto) {
    console.log("Servicio crear auto");
    return this.http.doPost<Auto, boolean>(`${environment.endpoint}/autos`, auto, this.http.optsName('crear autos'));
  }

  public actualizar(auto: Auto) {
    return this.http.doPut<Auto, boolean>(`${environment.endpoint}/autos`, auto, this.http.optsName('actualizar autos'));
  }

  /* public eliminar(auto: Auto) {
    return this.http.doDelete<boolean>(`${environment.endpoint}/autos/${auto.id}`,
                                                 this.http.optsName('eliminar autos'));
  } */
}

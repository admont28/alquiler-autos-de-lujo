import { Injectable } from '@angular/core';
import { HttpService } from '@core-service/http.service';
import { environment } from 'src/environments/environment';
import { Auto } from '../model/auto';

@Injectable()
export class AutoService {

  autoActivo: Auto;

  constructor(protected http: HttpService) {}

  public listar() {
    return this.http.doGet<Auto[]>(`${environment.endpoint}/autos`, this.http.optsName('listar autos'));
  }

  public crear(auto: Auto) {
    console.log('Servicio crear auto');
    return this.http.doPost<Auto, any>(`${environment.endpoint}/autos`, auto, this.http.optsName('crear autos'));
  }

  public actualizar(auto: Auto) {
    return this.http.doPut<Auto, boolean>(`${environment.endpoint}/autos/${auto.id}`, auto, this.http.optsName('actualizar autos'));
  }

  /* public eliminar(auto: Auto) {
    return this.http.doDelete<boolean>(`${environment.endpoint}/autos/${auto.id}`,
                                                 this.http.optsName('eliminar autos'));
  } */

}

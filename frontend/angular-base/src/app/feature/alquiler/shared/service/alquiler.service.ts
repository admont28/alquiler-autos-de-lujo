import { Injectable } from '@angular/core';
import { HttpService } from 'src/app/core/services/http.service';
import { environment } from 'src/environments/environment';
import { Alquiler } from '../model/alquiler';

@Injectable()
export class AlquilerService {

  alquilerActivo: Alquiler;

  constructor(protected http: HttpService) { }

  public crear(alquiler: Alquiler) {
    console.log('Servicio crear alquiler');
    return this.http.doPost<Alquiler, any>(`${environment.endpoint}/alquiler`, alquiler, this.http.optsName('crear alquiler'));
  }

  public listar() {
    return this.http.doGet<Alquiler[]>(`${environment.endpoint}/alquiler`,  this.http.optsName('listar alquileres'));
  }
}

import { Component, OnInit } from '@angular/core';
import { AlquilerService } from '../../shared/service/alquiler.service';
import { Alquiler } from '../../shared/model/alquiler';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-listar-alquiler',
  templateUrl: './listar-alquiler.component.html',
  styleUrls: ['./listar-alquiler.component.css']
})
export class ListarAlquilerComponent implements OnInit {

  alquileres: Observable<Alquiler[]>;

  constructor(protected alquilerService: AlquilerService) { }

  ngOnInit(): void {
    this.alquileres = this.alquilerService.listar();
  }

}

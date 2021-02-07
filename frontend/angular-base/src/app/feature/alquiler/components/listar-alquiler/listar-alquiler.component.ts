import { Component, OnInit } from '@angular/core';
import { AlquilerService } from '../../shared/service/alquiler.service';
import { Alquiler } from '../../shared/model/alquiler';
import { Auto } from '../../../auto/shared/model/auto';
import { Cliente } from '../../../cliente/shared/model/cliente';

@Component({
  selector: 'app-listar-alquiler',
  templateUrl: './listar-alquiler.component.html',
  styleUrls: ['./listar-alquiler.component.css']
})
export class ListarAlquilerComponent implements OnInit {

  alquileres: Alquiler[];
  autos: Auto[];
  clientes: Cliente[];

  constructor(protected alquilerService: AlquilerService) { }

  ngOnInit(): void {
    this.alquilerService.listar().subscribe( (alquileres) => this.alquileres = alquileres );
  }

}

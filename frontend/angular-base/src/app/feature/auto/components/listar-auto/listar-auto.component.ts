import { Component, OnInit } from '@angular/core';
import { Auto } from '../../shared/model/auto';
import { AutoService } from '../../shared/service/auto.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-listar-auto',
  templateUrl: './listar-auto.component.html',
  styleUrls: ['./listar-auto.component.css']
})
export class ListarAutoComponent implements OnInit {

  autos : Auto[];

  constructor(protected autoService: AutoService, private router: Router) { }

  ngOnInit(): void {
    this.autoService.listar().subscribe( autos => this.autos = autos);
  }

  navegarAEditar(auto: Auto){
    this.autoService.autoActivo = auto;
    this.router.navigateByUrl('/auto/editar');
  }

}

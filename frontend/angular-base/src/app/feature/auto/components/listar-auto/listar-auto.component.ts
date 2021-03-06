import { Component, OnInit } from '@angular/core';
import { Auto } from '../../shared/model/auto';
import { AutoService } from '../../shared/service/auto.service';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-listar-auto',
  templateUrl: './listar-auto.component.html',
  styleUrls: ['./listar-auto.component.css']
})
export class ListarAutoComponent implements OnInit {

  autos: Observable<Auto[]>;

  constructor(protected autoService: AutoService, private router: Router) { }

  ngOnInit(): void {
    this.autos = this.autoService.listar();
  }

  navegarAEditar(auto: Auto) {
    this.autoService.autoActivo = auto;
    this.router.navigateByUrl('/auto/editar');
  }

  asignarAutoParaAlquiler(auto: Auto) {
    this.autoService.autoActivo = auto;
    this.router.navigate(['alquiler/crear', { auto: JSON.stringify(auto) }]);
  }

}

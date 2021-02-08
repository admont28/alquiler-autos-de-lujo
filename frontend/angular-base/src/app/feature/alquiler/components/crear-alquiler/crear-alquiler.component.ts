import { Component, OnInit } from '@angular/core';
import { Auto } from '../../../auto/shared/model/auto';
import { Cliente } from '../../../cliente/shared/model/cliente';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { ClienteService } from '../../../cliente/shared/service/cliente.service';
import { ActivatedRoute, Router } from '@angular/router';
import { AlquilerService } from '../../shared/service/alquiler.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-crear-alquiler',
  templateUrl: './crear-alquiler.component.html',
  styleUrls: ['./crear-alquiler.component.css']
})
export class CrearAlquilerComponent implements OnInit {

  auto: Auto;
  clientes: Cliente[];
  alquilerForm: FormGroup;

  constructor( protected alquilerService: AlquilerService, protected clienteService: ClienteService, private router: Router, private activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    if(Object.keys(this.activatedRoute.snapshot.params).length == 0){
      this.router.navigate(['/auto/listar'], {skipLocationChange: true});
    }
    this.auto = JSON.parse(this.activatedRoute.snapshot.params.auto);
    this.clienteService.listar().subscribe( (clientes) => {
      this.clientes = clientes.filter( cliente => cliente.estado == 'ACTIVO');
    });
    this.construirFormularioAlquiler();
  }

  private construirFormularioAlquiler() {
    this.alquilerForm = new FormGroup({
      autoId: new FormControl(this.auto.id, [Validators.required]),
      clienteId: new FormControl('', [Validators.required]),
      fechaAlquiler: new FormControl('', [Validators.required]),
      fechaDevolucion: new FormControl('', [Validators.required])
    });
  }

  crear(){
    this.alquilerService.crear(this.alquilerForm.value).subscribe((alquiler) =>{
      console.log(alquiler);
      if(alquiler.valor){
        Swal.fire({
          icon : 'success',
          title : `Alquiler #${alquiler.valor} creado correctamente`
        }).then( () => {
          this.router.navigate(['/alquiler/listar'], {skipLocationChange: true});
        });
      }
    }, 
    (error) => {
      console.log(error);
      Swal.fire({
        icon : 'error',
        title : error.error.mensaje
      });
    });
  }

}

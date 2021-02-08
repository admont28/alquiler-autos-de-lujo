import { Component, OnInit } from '@angular/core';
import { Auto } from '../../shared/model/auto';
import { AutoService } from '../../shared/service/auto.service';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';

const LONGITUD_MINIMA_PERMITIDA_TEXTO = 3;
const LONGITUD_MAXIMA_PERMITIDA_TEXTO = 20;

@Component({
  selector: 'app-editar-auto',
  templateUrl: './editar-auto.component.html',
  styleUrls: ['./editar-auto.component.css']
})
export class EditarAutoComponent implements OnInit {

  autoForm: FormGroup;
  auto: Auto;

  constructor(protected autoService: AutoService, private router: Router) {
    this.auto = autoService.autoActivo;
  }

  ngOnInit(): void {
    this.construirFormularioAuto();
  }

  private construirFormularioAuto() {
    this.autoForm = new FormGroup({
      id: new FormControl(this.auto.id, [Validators.required]),
      serial: new FormControl(this.auto.serial, [Validators.required, Validators.minLength(LONGITUD_MINIMA_PERMITIDA_TEXTO), Validators.maxLength(LONGITUD_MAXIMA_PERMITIDA_TEXTO)]),
      nombre: new FormControl(this.auto.nombre, [Validators.required, Validators.minLength(LONGITUD_MINIMA_PERMITIDA_TEXTO), Validators.maxLength(LONGITUD_MAXIMA_PERMITIDA_TEXTO)]),
      modelo: new FormControl(this.auto.modelo, [Validators.required, Validators.minLength(LONGITUD_MINIMA_PERMITIDA_TEXTO), Validators.maxLength(LONGITUD_MAXIMA_PERMITIDA_TEXTO)]),
      precioPorDia: new FormControl(this.auto.precioPorDia, [Validators.required, Validators.minLength(LONGITUD_MINIMA_PERMITIDA_TEXTO), Validators.maxLength(LONGITUD_MAXIMA_PERMITIDA_TEXTO)]),
      estado: new FormControl(this.auto.estado, [Validators.required])
    });
  }

  editar(){
    console.log("Editar auto");
    this.autoService.actualizar(this.autoForm.value).subscribe(() =>{
      Swal.fire({
        icon : 'success',
        title : 'Auto actualizado correctamente'
      }).then(() => {
        this.autoForm.reset();
        this.router.navigateByUrl('/auto/listar');
      });
      
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

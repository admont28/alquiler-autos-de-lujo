import { Component, OnInit } from '@angular/core';
import { AutoService } from '../../shared/service/auto.service';
import { FormGroup, FormControl, Validators } from '@angular/forms';

const LONGITUD_MINIMA_PERMITIDA_TEXTO = 3;
const LONGITUD_MAXIMA_PERMITIDA_TEXTO = 20;

@Component({
  selector: 'app-crear-auto',
  templateUrl: './crear-auto.component.html',
  styleUrls: ['./crear-auto.component.css']
})
export class CrearAutoComponent implements OnInit {

  autoForm: FormGroup;

  constructor(protected autoService : AutoService) { 
    
  }

  ngOnInit(): void {
    this.construirFormularioAuto();
  }

  crear() {
    console.log("Crear auto");
    this.autoService.crear(this.autoForm.value).subscribe((auto) =>{
      console.log(auto);
      
      this.autoForm.reset();
    });
     
  }

  private construirFormularioAuto() {
    this.autoForm = new FormGroup({
      serial: new FormControl('', [Validators.required, Validators.minLength(LONGITUD_MINIMA_PERMITIDA_TEXTO), Validators.maxLength(LONGITUD_MAXIMA_PERMITIDA_TEXTO)]),
      nombre: new FormControl('', [Validators.required, Validators.minLength(LONGITUD_MINIMA_PERMITIDA_TEXTO), Validators.maxLength(LONGITUD_MAXIMA_PERMITIDA_TEXTO)]),
      modelo: new FormControl('', [Validators.required, Validators.minLength(LONGITUD_MINIMA_PERMITIDA_TEXTO), Validators.maxLength(LONGITUD_MAXIMA_PERMITIDA_TEXTO)]),
      precioPorDia: new FormControl('', [Validators.required, Validators.minLength(LONGITUD_MINIMA_PERMITIDA_TEXTO), Validators.maxLength(LONGITUD_MAXIMA_PERMITIDA_TEXTO)])
    });
  }

}

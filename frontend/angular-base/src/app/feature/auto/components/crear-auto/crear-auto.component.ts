import { Component, OnInit } from '@angular/core';
import { AutoService } from '../../shared/service/auto.service';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import Swal from 'sweetalert2';

const LONGITUD_MINIMA_PERMITIDA_TEXTO = 3;
const LONGITUD_MAXIMA_PERMITIDA_TEXTO = 20;

@Component({
  selector: 'app-crear-auto',
  templateUrl: './crear-auto.component.html',
  styleUrls: ['./crear-auto.component.css']
})
export class CrearAutoComponent implements OnInit {

  autoForm: FormGroup;

  constructor(protected autoService: AutoService) {
  }

  ngOnInit(): void {
    this.construirFormularioAuto();
  }

  crear() {
    console.log('Crear auto');
    console.log(this.autoForm.value);
    console.log(this.autoForm.get('imagen').value);
    
    this.autoService.crear(this.autoForm.value).subscribe((auto) => {
      console.log(auto);
      if ( auto.valor) {
        Swal.fire({
          icon : 'success',
          title : 'Auto creado correctamente'
        });
        this.autoForm.reset();
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

  onFileChange(event) {
  
    /* if (event.target.files.length > 0) {
      const file = event.target.files[0];
      console.log("onFileChange");
      this.autoForm.get('imagen').setValue(file);
      this.autoForm.patchValue({
        imagen: file
      });
    } */

    let reader = new FileReader();
    if(event.target.files && event.target.files.length > 0) {
      let file = event.target.files[0];
      reader.readAsDataURL(file);
      reader.onload = () => {
        this.autoForm.patchValue({
          imagen: reader.result.toString().split(',')[1]
        })
        /* this.autoForm.get('imagen').setValue({
          filename: file.name,
          filetype: file.type,
          value: reader.result
        })  */
      };
    }
  }

  private construirFormularioAuto() {
    this.autoForm = new FormGroup({
      serial: new FormControl('', [
        Validators.required,
        Validators.minLength(LONGITUD_MINIMA_PERMITIDA_TEXTO),
        Validators.maxLength(LONGITUD_MAXIMA_PERMITIDA_TEXTO)]),
      nombre: new FormControl('', [
        Validators.required,
        Validators.minLength(LONGITUD_MINIMA_PERMITIDA_TEXTO),
        Validators.maxLength(LONGITUD_MAXIMA_PERMITIDA_TEXTO)]),
      modelo: new FormControl('', [
        Validators.required,
        Validators.minLength(LONGITUD_MINIMA_PERMITIDA_TEXTO),
        Validators.maxLength(LONGITUD_MAXIMA_PERMITIDA_TEXTO)]),
      precioPorDia: new FormControl('', [
        Validators.required,
        Validators.minLength(LONGITUD_MINIMA_PERMITIDA_TEXTO),
        Validators.maxLength(LONGITUD_MAXIMA_PERMITIDA_TEXTO)]),
      fuenteImagen: new FormControl(null, [ Validators.required]),
      imagen: new FormControl(null, []),
    });
  }

}

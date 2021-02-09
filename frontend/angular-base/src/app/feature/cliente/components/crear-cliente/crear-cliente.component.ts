import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { ClienteService } from '../../shared/service/cliente.service';
import Swal from 'sweetalert2';

const LONGITUD_MINIMA_PERMITIDA_TEXTO = 3;
const LONGITUD_MAXIMA_PERMITIDA_TEXTO = 20;

@Component({
  selector: 'app-crear-cliente',
  templateUrl: './crear-cliente.component.html',
  styleUrls: ['./crear-cliente.component.css']
})
export class CrearClienteComponent implements OnInit {

  clienteForm: FormGroup;

  constructor(protected clienteService: ClienteService) {
  }

  ngOnInit(): void {
    this.construirFormularioCliente();
  }

  crear() {
    console.log('Crear cliente');
    this.clienteService.crear(this.clienteForm.value).subscribe((cliente) => {
      console.log(cliente);
      if ( cliente.valor) {
        Swal.fire({
          icon : 'success',
          title : 'Cliente creado correctamente'
        });
        this.clienteForm.reset();
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

  private construirFormularioCliente() {
    this.clienteForm = new FormGroup({
      nombre: new FormControl('', [
        Validators.required,
        Validators.minLength(LONGITUD_MINIMA_PERMITIDA_TEXTO),
        Validators.maxLength(LONGITUD_MAXIMA_PERMITIDA_TEXTO)]),
      apellido: new FormControl('', [
        Validators.required,
        Validators.minLength(LONGITUD_MINIMA_PERMITIDA_TEXTO),
        Validators.maxLength(LONGITUD_MAXIMA_PERMITIDA_TEXTO)]),
      direccion: new FormControl('', [
        Validators.required,
        Validators.minLength(LONGITUD_MINIMA_PERMITIDA_TEXTO),
        Validators.maxLength(LONGITUD_MAXIMA_PERMITIDA_TEXTO)]),
      cedula: new FormControl('', [
        Validators.required,
        Validators.minLength(LONGITUD_MINIMA_PERMITIDA_TEXTO),
        Validators.maxLength(LONGITUD_MAXIMA_PERMITIDA_TEXTO)])
    });
  }
}

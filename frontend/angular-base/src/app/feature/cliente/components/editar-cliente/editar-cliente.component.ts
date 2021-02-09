import { Component, OnInit } from '@angular/core';
import { ClienteService } from '../../shared/service/cliente.service';
import { Router } from '@angular/router';
import { Cliente } from '../../shared/model/cliente';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import Swal from 'sweetalert2';

const LONGITUD_MINIMA_PERMITIDA_TEXTO = 3;
const LONGITUD_MAXIMA_PERMITIDA_TEXTO = 20;

@Component({
  selector: 'app-editar-cliente',
  templateUrl: './editar-cliente.component.html',
  styleUrls: ['./editar-cliente.component.css']
})
export class EditarClienteComponent implements OnInit {

  cliente: Cliente;
  clienteForm: FormGroup;

  constructor(protected clienteService: ClienteService, private router: Router) {
    this.cliente = clienteService.clienteActivo;
  }

  ngOnInit(): void {
    this.construirFormularioCliente();
  }

  private construirFormularioCliente() {
    this.clienteForm = new FormGroup({
      id: new FormControl(this.cliente.id, [Validators.required]),
      nombre: new FormControl(this.cliente.nombre, [
        Validators.required,
        Validators.minLength(LONGITUD_MINIMA_PERMITIDA_TEXTO),
        Validators.maxLength(LONGITUD_MAXIMA_PERMITIDA_TEXTO)]),
      apellido: new FormControl(this.cliente.apellido, [
        Validators.required,
        Validators.minLength(LONGITUD_MINIMA_PERMITIDA_TEXTO),
        Validators.maxLength(LONGITUD_MAXIMA_PERMITIDA_TEXTO)]),
      direccion: new FormControl(this.cliente.direccion, [
        Validators.required,
        Validators.minLength(LONGITUD_MINIMA_PERMITIDA_TEXTO),
        Validators.maxLength(LONGITUD_MAXIMA_PERMITIDA_TEXTO)]),
      cedula: new FormControl(this.cliente.cedula, [
        Validators.required,
        Validators.minLength(LONGITUD_MINIMA_PERMITIDA_TEXTO),
        Validators.maxLength(LONGITUD_MAXIMA_PERMITIDA_TEXTO)]),
      estado: new FormControl(this.cliente.estado, [Validators.required])
    });
  }

  editar() {
    console.log('Editar cliente');
    this.clienteService.actualizar(this.clienteForm.value).subscribe(() => {
      Swal.fire({
        icon : 'success',
        title : 'Cliente actualizado correctamente'
      }).then( () => {
        this.clienteForm.reset();
        this.router.navigateByUrl('/cliente/listar');
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

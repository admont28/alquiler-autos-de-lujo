import { Component, OnInit } from '@angular/core';
import { ClienteService } from '../../shared/service/cliente.service';
import { Cliente } from '../../shared/model/cliente';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-listar-cliente',
  templateUrl: './listar-cliente.component.html',
  styleUrls: ['./listar-cliente.component.css']
})
export class ListarClienteComponent implements OnInit {

  clientes: Cliente[]; 

  constructor(protected clienteService: ClienteService, private router: Router) { }

  ngOnInit(): void {
    this.actualizarListaClientes();
  }

  actualizarListaClientes(){
    this.clienteService.listar().subscribe( (clientes) => this.clientes = clientes);
  }

  navegarAEditar(cliente: Cliente){
    this.clienteService.clienteActivo = cliente;
    this.router.navigateByUrl('/cliente/editar');
  }
  
  eliminar(cliente: Cliente){
    Swal.fire({
      title: '¿Desea eliminar el cliente?',
      text: "Luego de eliminado puedes volver a activar el cliente.",
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Si, eliminar!',
      cancelButtonText: 'No, cancelar'
    }).then((result) => {
      if (result.isConfirmed) {
        this.clienteService.eliminar(cliente).subscribe( () => {
          Swal.fire({
            icon : 'success',
            title : 'Cliente eliminado correctamente'
          }).then( () => {
            this.actualizarListaClientes();
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
    });
    
  }
}

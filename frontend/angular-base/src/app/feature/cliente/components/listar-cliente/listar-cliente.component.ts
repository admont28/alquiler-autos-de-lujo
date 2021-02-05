import { Component, OnInit } from '@angular/core';
import { ClienteService } from '../../shared/service/cliente.service';
import { Cliente } from '../../shared/model/cliente';
import { Router } from '@angular/router';

@Component({
  selector: 'app-listar-cliente',
  templateUrl: './listar-cliente.component.html',
  styleUrls: ['./listar-cliente.component.css']
})
export class ListarClienteComponent implements OnInit {

  clientes: Cliente[]; 

  constructor(protected clienteService: ClienteService, private router: Router) { }

  ngOnInit(): void {
    this.clienteService.listar().subscribe( (clientes) => this.clientes = clientes);
  }

  navegarAEditar(cliente: Cliente){
    this.clienteService.clienteActivo = cliente;
    this.router.navigateByUrl('/cliente/editar');
  }

}

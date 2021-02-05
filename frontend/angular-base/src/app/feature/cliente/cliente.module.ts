import { NgModule } from '@angular/core';
import { CrearClienteComponent } from './components/crear-cliente/crear-cliente.component';
import { ClienteComponent } from './components/cliente/cliente.component';
import { ClienteRoutingModule } from './cliente-routing.module';
import { SharedModule } from '@shared/shared.module';
import { ClienteService } from './shared/service/cliente.service';
import { ListarClienteComponent } from './components/listar-cliente/listar-cliente.component';
import { EditarClienteComponent } from './components/editar-cliente/editar-cliente.component';

@NgModule({
  declarations: [
    CrearClienteComponent, 
    ClienteComponent, ListarClienteComponent, EditarClienteComponent
  ],
  imports: [
    ClienteRoutingModule,
    SharedModule
  ],
  providers: [ ClienteService ]
})
export class ClienteModule { }

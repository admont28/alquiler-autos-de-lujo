import { NgModule } from '@angular/core';
import { CrearClienteComponent } from './components/crear-cliente/crear-cliente.component';
import { ClienteComponent } from './components/cliente/cliente.component';
import { Routes, RouterModule } from '@angular/router';
import { ListarClienteComponent } from './components/listar-cliente/listar-cliente.component';
import { EditarClienteComponent } from './components/editar-cliente/editar-cliente.component';

const routes: Routes = [
  {
    path: '',
    component: ClienteComponent,
    children: [
      {
        path: 'crear',
        component: CrearClienteComponent
      },
      {
        path: 'listar',
        component: ListarClienteComponent
      },
      {
        path: 'editar',
        component: EditarClienteComponent
      }
      
    ]
  }
];

@NgModule({
  declarations: [],
  imports: [ RouterModule.forChild(routes) ],
  exports: [ RouterModule ]
})
export class ClienteRoutingModule { }

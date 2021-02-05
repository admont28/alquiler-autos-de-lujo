import { NgModule } from '@angular/core';
import { AutoComponent } from './components/auto/auto.component';
import { CrearAutoComponent } from './components/crear-auto/crear-auto.component';
import { Routes, RouterModule } from '@angular/router';
import { ListarAutoComponent } from './components/listar-auto/listar-auto.component';
import { EditarAutoComponent } from './components/editar-auto/editar-auto.component';

const routes: Routes = [
  {
    path: '',
    component: AutoComponent,
    children: [
      {
        path: 'crear',
        component: CrearAutoComponent
      },
      {
        path: 'listar',
        component: ListarAutoComponent
      },
      {
        path: 'editar',
        component: EditarAutoComponent
      }
    ]
  }
];

@NgModule({
  declarations: [],
  imports: [ RouterModule.forChild(routes) ],
  exports: [ RouterModule ]
})
export class AutoRoutingModule { }

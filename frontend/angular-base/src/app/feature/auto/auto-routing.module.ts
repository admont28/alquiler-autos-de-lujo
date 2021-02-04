import { NgModule } from '@angular/core';
import { AutoComponent } from './components/auto/auto.component';
import { CrearAutoComponent } from './components/crear-auto/crear-auto.component';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
  {
    path: '',
    component: AutoComponent,
    children: [
      {
        path: 'crear',
        component: CrearAutoComponent
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

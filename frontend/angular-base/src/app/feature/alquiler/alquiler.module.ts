import { NgModule } from '@angular/core';
import { AlquilerComponent } from './components/alquiler/alquiler.component';
import { CrearAlquilerComponent } from './components/crear-alquiler/crear-alquiler.component';
import { AlquilerRoutingModule } from './alquiler-routing.module';
import { SharedModule } from '@shared/shared.module';
import { ListarAlquilerComponent } from './components/listar-alquiler/listar-alquiler.component';
import { AlquilerService } from './shared/service/alquiler.service';



@NgModule({
  declarations: [
    AlquilerComponent,
    CrearAlquilerComponent,
    ListarAlquilerComponent
  ],
  imports: [
    AlquilerRoutingModule,
    SharedModule
  ],
  providers: [ AlquilerService ]
})
export class AlquilerModule { }

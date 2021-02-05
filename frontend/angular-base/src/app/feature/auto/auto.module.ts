import { NgModule } from '@angular/core';
import { CrearAutoComponent } from './components/crear-auto/crear-auto.component';
import { SharedModule } from '@shared/shared.module';
import { AutoService } from './shared/service/auto.service';
import { AutoComponent } from './components/auto/auto.component';
import { AutoRoutingModule } from './auto-routing.module';
import { ListarAutoComponent } from './components/listar-auto/listar-auto.component';
import { EditarAutoComponent } from './components/editar-auto/editar-auto.component';

@NgModule({
  declarations: [
    CrearAutoComponent,
    AutoComponent,
    ListarAutoComponent,
    EditarAutoComponent
  ],
  imports: [
    AutoRoutingModule,
    SharedModule
  ],
  providers: [AutoService]
})
export class AutoModule { }

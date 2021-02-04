import { NgModule } from '@angular/core';
import { CrearAutoComponent } from './components/crear-auto/crear-auto.component';
import { SharedModule } from '@shared/shared.module';
import { AutoService } from './shared/service/auto.service';
import { AutoComponent } from './components/auto/auto.component';
import { AutoRoutingModule } from './auto-routing.module';



@NgModule({
  declarations: [
    CrearAutoComponent, 
    AutoComponent
  ],
  imports: [
    AutoRoutingModule,
    SharedModule
  ],
  providers: [AutoService]
})
export class AutoModule { }

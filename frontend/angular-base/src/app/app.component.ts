import { Component } from '@angular/core';
import { MenuItem } from '@core/modelo/menu-item';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app-base';
  public companies: MenuItem[] = [
    { url: '/home', nombre: 'home' },
    { url: '/producto', nombre: 'producto' },
    { url: '/auto/listar', nombre: 'auto' },
    { url: '/cliente/listar', nombre: 'cliente' },
    { url: '/alquiler/listar', nombre: 'alquiler' }
    
  ];

  
}


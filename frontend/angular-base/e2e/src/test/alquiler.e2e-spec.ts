import { browser } from 'protractor';
import { NavbarPage } from '../page/navbar/navbar.po';
import { AppPage } from '../app.po';
import { AlquilerPage } from '../page/alquiler/alquiler.po';
import { AutoPage } from '../page/auto/auto.po';

describe('workspace-project Alquiler', () => {
    let page: AppPage;
    let navBar: NavbarPage;
    let alquiler: AlquilerPage;
    let auto: AutoPage;

    beforeEach(() => {
        page = new AppPage();
        navBar = new NavbarPage();
        alquiler = new AlquilerPage();
        auto = new AutoPage();
        browser.driver.manage().window().maximize();
    });


    it('Deberia crear un alquiler', () => {
        page.navigateToHome();
        navBar.clicBotonAuto();
        auto.clickBotonAlquilar();
        alquiler.clickSeleccionarPrimerCliente();
        alquiler.ingresarFechaAlquiler();
        alquiler.ingresarFechaDevolucion();
        alquiler.clickBotonCrear();

        // Validaciones
        expect(alquiler.obtenerTextoSweetAlert()).toContain('creado correctamente');
        alquiler.clickBotonOK();
    });

    it('Deberia listar alquilers', () => {
        page.navigateToHome();
        navBar.clicBotonAlquiler();
        alquiler.clickBotonListarAlquileres();
        // Validaciones
        expect(alquiler.contarAlquileres()).toBeGreaterThanOrEqual(1);
    });
});

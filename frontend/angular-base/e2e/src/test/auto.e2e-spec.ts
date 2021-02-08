//import { browser, logging } from 'protractor';
import { NavbarPage } from '../page/navbar/navbar.po';
import { AppPage } from '../app.po';
import { AutoPage } from '../page/auto/auto.po';

describe('workspace-project Auto', () => {
    let page: AppPage;
    let navBar: NavbarPage;
    let auto: AutoPage;

    beforeEach(() => {
        page = new AppPage();
        navBar = new NavbarPage();
        auto = new AutoPage();
    });

    it('Deberia crear un auto', () => {
        const SERIAL = 'serial-nuevo-123';
        const NOMBRE =  'Chevrolet GT';
        const MODELO = '2021';
        const PRECIO_POR_DIA = 100000;

        page.navigateToHome();
        navBar.clicBotonAuto();
        auto.clickBotonCrearAuto();
        auto.ingresarSerial(SERIAL);
        auto.ingresarNombre(NOMBRE);
        auto.ingresarModelo(MODELO);
        auto.ingresarPrecioPorDia(PRECIO_POR_DIA);

        // Adicionamos las validaciones despues de la creación
        // expect(<>).toEqual(<>);
    });

    it('Deberia listar autos', () => {
        page.navigateToHome();
        navBar.clicBotonAuto();
        auto.clickBotonListarAutos();

        expect(10).toBe(auto.contarAutos());
    });
});

import { browser } from 'protractor';
import { NavbarPage } from '../page/navbar/navbar.po';
import { AppPage } from '../app.po';
import { ClientePage } from '../page/cliente/cliente.po';

describe('workspace-project Cliente', () => {
    let page: AppPage;
    let navBar: NavbarPage;
    let cliente: ClientePage;

    beforeEach(() => {
        page = new AppPage();
        navBar = new NavbarPage();
        cliente = new ClientePage();
        browser.driver.manage().window().maximize();
    });

    it('Deberia crear un cliente', () => {
        const NOMBRE =  'Chevrolet GT';
        const APELLIDO = '2021';
        const DIRECCION = 'Dirección nueva';
        const CEDULA = ( Math.floor(Math.random() * 9999999999) + 1000000000 );

        page.navigateToHome();
        navBar.clicBotonCliente();
        cliente.clickBotonCrearCliente();
        cliente.ingresarNombre(NOMBRE);
        cliente.ingresarApellido(APELLIDO);
        cliente.ingresarDireccion(DIRECCION);
        cliente.ingresarCedula(CEDULA);
        cliente.clickBotonCrear();

        // Validaciones
        expect(cliente.obtenerTextoSweetAlert()).toEqual('Cliente creado correctamente');
        cliente.clickBotonOK();
    });

    it('Deberia editar un cliente', () => {
        const NOMBRE =  'Nombre editado';
        const APELLIDO = 'Apellido editado';
        const DIRECCION = 'Dirección editada';

        page.navigateToHome();
        navBar.clicBotonCliente();
        cliente.clickBotonListarClientes();
        cliente.clickBotonEditarPrimerCliente();
        cliente.ingresarNombre(NOMBRE);
        cliente.ingresarApellido(APELLIDO);
        cliente.ingresarDireccion(DIRECCION);
        cliente.clickBotonEditar();

        // Validaciones
        expect(cliente.obtenerTextoSweetAlert()).toEqual('Cliente actualizado correctamente');
        cliente.clickBotonOK();
    });

    it('Deberia listar clientes', () => {
        page.navigateToHome();
        navBar.clicBotonCliente();
        cliente.clickBotonListarClientes();
        // Validaciones
        expect(cliente.contarClientes()).toBeGreaterThanOrEqual(1);
    });
});

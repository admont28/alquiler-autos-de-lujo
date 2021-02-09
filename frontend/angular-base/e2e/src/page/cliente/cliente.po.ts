import { element, by } from 'protractor';

export class ClientePage {
    
    private linkCrearCliente = element(by.id('linkCrearCliente'));
    private linkListarClientes = element(by.id('linkListarCliente'));
    private inputNombre = element(by.id('nombre'));
    private inputApellido = element(by.id('apellido'));
    private inputDireccion = element(by.id('direccion'));
    private inputCedula = element(by.id('cedula'));
    private botonCrear = element(by.buttonText('Crear'));
    private botonOkVentanaModal = element(by.buttonText('OK'));
    private textoSweetAlert = element(by.id('swal2-title'));
    private botonEditarPrimerCliente = element.all(by.css('.btn-editar-cliente')).first();
    private botonEliminarPrimerCliente = element.all(by.css('.btn-eliminar-cliente')).first();
    private botonEditar = element(by.buttonText('Editar'));
    private botonSiEliminar = element(by.buttonText('Si, eliminar!'));
    private inputActivo = element(by.id('activo'));
    
    private listaClientes = element.all(by.css('app-root table tbody tr'));
    
    async clickBotonCrearCliente() {
        await this.linkCrearCliente.click();
    }
    
    async clickBotonListarClientes() {
        await this.linkListarClientes.click();
    }
    
    async ingresarNombre(nombre) {
        this.inputNombre.clear();
        await this.inputNombre.sendKeys(nombre);
    }

    async ingresarApellido(apellido) {
        this.inputApellido.clear();
        await this.inputApellido.sendKeys(apellido);
    }

    async ingresarDireccion(direccion) {
        this.inputDireccion.clear();
        await this.inputDireccion.sendKeys(direccion);
    }
    
    async ingresarCedula(cedula) {
        this.inputCedula.clear();
        await this.inputCedula.sendKeys(cedula);
    }
    
    async contarClientes() {
        return this.listaClientes.count();
    }
    
    async clickBotonCrear() {
        await this.botonCrear.click();
    }
    
    obtenerTextoSweetAlert(){
        return this.textoSweetAlert.getText() as Promise<string>;
    }

    async clickBotonOK() {
        await this.botonOkVentanaModal.click();
    }

    async clickBotonEditarPrimerCliente(){
        await this.botonEditarPrimerCliente.click();
    }

    async clickBotonEliminarPrimerCliente(){
        await this.botonEliminarPrimerCliente.click();
    }

    async clickBotonSiEliminarCliente(){
        await this.botonSiEliminar.click();
    }

    async clickBotonEditar() {
        await this.botonEditar.click();
    }

    async clickInputActivo(){
        await this.inputActivo.click();
    }
}
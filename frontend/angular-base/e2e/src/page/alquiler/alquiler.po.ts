import { element, by, protractor } from 'protractor';

export class AlquilerPage {

    private linkListarAlquileres = element(by.id('linkListarAlquiler'));
    private inputPrimerCliente = element.all(by.tagName('option')).first();
    private inputFechaAlquiler = element(by.id('fechaAlquiler'));
    private inputFechaDevolucion = element(by.id('fechaDevolucion'));
    private botonCrear = element(by.buttonText('Crear'));
    private botonOkVentanaModal = element(by.buttonText('OK'));
    private textoSweetAlert = element(by.id('swal2-title'));
    private listaAlquileres = element.all(by.css('app-root table tbody tr'));

    async clickBotonListarAlquileres() {
        await this.linkListarAlquileres.click();
    }

    async clickSeleccionarPrimerCliente() {
        await this.inputPrimerCliente.click();
    }

    ingresarFechaAlquiler() {
        this.inputFechaAlquiler.click();
        this.inputFechaAlquiler.sendKeys(protractor.Key.ARROW_DOWN);
        this.inputFechaAlquiler.sendKeys(protractor.Key.ARROW_RIGHT);
        this.inputFechaAlquiler.sendKeys(protractor.Key.ARROW_DOWN);
        this.inputFechaAlquiler.sendKeys(protractor.Key.ARROW_RIGHT);
        this.inputFechaAlquiler.sendKeys(protractor.Key.ARROW_DOWN);
        this.inputFechaAlquiler.click();
    }

    ingresarFechaDevolucion() {
        this.inputFechaDevolucion.click();
        this.inputFechaDevolucion.sendKeys(protractor.Key.ARROW_DOWN);
        this.inputFechaDevolucion.sendKeys(protractor.Key.ARROW_RIGHT);
        this.inputFechaDevolucion.sendKeys(protractor.Key.ARROW_DOWN);
        this.inputFechaDevolucion.sendKeys(protractor.Key.ARROW_RIGHT);
        this.inputFechaDevolucion.sendKeys(protractor.Key.ARROW_DOWN);
        this.inputFechaDevolucion.click();
    }

    async contarAlquileres() {
        return this.listaAlquileres.count();
    }

    async clickBotonCrear() {
        await this.botonCrear.click();
    }

    obtenerTextoSweetAlert() {
        return this.textoSweetAlert.getText() as Promise<string>;
    }

    async clickBotonOK() {
        await this.botonOkVentanaModal.click();
    }
}

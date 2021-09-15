import { element, by, browser } from 'protractor';

export class AutoPage {

    private linkCrearAuto = element(by.id('linkCrearAuto'));
    private linkListarAutos = element(by.id('linkListarAuto'));
    private inputSerial = element(by.id('serial'));
    private inputNombre = element(by.id('nombre'));
    private inputModelo = element(by.id('modelo'));
    private inputPrecioPorDia = element(by.id('precioPorDia'));
    private inputSeleccionarImagenAuto = element(by.id('imagen'));
    private botonCrear = element(by.buttonText('Crear'));
    private botonOkVentanaModal = element(by.buttonText('OK'));
    private textoSweetAlert = element(by.id('swal2-title'));
    private botonEditarPrimerAuto = element.all(by.css('.btn-editar-auto')).first();
    private botonAlquilarPrimerAuto = element.all(by.css('.btn-alquilar-auto')).first();
    private botonEditar = element(by.buttonText('Editar'));
    private listaAutos = element.all(by.css('app-root div.autos'));

    async clickBotonCrearAuto() {
        await this.linkCrearAuto.click();
    }

    async clickBotonListarAutos() {
        await this.linkListarAutos.click();
    }

    async ingresarSerial(serial) {
        this.inputSerial.clear();
        await this.inputSerial.sendKeys(serial);
    }

    async ingresarNombre(nombre) {
        this.inputNombre.clear();
        await this.inputNombre.sendKeys(nombre);
    }

    async ingresarModelo(modelo) {
        this.inputModelo.clear();
        await this.inputModelo.sendKeys(modelo);
    }

    async ingresarPrecioPorDia(precioPorDia) {
        this.inputPrecioPorDia.clear();
        await this.inputPrecioPorDia.sendKeys(precioPorDia);
    }

    async seleccionarImagenDeAuto(rutaAbsolutaImagen: string) {
        this.inputSeleccionarImagenAuto.clear();
        await this.inputSeleccionarImagenAuto.sendKeys(rutaAbsolutaImagen);
    }

    async contarAutos() {
        return this.listaAutos.count();
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

    async clickBotonEditarPrimerAuto() {
        await this.botonEditarPrimerAuto.click();
    }

    async clickBotonEditar() {
        await this.botonEditar.click();
    }

    async clickBotonAlquilar() {
        browser.actions().mouseMove(this.botonAlquilarPrimerAuto).perform();
        browser.sleep(2500);
        await this.botonAlquilarPrimerAuto.click();
    }
}

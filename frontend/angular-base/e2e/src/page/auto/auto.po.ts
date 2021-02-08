import { element, by } from 'protractor';

export class AutoPage {
    
    private linkCrearAuto = element(by.id('linkCrearAuto'));
    private linkListarAutos = element(by.id('linkListarAuto'));
    private inputSerial = element(by.id('serial'));
    private inputNombre = element(by.id('nombre'));
    private inputModelo = element(by.id('modelo'));
    private inputPrecioPorDia = element(by.id('precioPorDia'));
    private botonCrear = element(by.buttonText('Crear'));
    private botonOkVentanaModal = element(by.buttonText('OK'));
    private textoSweetAlert = element(by.id('swal2-title'));
    
    private listaAutos = element.all(by.css('app-root div.autos'));
    
    async clickBotonCrearAuto() {
        await this.linkCrearAuto.click();
    }
    
    async clickBotonListarAutos() {
        await this.linkListarAutos.click();
    }
    
    async ingresarSerial(serial) {
        await this.inputSerial.sendKeys(serial);
    }
    
    async ingresarNombre(nombre) {
        await this.inputNombre.sendKeys(nombre);
    }
    
    async ingresarModelo(modelo) {
        await this.inputModelo.sendKeys(modelo);
    }
    
    async ingresarPrecioPorDia(precioPorDia) {
        await this.inputPrecioPorDia.sendKeys(precioPorDia);
    }
    
    async contarAutos() {
        return this.listaAutos.count();
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
}
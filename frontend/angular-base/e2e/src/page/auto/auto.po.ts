import { element, by } from 'protractor';

export class AutoPage {
    
    private linkCrearAuto = element(by.id('linkCrearAuto'));
    private linkListarAutos = element(by.id('linkListarAuto'));
    private inputSerial = element(by.id('serial'));
    private inputNombre = element(by.id('nombre'));
    private inputModelo = element(by.id('modelo'));
    private inputPrecioPorDia = element(by.id('precioPorDia'));

    private listaAutos = element.all(by.css('div.autos'));

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
}
import { by, element } from 'protractor';

export class NavbarPage {
    linkHome = element(by.xpath('/html/body/app-root/app-navbar/nav/a[1]'));
    linkProducto = element(by.xpath('/html/body/app-root/app-navbar/nav/a[2]'));
    linkAuto = element(by.xpath('/html/body/app-root/app-navbar/nav/div/div/ul/li[3]/a'));
    linkCliente = element(by.xpath('/html/body/app-root/app-navbar/nav/a[4]'));
    linkAlquiler = element(by.xpath('/html/body/app-root/app-navbar/nav/a[5]'));

    async clickBotonProductos() {
        await this.linkProducto.click();
    }

    async clicBotonAuto(){
        await this.linkAuto.click();
    }

    async clicBotonCliente(){
        await this.linkCliente.click();
    }

    async clicBotonAlquiler(){
        await this.linkAlquiler.click();
    }
}

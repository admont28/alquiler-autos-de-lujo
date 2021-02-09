import { by, element } from 'protractor';

export class NavbarPage {
    linkHome = element(by.xpath('/html/body/app-root/app-navbar/nav/div/div/ul/li[1]/a'));
    linkAuto = element(by.xpath('/html/body/app-root/app-navbar/nav/div/div/ul/li[2]/a'));
    linkCliente = element(by.xpath('/html/body/app-root/app-navbar/nav/div/div/ul/li[3]/a'));
    linkAlquiler = element(by.xpath('/html/body/app-root/app-navbar/nav/div/div/ul/li[4]/a'));

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

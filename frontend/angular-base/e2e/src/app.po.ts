import { browser, by, element } from 'protractor';

export class AppPage {
  navigateToHome() {
    return browser.get(browser.baseUrl) as Promise<any>;
  }

  getTitleText() {
    return element(by.tagName('h1')).getText() as Promise<string>;
  }
}

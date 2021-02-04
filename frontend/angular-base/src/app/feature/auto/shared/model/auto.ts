export class Auto {
    serial: string;
    nombre: string;
    modelo: string;
    precioPorDia: number;

    constructor(serial: string, nombre: string, modelo: string, precioPorDia: number){
        this.serial = serial;
        this.nombre = nombre;
        this.modelo = modelo;
        this.precioPorDia = precioPorDia;
    }
}

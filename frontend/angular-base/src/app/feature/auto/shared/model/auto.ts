export class Auto {
    id: string;
    serial: string;
    nombre: string;
    modelo: string;
    precioPorDia: number;

    constructor(id: string, serial: string, nombre: string, modelo: string, precioPorDia: number){
        this.id = id;
        this.serial = serial;
        this.nombre = nombre;
        this.modelo = modelo;
        this.precioPorDia = precioPorDia;
    }
}

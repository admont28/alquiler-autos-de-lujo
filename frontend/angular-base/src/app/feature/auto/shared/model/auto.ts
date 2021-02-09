export class Auto {
    id: number;
    serial: string;
    nombre: string;
    modelo: string;
    precioPorDia: number;
    estado: string;
    fechaCreacion: Date;

    constructor(
        id: number, serial: string, nombre: string,
        modelo: string, precioPorDia: number, estado: string,
        fechaCreacion: Date) {
        this.id = id;
        this.serial = serial;
        this.nombre = nombre;
        this.modelo = modelo;
        this.precioPorDia = precioPorDia;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
    }
}

export class Auto {
    id: number;
    serial: string;
    nombre: string;
    modelo: string;
    precioPorDia: number;
    estado: string;
    fechaCreacion: Date;
    urlImagen: string;

    constructor(
        id: number, serial: string, nombre: string,
        modelo: string, precioPorDia: number, estado: string,
        fechaCreacion: Date, urlImagen: string) {
        this.id = id;
        this.serial = serial;
        this.nombre = nombre;
        this.modelo = modelo;
        this.precioPorDia = precioPorDia;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
        this.urlImagen = urlImagen;
    }
}

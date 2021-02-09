export class Cliente {
    id: number;
    nombre: string;
    apellido: string;
    direccion: string;
    cedula: string;
    estado: string;
    fechaCreacion: Date;

    constructor(
        id: number, nombre: string, apellido: string,
        direccion: string, cedula: string, estado: string, fechaCreacion: Date) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.cedula = cedula;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
    }
}

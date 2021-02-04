export class Cliente {
    id: string;
    nombre: string;
    apellido: string;
    direccion: string;
    cedula: string;

    constructor(id: string, nombre: string, apellido: string, direccion: string, cedula: string){
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.cedula = cedula;
    }
}

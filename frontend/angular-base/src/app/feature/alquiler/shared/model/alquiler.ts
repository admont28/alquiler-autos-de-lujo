export class Alquiler {
    id: number;
    autoId: number;
    clienteId: number;
    subTotal: number;
    descuento: number;
    total: number;
    fechaAlquiler: Date;
    fechaDevolucion: Date;
    fechaCreacion: Date;

    constructor(id: number, autoId: number, clienteId: number, subTotal: number, descuento: number, total: number, fechaAlquiler: Date, fechaDevolucion: Date, fechaCreacion: Date){
        this.id = id;
        this.autoId = autoId;
        this.clienteId = clienteId;
        this.subTotal = subTotal;
        this.descuento = descuento;
        this.total = total;
        this.fechaAlquiler = fechaAlquiler;
        this.fechaDevolucion = fechaDevolucion;
        this.fechaCreacion = fechaCreacion;
    }
}

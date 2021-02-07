import { Auto } from '../../../auto/shared/model/auto';
import { Cliente } from '../../../cliente/shared/model/cliente';

export class Alquiler {
    id: number;
    auto: Auto;
    cliente: Cliente;
    subTotal: number;
    descuento: number;
    total: number;
    fechaAlquiler: Date;
    fechaDevolucion: Date;
    fechaCreacion: Date;

    constructor(id: number, auto: Auto, cliente: Cliente, subTotal: number, descuento: number, total: number, fechaAlquiler: Date, fechaDevolucion: Date, fechaCreacion: Date){
        this.id = id;
        this.auto = auto;
        this.cliente = cliente;
        this.subTotal = subTotal;
        this.descuento = descuento;
        this.total = total;
        this.fechaAlquiler = fechaAlquiler;
        this.fechaDevolucion = fechaDevolucion;
        this.fechaCreacion = fechaCreacion;
    }
}

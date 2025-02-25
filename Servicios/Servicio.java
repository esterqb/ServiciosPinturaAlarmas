package Servicios;

import java.time.LocalDate;

abstract class Servicio {
    private String trabajador;
    private LocalDate fechaInicio;
    private String cliente;

    public String getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(String trabajador) {
        this.trabajador = trabajador;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public Servicio(String trabajador, LocalDate fechaInicio, String cliente) {
        this.trabajador = trabajador;
        this.fechaInicio = fechaInicio;
        this.cliente = cliente;
    }

    public abstract double costeMaterial();
    public abstract double costeManoObra();
    public double costeTotal(){
        return costeMaterial()+costeManoObra();
    }
    public String detalleServicio() {
        return "Detalles del servicio:" +
                "\n\tTrabajador: " + trabajador + "."+
                "\n\tFecha inicio obra: " + fechaInicio +"."+
                "\n\tCliente: " + cliente +"."+
                "\n\tCoste del material: " + costeMaterial() +"."+
                "\n\tCoste de la mano de obra: " + costeManoObra() +"."+
                "\n\tCoste total: " + costeTotal()+ ".";
    }
}

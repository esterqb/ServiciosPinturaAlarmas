package Servicios;

import java.time.LocalDate;

public class TrabajoPintura extends Servicio {
    private double superficie;
    private double precioPintura;

    public TrabajoPintura(String trabajador, LocalDate fechaInicio, String cliente, double superficie, double precioPintura) {
        super(trabajador, fechaInicio, cliente);
        this.superficie = superficie;
        this.precioPintura = precioPintura;
    }

    public double getSuperficie() {
        return superficie;
    }

    public void setSuperficie(double superficie) {
        this.superficie = superficie;
    }

    public double getPrecioPintura() {
        return precioPintura;
    }

    public void setPrecioPintura(double precioPintura) {
        this.precioPintura = precioPintura;
    }

    @Override
    public double costeMaterial() {
        double coste_material = (superficie / 7.8) * precioPintura;
        return redondear(coste_material);
    }

    @Override
    public double costeManoObra() {
        double coste_mano_obra = (superficie / 10) * 9.5;
        return redondear(coste_mano_obra);
    }

    public double costeAdicional() {
        double costeAdicional = 0.0;
        double costeMaterial = costeMaterial();
        double costeManoObra = costeManoObra();
        if (superficie < 50) {
            costeAdicional = (costeMaterial + costeManoObra)*0.15;
        }return redondear(costeAdicional);
    }

    @Override
    public double costeTotal() {
        double total = costeMaterial() + costeManoObra() + costeAdicional();
        return redondear(total);
    }

    private double redondear(double valor) {
        return Math.round(valor);
    }

    @Override
    public String detalleServicio() {
        return "TRABAJO DE PINTURA" +
                "\nCliente: " + getCliente() +
                "\nFecha de inicio: " + getFechaInicio() +
                "\n__________________________________________________" +
                "\nPintor: " + getTrabajador() +
                "\nCoste Material....." + costeMaterial() + "€" +
                "\nCoste Mano Obra...." + costeManoObra() + "€" +
                "\nCoste Adicional...." + costeAdicional() + "€" +
                "\nCoste total........" + costeTotal() + "€" +
                "\n__________________________________________________";
    }
}

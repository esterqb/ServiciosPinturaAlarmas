package Servicios;

import java.time.LocalDate;

public class RevisionAlarma extends Servicio{
    private int numeroAlarmas;

    public int getNumeroAlarmas() {
        return numeroAlarmas;
    }

    public void setNumeroAlarmas(int numeroAlarmas) {
        this.numeroAlarmas = numeroAlarmas;
    }

    public RevisionAlarma(String trabajador, LocalDate fechaInicio, String cliente, int numeroAlarmas) {
        super(trabajador, fechaInicio, cliente);
        trabajador = "Revisor Especialista Contraincendios";
        this.numeroAlarmas = numeroAlarmas;
    }

    @Override
    public double costeMaterial() {
        return 0;
    }

    @Override
    public double costeManoObra() {
        double manoObra=(numeroAlarmas / 3) * 40;
        return redondear(manoObra);
    }

    @Override
    public double costeTotal() {
        double total = costeMaterial() + costeManoObra();
        return total;
    }

    private double redondear(double valor) {
        return Math.round(valor);
    }

    @Override
    public String detalleServicio() {
        return "REVISIÓN PERIÓDICA ALARMAS CONTRAINCENDIOS" +
                "\nCliente: " + getCliente() +
                "\nFecha revisión: " + getFechaInicio() +
                "\n__________________________________________________" +
                "\nTOTAL: ......."+ costeTotal()+ "€" +
                "\n__________________________________________________";
    }
}

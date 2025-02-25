package Servicios;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        ArrayList<Servicio> listaServicios = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("__________________________________________________");
            System.out.println("_SERVICIOS PINTURA Y ALARMAS CÓRDOBA JARJAR BINKS_");
            System.out.println("__________________________________________________");
            System.out.println("Seleccione el tipo de servicio:");
            System.out.println("__________________________________________________");

            System.out.println("1. Trabajo de Pintura");
            System.out.println("2. Revisión de Alarmas Contraincendios");
            System.out.println("3. Salir");
            System.out.println("Ingrese su opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            if (opcion == 1) {
                System.out.print("Nombre del trabajador: ");
                String trabajador = scanner.nextLine();

                System.out.print("Fecha de inicio (formato YYYY-MM-DD): ");
                String fecha = scanner.nextLine();
                LocalDate fechaInicio = LocalDate.parse(fecha);

                System.out.print("Su nombre o empresa: ");
                String cliente = scanner.nextLine();

                System.out.print("Superficie (m2): ");
                double superficie = scanner.nextDouble();
                scanner.nextLine();

                System.out.print("Precio pintura/l: ");
                double precioPintura = scanner.nextDouble();
                scanner.nextLine();

                TrabajoPintura trabajo = new TrabajoPintura(trabajador, fechaInicio, cliente, superficie, precioPintura);
                listaServicios.add(trabajo);
                System.out.println("✅ Añadido al sistema.\n");

            } else if (opcion == 2) {
                System.out.print("Nombre del trabajador: ");
                String trabajador = scanner.nextLine();

                System.out.print("Fecha (formato YYYY-MM-DD): ");
                String fecha = scanner.nextLine();
                LocalDate fechaInicio = LocalDate.parse(fecha);

                System.out.print("Su nombre o empresa: ");
                String cliente = scanner.nextLine();

                System.out.print("Número de alarmas: ");
                int numeroAlarmas = scanner.nextInt();
                scanner.nextLine();

                RevisionAlarma revision = new RevisionAlarma(trabajador, fechaInicio, cliente, numeroAlarmas);
                listaServicios.add(revision);
                System.out.println("✅ Añadido al sistema.\n");

            } else if (opcion == 3) {
                break;
            } else {
                System.out.println("Opción no admitida. Pruebe de nuevo.");
            }
        }

        double costeTotal = 0;
        double sueldosTotales = 0;

        System.out.println("Resumen:\n");
        for (Servicio servicio : listaServicios) {
            System.out.println(servicio.detalleServicio());
            System.out.println();
            costeTotal += servicio.costeTotal();
            sueldosTotales += servicio.costeManoObra();
        }

        System.out.println("__________________________________________________");
        System.out.println("Coste total de todos los trabajos: " + costeTotal + "€");
        System.out.println("Sueldo total por mano de obra: " + sueldosTotales + "€");
        System.out.println("__________________________________________________");

        scanner.close();
    }
}

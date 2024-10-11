package org.example;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Administrador admin = new Administrador();
        Cliente cliente = new Cliente("1", "Juan Perez");


        Auto auto1 = new Auto("1", "Toyota", "Corolla", 2022, 50.0, true, "Gasolina");
        admin.añadirVehiculo(auto1);
        Moto moto1 = new Moto("2", "Yamaha", "YZF-R3", 2021, 30.0, true, 300);
        admin.añadirVehiculo(moto1);


        LocalDate inicio = LocalDate.of(2023, 10, 1);
        LocalDate fin = LocalDate.of(2023, 10, 5);
        cliente.reservarVehiculo(auto1, inicio, fin, true, true);


        boolean disponible = admin.verificarDisponibilidad(auto1, inicio, fin);
        System.out.println("Disponibilidad del auto después de la reserva: " + disponible);


        System.out.println("Vehículos disponibles:");
        for (Vehiculo v : admin.listarVehiculosDisponibles()) {
            System.out.println(v.marca + " " + v.modelo);
        }
    }
}
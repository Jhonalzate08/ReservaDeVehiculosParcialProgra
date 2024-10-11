package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

<<<<<<< HEAD
=======
class Vehiculo {
    private String idVehiculo;
    String marca;
    String modelo;
    private int ano;
    private double costoDiario;
    private boolean disponibilidad;

    public Vehiculo(String idVehiculo, String marca, String modelo, int ano, double costoDiario, boolean disponibilidad) {
        this.idVehiculo = idVehiculo;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.costoDiario = costoDiario;
        this.disponibilidad = disponibilidad;
    }

    public double calcularPrecio(int dias, boolean seguro, boolean gps) {
        double costo = dias * costoDiario;
        if (seguro) {
            costo += 0.1 * costoDiario * dias;
        }
        if (gps) {
            costo += 5 * dias;
        }
        return costo;
    }


    public String getIdVehiculo() { return idVehiculo; }
    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }
    public int getAno() { return ano; }
    public double getCostoDiario() { return costoDiario; }
    public boolean isDisponibilidad() { return disponibilidad; }
    public void setDisponibilidad(boolean disponibilidad) { this.disponibilidad = disponibilidad; }
}

// Subclase Auto
class Auto extends Vehiculo {
    private String tipoCombustible;

    public Auto(String idVehiculo, String marca, String modelo, int ano, double costoDiario, boolean disponibilidad, String tipoCombustible) {
        super(idVehiculo, marca, modelo, ano, costoDiario, disponibilidad);
        this.tipoCombustible = tipoCombustible;
    }


    public String getTipoCombustible() { return tipoCombustible; }
    public void setTipoCombustible(String tipoCombustible) { this.tipoCombustible = tipoCombustible; }
}

// Subclase Moto
class Moto extends Vehiculo {
    private int cilindrada;

    public Moto(String idVehiculo, String marca, String modelo, int ano, double costoDiario, boolean disponibilidad, int cilindrada) {
        super(idVehiculo, marca, modelo, ano, costoDiario, disponibilidad);
        this.cilindrada = cilindrada;
    }


    public int getCilindrada() { return cilindrada; }
    public void setCilindrada(int cilindrada) { this.cilindrada = cilindrada; }
}

// Subclase Camioneta
class Camioneta extends Vehiculo {
    private int capacidadCarga;

    public Camioneta(String idVehiculo, String marca, String modelo, int ano, double costoDiario, boolean disponibilidad, int capacidadCarga) {
        super(idVehiculo, marca, modelo, ano, costoDiario, disponibilidad);
        this.capacidadCarga = capacidadCarga;
    }


    public int getCapacidadCarga() { return capacidadCarga; }
    public void setCapacidadCarga(int capacidadCarga) { this.capacidadCarga = capacidadCarga; }
}

// Subclase Autobus
class Autobus extends Vehiculo {
    private int capacidadPasajeros;

    public Autobus(String idVehiculo, String marca, String modelo, int ano, double costoDiario, boolean disponibilidad, int capacidadPasajeros) {
        super(idVehiculo, marca, modelo, ano, costoDiario, disponibilidad);
        this.capacidadPasajeros = capacidadPasajeros;
    }


    public int getCapacidadPasajeros() { return capacidadPasajeros; }
    public void setCapacidadPasajeros(int capacidadPasajeros) { this.capacidadPasajeros = capacidadPasajeros; }
}

// Clase Reserva
class Reserva {
    private String idReserva;
    private Cliente cliente;
    private Vehiculo vehiculo;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private double costoTotal;

    public Reserva(String idReserva, Cliente cliente, Vehiculo vehiculo, LocalDate fechaInicio, LocalDate fechaFin) {
        this.idReserva = idReserva;
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.costoTotal = vehiculo.calcularPrecio(diasEntre(fechaInicio, fechaFin), false, true);  // Ejemplo de uso de seguro y GPS
    }

    public void confirmarReserva() {
        vehiculo.setDisponibilidad(false);
    }

    private int diasEntre(LocalDate inicio, LocalDate fin) {
        return (int) java.time.temporal.ChronoUnit.DAYS.between(inicio, fin);
    }


    public String getIdReserva() { return idReserva; }
    public Cliente getCliente() { return cliente; }
    public Vehiculo getVehiculo() { return vehiculo; }
    public LocalDate getFechaInicio() { return fechaInicio; }
    public LocalDate getFechaFin() { return fechaFin; }
    public double getCostoTotal() { return costoTotal; }
}

// Clase Cliente
class Cliente {
    private String idCliente;
    private String nombre;
    private List<Reserva> reservas;

    public Cliente(String idCliente, String nombre) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.reservas = new ArrayList<>();
    }

    public void reservarVehiculo(Vehiculo vehiculo, LocalDate fechaInicio, LocalDate fechaFin, boolean seguro, boolean gps) {
        if (vehiculo.isDisponibilidad()) {
            Reserva reserva = new Reserva("reserva" + reservas.size(), this, vehiculo, fechaInicio, fechaFin);
            reservas.add(reserva);
            reserva.confirmarReserva();
        }
    }


    public String getIdCliente() { return idCliente; }
    public String getNombre() { return nombre; }
    public List<Reserva> getReservas() { return reservas; }
}

// Clase Administrador
class Administrador {
    private List<Vehiculo> flota;

    public Administrador() {
        this.flota = new ArrayList<>();
    }

    public void anadirVehiculo(Vehiculo vehiculo) {
        flota.add(vehiculo);
    }

    public String verificarDisponibilidad(Vehiculo vehiculo, LocalDate fechaInicio, LocalDate fechaFin) {
        for (Vehiculo v : flota) {
            if (v.equals(vehiculo) && !vehiculo.isDisponibilidad()) {
                return "Reservado";
            }
        }
        return "Disponible";
    }

    public List<Vehiculo> listarVehiculosDisponibles() {
        List<Vehiculo> disponibles = new ArrayList<>();
        for (Vehiculo vehiculo : flota) {
            if (vehiculo.isDisponibilidad()) {
                disponibles.add(vehiculo);
            }
        }
        return disponibles;
    }

    public List<Vehiculo> getFlota() { return flota; }
}
>>>>>>> Develop







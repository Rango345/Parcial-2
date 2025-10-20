/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author oeara
 */
public class Profesor extends Personas{
    private int cedula;
    private String area;
    public double salarioHora;
    public int horasDictadas;
    private double pagoTotal;    
    private double prestaciones;
    
    public Profesor(String nombre, int telefono, String nacimiento, String direccion,int cedula, String area, double salarioHora, int horasDictadas) {
        super(nombre, telefono, nacimiento, direccion);
        
        this.cedula = cedula;
        this.area = area;
        this.salarioHora = salarioHora;
        this.horasDictadas = horasDictadas;
    }

    public double getSalarioHora() {
        return salarioHora;
    }

    public int getHorasDictadas() {
        return horasDictadas;
    }

    public double getPagoTotal() {
        return pagoTotal;
    }

    public double getPrestaciones() {
        return prestaciones;
    }

    public void setPagoTotal(double pagoTotal) {
        this.pagoTotal = pagoTotal;
    }

    public void setPrestaciones(double prestaciones) {
        this.prestaciones = prestaciones;
    }

    public void setHorasDictadas(int horasDictadas) {
        this.horasDictadas = horasDictadas;
    }
    
    
    
  
    @Override
    public String mostrarInformacion() {
        return "Profesor: " +
               "Nombre: " + getNombre() +
               "\nTeléfono: " + getTelefono() +
               "\nNacimiento: " + getNacimiento() +
               "\nDirección: " + getDireccion() +
               "\nCédula: " + cedula +
               "\nÁrea: " + area +
               "\nSalario por hora: " + salarioHora +
               "\nHoras dictadas: " + horasDictadas +
               "\nPago mensual: " + pagoTotal +
               "\nPrestaciones: " + prestaciones;
    
}
}

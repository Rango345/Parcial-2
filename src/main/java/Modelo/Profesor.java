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
    
    public Profesor(String nombre, int telefono, int nacimiento, String direccion,int cedula, String area, double salarioHora, int horasDictadas) {
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
               "\nPago mensual: " + Salario.calcularPagoMensual(this) +
               "\nPrestaciones: " + Salario.calcularPrestaciones(this);
    
}
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author oeara
 */
public class Personas {
    
    private String nombre;
    private int telefono;
    private int nacimiento;
    private String direccion;

    public Personas(String nombre, int telefono, int nacimiento, String direccion) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.nacimiento = nacimiento;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public int getNacimiento() {
        return nacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public void setNacimiento(int nacimiento) {
        this.nacimiento = nacimiento;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
     public String mostrarInformacion() {
         return ("Nombre: " + nombre + "Fecha de Nacimiento: " + nacimiento + "Dirección: " + direccion + "Teléfono: " + telefono);
    }
}

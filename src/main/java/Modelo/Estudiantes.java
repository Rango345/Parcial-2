/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author oeara
 */
public class Estudiantes extends Personas {
    
    public Estudiantes(String nombre, int telefono, String nacimiento, String direccion) {
        super(nombre, telefono, nacimiento, direccion);
    }
    
    @Override
    public String mostrarInformacion() {
        return "Etudinate: "+
                "Nombre: " + getNombre() +
               "\nTeléfono: " + getTelefono() +
               "\nNacimiento: " + getNacimiento() +
               "\nDirección: " + getDireccion();         
    }

    
    
}

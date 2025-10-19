/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author oeara
 */
public class Salario {
    
    
     public static double calcularPagoMensual(Profesor profe) {
    double pagoBase = profe.getSalarioHora() * profe.getHorasDictadas();
    double pagoConPreparacion = pagoBase + (pagoBase * 0.20); 
    return pagoConPreparacion;
    }

    
    public static double calcularPrestaciones(Profesor profe) {
        return calcularPagoMensual(profe) * 0.17;
    }
    
    
}

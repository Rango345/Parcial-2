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
     
    public static double calcularPagoMensual(Profesor profe, int horasExtra) {
    int totalHoras = profe.getHorasDictadas() + horasExtra;
    double base = profe.getSalarioHora() * totalHoras;
    return base + (base * 0.20);
    }

    
    public static double calcularPrestaciones(Profesor profe) {
        return calcularPagoMensual(profe) * 0.17;
    }
    
    
}

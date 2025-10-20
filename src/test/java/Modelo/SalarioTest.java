/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Modelo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author oeara
 */
public class SalarioTest {
    
     @Test
    public void testCalcularPagoMensual_SinHorasExtra() {
        
        Profesor profe = new Profesor("Laura", 300123456, "10/05/1980", "Calle 45",
                                      10254879, "Matemáticas", 40000, 40);
        double esperado = 1_920_000;
        double resultado = Salario.calcularPagoMensual(profe);
        assertEquals(esperado, resultado, 0.001, "El cálculo sin horas extra es incorrecto");
    }

    @Test
    public void testCalcularPagoMensual_ConHorasExtra() {
        Profesor profe = new Profesor("Carlos", 300987654, "02/02/1985", "Carrera 10",
                                      10123456, "Física", 40000, 40);
        double esperado = 2_160_000;
        double resultado = Salario.calcularPagoMensual(profe, 5);
        assertEquals(esperado, resultado, 0.001, "El cálculo con horas extra es incorrecto");
    }

    @Test
    public void testCalcularPrestaciones() {
        Profesor profe = new Profesor("Marta", 300111222, "20/07/1990", "Av. Siempre Viva",
                                      10234567, "Química", 40000, 40);
        profe.setPagoTotal(1_920_000);
        double esperado = 326_400;
        double resultado = Salario.calcularPrestaciones(profe);

        assertEquals(esperado, resultado, 0.001, "El cálculo de prestaciones es incorrecto");
    }

    @Test
    public void testCalcularPagoMensual_CeroHoras() {
        Profesor profe = new Profesor("Pedro", 301234567, "01/01/1990", "Calle 50",
                                      10987654, "Historia", 40000, 0);
        double esperado = 0.0;
        double resultado = Salario.calcularPagoMensual(profe);

        assertEquals(esperado, resultado, 0.001, "El cálculo con cero horas debe ser 0");
    }
}

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
import java.util.List;

/**
 *
 * @author oeara
 */
public class MenulogicTest {
    private Menulogic menu;

    @BeforeEach
    public void setUp() {
        menu = new Menulogic();
    }

    @Test
    public void testAgregarEstudiante() {
        Estudiantes e = new Estudiantes("Ana", 300111222, "01/01/2000", "Calle 1");
        menu.agregarEstudiante(e);

        List<Estudiantes> lista = menu.getEstudiantes();
        assertEquals(1, lista.size());
        assertEquals("Ana", lista.get(0).getNombre());
    }

    @Test
    public void testAgregarProfesor() {
        Profesor p = new Profesor("Carlos", 300555777, "05/05/1985", "Calle 2", 101, "Física", 40000, 40);
        p.setPagoTotal(Salario.calcularPagoMensual(p));
        p.setPrestaciones(Salario.calcularPrestaciones(p));

        menu.agregarProfesor(p);

        List<Profesor> lista = menu.getProfesores();
        assertEquals(1, lista.size());
        assertEquals("Carlos", lista.get(0).getNombre());
        assertEquals(1_920_000, lista.get(0).getPagoTotal(), 0.001);
    }

    @Test
    public void testObtenerProfesoresOrdenadosPorSalario() {
        Profesor p1 = new Profesor("Laura", 301111111, "01/01/1980", "Calle A", 111, "Mate", 40000, 40);
        p1.setPagoTotal(Salario.calcularPagoMensual(p1));

        Profesor p2 = new Profesor("Pedro", 302222222, "02/02/1985", "Calle B", 222, "Arte", 40000, 20);
        p2.setPagoTotal(Salario.calcularPagoMensual(p2));

        menu.agregarProfesor(p1);
        menu.agregarProfesor(p2);

        List<Profesor> ordenados = menu.obtenerProfesoresOrdenadosPorSalario();

        // El profesor con menos horas debe ir primero
        assertEquals("Pedro", ordenados.get(0).getNombre());
        assertEquals("Laura", ordenados.get(1).getNombre());
    }

    @Test
    public void testCalcularTotalPrestaciones() {
        Profesor p1 = new Profesor("Laura", 301111111, "01/01/1980", "Calle A", 111, "Mate", 40000, 40);
        Profesor p2 = new Profesor("Pedro", 302222222, "02/02/1985", "Calle B", 222, "Arte", 40000, 20);

        double pago1 = Salario.calcularPagoMensual(p1);
        double pago2 = Salario.calcularPagoMensual(p2);

        p1.setPagoTotal(pago1);
        p2.setPagoTotal(pago2);

        p1.setPrestaciones(pago1 * 0.17);
        p2.setPrestaciones(pago2 * 0.17);

        menu.agregarProfesor(p1);
        menu.agregarProfesor(p2);

        double totalEsperado = (pago1 * 0.17) + (pago2 * 0.17);
        double totalObtenido = menu.calcularTotalPrestaciones();

        assertEquals(totalEsperado, totalObtenido, 0.001, "El total de prestaciones no coincide");
    }    
}

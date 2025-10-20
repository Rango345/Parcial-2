/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
/**
 *
 * @author oeara
 */
public class ProgrmaTest {
     private Menulogic menu;

    @BeforeEach
    public void setUp() {
        menu = new Menulogic();
    }

    @Test
    public void testFlujoCompletoPrograma() {
       
        Estudiantes e1 = new Estudiantes("Laura", 300111222, "01/01/2000", "Calle 10");
        Estudiantes e2 = new Estudiantes("Carlos", 300222333, "05/05/2001", "Calle 20");
        menu.agregarEstudiante(e1);
        menu.agregarEstudiante(e2);

        assertEquals(2, menu.getEstudiantes().size(), "Debe haber 2 estudiantes registrados");

        Profesor p1 = new Profesor("Marta", 311000000, "10/10/1980", "Av. 30", 
                1001, "Matemáticas", 40000, 40);
        double pago1 = Salario.calcularPagoMensual(p1);
        double prestaciones1 = pago1 * 0.17;
        p1.setPagoTotal(pago1);
        p1.setPrestaciones(prestaciones1);

        menu.agregarProfesor(p1);

        Profesor p2 = new Profesor("Juan", 322000000, "15/08/1978", "Av. 40", 
                1002, "Física", 40000, 40);
        double pago2 = Salario.calcularPagoMensual(p2, 5); 
        double prestaciones2 = pago2 * 0.17;
        p2.setHorasDictadas(p2.getHorasDictadas() + 5);
        p2.setPagoTotal(pago2);
        p2.setPrestaciones(prestaciones2);

        menu.agregarProfesor(p2);

        assertEquals(1_920_000, p1.getPagoTotal(), 0.001, "Pago profesor sin horas extra incorrecto");
        assertEquals(2_160_000, p2.getPagoTotal(), 0.001, "Pago profesor con horas extra incorrecto");

        assertEquals(326_400, p1.getPrestaciones(), 0.001, "Prestaciones p1 incorrectas");
        assertEquals(367_200, p2.getPrestaciones(), 0.001, "Prestaciones p2 incorrectas");

        
        List<Profesor> listaProfes = menu.getProfesores();
        assertEquals(2, listaProfes.size(), "Debe haber 2 profesores registrados");

        List<Profesor> ordenados = menu.obtenerProfesoresOrdenadosPorSalario();
        assertEquals("Marta", ordenados.get(0).getNombre(), "El profesor con menor salario debe ir primero");
        assertEquals("Juan", ordenados.get(1).getNombre(), "El profesor con mayor salario debe ir después");

        double totalEsperado = p1.getPrestaciones() + p2.getPrestaciones();
        double totalObtenido = menu.calcularTotalPrestaciones();

        assertEquals(totalEsperado, totalObtenido, 0.001, "El total de prestaciones no coincide");


        String info1 = p1.mostrarInformacion();
        assertTrue(info1.contains("Marta"));
        assertTrue(info1.contains("Pago mensual total"));
        assertTrue(info1.contains("Prestaciones"));


        assertEquals(45, p2.getHorasDictadas(), "Las horas dictadas no sumaron las horas extra");
    }
    
}

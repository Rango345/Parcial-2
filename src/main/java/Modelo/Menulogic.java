/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import java.util.ArrayList;
import java.util.Comparator;
/**
 *
 * @author oeara
 */
public class Menulogic {
     private ArrayList<Estudiantes> listaEstudiantes = new ArrayList<>();
    private ArrayList<Profesor> listaProfesores = new ArrayList<>();

    // === Métodos de estudiantes ===
    public void agregarEstudiante(Estudiantes e) {
        listaEstudiantes.add(e);
    }

    public ArrayList<Estudiantes> getEstudiantes() {
        return listaEstudiantes;
    }

    // === Métodos de profesores ===
    public void agregarProfesor(Profesor p) {
        listaProfesores.add(p);
    }

    public ArrayList<Profesor> getProfesores() {
        return listaProfesores;
    }

    // === Reporte de profesores ordenado por salario ===
    public ArrayList<Profesor> obtenerProfesoresOrdenadosPorSalario() {
        ArrayList<Profesor> copia = new ArrayList<>(listaProfesores);
        copia.sort(Comparator.comparingDouble(Profesor::getPagoTotal));
        return copia;
    }

    // === Total de prestaciones ===
    public double calcularTotalPrestaciones() {
        double total = 0;
        for (Profesor p : listaProfesores) {
            total += p.getPrestaciones();
        }
        return total;
    }
    
}

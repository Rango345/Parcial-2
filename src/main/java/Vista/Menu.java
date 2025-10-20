/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;
import Modelo.Estudiantes;
import Modelo.Personas;
import Modelo.Profesor;
import Modelo.Salario;
import javax.swing.JOptionPane;
import java.util.ArrayList;

/**
 *
 * @author oeara
 */
public class Menu {
        private Personas persona;
        private ArrayList<Estudiantes> listaEstudiantes = new ArrayList<>();
        private ArrayList<Profesor> listaProfesores = new ArrayList<>();

    public void iniciar() {
        int opcion;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(
                "MENÚ \n" +
                "1. Agregar estudiante\n" +
                "2. Agrefar profesor\n" +
                "3. Lista de estudiantes\n" +
                "4. Lista de profesores\n" +
                "5. Salir\n\n" +
                "Elija una opción:"
            ));
            
             switch (opcion) {
                 case 1:
                        agregarPersona();
                        break;
                case 2:
                       agregarProfesor();
                       break;
                case 3:
                      mostrarEstudiantes();
                      break;
                case 4:
                     mostrarProfesores();
                     break;
                case 5:
                    JOptionPane.showMessageDialog(null, "Saliendo del sistema");
                    break;
                    
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida");
                    break;
            }
        } while (opcion != 5);
    
    }


            private void agregarPersona() {
            String nombre = JOptionPane.showInputDialog("Nombre del estudiante:");

            int telefono = -1;
            while (true) {
                try {
                    telefono = Integer.parseInt(
                        JOptionPane.showInputDialog("Ingrese el telefono: ") );
                    break; 
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Debe ingresar un número válido.");
                }
            }
            
            String nacimiento = JOptionPane.showInputDialog("Fecha de nacimiento (dd/mm/aaaa): ");
            
            String direccion = JOptionPane.showInputDialog("Direccion del estudiante: ");
            
            
            Estudiantes estudiante = new Estudiantes (nombre, telefono, nacimiento, direccion);
            listaEstudiantes.add(estudiante);

            JOptionPane.showMessageDialog(null, "Estudiante agregado correctamente");
           }
            
            private void agregarProfesor() {
            String nombre = JOptionPane.showInputDialog("Nombre del profesor:");

            int telefono = -1;
            while (true) {
                try {
                    telefono = Integer.parseInt(
                        JOptionPane.showInputDialog("Ingrese el telefono: ") );
                    break; 
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Debe ingresar un número válido.");
                }
            }
            
            String nacimiento = JOptionPane.showInputDialog("Fecha de nacimiento (dd/mm/aaaa): ");
            
            String direccion = JOptionPane.showInputDialog("Direccion del profesor: ");
            
            int cedula = -1;
            while (true) {
                try {
                    cedula = Integer.parseInt(
                        JOptionPane.showInputDialog("Ingrese el numero de cedula: ") );
                    break; 
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Debe ingresar un número válido.");
                }
            }
            
            String area = JOptionPane.showInputDialog("En que area trabaja:");
            
            int salarioHora = -1;
            while (true) {
                try {
                    salarioHora = Integer.parseInt(
                        JOptionPane.showInputDialog("Ingrese cuanto cobra la hora de clase: ") );
                    break; 
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Debe ingresar un número válido.");
                }
            }
            
            int horasDictadas = -1;
            while (true) {
                try {
                    horasDictadas = Integer.parseInt(
                        JOptionPane.showInputDialog("Ingrese cuantas horas de clase da: ") );
                    break; 
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Debe ingresar un número válido.");
                }
            }            
            Profesor profe = new Profesor (nombre, telefono, nacimiento, direccion, cedula, area,salarioHora,horasDictadas );
           int respuesta = JOptionPane.showConfirmDialog(null,
           "¿El profesor tiene horas extra?", "Horas extra", JOptionPane.YES_NO_OPTION);

          double pagoFinal;
            if (respuesta == JOptionPane.YES_OPTION) {
            int horasExtra = Integer.parseInt(JOptionPane.showInputDialog("¿Cuántas horas extra trabajó?"));
            pagoFinal = Salario.calcularPagoMensual(profe, horasExtra); 
            profe.setHorasDictadas(profe.getHorasDictadas() + horasExtra);
            } else {
            pagoFinal = Salario.calcularPagoMensual(profe);
             }
           double prestaciones = pagoFinal * 0.17;
           
           profe.setPagoTotal(pagoFinal);
           profe.setPrestaciones(prestaciones);
           
          listaProfesores.add(profe);    
          JOptionPane.showMessageDialog(null, "Profesor agregado correctamente");
           
     }
            
            public void mostrarEstudiantes(){
                if (listaEstudiantes.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No hay estudiantes registrados.");
                 } else {
                 StringBuilder mensaje = new StringBuilder("Lista de Estudiantes:\n\n");

                   for (Estudiantes e : listaEstudiantes) {
                  mensaje.append(e.mostrarInformacion()).append("\n-----------------------\n");
                    }

                   JOptionPane.showMessageDialog(null, mensaje.toString());
               } 
            }
            
             public void mostrarProfesores(){
                  if (listaProfesores.isEmpty()) {
                  JOptionPane.showMessageDialog(null, "No hay profesores registrados.");
                  return;
                  }

    
                  listaProfesores.sort((p1, p2) -> {
                   double salario1 = Salario.calcularPagoMensual(p1);
                   double salario2 = Salario.calcularPagoMensual(p2);
                   return Double.compare(salario1, salario2);
                   });

    
                  StringBuilder mensaje = new StringBuilder("Reporte de profesores \n\n");
                  double totalPrestaciones = 0;
                      for (Profesor p : listaProfesores) {
                      double prestaciones = Salario.calcularPrestaciones(p);
                      totalPrestaciones += prestaciones;

                      mensaje.append(p.mostrarInformacion())
                       .append("\n---------------------------------\n");
                     }

                  mensaje.append("\n TOTAL DE PRESTACIONES SOCIALES: ").append(totalPrestaciones);

                  JOptionPane.showMessageDialog(null, mensaje.toString());
                 
                 }    
                
}


    

            








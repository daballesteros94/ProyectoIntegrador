package Accenture.java.basics;

import java.io.IOException;
import java.util.Scanner;
public class Postwork1 {

    public static void main(String[] args) throws IOException {

        String Mensaje = "" ;
        short Opcion;

        System.out.println("selecciona una de las siguientes opciones: ");
        System.out.println("  1.Crear nueva lista de tareas");
        System.out.println("  2.Ver listas de tareas");
        System.out.println("  3.Ver tareas de lista");
        System.out.println("  4.Actualizar lista de tareas.");
        System.out.println("  5.Eliminar lista de tareas");
        System.out.println("  6.Salir");
        System.out.println();
        System.out.print("Opcion: ");


        Scanner s = new Scanner(System.in);
        int leer = s.nextInt();
        Opcion = (short)leer;

        switch (Opcion){
            case 1:
                Mensaje="1.Crear nueva lista de tareas";
                break;
            case 2:
                Mensaje="2.Ver listas de tareas";
                break;
            case 3:
                Mensaje="3.Ver tareas de lista";
                break;
            case 4:
                Mensaje="4.Actualizar lista de tareas.";
                break;
            case 5:
                Mensaje="5.Eliminar lista de tareas";
                break;
            default:
        }

        System.out.println("La opción seleccionada es : " + Mensaje);
        System.out.println("\nEn construcción..");
    }
}

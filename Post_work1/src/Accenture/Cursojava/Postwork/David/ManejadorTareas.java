package Accenture.Cursojava.Postwork.David;

import Accenture.Cursojava.Modelo.ListaTareas;
import Accenture.Cursojava.Modelo.Tarea;

import java.time.LocalDate;

public class ManejadorTareas {

    private final Lector lector = new Lector();

    public Tarea nuevaTarea(){
        System.out.println("Nueva Tarea");
        System.out.println("Introduce los datos de la nueva tarea: ");
        System.out.println("Nombre:");
        String nombreTarea = lector.leeCadena();
        return new Tarea(nombreTarea);
    }

    public Tarea eliminaTarea(ListaTareas listaTareas){
        System.out.println("Eliminar tarea");

        System.out.println("Introduce el indice de la tarea a eliminar");
        byte index = lector.leeOpcion();

        if ( index > listaTareas.numeroTareas()){
            System.out.println("La tarea seleccionada no existe");
            return null;
        }
        return listaTareas.eliminaTarea((index-1));
    }

    public Tarea marcarTareaFinal(ListaTareas listaTareas){
        System.out.println("Finalizar tarea");

        System.out.println("Indica el indice de la tarea a marcar");
        byte index = lector.leeOpcion();

        if ( index > listaTareas.numeroTareas()){
            System.out.println("La tarea indicada no existe");
            return null;
        }

        Tarea tarea = listaTareas.getTareas().get(index-1);
        tarea.setFechaRealizacion(LocalDate.now());
        tarea.setRealizada(true);
        return  tarea;
    }
}

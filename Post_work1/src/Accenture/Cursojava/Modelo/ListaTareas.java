package Accenture.Cursojava.Modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ListaTareas implements Serializable {

    public String nombre;
    public final LocalDate fechaCreacion;
    private final List<Tarea> tareas = new ArrayList<>();


    {
        fechaCreacion=LocalDate.now();
    }

    public ListaTareas(String nombre){
        this.nombre=nombre;
    }

    public void agregarTarea(Tarea tarea){
        tareas.add(tarea);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public Tarea eliminaTarea (int index){
        if (index > tareas.size()){
            System.out.println("La tarea no se encuentra en la lista.");
            return null;
        }
        return tareas.remove(index);
    }

    public List<Tarea> getTareas() {
        return tareas;
    }

    public int numeroTareas(){
        return tareas.size();
    }

    public void muestraTareas(){
        for(int i=0; i<tareas.size();i++){
            Tarea tarea = tareas.get(i);
            System.out.println((i+1) + " >> " + tareas.get(i).getNombre() + " [" + (tarea.isRealizada() ? "x" : "") + "] " + (tarea.isRealizada() ? tarea.getFechaRealizacion() : ""));
        }
    }

}

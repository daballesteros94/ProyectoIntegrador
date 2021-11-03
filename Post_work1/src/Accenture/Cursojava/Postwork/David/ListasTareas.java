package Accenture.Cursojava.Postwork.David;

import Accenture.Cursojava.Modelo.ListaTareas;
import Accenture.Cursojava.Modelo.Tarea;

import java.io.*;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class ListasTareas {

    private Lector l1 = new Lector();
    private Menu menu = new Menu();

    private ManejadorTareas manejadorTareas = new ManejadorTareas();
    private List<ListaTareas> listasTareas = new ArrayList<>();

    private static final String NOMBRE_ARCHIVO = System.getProperty("user.home")+"/Documents/Curso_java/Sesion01/Post_work1/.tareas";

    public ListasTareas() throws Exception{
        cargaTareas();
    }

    public void crearNuevaLista(){
            System.out.println("Crear nueva lista de tareas.");
            String nombre = l1.leeCadena();
            ListaTareas lista = new ListaTareas(nombre);
            listasTareas.add(lista);
    }

    public void verListaTareas(){
            System.out.println("Ver Lista de tareas");

            if ( !validaExistList()){
                return;
            }
            for (int i = 0; i<listasTareas.size(); i++){
                System.out.printf("%d >> %s%n" ,(i+1) , listasTareas.get(i).getNombre());
            }
    }

    public void verTareasDeLista(){
        System.out.println("Ver tareas de lista.");
        byte index = validaIndex();

        if (index == 0){
            return;
        }
        ListaTareas listat = listasTareas.get((index-1));
        if (listat.numeroTareas() == 0){
            System.out.println("Lista vacia");
        }
        listat.muestraTareas();
    }

    public void actualizarListaDeTareas(){
        System.out.println("Actualizar lista de tareas.");
        byte index = validaIndex();
        if(index == 0 ){
            return;
        }
        ListaTareas listaActual = listasTareas.get(index-1);
        menu.muestraOpcionesTarea();
        byte opcionselc = l1.leeOpcion();
        switch (opcionselc){
            case 1:
                Tarea t1 = manejadorTareas.nuevaTarea();
                listaActual.agregarTarea(t1);
                break;
            case 2:
                Tarea t2 = manejadorTareas.eliminaTarea(listaActual);
                if (t2 != null){
                    System.out.println("Se elimino la tarea " + t2.getNombre());
                }
                else {
                    System.out.println("No se pudo eliminar la tarea");
                }
                break;
            case 3:
                Tarea t3 = manejadorTareas.marcarTareaFinal(listaActual);
                if (t3 != null){
                    System.out.printf("La tarea %s se completo el %2$td %2$tb, %2$tY\n", t3.getNombre(), t3.getFechaRealizacion());
                }
                else {
                    System.out.println("La tarea no se pudo marcar como finalizada");
                }
                break;
            case 4:
                break;
            default:
                System.out.println("La opcion seleccionada es Invalida");
        }
    }

    public void eliminarListaDeTareas(){
        System.out.println("Eliminar lista de tareas.");
        byte index = validaIndex();
        if(index == 0 ){
            return;
        }
        ListaTareas listaElim = listasTareas.remove((index-1));
        System.out.println("Se elimino la lista de tareas " + listaElim.getNombre());
    }


    private boolean validaExistList() {
        if (listasTareas == null || listasTareas.isEmpty()){
            System.out.println("Aun no se ha creado ninguna lista de tareas.");
            return false;
        }
        return true;
    }

    private byte validaIndex(){
        byte index = 0;

        if(!validaExistList()){
            return index;
        }

        System.out.println("Indique el indice de la lista de tareas");
        index=l1.leeOpcion();

        if (index > listasTareas.size() || index < 0){
            System.out.println("No existe una lista de tareas con el indice seleccionado");
            index=0;
        }
        return index;
    }

    public void cargaTareas() throws Exception {
        if (new File(NOMBRE_ARCHIVO).exists()) {
            ObjectInputStream obis = new ObjectInputStream(new FileInputStream(NOMBRE_ARCHIVO));
            listasTareas = (List<ListaTareas>) obis.readObject();
        }
    }

    public void guardarTareas() throws Exception{
        ObjectOutputStream obos = new ObjectOutputStream(new FileOutputStream(NOMBRE_ARCHIVO));
        obos.writeObject(listasTareas);
    }
}

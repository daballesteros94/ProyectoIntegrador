package Accenture.Cursojava.Modelo;

import java.io.Serializable;
import java.time.LocalDate;

public class Tarea implements Serializable {

    public Tarea (String nombre){
        this.nombre=nombre;
    }

    private String nombre;
    private final LocalDate fechaCreacion;
    private LocalDate fechaExpiracion;
    private LocalDate fechaRealizacion;
    private boolean realizada;

    {
        fechaCreacion=LocalDate.now();
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


    public LocalDate getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(LocalDate fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    public LocalDate getFechaRealizacion() {
        return fechaRealizacion;
    }

    public void setFechaRealizacion(LocalDate fechaRealizacion) {
        this.fechaRealizacion = fechaRealizacion;
    }

    public boolean getRealizada() {
        return realizada;
    }

    public void setRealizada(boolean realizada) {
        this.realizada = realizada;
    }

    @Override
    public int hashCode(){
        int hash=0;
        hash = nombre.hashCode();
        return hash;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tarea tarea = (Tarea) o;

        return nombre.equals(tarea.nombre);
    }

    public boolean isRealizada(){
        return realizada;
    }
}

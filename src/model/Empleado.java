//CLASE ELEGIDA: "EMPLEADO"
package model;

import java.time.LocalDate;

public class Empleado {
    private String nombre;
    private String apellido;
    private LocalDate fNac;
    private double salario;

    //Creación de Primer Constructor:
    public Empleado() {
    }

    public Empleado(String nombre) {
        this.nombre = nombre;
    }
    
    //Creación de Segundo Constructor: 
    public Empleado(String nombre, String apellido, LocalDate fNac, double salario) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fNac = fNac;
        this.salario = salario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public LocalDate getfNac() {
        return fNac;
    }

    public void setfNac(LocalDate fNac) {
        this.fNac = fNac;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Empleado{" + "nombre=" + nombre + ", apellido=" + apellido + ", fNac=" + fNac + ", salario=" + salario + '}';
    }
    
}

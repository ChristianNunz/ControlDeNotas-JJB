/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica_Negocios;

/**
 *
 * @author Jorge Villanueva
 */
public class Seccion {
    private int id_seccion;
    private String nombre_seccion;
    private int id_materia;
    private int id_turno;

    public Seccion(int id_seccion, String nombre_seccion, int id_materia, int id_turno) {
        this.id_seccion = id_seccion;
        this.nombre_seccion = nombre_seccion;
        this.id_materia = id_materia;
        this.id_turno = id_turno;
    }

    public int getId_seccion() {
        return id_seccion;
    }

    public void setId_seccion(int id_seccion) {
        this.id_seccion = id_seccion;
    }

    public String getNombre_seccion() {
        return nombre_seccion;
    }

    public void setNombre_seccion(String nombre_seccion) {
        this.nombre_seccion = nombre_seccion;
    }

    public int getId_materia() {
        return id_materia;
    }

    public void setId_materia(int id_materia) {
        this.id_materia = id_materia;
    }

    public int getId_turno() {
        return id_turno;
    }

    public void setId_turno(int id_turno) {
        this.id_turno = id_turno;
    }
    
    
}

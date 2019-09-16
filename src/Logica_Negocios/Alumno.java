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
public class Alumno {

    private int id_alumno;
    private String nombre;
    private String apellido;
    private String direccion;
    private String tel;
    private String nie;
    private String fecha;
    private int genero;
    
    public Alumno(int id_alumno, String nombre, String apellido, String direccion, String tel, String nie, String fecha, int genero) {
        this.id_alumno = id_alumno;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.tel = tel;
        this.nie = nie;
        this.fecha = fecha;
        this.genero = genero;
    }
    
    public int getId_alumno() {
        return id_alumno;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTel() {
        return tel;
    }

    public String getNie() {
        return nie;
    }

    public String getFecha() {
        return fecha;
    }

    public int getGenero() {
        return genero;
    }

    public void setId_alumno(int id_alumno) {
        this.id_alumno = id_alumno;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setNie(String nie) {
        this.nie = nie;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setGenero(int genero) {
        this.genero = genero;
    }

}

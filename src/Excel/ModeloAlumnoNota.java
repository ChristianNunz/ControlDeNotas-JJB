/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excel;

/**
 *
 * @author Jorge Villanueva
 */
public class ModeloAlumnoNota {
    private String Nombre;
    private String Apellido;
    private double Nota1;
    private double Nota2;
    private double Nota3;

    public ModeloAlumnoNota(String Nombre, String Apellido, double Nota1, double Nota2, double Nota3) {
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Nota1 = Nota1;
        this.Nota2 = Nota2;
        this.Nota3 = Nota3;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public double getNota1() {
        return Nota1;
    }

    public double getNota2() {
        return Nota2;
    }

    public double getNota3() {
        return Nota3;
    }
    
    
}

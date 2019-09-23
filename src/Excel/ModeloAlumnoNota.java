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
    private String Nota1;
    private String Nota2;
    private String Nota3;

    public ModeloAlumnoNota(String Nombre, String Apellido, String Nota1, String Nota2, String Nota3) {
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

    public String getNota1() {
        return Nota1;
    }

    public String getNota2() {
        return Nota2;
    }

    public String getNota3() {
        return Nota3;
    }
    
    
}

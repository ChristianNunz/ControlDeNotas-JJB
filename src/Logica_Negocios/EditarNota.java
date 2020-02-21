/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica_Negocios;

/**
 *
 * @author Diego Huete
 */
public class EditarNota {
    private String Id;
    private String Nombre;
    private String Apellido;
    private double Nota1;
    private double Nota2;
    private double Nota3;
    private String Estado;

    public EditarNota(String Id, String Nombre, String Apellido, double Nota1, double Nota2, double Nota3) {
        this.Id = Id;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Nota1 = Nota1;
        this.Nota2 = Nota2;
        this.Nota3 = Nota3;
    }

    public EditarNota(String Id, String Nombre, String Apellido, String Estado) {
        this.Id = Id;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Estado = Estado;
    }

    public Boolean getEstado() {
        if(Estado.equals("1")){
            return true;
        }else{
            return false;
        }
      
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }    

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public double getNota1() {
        return Nota1;
    }

    public void setNota1(double Nota1) {
        this.Nota1 = Nota1;
    }

    public double getNota2() {
        return Nota2;
    }

    public void setNota2(double Nota2) {
        this.Nota2 = Nota2;
    }

    public double getNota3() {
        return Nota3;
    }

    public void setNota3(double Nota3) {
        this.Nota3 = Nota3;
    }
    
    
    
}

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
public class Nota {
    private int id_nota;
    private int id_alumno;
    private int id_materia;

    public Nota(int id_nota, int id_alumno, int id_materia) {
        this.id_nota = id_nota;
        this.id_alumno = id_alumno;
        this.id_materia = id_materia;
    }

    public int getId_nota() {
        return id_nota;
    }

    public void setId_nota(int id_nota) {
        this.id_nota = id_nota;
    }

    public int getId_alumno() {
        return id_alumno;
    }

    public void setId_alumno(int id_alumno) {
        this.id_alumno = id_alumno;
    }

    public int getId_materia() {
        return id_materia;
    }

    public void setId_materia(int id_materia) {
        this.id_materia = id_materia;
    }
    
    
}

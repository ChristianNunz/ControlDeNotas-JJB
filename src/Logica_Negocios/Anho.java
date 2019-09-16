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
public class Anho {
    private int id_anho;
    private String anho;
    private int id_materia;

    public Anho(int id_anho, String anho, int id_materia) {
        this.id_anho = id_anho;
        this.anho = anho;
        this.id_materia = id_materia;
    }

    public int getId_anho() {
        return id_anho;
    }

    public void setId_anho(int id_anho) {
        this.id_anho = id_anho;
    }

    public String getAnho() {
        return anho;
    }

    public void setAnho(String anho) {
        this.anho = anho;
    }

    public int getId_materia() {
        return id_materia;
    }

    public void setId_materia(int id_materia) {
        this.id_materia = id_materia;
    }
    
    
}

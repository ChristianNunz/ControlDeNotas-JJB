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
public class Turno {
    private int id_turno;
    private String turno_nombre;

    public Turno(int id_turno, String turno_nombre) {
        this.id_turno = id_turno;
        this.turno_nombre = turno_nombre;
    }

    public int getId_turno() {
        return id_turno;
    }
    public void setId_turno(int id_turno) {
        this.id_turno = id_turno;
    }

    public String getTurno_nombre() {
        return turno_nombre;
    }

    public void setTurno_nombre(String turno_nombre) {
        this.turno_nombre = turno_nombre;
    }
    
    
}

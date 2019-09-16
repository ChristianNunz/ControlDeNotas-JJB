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
public class Rol {
   private int id_rol;
   private String rol_nombre;

    public Rol(int id_rol, String rol_nombre) {
        this.id_rol = id_rol;
        this.rol_nombre = rol_nombre;
    }

    public int getId_rol() {
        return id_rol;
    }

    public void setId_rol(int id_rol) {
        this.id_rol = id_rol;
    }

    public String getRol_nombre() {
        return rol_nombre;
    }

    public void setRol_nombre(String rol_nombre) {
        this.rol_nombre = rol_nombre;
    }
   
    
}

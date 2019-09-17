/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acceso_Datos;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



/**
 *
 * @author Jorge Villanueva
 */
public class entityMain {
    private static final EntityManagerFactory ent = Persistence.createEntityManagerFactory("GestiondeNotas");
    
    public entityMain(){
    }
    public static EntityManagerFactory getInstance(){
        return ent;
    }
}

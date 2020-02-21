/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excel;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Jorge Villanueva
 */
public class ModeloAlumnoResponsable {
    private String Anombre;
    private String Aapellido;
    private String Adireccion;
    private String Atel;
    private String Anie;
    private Date AfechNac;
    private String Agenero;    
    
    private String Rnombre;
    private String Rapellido;
    private String Rdireccion;
    private String RTel;
    private String Rdui;
    private String Rgenero;    

    public ModeloAlumnoResponsable(String Anombre, String Aapellido, String Adireccion, String Atel, Date AfechNac, String Agenero, String Rnombre, String Rapellido, String Rdireccion, String RTel, String Rdui, String Rgenero) {
        this.Anombre = Anombre;
        this.Aapellido = Aapellido;
        this.Adireccion = Adireccion;
        this.Atel = Atel;
        this.AfechNac = AfechNac;
        this.Agenero = Agenero.toUpperCase();
        this.Rnombre = Rnombre;
        this.Rapellido = Rapellido;
        this.Rdireccion = Rdireccion;
        this.RTel = RTel;
        this.Rdui = Rdui;
        this.Rgenero = Rgenero.toUpperCase();
    }

    public String getAnombre() {
        return Anombre;
    }

    public void setAnombre(String Anombre) {
        this.Anombre = Anombre;
    }

    public String getAapellido() {
        return Aapellido;
    }

    public void setAapellido(String Aapellido) {
        this.Aapellido = Aapellido;
    }

    public String getAdireccion() {
        return Adireccion;
    }

    public void setAdireccion(String Adireccion) {
        this.Adireccion = Adireccion;
    }

    public String getAtel() {
        return Atel;
    }

    public void setAtel(String Atel) {
        this.Atel = Atel;
    }

    public String getAnie() {
        return Anie;
    }

    public void setAnie(String Anie) {
        this.Anie = Anie;
    }

    public String getAfechNac() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");                
        return sdf.format(AfechNac);
    }

    public void setAfechNac(Date AfechNac) {
        this.AfechNac = AfechNac;
    }

    public String getAgenero() {
        return Agenero;
    }

    public void setAgenero(String Agenero) {
        this.Agenero = Agenero.toUpperCase();
    }


    public String getRnombre() {
        return Rnombre;
    }

    public void setRnombre(String Rnombre) {
        this.Rnombre = Rnombre;
    }

    public String getRapellido() {
        return Rapellido;
    }

    public void setRapellido(String Rapellido) {
        this.Rapellido = Rapellido;
    }

    public String getRdireccion() {
        return Rdireccion;
    }

    public void setRdireccion(String Rdireccion) {
        this.Rdireccion = Rdireccion;
    }

    public String getRTel() {
        return RTel;
    }

    public void setRTel(String RTel) {
        this.RTel = RTel;
    }

    public String getRdui() {
        return Rdui;
    }

    public void setRdui(String Rdui) {
        this.Rdui = Rdui;
    }

    public String getRgenero() {
        return Rgenero;
    }

    public void setRgenero(String Rgenero) {
        this.Rgenero = Rgenero.toUpperCase();
    }


    
    
    

    

    

    
    
    
    
}

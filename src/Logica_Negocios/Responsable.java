/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica_Negocios;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Jorge Villanueva
 */
@Entity
@Table(name = "RESPONSABLE")
@NamedQueries({
    @NamedQuery(name = "Responsable.findAll", query = "SELECT r FROM Responsable r")})
public class Responsable implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_RESPONSABLE")
    private BigDecimal idResponsable;
    @Basic(optional = false)
    @Column(name = "RESPONSABLE_NOMBRE")
    private String responsableNombre;
    @Basic(optional = false)
    @Column(name = "RESPONSABLE_APELLIDOS")
    private String responsableApellidos;
    @Basic(optional = false)
    @Column(name = "RESPONSABLE_DIRECCION")
    private String responsableDireccion;
    @Basic(optional = false)
    @Column(name = "RESPONSABLE_DUI")
    private String responsableDui;
    @Basic(optional = false)
    @Column(name = "RESPONSABLE_TEL")
    private String responsableTel;
    @Basic(optional = false)
    @Column(name = "RESPONSABLE_ESTADO")
    private BigInteger responsableEstado;
    @Basic(optional = false)
    @Column(name = "RESPONSABLE_GENERO")
    private BigInteger responsableGenero;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEsponsable")
    private List<AlumnoResponsable> alumnoResponsableList;

    public Responsable() {
    }

    public Responsable(BigDecimal idResponsable) {
        this.idResponsable = idResponsable;
    }

    public Responsable(BigDecimal idResponsable, String responsableNombre, String responsableApellidos, String responsableDireccion, String responsableDui, String responsableTel, BigInteger responsableEstado, BigInteger responsableGenero) {
        this.idResponsable = idResponsable;
        this.responsableNombre = responsableNombre;
        this.responsableApellidos = responsableApellidos;
        this.responsableDireccion = responsableDireccion;
        this.responsableDui = responsableDui;
        this.responsableTel = responsableTel;
        this.responsableEstado = responsableEstado;
        this.responsableGenero = responsableGenero;
    }

    public BigDecimal getIdResponsable() {
        return idResponsable;
    }

    public void setIdResponsable(BigDecimal idResponsable) {
        this.idResponsable = idResponsable;
    }

    public String getResponsableNombre() {
        return responsableNombre;
    }

    public void setResponsableNombre(String responsableNombre) {
        this.responsableNombre = responsableNombre;
    }

    public String getResponsableApellidos() {
        return responsableApellidos;
    }

    public void setResponsableApellidos(String responsableApellidos) {
        this.responsableApellidos = responsableApellidos;
    }

    public String getResponsableDireccion() {
        return responsableDireccion;
    }

    public void setResponsableDireccion(String responsableDireccion) {
        this.responsableDireccion = responsableDireccion;
    }

    public String getResponsableDui() {
        return responsableDui;
    }

    public void setResponsableDui(String responsableDui) {
        this.responsableDui = responsableDui;
    }

    public String getResponsableTel() {
        return responsableTel;
    }

    public void setResponsableTel(String responsableTel) {
        this.responsableTel = responsableTel;
    }

    public BigInteger getResponsableEstado() {
        return responsableEstado;
    }

    public void setResponsableEstado(BigInteger responsableEstado) {
        this.responsableEstado = responsableEstado;
    }

    public BigInteger getResponsableGenero() {
        return responsableGenero;
    }

    public void setResponsableGenero(BigInteger responsableGenero) {
        this.responsableGenero = responsableGenero;
    }

    public List<AlumnoResponsable> getAlumnoResponsableList() {
        return alumnoResponsableList;
    }

    public void setAlumnoResponsableList(List<AlumnoResponsable> alumnoResponsableList) {
        this.alumnoResponsableList = alumnoResponsableList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idResponsable != null ? idResponsable.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Responsable)) {
            return false;
        }
        Responsable other = (Responsable) object;
        if ((this.idResponsable == null && other.idResponsable != null) || (this.idResponsable != null && !this.idResponsable.equals(other.idResponsable))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Logica_Negocios.Responsable[ idResponsable=" + idResponsable + " ]";
    }
    
}

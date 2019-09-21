/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica_Negocios;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Jorge Villanueva
 */
@Entity
@Table(name = "ALUMNO_RESPONSABLE")
@NamedQueries({
    @NamedQuery(name = "AlumnoResponsable.findAll", query = "SELECT a FROM AlumnoResponsable a")})
public class AlumnoResponsable implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_ALUMNO_RESPONSABLE")
    private BigDecimal idAlumnoResponsable;
    @JoinColumn(name = "ID_ALUMNO", referencedColumnName = "ID_ALUMNO")
    @ManyToOne(optional = false)
    private Alumno idAlumno;
    @JoinColumn(name = "ID_ESPONSABLE", referencedColumnName = "ID_RESPONSABLE")
    @ManyToOne(optional = false)
    private Responsable idEsponsable;

    public AlumnoResponsable() {
    }

    public AlumnoResponsable(BigDecimal idAlumnoResponsable) {
        this.idAlumnoResponsable = idAlumnoResponsable;
    }

    public BigDecimal getIdAlumnoResponsable() {
        return idAlumnoResponsable;
    }

    public void setIdAlumnoResponsable(BigDecimal idAlumnoResponsable) {
        this.idAlumnoResponsable = idAlumnoResponsable;
    }

    public Alumno getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Alumno idAlumno) {
        this.idAlumno = idAlumno;
    }

    public Responsable getIdEsponsable() {
        return idEsponsable;
    }

    public void setIdEsponsable(Responsable idEsponsable) {
        this.idEsponsable = idEsponsable;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAlumnoResponsable != null ? idAlumnoResponsable.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AlumnoResponsable)) {
            return false;
        }
        AlumnoResponsable other = (AlumnoResponsable) object;
        if ((this.idAlumnoResponsable == null && other.idAlumnoResponsable != null) || (this.idAlumnoResponsable != null && !this.idAlumnoResponsable.equals(other.idAlumnoResponsable))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Logica_Negocios.AlumnoResponsable[ idAlumnoResponsable=" + idAlumnoResponsable + " ]";
    }
    
}

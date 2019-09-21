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
@Table(name = "DOCENTE_MATERIA")
@NamedQueries({
    @NamedQuery(name = "DocenteMateria.findAll", query = "SELECT d FROM DocenteMateria d")})
public class DocenteMateria implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_DOCENTE_MATERIA")
    private BigDecimal idDocenteMateria;
    @JoinColumn(name = "ID_DOCENTE", referencedColumnName = "ID_DOCENTE")
    @ManyToOne(optional = false)
    private Docente idDocente;
    @JoinColumn(name = "ID_MATERIA", referencedColumnName = "ID_MATERIA")
    @ManyToOne(optional = false)
    private Materia idMateria;

    public DocenteMateria() {
    }

    public DocenteMateria(BigDecimal idDocenteMateria) {
        this.idDocenteMateria = idDocenteMateria;
    }

    public BigDecimal getIdDocenteMateria() {
        return idDocenteMateria;
    }

    public void setIdDocenteMateria(BigDecimal idDocenteMateria) {
        this.idDocenteMateria = idDocenteMateria;
    }

    public Docente getIdDocente() {
        return idDocente;
    }

    public void setIdDocente(Docente idDocente) {
        this.idDocente = idDocente;
    }

    public Materia getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(Materia idMateria) {
        this.idMateria = idMateria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDocenteMateria != null ? idDocenteMateria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DocenteMateria)) {
            return false;
        }
        DocenteMateria other = (DocenteMateria) object;
        if ((this.idDocenteMateria == null && other.idDocenteMateria != null) || (this.idDocenteMateria != null && !this.idDocenteMateria.equals(other.idDocenteMateria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Logica_Negocios.DocenteMateria[ idDocenteMateria=" + idDocenteMateria + " ]";
    }
    
}

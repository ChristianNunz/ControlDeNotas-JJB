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
@Table(name = "MATERIA_GRADO")
@NamedQueries({
    @NamedQuery(name = "MateriaGrado.findAll", query = "SELECT m FROM MateriaGrado m")})
public class MateriaGrado implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_MATERIA_GRADO")
    private BigDecimal idMateriaGrado;
    @JoinColumn(name = "ID_GRADO", referencedColumnName = "ID_GRADO")
    @ManyToOne(optional = false)
    private Grado idGrado;
    @JoinColumn(name = "ID_MATERIA", referencedColumnName = "ID_MATERIA")
    @ManyToOne(optional = false)
    private Materia idMateria;

    public MateriaGrado() {
    }

    public MateriaGrado(BigDecimal idMateriaGrado) {
        this.idMateriaGrado = idMateriaGrado;
    }

    public BigDecimal getIdMateriaGrado() {
        return idMateriaGrado;
    }

    public void setIdMateriaGrado(BigDecimal idMateriaGrado) {
        this.idMateriaGrado = idMateriaGrado;
    }

    public Grado getIdGrado() {
        return idGrado;
    }

    public void setIdGrado(Grado idGrado) {
        this.idGrado = idGrado;
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
        hash += (idMateriaGrado != null ? idMateriaGrado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MateriaGrado)) {
            return false;
        }
        MateriaGrado other = (MateriaGrado) object;
        if ((this.idMateriaGrado == null && other.idMateriaGrado != null) || (this.idMateriaGrado != null && !this.idMateriaGrado.equals(other.idMateriaGrado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Logica_Negocios.MateriaGrado[ idMateriaGrado=" + idMateriaGrado + " ]";
    }
    
}

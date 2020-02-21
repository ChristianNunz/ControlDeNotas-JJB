/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica_Negocios;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "GRADO")
@NamedQueries({
    @NamedQuery(name = "Grado.findAll", query = "SELECT g FROM Grado g")})
public class Grado implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idGrado")
    private List<MateriaGrado> materiaGradoList;
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_GRADO")
    private BigDecimal idGrado;
    @Basic(optional = false)
    @Column(name = "GRADO")
    private String grado;

    public Grado() {
    }

    public Grado(BigDecimal idGrado) {
        this.idGrado = idGrado;
    }

    public Grado(BigDecimal idGrado, String grado) {
        this.idGrado = idGrado;
        this.grado = grado;
    }

    public BigDecimal getIdGrado() {
        return idGrado;
    }

    public void setIdGrado(BigDecimal idGrado) {
        this.idGrado = idGrado;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGrado != null ? idGrado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Grado)) {
            return false;
        }
        Grado other = (Grado) object;
        if ((this.idGrado == null && other.idGrado != null) || (this.idGrado != null && !this.idGrado.equals(other.idGrado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Logica_Negocios.Grado[ idGrado=" + idGrado + " ]";
    }

    public List<MateriaGrado> getMateriaGradoList() {
        return materiaGradoList;
    }

    public void setMateriaGradoList(List<MateriaGrado> materiaGradoList) {
        this.materiaGradoList = materiaGradoList;
    }
    
}

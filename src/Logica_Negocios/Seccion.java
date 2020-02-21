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
@Table(name = "SECCION")
@NamedQueries({
    @NamedQuery(name = "Seccion.findAll", query = "SELECT s FROM Seccion s")})
public class Seccion implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSeccion")
    private List<MateriaGrado> materiaGradoList;
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_SECCION")
    private BigDecimal idSeccion;
    @Basic(optional = false)
    @Column(name = "NOMBRE_SECCION")
    private String nombreSeccion;
    @Basic(optional = false)
    @Column(name = "ESTADO")
    private BigInteger estado;

    public Seccion() {
    }

    public Seccion(BigDecimal idSeccion) {
        this.idSeccion = idSeccion;
    }

    public Seccion(BigDecimal idSeccion, String nombreSeccion, BigInteger estado) {
        this.idSeccion = idSeccion;
        this.nombreSeccion = nombreSeccion;
        this.estado = estado;
    }

    public BigDecimal getIdSeccion() {
        return idSeccion;
    }

    public void setIdSeccion(BigDecimal idSeccion) {
        this.idSeccion = idSeccion;
    }

    public String getNombreSeccion() {
        return nombreSeccion;
    }

    public void setNombreSeccion(String nombreSeccion) {
        this.nombreSeccion = nombreSeccion;
    }

    public BigInteger getEstado() {
        return estado;
    }

    public void setEstado(BigInteger estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSeccion != null ? idSeccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Seccion)) {
            return false;
        }
        Seccion other = (Seccion) object;
        if ((this.idSeccion == null && other.idSeccion != null) || (this.idSeccion != null && !this.idSeccion.equals(other.idSeccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Logica_Negocios.Seccion[ idSeccion=" + idSeccion + " ]";
    }

    public List<MateriaGrado> getMateriaGradoList() {
        return materiaGradoList;
    }

    public void setMateriaGradoList(List<MateriaGrado> materiaGradoList) {
        this.materiaGradoList = materiaGradoList;
    }
    
}

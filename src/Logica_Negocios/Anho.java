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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author chris
 */
@Entity
@Table(name = "ANHO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Anho.findAll", query = "SELECT a FROM Anho a"),
    @NamedQuery(name = "Anho.findByIdAnho", query = "SELECT a FROM Anho a WHERE a.idAnho = :idAnho"),
    @NamedQuery(name = "Anho.findByAnho", query = "SELECT a FROM Anho a WHERE a.anho = :anho")})
public class Anho implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_ANHO")
    private BigDecimal idAnho;
    @Basic(optional = false)
    @Column(name = "ANHO")
    private String anho;
    @JoinColumn(name = "MATERIA_ID_MATERIA", referencedColumnName = "ID_MATERIA")
    @ManyToOne(optional = false)
    private Materia materiaIdMateria;

    public Anho() {
    }

    public Anho(BigDecimal idAnho) {
        this.idAnho = idAnho;
    }

    public Anho(BigDecimal idAnho, String anho) {
        this.idAnho = idAnho;
        this.anho = anho;
    }

    public BigDecimal getIdAnho() {
        return idAnho;
    }

    public void setIdAnho(BigDecimal idAnho) {
        this.idAnho = idAnho;
    }

    public String getAnho() {
        return anho;
    }

    public void setAnho(String anho) {
        this.anho = anho;
    }

    public Materia getMateriaIdMateria() {
        return materiaIdMateria;
    }

    public void setMateriaIdMateria(Materia materiaIdMateria) {
        this.materiaIdMateria = materiaIdMateria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAnho != null ? idAnho.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Anho)) {
            return false;
        }
        Anho other = (Anho) object;
        if ((this.idAnho == null && other.idAnho != null) || (this.idAnho != null && !this.idAnho.equals(other.idAnho))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Logica_Negocios.Anho[ idAnho=" + idAnho + " ]";
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaNegocios;

import Logica_Negocios.Nota;
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
 * @author Jorge Villanueva
 */
@Entity
@Table(name = "PERIODO2")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Periodo2.findAll", query = "SELECT p FROM Periodo2 p"),
    @NamedQuery(name = "Periodo2.findByIdPeriodo2", query = "SELECT p FROM Periodo2 p WHERE p.idPeriodo2 = :idPeriodo2"),
    @NamedQuery(name = "Periodo2.findByNota1", query = "SELECT p FROM Periodo2 p WHERE p.nota1 = :nota1"),
    @NamedQuery(name = "Periodo2.findByNota2", query = "SELECT p FROM Periodo2 p WHERE p.nota2 = :nota2"),
    @NamedQuery(name = "Periodo2.findByNota3", query = "SELECT p FROM Periodo2 p WHERE p.nota3 = :nota3")})
public class Periodo2 implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_PERIODO2")
    private BigDecimal idPeriodo2;
    @Basic(optional = false)
    @Column(name = "NOTA1")
    private BigDecimal nota1;
    @Basic(optional = false)
    @Column(name = "NOTA2")
    private BigDecimal nota2;
    @Basic(optional = false)
    @Column(name = "NOTA3")
    private BigDecimal nota3;
    @JoinColumn(name = "ID_NOTA", referencedColumnName = "ID_NOTA")
    @ManyToOne(optional = false)
    private Nota idNota;

    public Periodo2() {
    }

    public Periodo2(BigDecimal idPeriodo2) {
        this.idPeriodo2 = idPeriodo2;
    }

    public Periodo2(BigDecimal idPeriodo2, BigDecimal nota1, BigDecimal nota2, BigDecimal nota3) {
        this.idPeriodo2 = idPeriodo2;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
    }

    public BigDecimal getIdPeriodo2() {
        return idPeriodo2;
    }

    public void setIdPeriodo2(BigDecimal idPeriodo2) {
        this.idPeriodo2 = idPeriodo2;
    }

    public BigDecimal getNota1() {
        return nota1;
    }

    public void setNota1(BigDecimal nota1) {
        this.nota1 = nota1;
    }

    public BigDecimal getNota2() {
        return nota2;
    }

    public void setNota2(BigDecimal nota2) {
        this.nota2 = nota2;
    }

    public BigDecimal getNota3() {
        return nota3;
    }

    public void setNota3(BigDecimal nota3) {
        this.nota3 = nota3;
    }

    public Nota getIdNota() {
        return idNota;
    }

    public void setIdNota(Nota idNota) {
        this.idNota = idNota;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPeriodo2 != null ? idPeriodo2.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Periodo2)) {
            return false;
        }
        Periodo2 other = (Periodo2) object;
        if ((this.idPeriodo2 == null && other.idPeriodo2 != null) || (this.idPeriodo2 != null && !this.idPeriodo2.equals(other.idPeriodo2))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "LogicaNegocios.Periodo2[ idPeriodo2=" + idPeriodo2 + " ]";
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica_Negocios;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
@Table(name = "PERIODO")
@NamedQueries({
    @NamedQuery(name = "Periodo.findAll", query = "SELECT p FROM Periodo p")})
public class Periodo implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_PERIODO")
    private BigDecimal idPeriodo;
    @Basic(optional = false)
    @Column(name = "NOTA1")
    private BigDecimal nota1;
    @Basic(optional = false)
    @Column(name = "NOTA2")
    private BigDecimal nota2;
    @Basic(optional = false)
    @Column(name = "NOTA3")
    private BigDecimal nota3;
    @Basic(optional = false)
    @Column(name = "ID_LOGIN")
    private BigInteger idLogin;
    @Basic(optional = false)
    @Column(name = "PERIODO")
    private BigInteger periodo;
    @JoinColumn(name = "ID_NOTA", referencedColumnName = "ID_NOTA")
    @ManyToOne(optional = false)
    private Nota idNota;

    public Periodo() {
    }

    public Periodo(BigDecimal idPeriodo) {
        this.idPeriodo = idPeriodo;
    }

    public Periodo(BigDecimal idPeriodo, BigDecimal nota1, BigDecimal nota2, BigDecimal nota3, BigInteger idLogin, BigInteger periodo) {
        this.idPeriodo = idPeriodo;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
        this.idLogin = idLogin;
        this.periodo = periodo;
    }

    public BigDecimal getIdPeriodo() {
        return idPeriodo;
    }

    public void setIdPeriodo(BigDecimal idPeriodo) {
        this.idPeriodo = idPeriodo;
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

    public BigInteger getIdLogin() {
        return idLogin;
    }

    public void setIdLogin(BigInteger idLogin) {
        this.idLogin = idLogin;
    }

    public BigInteger getPeriodo() {
        return periodo;
    }

    public void setPeriodo(BigInteger periodo) {
        this.periodo = periodo;
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
        hash += (idPeriodo != null ? idPeriodo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Periodo)) {
            return false;
        }
        Periodo other = (Periodo) object;
        if ((this.idPeriodo == null && other.idPeriodo != null) || (this.idPeriodo != null && !this.idPeriodo.equals(other.idPeriodo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Logica_Negocios.Periodo[ idPeriodo=" + idPeriodo + " ]";
    }
    
}

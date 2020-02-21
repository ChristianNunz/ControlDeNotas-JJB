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
@Table(name = "TURNO")
@NamedQueries({
    @NamedQuery(name = "Turno.findAll", query = "SELECT t FROM Turno t")})
public class Turno implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTurno")
    private List<MateriaGrado> materiaGradoList;
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_TURNO")
    private BigDecimal idTurno;
    @Basic(optional = false)
    @Column(name = "TURNO_NOMBRE")
    private String turnoNombre;

    public Turno() {
    }

    public Turno(BigDecimal idTurno) {
        this.idTurno = idTurno;
    }

    public Turno(BigDecimal idTurno, String turnoNombre) {
        this.idTurno = idTurno;
        this.turnoNombre = turnoNombre;
    }

    public BigDecimal getIdTurno() {
        return idTurno;
    }

    public void setIdTurno(BigDecimal idTurno) {
        this.idTurno = idTurno;
    }

    public String getTurnoNombre() {
        return turnoNombre;
    }

    public void setTurnoNombre(String turnoNombre) {
        this.turnoNombre = turnoNombre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTurno != null ? idTurno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Turno)) {
            return false;
        }
        Turno other = (Turno) object;
        if ((this.idTurno == null && other.idTurno != null) || (this.idTurno != null && !this.idTurno.equals(other.idTurno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Logica_Negocios.Turno[ idTurno=" + idTurno + " ]";
    }

    public List<MateriaGrado> getMateriaGradoList() {
        return materiaGradoList;
    }

    public void setMateriaGradoList(List<MateriaGrado> materiaGradoList) {
        this.materiaGradoList = materiaGradoList;
    }
    
}

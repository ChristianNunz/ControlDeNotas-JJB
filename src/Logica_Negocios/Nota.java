/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica_Negocios;


import LogicaNegocios.Periodo1;
import LogicaNegocios.Periodo2;
import LogicaNegocios.Periodo3;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Diego Huete
 */
@Entity
@Table(name = "NOTA")
@NamedQueries({
    @NamedQuery(name = "Nota.findAll", query = "SELECT n FROM Nota n")})
public class Nota implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idNota")
    private List<Periodo1> periodo1List;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idNota")
    private List<Periodo3> periodo3List;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idNota")
    private List<Periodo2> periodo2List;

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_NOTA")
    private BigDecimal idNota;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idNota")
    private List<Periodo> periodoList;
    @JoinColumn(name = "ID_ALUMNO", referencedColumnName = "ID_ALUMNO")
    @ManyToOne(optional = false)
    private Alumno idAlumno;
    @JoinColumn(name = "ID_MATERIA_GRADO", referencedColumnName = "ID_MATERIA_GRADO")
    @ManyToOne(optional = false)
    private MateriaGrado idMateriaGrado;

    public Nota() {
    }

    public Nota(BigDecimal idNota) {
        this.idNota = idNota;
    }

    public BigDecimal getIdNota() {
        return idNota;
    }

    public void setIdNota(BigDecimal idNota) {
        this.idNota = idNota;
    }

    public List<Periodo> getPeriodoList() {
        return periodoList;
    }

    public void setPeriodoList(List<Periodo> periodoList) {
        this.periodoList = periodoList;
    }

    public Alumno getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Alumno idAlumno) {
        this.idAlumno = idAlumno;
    }

    public MateriaGrado getIdMateriaGrado() {
        return idMateriaGrado;
    }

    public void setIdMateriaGrado(MateriaGrado idMateriaGrado) {
        this.idMateriaGrado = idMateriaGrado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNota != null ? idNota.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nota)) {
            return false;
        }
        Nota other = (Nota) object;
        if ((this.idNota == null && other.idNota != null) || (this.idNota != null && !this.idNota.equals(other.idNota))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Logica_Negocios.Nota[ idNota=" + idNota + " ]";
    }

    @XmlTransient
    public List<Periodo1> getPeriodo1List() {
        return periodo1List;
    }

    public void setPeriodo1List(List<Periodo1> periodo1List) {
        this.periodo1List = periodo1List;
    }

    @XmlTransient
    public List<Periodo3> getPeriodo3List() {
        return periodo3List;
    }

    public void setPeriodo3List(List<Periodo3> periodo3List) {
        this.periodo3List = periodo3List;
    }

    @XmlTransient
    public List<Periodo2> getPeriodo2List() {
        return periodo2List;
    }

    public void setPeriodo2List(List<Periodo2> periodo2List) {
        this.periodo2List = periodo2List;
    }
    
}

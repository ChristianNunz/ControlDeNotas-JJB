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
@Table(name = "MATERIA")
@NamedQueries({
    @NamedQuery(name = "Materia.findAll", query = "SELECT m FROM Materia m")})
public class Materia implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMateria")
    private List<MateriaGrado> materiaGradoList;
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_MATERIA")
    private BigDecimal idMateria;
    @Basic(optional = false)
    @Column(name = "MATERIA_NOMBRE")
    private String materiaNombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "materiaIdMateria")
    private List<Anho> anhoList;

    public Materia() {
    }

    public Materia(BigDecimal idMateria) {
        this.idMateria = idMateria;
    }

    public Materia(BigDecimal idMateria, String materiaNombre) {
        this.idMateria = idMateria;
        this.materiaNombre = materiaNombre;
    }

    public BigDecimal getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(BigDecimal idMateria) {
        this.idMateria = idMateria;
    }

    public String getMateriaNombre() {
        return materiaNombre;
    }

    public void setMateriaNombre(String materiaNombre) {
        this.materiaNombre = materiaNombre;
    }

    public List<Anho> getAnhoList() {
        return anhoList;
    }

    public void setAnhoList(List<Anho> anhoList) {
        this.anhoList = anhoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMateria != null ? idMateria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Materia)) {
            return false;
        }
        Materia other = (Materia) object;
        if ((this.idMateria == null && other.idMateria != null) || (this.idMateria != null && !this.idMateria.equals(other.idMateria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Logica_Negocios.Materia[ idMateria=" + idMateria + " ]";
    }

    public List<MateriaGrado> getMateriaGradoList() {
        return materiaGradoList;
    }

    public void setMateriaGradoList(List<MateriaGrado> materiaGradoList) {
        this.materiaGradoList = materiaGradoList;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica_Negocios;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Jorge Villanueva
 */
@Entity
@Table(name = "DOCENTE")
@NamedQueries({
    @NamedQuery(name = "Docente.findAll", query = "SELECT d FROM Docente d")})
public class Docente implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDocente")
    private List<MateriaGrado> materiaGradoList;
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_DOCENTE")
    private BigDecimal idDocente;
    @Basic(optional = false)
    @Column(name = "DOCENTE_NOMBRE")
    private String docenteNombre;
    @Basic(optional = false)
    @Column(name = "DOCENTE_APELLIDO")
    private String docenteApellido;
    @Basic(optional = false)
    @Column(name = "DOCENTE_TEL")
    private String docenteTel;
    @Basic(optional = false)
    @Column(name = "DOCENTE_DIRECCION")
    private String docenteDireccion;
    @Basic(optional = false)
    @Column(name = "DOCENTE_DOC")
    private String docenteDoc;
    @Basic(optional = false)
    @Column(name = "DOCENTE_FECHA_NAC")
    @Temporal(TemporalType.TIMESTAMP)
    private Date docenteFechaNac;
    @Basic(optional = false)
    @Column(name = "DOCENTE_ESTADO")
    private BigInteger docenteEstado;
    @Basic(optional = false)
    @Column(name = "DOCENTE_GENERO")
    private BigInteger docenteGenero;

    public Docente() {
    }

    public Docente(BigDecimal idDocente) {
        this.idDocente = idDocente;
    }

    public Docente(BigDecimal idDocente, String docenteNombre, String docenteApellido, String docenteTel, String docenteDireccion, String docenteDoc, Date docenteFechaNac, BigInteger docenteEstado, BigInteger docenteGenero) {
        this.idDocente = idDocente;
        this.docenteNombre = docenteNombre;
        this.docenteApellido = docenteApellido;
        this.docenteTel = docenteTel;
        this.docenteDireccion = docenteDireccion;
        this.docenteDoc = docenteDoc;
        this.docenteFechaNac = docenteFechaNac;
        this.docenteEstado = docenteEstado;
        this.docenteGenero = docenteGenero;
    }

    public BigDecimal getIdDocente() {
        return idDocente;
    }

    public void setIdDocente(BigDecimal idDocente) {
        this.idDocente = idDocente;
    }

    public String getDocenteNombre() {
        return docenteNombre;
    }

    public void setDocenteNombre(String docenteNombre) {
        this.docenteNombre = docenteNombre;
    }

    public String getDocenteApellido() {
        return docenteApellido;
    }

    public void setDocenteApellido(String docenteApellido) {
        this.docenteApellido = docenteApellido;
    }

    public String getDocenteTel() {
        return docenteTel;
    }

    public void setDocenteTel(String docenteTel) {
        this.docenteTel = docenteTel;
    }

    public String getDocenteDireccion() {
        return docenteDireccion;
    }

    public void setDocenteDireccion(String docenteDireccion) {
        this.docenteDireccion = docenteDireccion;
    }

    public String getDocenteDoc() {
        return docenteDoc;
    }

    public void setDocenteDoc(String docenteDoc) {
        this.docenteDoc = docenteDoc;
    }

    public String getDocenteFechaNac() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String fecha=sdf.format(docenteFechaNac);
        return fecha;
    }

    public void setDocenteFechaNac(Date docenteFechaNac) {
        this.docenteFechaNac = docenteFechaNac;
    }

    public String getDocenteEstado() {
        BigInteger dos = new BigInteger("2");
        int result=dos.compareTo(docenteEstado);
        if (result==0) {
            return "Inactivo";
        }else{
            return "Activo";
        }
    }

    public void setDocenteEstado(BigInteger docenteEstado) {
        this.docenteEstado = docenteEstado;
    }

    public String getDocenteGenero() {
        BigInteger dos = new BigInteger("2");
        int result=dos.compareTo(docenteGenero);
        if (result==0) {
            return "F";
        }else{
            return "M";
        }
    }

    public void setDocenteGenero(BigInteger docenteGenero) {
        this.docenteGenero = docenteGenero;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDocente != null ? idDocente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Docente)) {
            return false;
        }
        Docente other = (Docente) object;
        if ((this.idDocente == null && other.idDocente != null) || (this.idDocente != null && !this.idDocente.equals(other.idDocente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Logica_Negocios.Docente[ idDocente=" + idDocente + " ]";
    }

    public List<MateriaGrado> getMateriaGradoList() {
        return materiaGradoList;
    }

    public void setMateriaGradoList(List<MateriaGrado> materiaGradoList) {
        this.materiaGradoList = materiaGradoList;
    }
    
}

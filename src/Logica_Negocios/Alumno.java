/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica_Negocios;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
 * @author diego
 */
@Entity
@Table(name = "ALUMNO")
@NamedQueries({
    @NamedQuery(name = "Alumno.findAll", query = "SELECT a FROM Alumno a")})
public class Alumno implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAlumno")
    private List<Nota> notaList;

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_ALUMNO")
    private BigDecimal idAlumno;
    @Basic(optional = false)
    @Column(name = "ALUMNO_NOMBRE")
    private String alumnoNombre;
    @Basic(optional = false)
    @Column(name = "ALUMNO_APELIDOS")
    private String alumnoApelidos;
    @Basic(optional = false)
    @Column(name = "ALUMNO_DIRECCION")
    private String alumnoDireccion;
    @Basic(optional = false)
    @Column(name = "ALUMNO_TEL")
    private String alumnoTel;
    @Basic(optional = false)
    @Column(name = "ALUMNO_NIE")
    private String alumnoNie;
    @Basic(optional = false)
    @Column(name = "ALUMNO_FECHA_NAC")
    @Temporal(TemporalType.TIMESTAMP)
    private Date alumnoFechaNac;
    @Basic(optional = false)
    @Column(name = "ALUMNO_GENERO")
    private BigInteger alumnoGenero;
    @Basic(optional = false)
    @Column(name = "ALUMNO_ESTADO")
    private BigInteger alumnoEstado;

    public Alumno() {
    }

    public Alumno(BigDecimal idAlumno) {
        this.idAlumno = idAlumno;
    }

    public Alumno(BigDecimal idAlumno, String alumnoNombre, String alumnoApelidos, String alumnoDireccion, String alumnoTel, String alumnoNie, Date alumnoFechaNac, BigInteger alumnoGenero, BigInteger alumnoEstado) {
        this.idAlumno = idAlumno;
        this.alumnoNombre = alumnoNombre;
        this.alumnoApelidos = alumnoApelidos;
        this.alumnoDireccion = alumnoDireccion;
        this.alumnoTel = alumnoTel;
        this.alumnoNie = alumnoNie;
        this.alumnoFechaNac = alumnoFechaNac;
        this.alumnoGenero = alumnoGenero;
        this.alumnoEstado = alumnoEstado;
    }

    public BigDecimal getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(BigDecimal idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getAlumnoNombre() {
        return alumnoNombre;
    }

    public void setAlumnoNombre(String alumnoNombre) {
        this.alumnoNombre = alumnoNombre;
    }

    public String getAlumnoApelidos() {
        return alumnoApelidos;
    }

    public void setAlumnoApelidos(String alumnoApelidos) {
        this.alumnoApelidos = alumnoApelidos;
    }

    public String getAlumnoDireccion() {
        return alumnoDireccion;
    }

    public void setAlumnoDireccion(String alumnoDireccion) {
        this.alumnoDireccion = alumnoDireccion;
    }

    public String getAlumnoTel() {
        return alumnoTel;
    }

    public void setAlumnoTel(String alumnoTel) {
        this.alumnoTel = alumnoTel;
    }

    public String getAlumnoNie() {
        return alumnoNie;
    }

    public void setAlumnoNie(String alumnoNie) {
        this.alumnoNie = alumnoNie;
    }

    public Date getAlumnoFechaNac() {
        return alumnoFechaNac;
    }

    public void setAlumnoFechaNac(Date alumnoFechaNac) {
        this.alumnoFechaNac = alumnoFechaNac;
    }

    public BigInteger getAlumnoGenero() {
        return alumnoGenero;
    }

    public void setAlumnoGenero(BigInteger alumnoGenero) {
        this.alumnoGenero = alumnoGenero;
    }

    public BigInteger getAlumnoEstado() {
        return alumnoEstado;
    }

    public void setAlumnoEstado(BigInteger alumnoEstado) {
        this.alumnoEstado = alumnoEstado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAlumno != null ? idAlumno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alumno)) {
            return false;
        }
        Alumno other = (Alumno) object;
        if ((this.idAlumno == null && other.idAlumno != null) || (this.idAlumno != null && !this.idAlumno.equals(other.idAlumno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Logica_Negocios.Alumno[ idAlumno=" + idAlumno + " ]";
    }

    public List<Nota> getNotaList() {
        return notaList;
    }

    public void setNotaList(List<Nota> notaList) {
        this.notaList = notaList;
    }
    
}

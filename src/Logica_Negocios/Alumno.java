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
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jorge Villanueva
 */
@Entity
@Table(name = "ALUMNO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Alumno.findAll", query = "SELECT a FROM Alumno a"),
    @NamedQuery(name = "Alumno.findByIdAlumno", query = "SELECT a FROM Alumno a WHERE a.idAlumno = :idAlumno"),
    @NamedQuery(name = "Alumno.findByAlumnoNombre", query = "SELECT a FROM Alumno a WHERE a.alumnoNombre = :alumnoNombre"),
    @NamedQuery(name = "Alumno.findByAlumnoApellidos", query = "SELECT a FROM Alumno a WHERE a.alumnoApellidos = :alumnoApellidos"),
    @NamedQuery(name = "Alumno.findByAlumnoDireccion", query = "SELECT a FROM Alumno a WHERE a.alumnoDireccion = :alumnoDireccion"),
    @NamedQuery(name = "Alumno.findByAlumnoTel", query = "SELECT a FROM Alumno a WHERE a.alumnoTel = :alumnoTel"),
    @NamedQuery(name = "Alumno.findByAlumnoNie", query = "SELECT a FROM Alumno a WHERE a.alumnoNie = :alumnoNie"),
    @NamedQuery(name = "Alumno.findByAlumnoFechaNac", query = "SELECT a FROM Alumno a WHERE a.alumnoFechaNac = :alumnoFechaNac"),
    @NamedQuery(name = "Alumno.findByAlumnoGenero", query = "SELECT a FROM Alumno a WHERE a.alumnoGenero = :alumnoGenero"),
    @NamedQuery(name = "Alumno.findByAlumnoEstado", query = "SELECT a FROM Alumno a WHERE a.alumnoEstado = :alumnoEstado")})
public class Alumno implements Serializable {
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
    @Column(name = "ALUMNO_APELLIDOS")
    private String alumnoApellidos;
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

    public Alumno(BigDecimal idAlumno, String alumnoNombre, String alumnoApellidos, String alumnoDireccion, String alumnoTel, String alumnoNie, Date alumnoFechaNac, BigInteger alumnoGenero, BigInteger alumnoEstado) {
        this.idAlumno = idAlumno;
        this.alumnoNombre = alumnoNombre;
        this.alumnoApellidos = alumnoApellidos;
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

    public String getAlumnoApellidos() {
        return alumnoApellidos;
    }

    public void setAlumnoApellidos(String alumnoApellidos) {
        this.alumnoApellidos = alumnoApellidos;
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

    public String getAlumnoFechaNac() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String fecha=sdf.format(alumnoFechaNac);
        return fecha;
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
    
}

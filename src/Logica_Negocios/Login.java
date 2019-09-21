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
@Table(name = "LOGIN")
@NamedQueries({
    @NamedQuery(name = "Login.findAll", query = "SELECT l FROM Login l")})
public class Login implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_LOGIN")
    private BigDecimal idLogin;
    @Basic(optional = false)
    @Column(name = "LOGIN_USUARIO")
    private String loginUsuario;
    @Basic(optional = false)
    @Column(name = "LOGIN_CLAVE")
    private String loginClave;
    @Column(name = "ID_DOCENTE")
    private BigInteger idDocente;
    @JoinColumn(name = "ID_ROL", referencedColumnName = "ID_ROL")
    @ManyToOne(optional = false)
    private Rol idRol;

    public Login() {
    }

    public Login(BigDecimal idLogin) {
        this.idLogin = idLogin;
    }

    public Login(BigDecimal idLogin, String loginUsuario, String loginClave) {
        this.idLogin = idLogin;
        this.loginUsuario = loginUsuario;
        this.loginClave = loginClave;
    }

    public BigDecimal getIdLogin() {
        return idLogin;
    }

    public void setIdLogin(BigDecimal idLogin) {
        this.idLogin = idLogin;
    }

    public String getLoginUsuario() {
        return loginUsuario;
    }

    public void setLoginUsuario(String loginUsuario) {
        this.loginUsuario = loginUsuario;
    }

    public String getLoginClave() {
        return loginClave;
    }

    public void setLoginClave(String loginClave) {
        this.loginClave = loginClave;
    }

    public BigInteger getIdDocente() {
        return idDocente;
    }

    public void setIdDocente(BigInteger idDocente) {
        this.idDocente = idDocente;
    }

    public Rol getIdRol() {
        return idRol;
    }

    public void setIdRol(Rol idRol) {
        this.idRol = idRol;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLogin != null ? idLogin.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Login)) {
            return false;
        }
        Login other = (Login) object;
        if ((this.idLogin == null && other.idLogin != null) || (this.idLogin != null && !this.idLogin.equals(other.idLogin))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Logica_Negocios.Login[ idLogin=" + idLogin + " ]";
    }
    
}

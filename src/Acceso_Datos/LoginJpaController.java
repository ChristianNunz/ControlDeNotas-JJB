/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acceso_Datos;

import Acceso_Datos.exceptions.NonexistentEntityException;
import Acceso_Datos.exceptions.PreexistingEntityException;
import Logica_Negocios.Login;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Logica_Negocios.Rol;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Jorge Villanueva
 */
public class LoginJpaController implements Serializable {

    public LoginJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Login login) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Rol idRol = login.getIdRol();
            if (idRol != null) {
                idRol = em.getReference(idRol.getClass(), idRol.getIdRol());
                login.setIdRol(idRol);
            }
            em.persist(login);
            if (idRol != null) {
                idRol.getLoginList().add(login);
                idRol = em.merge(idRol);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findLogin(login.getIdLogin()) != null) {
                throw new PreexistingEntityException("Login " + login + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Login login) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Login persistentLogin = em.find(Login.class, login.getIdLogin());
            Rol idRolOld = persistentLogin.getIdRol();
            Rol idRolNew = login.getIdRol();
            if (idRolNew != null) {
                idRolNew = em.getReference(idRolNew.getClass(), idRolNew.getIdRol());
                login.setIdRol(idRolNew);
            }
            login = em.merge(login);
            if (idRolOld != null && !idRolOld.equals(idRolNew)) {
                idRolOld.getLoginList().remove(login);
                idRolOld = em.merge(idRolOld);
            }
            if (idRolNew != null && !idRolNew.equals(idRolOld)) {
                idRolNew.getLoginList().add(login);
                idRolNew = em.merge(idRolNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                BigDecimal id = login.getIdLogin();
                if (findLogin(id) == null) {
                    throw new NonexistentEntityException("The login with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(BigDecimal id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Login login;
            try {
                login = em.getReference(Login.class, id);
                login.getIdLogin();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The login with id " + id + " no longer exists.", enfe);
            }
            Rol idRol = login.getIdRol();
            if (idRol != null) {
                idRol.getLoginList().remove(login);
                idRol = em.merge(idRol);
            }
            em.remove(login);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Login> findLoginEntities() {
        return findLoginEntities(true, -1, -1);
    }

    public List<Login> findLoginEntities(int maxResults, int firstResult) {
        return findLoginEntities(false, maxResults, firstResult);
    }

    private List<Login> findLoginEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Login.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Login findLogin(BigDecimal id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Login.class, id);
        } finally {
            em.close();
        }
    }

    public int getLoginCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Login> rt = cq.from(Login.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    public String Login(String user, String contra, Connection con) {
        try {
//            ConectionDB con = new ConectionDB();
            Statement st = con.createStatement();
            ResultSet resultSet = st.executeQuery("SELECT l.ID_LOGIN,R.ROL_NOMBRE FROM LOGIN L INNER JOIN ROL R ON L.id_rol=R.id_rol WHERE L.LOGIN_USUARIO='"+user+"' AND L.LOGIN_CLAVE='"+contra+"'");
            resultSet.next();
            String Id = resultSet.getString(1);
            String Rol=resultSet.getString(2);
            
//            IdLog=Id;
            st.close();
            return Rol+","+Id;
        } catch (Exception e) {
             return "null";
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acceso_Datos;

import Acceso_Datos.exceptions.IllegalOrphanException;
import Acceso_Datos.exceptions.NonexistentEntityException;
import Acceso_Datos.exceptions.PreexistingEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Logica_Negocios.Login;
import Logica_Negocios.Rol;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Jorge Villanueva
 */
public class RolJpaController implements Serializable {

    public RolJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Rol rol) throws PreexistingEntityException, Exception {
        if (rol.getLoginList() == null) {
            rol.setLoginList(new ArrayList<Login>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Login> attachedLoginList = new ArrayList<Login>();
            for (Login loginListLoginToAttach : rol.getLoginList()) {
                loginListLoginToAttach = em.getReference(loginListLoginToAttach.getClass(), loginListLoginToAttach.getIdLogin());
                attachedLoginList.add(loginListLoginToAttach);
            }
            rol.setLoginList(attachedLoginList);
            em.persist(rol);
            for (Login loginListLogin : rol.getLoginList()) {
                Rol oldIdRolOfLoginListLogin = loginListLogin.getIdRol();
                loginListLogin.setIdRol(rol);
                loginListLogin = em.merge(loginListLogin);
                if (oldIdRolOfLoginListLogin != null) {
                    oldIdRolOfLoginListLogin.getLoginList().remove(loginListLogin);
                    oldIdRolOfLoginListLogin = em.merge(oldIdRolOfLoginListLogin);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findRol(rol.getIdRol()) != null) {
                throw new PreexistingEntityException("Rol " + rol + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Rol rol) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Rol persistentRol = em.find(Rol.class, rol.getIdRol());
            List<Login> loginListOld = persistentRol.getLoginList();
            List<Login> loginListNew = rol.getLoginList();
            List<String> illegalOrphanMessages = null;
            for (Login loginListOldLogin : loginListOld) {
                if (!loginListNew.contains(loginListOldLogin)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Login " + loginListOldLogin + " since its idRol field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<Login> attachedLoginListNew = new ArrayList<Login>();
            for (Login loginListNewLoginToAttach : loginListNew) {
                loginListNewLoginToAttach = em.getReference(loginListNewLoginToAttach.getClass(), loginListNewLoginToAttach.getIdLogin());
                attachedLoginListNew.add(loginListNewLoginToAttach);
            }
            loginListNew = attachedLoginListNew;
            rol.setLoginList(loginListNew);
            rol = em.merge(rol);
            for (Login loginListNewLogin : loginListNew) {
                if (!loginListOld.contains(loginListNewLogin)) {
                    Rol oldIdRolOfLoginListNewLogin = loginListNewLogin.getIdRol();
                    loginListNewLogin.setIdRol(rol);
                    loginListNewLogin = em.merge(loginListNewLogin);
                    if (oldIdRolOfLoginListNewLogin != null && !oldIdRolOfLoginListNewLogin.equals(rol)) {
                        oldIdRolOfLoginListNewLogin.getLoginList().remove(loginListNewLogin);
                        oldIdRolOfLoginListNewLogin = em.merge(oldIdRolOfLoginListNewLogin);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                BigDecimal id = rol.getIdRol();
                if (findRol(id) == null) {
                    throw new NonexistentEntityException("The rol with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(BigDecimal id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Rol rol;
            try {
                rol = em.getReference(Rol.class, id);
                rol.getIdRol();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The rol with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Login> loginListOrphanCheck = rol.getLoginList();
            for (Login loginListOrphanCheckLogin : loginListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Rol (" + rol + ") cannot be destroyed since the Login " + loginListOrphanCheckLogin + " in its loginList field has a non-nullable idRol field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(rol);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Rol> findRolEntities() {
        return findRolEntities(true, -1, -1);
    }

    public List<Rol> findRolEntities(int maxResults, int firstResult) {
        return findRolEntities(false, maxResults, firstResult);
    }

    private List<Rol> findRolEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Rol.class));
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

    public Rol findRol(BigDecimal id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Rol.class, id);
        } finally {
            em.close();
        }
    }

    public int getRolCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Rol> rt = cq.from(Rol.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

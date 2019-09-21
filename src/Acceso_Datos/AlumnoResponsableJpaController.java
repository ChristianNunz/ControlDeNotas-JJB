/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acceso_Datos;

import Acceso_Datos.exceptions.NonexistentEntityException;
import Acceso_Datos.exceptions.PreexistingEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Logica_Negocios.Alumno;
import Logica_Negocios.AlumnoResponsable;
import Logica_Negocios.Responsable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Jorge Villanueva
 */
public class AlumnoResponsableJpaController implements Serializable {

    public AlumnoResponsableJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(AlumnoResponsable alumnoResponsable) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Alumno idAlumno = alumnoResponsable.getIdAlumno();
            if (idAlumno != null) {
                idAlumno = em.getReference(idAlumno.getClass(), idAlumno.getIdAlumno());
                alumnoResponsable.setIdAlumno(idAlumno);
            }
            Responsable idEsponsable = alumnoResponsable.getIdEsponsable();
            if (idEsponsable != null) {
                idEsponsable = em.getReference(idEsponsable.getClass(), idEsponsable.getIdResponsable());
                alumnoResponsable.setIdEsponsable(idEsponsable);
            }
            em.persist(alumnoResponsable);
            if (idAlumno != null) {
                idAlumno.getAlumnoResponsableList().add(alumnoResponsable);
                idAlumno = em.merge(idAlumno);
            }
            if (idEsponsable != null) {
                idEsponsable.getAlumnoResponsableList().add(alumnoResponsable);
                idEsponsable = em.merge(idEsponsable);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findAlumnoResponsable(alumnoResponsable.getIdAlumnoResponsable()) != null) {
                throw new PreexistingEntityException("AlumnoResponsable " + alumnoResponsable + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(AlumnoResponsable alumnoResponsable) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            AlumnoResponsable persistentAlumnoResponsable = em.find(AlumnoResponsable.class, alumnoResponsable.getIdAlumnoResponsable());
            Alumno idAlumnoOld = persistentAlumnoResponsable.getIdAlumno();
            Alumno idAlumnoNew = alumnoResponsable.getIdAlumno();
            Responsable idEsponsableOld = persistentAlumnoResponsable.getIdEsponsable();
            Responsable idEsponsableNew = alumnoResponsable.getIdEsponsable();
            if (idAlumnoNew != null) {
                idAlumnoNew = em.getReference(idAlumnoNew.getClass(), idAlumnoNew.getIdAlumno());
                alumnoResponsable.setIdAlumno(idAlumnoNew);
            }
            if (idEsponsableNew != null) {
                idEsponsableNew = em.getReference(idEsponsableNew.getClass(), idEsponsableNew.getIdResponsable());
                alumnoResponsable.setIdEsponsable(idEsponsableNew);
            }
            alumnoResponsable = em.merge(alumnoResponsable);
            if (idAlumnoOld != null && !idAlumnoOld.equals(idAlumnoNew)) {
                idAlumnoOld.getAlumnoResponsableList().remove(alumnoResponsable);
                idAlumnoOld = em.merge(idAlumnoOld);
            }
            if (idAlumnoNew != null && !idAlumnoNew.equals(idAlumnoOld)) {
                idAlumnoNew.getAlumnoResponsableList().add(alumnoResponsable);
                idAlumnoNew = em.merge(idAlumnoNew);
            }
            if (idEsponsableOld != null && !idEsponsableOld.equals(idEsponsableNew)) {
                idEsponsableOld.getAlumnoResponsableList().remove(alumnoResponsable);
                idEsponsableOld = em.merge(idEsponsableOld);
            }
            if (idEsponsableNew != null && !idEsponsableNew.equals(idEsponsableOld)) {
                idEsponsableNew.getAlumnoResponsableList().add(alumnoResponsable);
                idEsponsableNew = em.merge(idEsponsableNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                BigDecimal id = alumnoResponsable.getIdAlumnoResponsable();
                if (findAlumnoResponsable(id) == null) {
                    throw new NonexistentEntityException("The alumnoResponsable with id " + id + " no longer exists.");
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
            AlumnoResponsable alumnoResponsable;
            try {
                alumnoResponsable = em.getReference(AlumnoResponsable.class, id);
                alumnoResponsable.getIdAlumnoResponsable();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The alumnoResponsable with id " + id + " no longer exists.", enfe);
            }
            Alumno idAlumno = alumnoResponsable.getIdAlumno();
            if (idAlumno != null) {
                idAlumno.getAlumnoResponsableList().remove(alumnoResponsable);
                idAlumno = em.merge(idAlumno);
            }
            Responsable idEsponsable = alumnoResponsable.getIdEsponsable();
            if (idEsponsable != null) {
                idEsponsable.getAlumnoResponsableList().remove(alumnoResponsable);
                idEsponsable = em.merge(idEsponsable);
            }
            em.remove(alumnoResponsable);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<AlumnoResponsable> findAlumnoResponsableEntities() {
        return findAlumnoResponsableEntities(true, -1, -1);
    }

    public List<AlumnoResponsable> findAlumnoResponsableEntities(int maxResults, int firstResult) {
        return findAlumnoResponsableEntities(false, maxResults, firstResult);
    }

    private List<AlumnoResponsable> findAlumnoResponsableEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(AlumnoResponsable.class));
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

    public AlumnoResponsable findAlumnoResponsable(BigDecimal id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(AlumnoResponsable.class, id);
        } finally {
            em.close();
        }
    }

    public int getAlumnoResponsableCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<AlumnoResponsable> rt = cq.from(AlumnoResponsable.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

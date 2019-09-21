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
import Logica_Negocios.Docente;
import Logica_Negocios.DocenteMateria;
import Logica_Negocios.Materia;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Jorge Villanueva
 */
public class DocenteMateriaJpaController implements Serializable {

    public DocenteMateriaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(DocenteMateria docenteMateria) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Docente idDocente = docenteMateria.getIdDocente();
            if (idDocente != null) {
                idDocente = em.getReference(idDocente.getClass(), idDocente.getIdDocente());
                docenteMateria.setIdDocente(idDocente);
            }
            Materia idMateria = docenteMateria.getIdMateria();
            if (idMateria != null) {
                idMateria = em.getReference(idMateria.getClass(), idMateria.getIdMateria());
                docenteMateria.setIdMateria(idMateria);
            }
            em.persist(docenteMateria);
            if (idDocente != null) {
                idDocente.getDocenteMateriaList().add(docenteMateria);
                idDocente = em.merge(idDocente);
            }
            if (idMateria != null) {
                idMateria.getDocenteMateriaList().add(docenteMateria);
                idMateria = em.merge(idMateria);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findDocenteMateria(docenteMateria.getIdDocenteMateria()) != null) {
                throw new PreexistingEntityException("DocenteMateria " + docenteMateria + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(DocenteMateria docenteMateria) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            DocenteMateria persistentDocenteMateria = em.find(DocenteMateria.class, docenteMateria.getIdDocenteMateria());
            Docente idDocenteOld = persistentDocenteMateria.getIdDocente();
            Docente idDocenteNew = docenteMateria.getIdDocente();
            Materia idMateriaOld = persistentDocenteMateria.getIdMateria();
            Materia idMateriaNew = docenteMateria.getIdMateria();
            if (idDocenteNew != null) {
                idDocenteNew = em.getReference(idDocenteNew.getClass(), idDocenteNew.getIdDocente());
                docenteMateria.setIdDocente(idDocenteNew);
            }
            if (idMateriaNew != null) {
                idMateriaNew = em.getReference(idMateriaNew.getClass(), idMateriaNew.getIdMateria());
                docenteMateria.setIdMateria(idMateriaNew);
            }
            docenteMateria = em.merge(docenteMateria);
            if (idDocenteOld != null && !idDocenteOld.equals(idDocenteNew)) {
                idDocenteOld.getDocenteMateriaList().remove(docenteMateria);
                idDocenteOld = em.merge(idDocenteOld);
            }
            if (idDocenteNew != null && !idDocenteNew.equals(idDocenteOld)) {
                idDocenteNew.getDocenteMateriaList().add(docenteMateria);
                idDocenteNew = em.merge(idDocenteNew);
            }
            if (idMateriaOld != null && !idMateriaOld.equals(idMateriaNew)) {
                idMateriaOld.getDocenteMateriaList().remove(docenteMateria);
                idMateriaOld = em.merge(idMateriaOld);
            }
            if (idMateriaNew != null && !idMateriaNew.equals(idMateriaOld)) {
                idMateriaNew.getDocenteMateriaList().add(docenteMateria);
                idMateriaNew = em.merge(idMateriaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                BigDecimal id = docenteMateria.getIdDocenteMateria();
                if (findDocenteMateria(id) == null) {
                    throw new NonexistentEntityException("The docenteMateria with id " + id + " no longer exists.");
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
            DocenteMateria docenteMateria;
            try {
                docenteMateria = em.getReference(DocenteMateria.class, id);
                docenteMateria.getIdDocenteMateria();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The docenteMateria with id " + id + " no longer exists.", enfe);
            }
            Docente idDocente = docenteMateria.getIdDocente();
            if (idDocente != null) {
                idDocente.getDocenteMateriaList().remove(docenteMateria);
                idDocente = em.merge(idDocente);
            }
            Materia idMateria = docenteMateria.getIdMateria();
            if (idMateria != null) {
                idMateria.getDocenteMateriaList().remove(docenteMateria);
                idMateria = em.merge(idMateria);
            }
            em.remove(docenteMateria);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<DocenteMateria> findDocenteMateriaEntities() {
        return findDocenteMateriaEntities(true, -1, -1);
    }

    public List<DocenteMateria> findDocenteMateriaEntities(int maxResults, int firstResult) {
        return findDocenteMateriaEntities(false, maxResults, firstResult);
    }

    private List<DocenteMateria> findDocenteMateriaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(DocenteMateria.class));
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

    public DocenteMateria findDocenteMateria(BigDecimal id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(DocenteMateria.class, id);
        } finally {
            em.close();
        }
    }

    public int getDocenteMateriaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<DocenteMateria> rt = cq.from(DocenteMateria.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

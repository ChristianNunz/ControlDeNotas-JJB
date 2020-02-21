/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acceso_Datos;

import Acceso_Datos.exceptions.NonexistentEntityException;
import Acceso_Datos.exceptions.PreexistingEntityException;
import Logica_Negocios.Anho;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Logica_Negocios.Materia;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author chris
 */
public class AnhoJpaController implements Serializable {

    public AnhoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Anho anho) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Materia materiaIdMateria = anho.getMateriaIdMateria();
            if (materiaIdMateria != null) {
                materiaIdMateria = em.getReference(materiaIdMateria.getClass(), materiaIdMateria.getIdMateria());
                anho.setMateriaIdMateria(materiaIdMateria);
            }
            em.persist(anho);
            if (materiaIdMateria != null) {
                materiaIdMateria.getAnhoList().add(anho);
                materiaIdMateria = em.merge(materiaIdMateria);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findAnho(anho.getIdAnho()) != null) {
                throw new PreexistingEntityException("Anho " + anho + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Anho anho) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Anho persistentAnho = em.find(Anho.class, anho.getIdAnho());
            Materia materiaIdMateriaOld = persistentAnho.getMateriaIdMateria();
            Materia materiaIdMateriaNew = anho.getMateriaIdMateria();
            if (materiaIdMateriaNew != null) {
                materiaIdMateriaNew = em.getReference(materiaIdMateriaNew.getClass(), materiaIdMateriaNew.getIdMateria());
                anho.setMateriaIdMateria(materiaIdMateriaNew);
            }
            anho = em.merge(anho);
            if (materiaIdMateriaOld != null && !materiaIdMateriaOld.equals(materiaIdMateriaNew)) {
                materiaIdMateriaOld.getAnhoList().remove(anho);
                materiaIdMateriaOld = em.merge(materiaIdMateriaOld);
            }
            if (materiaIdMateriaNew != null && !materiaIdMateriaNew.equals(materiaIdMateriaOld)) {
                materiaIdMateriaNew.getAnhoList().add(anho);
                materiaIdMateriaNew = em.merge(materiaIdMateriaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                BigDecimal id = anho.getIdAnho();
                if (findAnho(id) == null) {
                    throw new NonexistentEntityException("The anho with id " + id + " no longer exists.");
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
            Anho anho;
            try {
                anho = em.getReference(Anho.class, id);
                anho.getIdAnho();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The anho with id " + id + " no longer exists.", enfe);
            }
            Materia materiaIdMateria = anho.getMateriaIdMateria();
            if (materiaIdMateria != null) {
                materiaIdMateria.getAnhoList().remove(anho);
                materiaIdMateria = em.merge(materiaIdMateria);
            }
            em.remove(anho);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Anho> findAnhoEntities() {
        return findAnhoEntities(true, -1, -1);
    }

    public List<Anho> findAnhoEntities(int maxResults, int firstResult) {
        return findAnhoEntities(false, maxResults, firstResult);
    }

    private List<Anho> findAnhoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Anho.class));
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

    public Anho findAnho(BigDecimal id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Anho.class, id);
        } finally {
            em.close();
        }
    }

    public int getAnhoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Anho> rt = cq.from(Anho.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

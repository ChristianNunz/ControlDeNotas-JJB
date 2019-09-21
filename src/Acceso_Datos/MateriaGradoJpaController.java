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
import Logica_Negocios.Grado;
import Logica_Negocios.Materia;
import Logica_Negocios.MateriaGrado;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Jorge Villanueva
 */
public class MateriaGradoJpaController implements Serializable {

    public MateriaGradoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(MateriaGrado materiaGrado) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Grado idGrado = materiaGrado.getIdGrado();
            if (idGrado != null) {
                idGrado = em.getReference(idGrado.getClass(), idGrado.getIdGrado());
                materiaGrado.setIdGrado(idGrado);
            }
            Materia idMateria = materiaGrado.getIdMateria();
            if (idMateria != null) {
                idMateria = em.getReference(idMateria.getClass(), idMateria.getIdMateria());
                materiaGrado.setIdMateria(idMateria);
            }
            em.persist(materiaGrado);
            if (idGrado != null) {
                idGrado.getMateriaGradoList().add(materiaGrado);
                idGrado = em.merge(idGrado);
            }
            if (idMateria != null) {
                idMateria.getMateriaGradoList().add(materiaGrado);
                idMateria = em.merge(idMateria);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findMateriaGrado(materiaGrado.getIdMateriaGrado()) != null) {
                throw new PreexistingEntityException("MateriaGrado " + materiaGrado + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(MateriaGrado materiaGrado) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            MateriaGrado persistentMateriaGrado = em.find(MateriaGrado.class, materiaGrado.getIdMateriaGrado());
            Grado idGradoOld = persistentMateriaGrado.getIdGrado();
            Grado idGradoNew = materiaGrado.getIdGrado();
            Materia idMateriaOld = persistentMateriaGrado.getIdMateria();
            Materia idMateriaNew = materiaGrado.getIdMateria();
            if (idGradoNew != null) {
                idGradoNew = em.getReference(idGradoNew.getClass(), idGradoNew.getIdGrado());
                materiaGrado.setIdGrado(idGradoNew);
            }
            if (idMateriaNew != null) {
                idMateriaNew = em.getReference(idMateriaNew.getClass(), idMateriaNew.getIdMateria());
                materiaGrado.setIdMateria(idMateriaNew);
            }
            materiaGrado = em.merge(materiaGrado);
            if (idGradoOld != null && !idGradoOld.equals(idGradoNew)) {
                idGradoOld.getMateriaGradoList().remove(materiaGrado);
                idGradoOld = em.merge(idGradoOld);
            }
            if (idGradoNew != null && !idGradoNew.equals(idGradoOld)) {
                idGradoNew.getMateriaGradoList().add(materiaGrado);
                idGradoNew = em.merge(idGradoNew);
            }
            if (idMateriaOld != null && !idMateriaOld.equals(idMateriaNew)) {
                idMateriaOld.getMateriaGradoList().remove(materiaGrado);
                idMateriaOld = em.merge(idMateriaOld);
            }
            if (idMateriaNew != null && !idMateriaNew.equals(idMateriaOld)) {
                idMateriaNew.getMateriaGradoList().add(materiaGrado);
                idMateriaNew = em.merge(idMateriaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                BigDecimal id = materiaGrado.getIdMateriaGrado();
                if (findMateriaGrado(id) == null) {
                    throw new NonexistentEntityException("The materiaGrado with id " + id + " no longer exists.");
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
            MateriaGrado materiaGrado;
            try {
                materiaGrado = em.getReference(MateriaGrado.class, id);
                materiaGrado.getIdMateriaGrado();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The materiaGrado with id " + id + " no longer exists.", enfe);
            }
            Grado idGrado = materiaGrado.getIdGrado();
            if (idGrado != null) {
                idGrado.getMateriaGradoList().remove(materiaGrado);
                idGrado = em.merge(idGrado);
            }
            Materia idMateria = materiaGrado.getIdMateria();
            if (idMateria != null) {
                idMateria.getMateriaGradoList().remove(materiaGrado);
                idMateria = em.merge(idMateria);
            }
            em.remove(materiaGrado);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<MateriaGrado> findMateriaGradoEntities() {
        return findMateriaGradoEntities(true, -1, -1);
    }

    public List<MateriaGrado> findMateriaGradoEntities(int maxResults, int firstResult) {
        return findMateriaGradoEntities(false, maxResults, firstResult);
    }

    private List<MateriaGrado> findMateriaGradoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(MateriaGrado.class));
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

    public MateriaGrado findMateriaGrado(BigDecimal id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(MateriaGrado.class, id);
        } finally {
            em.close();
        }
    }

    public int getMateriaGradoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<MateriaGrado> rt = cq.from(MateriaGrado.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

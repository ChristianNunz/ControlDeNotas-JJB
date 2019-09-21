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
import Logica_Negocios.Materia;
import Logica_Negocios.Seccion;
import Logica_Negocios.Turno;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Jorge Villanueva
 */
public class SeccionJpaController implements Serializable {

    public SeccionJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Seccion seccion) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Materia idMateria = seccion.getIdMateria();
            if (idMateria != null) {
                idMateria = em.getReference(idMateria.getClass(), idMateria.getIdMateria());
                seccion.setIdMateria(idMateria);
            }
            Turno idTurno = seccion.getIdTurno();
            if (idTurno != null) {
                idTurno = em.getReference(idTurno.getClass(), idTurno.getIdTurno());
                seccion.setIdTurno(idTurno);
            }
            em.persist(seccion);
            if (idMateria != null) {
                idMateria.getSeccionList().add(seccion);
                idMateria = em.merge(idMateria);
            }
            if (idTurno != null) {
                idTurno.getSeccionList().add(seccion);
                idTurno = em.merge(idTurno);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findSeccion(seccion.getIdSeccion()) != null) {
                throw new PreexistingEntityException("Seccion " + seccion + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Seccion seccion) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Seccion persistentSeccion = em.find(Seccion.class, seccion.getIdSeccion());
            Materia idMateriaOld = persistentSeccion.getIdMateria();
            Materia idMateriaNew = seccion.getIdMateria();
            Turno idTurnoOld = persistentSeccion.getIdTurno();
            Turno idTurnoNew = seccion.getIdTurno();
            if (idMateriaNew != null) {
                idMateriaNew = em.getReference(idMateriaNew.getClass(), idMateriaNew.getIdMateria());
                seccion.setIdMateria(idMateriaNew);
            }
            if (idTurnoNew != null) {
                idTurnoNew = em.getReference(idTurnoNew.getClass(), idTurnoNew.getIdTurno());
                seccion.setIdTurno(idTurnoNew);
            }
            seccion = em.merge(seccion);
            if (idMateriaOld != null && !idMateriaOld.equals(idMateriaNew)) {
                idMateriaOld.getSeccionList().remove(seccion);
                idMateriaOld = em.merge(idMateriaOld);
            }
            if (idMateriaNew != null && !idMateriaNew.equals(idMateriaOld)) {
                idMateriaNew.getSeccionList().add(seccion);
                idMateriaNew = em.merge(idMateriaNew);
            }
            if (idTurnoOld != null && !idTurnoOld.equals(idTurnoNew)) {
                idTurnoOld.getSeccionList().remove(seccion);
                idTurnoOld = em.merge(idTurnoOld);
            }
            if (idTurnoNew != null && !idTurnoNew.equals(idTurnoOld)) {
                idTurnoNew.getSeccionList().add(seccion);
                idTurnoNew = em.merge(idTurnoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                BigDecimal id = seccion.getIdSeccion();
                if (findSeccion(id) == null) {
                    throw new NonexistentEntityException("The seccion with id " + id + " no longer exists.");
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
            Seccion seccion;
            try {
                seccion = em.getReference(Seccion.class, id);
                seccion.getIdSeccion();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The seccion with id " + id + " no longer exists.", enfe);
            }
            Materia idMateria = seccion.getIdMateria();
            if (idMateria != null) {
                idMateria.getSeccionList().remove(seccion);
                idMateria = em.merge(idMateria);
            }
            Turno idTurno = seccion.getIdTurno();
            if (idTurno != null) {
                idTurno.getSeccionList().remove(seccion);
                idTurno = em.merge(idTurno);
            }
            em.remove(seccion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Seccion> findSeccionEntities() {
        return findSeccionEntities(true, -1, -1);
    }

    public List<Seccion> findSeccionEntities(int maxResults, int firstResult) {
        return findSeccionEntities(false, maxResults, firstResult);
    }

    private List<Seccion> findSeccionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Seccion.class));
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

    public Seccion findSeccion(BigDecimal id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Seccion.class, id);
        } finally {
            em.close();
        }
    }

    public int getSeccionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Seccion> rt = cq.from(Seccion.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

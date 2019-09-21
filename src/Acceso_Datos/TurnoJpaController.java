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
import Logica_Negocios.Seccion;
import Logica_Negocios.Turno;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Jorge Villanueva
 */
public class TurnoJpaController implements Serializable {

    public TurnoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Turno turno) throws PreexistingEntityException, Exception {
        if (turno.getSeccionList() == null) {
            turno.setSeccionList(new ArrayList<Seccion>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Seccion> attachedSeccionList = new ArrayList<Seccion>();
            for (Seccion seccionListSeccionToAttach : turno.getSeccionList()) {
                seccionListSeccionToAttach = em.getReference(seccionListSeccionToAttach.getClass(), seccionListSeccionToAttach.getIdSeccion());
                attachedSeccionList.add(seccionListSeccionToAttach);
            }
            turno.setSeccionList(attachedSeccionList);
            em.persist(turno);
            for (Seccion seccionListSeccion : turno.getSeccionList()) {
                Turno oldIdTurnoOfSeccionListSeccion = seccionListSeccion.getIdTurno();
                seccionListSeccion.setIdTurno(turno);
                seccionListSeccion = em.merge(seccionListSeccion);
                if (oldIdTurnoOfSeccionListSeccion != null) {
                    oldIdTurnoOfSeccionListSeccion.getSeccionList().remove(seccionListSeccion);
                    oldIdTurnoOfSeccionListSeccion = em.merge(oldIdTurnoOfSeccionListSeccion);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTurno(turno.getIdTurno()) != null) {
                throw new PreexistingEntityException("Turno " + turno + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Turno turno) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Turno persistentTurno = em.find(Turno.class, turno.getIdTurno());
            List<Seccion> seccionListOld = persistentTurno.getSeccionList();
            List<Seccion> seccionListNew = turno.getSeccionList();
            List<String> illegalOrphanMessages = null;
            for (Seccion seccionListOldSeccion : seccionListOld) {
                if (!seccionListNew.contains(seccionListOldSeccion)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Seccion " + seccionListOldSeccion + " since its idTurno field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<Seccion> attachedSeccionListNew = new ArrayList<Seccion>();
            for (Seccion seccionListNewSeccionToAttach : seccionListNew) {
                seccionListNewSeccionToAttach = em.getReference(seccionListNewSeccionToAttach.getClass(), seccionListNewSeccionToAttach.getIdSeccion());
                attachedSeccionListNew.add(seccionListNewSeccionToAttach);
            }
            seccionListNew = attachedSeccionListNew;
            turno.setSeccionList(seccionListNew);
            turno = em.merge(turno);
            for (Seccion seccionListNewSeccion : seccionListNew) {
                if (!seccionListOld.contains(seccionListNewSeccion)) {
                    Turno oldIdTurnoOfSeccionListNewSeccion = seccionListNewSeccion.getIdTurno();
                    seccionListNewSeccion.setIdTurno(turno);
                    seccionListNewSeccion = em.merge(seccionListNewSeccion);
                    if (oldIdTurnoOfSeccionListNewSeccion != null && !oldIdTurnoOfSeccionListNewSeccion.equals(turno)) {
                        oldIdTurnoOfSeccionListNewSeccion.getSeccionList().remove(seccionListNewSeccion);
                        oldIdTurnoOfSeccionListNewSeccion = em.merge(oldIdTurnoOfSeccionListNewSeccion);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                BigDecimal id = turno.getIdTurno();
                if (findTurno(id) == null) {
                    throw new NonexistentEntityException("The turno with id " + id + " no longer exists.");
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
            Turno turno;
            try {
                turno = em.getReference(Turno.class, id);
                turno.getIdTurno();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The turno with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Seccion> seccionListOrphanCheck = turno.getSeccionList();
            for (Seccion seccionListOrphanCheckSeccion : seccionListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Turno (" + turno + ") cannot be destroyed since the Seccion " + seccionListOrphanCheckSeccion + " in its seccionList field has a non-nullable idTurno field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(turno);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Turno> findTurnoEntities() {
        return findTurnoEntities(true, -1, -1);
    }

    public List<Turno> findTurnoEntities(int maxResults, int firstResult) {
        return findTurnoEntities(false, maxResults, firstResult);
    }

    private List<Turno> findTurnoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Turno.class));
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

    public Turno findTurno(BigDecimal id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Turno.class, id);
        } finally {
            em.close();
        }
    }

    public int getTurnoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Turno> rt = cq.from(Turno.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

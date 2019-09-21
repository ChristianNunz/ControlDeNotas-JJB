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
import Logica_Negocios.AlumnoResponsable;
import Logica_Negocios.Responsable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Jorge Villanueva
 */
public class ResponsableJpaController implements Serializable {

    public ResponsableJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Responsable responsable) throws PreexistingEntityException, Exception {
        if (responsable.getAlumnoResponsableList() == null) {
            responsable.setAlumnoResponsableList(new ArrayList<AlumnoResponsable>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<AlumnoResponsable> attachedAlumnoResponsableList = new ArrayList<AlumnoResponsable>();
            for (AlumnoResponsable alumnoResponsableListAlumnoResponsableToAttach : responsable.getAlumnoResponsableList()) {
                alumnoResponsableListAlumnoResponsableToAttach = em.getReference(alumnoResponsableListAlumnoResponsableToAttach.getClass(), alumnoResponsableListAlumnoResponsableToAttach.getIdAlumnoResponsable());
                attachedAlumnoResponsableList.add(alumnoResponsableListAlumnoResponsableToAttach);
            }
            responsable.setAlumnoResponsableList(attachedAlumnoResponsableList);
            em.persist(responsable);
            for (AlumnoResponsable alumnoResponsableListAlumnoResponsable : responsable.getAlumnoResponsableList()) {
                Responsable oldIdEsponsableOfAlumnoResponsableListAlumnoResponsable = alumnoResponsableListAlumnoResponsable.getIdEsponsable();
                alumnoResponsableListAlumnoResponsable.setIdEsponsable(responsable);
                alumnoResponsableListAlumnoResponsable = em.merge(alumnoResponsableListAlumnoResponsable);
                if (oldIdEsponsableOfAlumnoResponsableListAlumnoResponsable != null) {
                    oldIdEsponsableOfAlumnoResponsableListAlumnoResponsable.getAlumnoResponsableList().remove(alumnoResponsableListAlumnoResponsable);
                    oldIdEsponsableOfAlumnoResponsableListAlumnoResponsable = em.merge(oldIdEsponsableOfAlumnoResponsableListAlumnoResponsable);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findResponsable(responsable.getIdResponsable()) != null) {
                throw new PreexistingEntityException("Responsable " + responsable + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Responsable responsable) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Responsable persistentResponsable = em.find(Responsable.class, responsable.getIdResponsable());
            List<AlumnoResponsable> alumnoResponsableListOld = persistentResponsable.getAlumnoResponsableList();
            List<AlumnoResponsable> alumnoResponsableListNew = responsable.getAlumnoResponsableList();
            List<String> illegalOrphanMessages = null;
            for (AlumnoResponsable alumnoResponsableListOldAlumnoResponsable : alumnoResponsableListOld) {
                if (!alumnoResponsableListNew.contains(alumnoResponsableListOldAlumnoResponsable)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain AlumnoResponsable " + alumnoResponsableListOldAlumnoResponsable + " since its idEsponsable field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<AlumnoResponsable> attachedAlumnoResponsableListNew = new ArrayList<AlumnoResponsable>();
            for (AlumnoResponsable alumnoResponsableListNewAlumnoResponsableToAttach : alumnoResponsableListNew) {
                alumnoResponsableListNewAlumnoResponsableToAttach = em.getReference(alumnoResponsableListNewAlumnoResponsableToAttach.getClass(), alumnoResponsableListNewAlumnoResponsableToAttach.getIdAlumnoResponsable());
                attachedAlumnoResponsableListNew.add(alumnoResponsableListNewAlumnoResponsableToAttach);
            }
            alumnoResponsableListNew = attachedAlumnoResponsableListNew;
            responsable.setAlumnoResponsableList(alumnoResponsableListNew);
            responsable = em.merge(responsable);
            for (AlumnoResponsable alumnoResponsableListNewAlumnoResponsable : alumnoResponsableListNew) {
                if (!alumnoResponsableListOld.contains(alumnoResponsableListNewAlumnoResponsable)) {
                    Responsable oldIdEsponsableOfAlumnoResponsableListNewAlumnoResponsable = alumnoResponsableListNewAlumnoResponsable.getIdEsponsable();
                    alumnoResponsableListNewAlumnoResponsable.setIdEsponsable(responsable);
                    alumnoResponsableListNewAlumnoResponsable = em.merge(alumnoResponsableListNewAlumnoResponsable);
                    if (oldIdEsponsableOfAlumnoResponsableListNewAlumnoResponsable != null && !oldIdEsponsableOfAlumnoResponsableListNewAlumnoResponsable.equals(responsable)) {
                        oldIdEsponsableOfAlumnoResponsableListNewAlumnoResponsable.getAlumnoResponsableList().remove(alumnoResponsableListNewAlumnoResponsable);
                        oldIdEsponsableOfAlumnoResponsableListNewAlumnoResponsable = em.merge(oldIdEsponsableOfAlumnoResponsableListNewAlumnoResponsable);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                BigDecimal id = responsable.getIdResponsable();
                if (findResponsable(id) == null) {
                    throw new NonexistentEntityException("The responsable with id " + id + " no longer exists.");
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
            Responsable responsable;
            try {
                responsable = em.getReference(Responsable.class, id);
                responsable.getIdResponsable();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The responsable with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<AlumnoResponsable> alumnoResponsableListOrphanCheck = responsable.getAlumnoResponsableList();
            for (AlumnoResponsable alumnoResponsableListOrphanCheckAlumnoResponsable : alumnoResponsableListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Responsable (" + responsable + ") cannot be destroyed since the AlumnoResponsable " + alumnoResponsableListOrphanCheckAlumnoResponsable + " in its alumnoResponsableList field has a non-nullable idEsponsable field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(responsable);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Responsable> findResponsableEntities() {
        return findResponsableEntities(true, -1, -1);
    }

    public List<Responsable> findResponsableEntities(int maxResults, int firstResult) {
        return findResponsableEntities(false, maxResults, firstResult);
    }

    private List<Responsable> findResponsableEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Responsable.class));
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

    public Responsable findResponsable(BigDecimal id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Responsable.class, id);
        } finally {
            em.close();
        }
    }

    public int getResponsableCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Responsable> rt = cq.from(Responsable.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

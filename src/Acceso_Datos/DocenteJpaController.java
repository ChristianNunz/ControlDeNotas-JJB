/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acceso_Datos;

import Acceso_Datos.exceptions.IllegalOrphanException;
import Acceso_Datos.exceptions.NonexistentEntityException;
import Acceso_Datos.exceptions.PreexistingEntityException;
import Logica_Negocios.Docente;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Logica_Negocios.DocenteMateria;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Jorge Villanueva
 */
public class DocenteJpaController implements Serializable {

    public DocenteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Docente docente) throws PreexistingEntityException, Exception {
        if (docente.getDocenteMateriaList() == null) {
            docente.setDocenteMateriaList(new ArrayList<DocenteMateria>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<DocenteMateria> attachedDocenteMateriaList = new ArrayList<DocenteMateria>();
            for (DocenteMateria docenteMateriaListDocenteMateriaToAttach : docente.getDocenteMateriaList()) {
                docenteMateriaListDocenteMateriaToAttach = em.getReference(docenteMateriaListDocenteMateriaToAttach.getClass(), docenteMateriaListDocenteMateriaToAttach.getIdDocenteMateria());
                attachedDocenteMateriaList.add(docenteMateriaListDocenteMateriaToAttach);
            }
            docente.setDocenteMateriaList(attachedDocenteMateriaList);
            em.persist(docente);
            for (DocenteMateria docenteMateriaListDocenteMateria : docente.getDocenteMateriaList()) {
                Docente oldIdDocenteOfDocenteMateriaListDocenteMateria = docenteMateriaListDocenteMateria.getIdDocente();
                docenteMateriaListDocenteMateria.setIdDocente(docente);
                docenteMateriaListDocenteMateria = em.merge(docenteMateriaListDocenteMateria);
                if (oldIdDocenteOfDocenteMateriaListDocenteMateria != null) {
                    oldIdDocenteOfDocenteMateriaListDocenteMateria.getDocenteMateriaList().remove(docenteMateriaListDocenteMateria);
                    oldIdDocenteOfDocenteMateriaListDocenteMateria = em.merge(oldIdDocenteOfDocenteMateriaListDocenteMateria);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findDocente(docente.getIdDocente()) != null) {
                throw new PreexistingEntityException("Docente " + docente + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Docente docente) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Docente persistentDocente = em.find(Docente.class, docente.getIdDocente());
            List<DocenteMateria> docenteMateriaListOld = persistentDocente.getDocenteMateriaList();
            List<DocenteMateria> docenteMateriaListNew = docente.getDocenteMateriaList();
            List<String> illegalOrphanMessages = null;
            for (DocenteMateria docenteMateriaListOldDocenteMateria : docenteMateriaListOld) {
                if (!docenteMateriaListNew.contains(docenteMateriaListOldDocenteMateria)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain DocenteMateria " + docenteMateriaListOldDocenteMateria + " since its idDocente field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<DocenteMateria> attachedDocenteMateriaListNew = new ArrayList<DocenteMateria>();
            for (DocenteMateria docenteMateriaListNewDocenteMateriaToAttach : docenteMateriaListNew) {
                docenteMateriaListNewDocenteMateriaToAttach = em.getReference(docenteMateriaListNewDocenteMateriaToAttach.getClass(), docenteMateriaListNewDocenteMateriaToAttach.getIdDocenteMateria());
                attachedDocenteMateriaListNew.add(docenteMateriaListNewDocenteMateriaToAttach);
            }
            docenteMateriaListNew = attachedDocenteMateriaListNew;
            docente.setDocenteMateriaList(docenteMateriaListNew);
            docente = em.merge(docente);
            for (DocenteMateria docenteMateriaListNewDocenteMateria : docenteMateriaListNew) {
                if (!docenteMateriaListOld.contains(docenteMateriaListNewDocenteMateria)) {
                    Docente oldIdDocenteOfDocenteMateriaListNewDocenteMateria = docenteMateriaListNewDocenteMateria.getIdDocente();
                    docenteMateriaListNewDocenteMateria.setIdDocente(docente);
                    docenteMateriaListNewDocenteMateria = em.merge(docenteMateriaListNewDocenteMateria);
                    if (oldIdDocenteOfDocenteMateriaListNewDocenteMateria != null && !oldIdDocenteOfDocenteMateriaListNewDocenteMateria.equals(docente)) {
                        oldIdDocenteOfDocenteMateriaListNewDocenteMateria.getDocenteMateriaList().remove(docenteMateriaListNewDocenteMateria);
                        oldIdDocenteOfDocenteMateriaListNewDocenteMateria = em.merge(oldIdDocenteOfDocenteMateriaListNewDocenteMateria);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                BigDecimal id = docente.getIdDocente();
                if (findDocente(id) == null) {
                    throw new NonexistentEntityException("The docente with id " + id + " no longer exists.");
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
            Docente docente;
            try {
                docente = em.getReference(Docente.class, id);
                docente.getIdDocente();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The docente with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<DocenteMateria> docenteMateriaListOrphanCheck = docente.getDocenteMateriaList();
            for (DocenteMateria docenteMateriaListOrphanCheckDocenteMateria : docenteMateriaListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Docente (" + docente + ") cannot be destroyed since the DocenteMateria " + docenteMateriaListOrphanCheckDocenteMateria + " in its docenteMateriaList field has a non-nullable idDocente field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(docente);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Docente> findDocenteEntities() {
        return findDocenteEntities(true, -1, -1);
    }

    public List<Docente> findDocenteEntities(int maxResults, int firstResult) {
        return findDocenteEntities(false, maxResults, firstResult);
    }

    private List<Docente> findDocenteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Docente.class));
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

    public Docente findDocente(BigDecimal id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Docente.class, id);
        } finally {
            em.close();
        }
    }

    public int getDocenteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Docente> rt = cq.from(Docente.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

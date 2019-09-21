/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acceso_Datos;

import Acceso_Datos.exceptions.IllegalOrphanException;
import Acceso_Datos.exceptions.NonexistentEntityException;
import Acceso_Datos.exceptions.PreexistingEntityException;
import Logica_Negocios.Grado;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Logica_Negocios.MateriaGrado;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Jorge Villanueva
 */
public class GradoJpaController implements Serializable {

    public GradoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Grado grado) throws PreexistingEntityException, Exception {
        if (grado.getMateriaGradoList() == null) {
            grado.setMateriaGradoList(new ArrayList<MateriaGrado>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<MateriaGrado> attachedMateriaGradoList = new ArrayList<MateriaGrado>();
            for (MateriaGrado materiaGradoListMateriaGradoToAttach : grado.getMateriaGradoList()) {
                materiaGradoListMateriaGradoToAttach = em.getReference(materiaGradoListMateriaGradoToAttach.getClass(), materiaGradoListMateriaGradoToAttach.getIdMateriaGrado());
                attachedMateriaGradoList.add(materiaGradoListMateriaGradoToAttach);
            }
            grado.setMateriaGradoList(attachedMateriaGradoList);
            em.persist(grado);
            for (MateriaGrado materiaGradoListMateriaGrado : grado.getMateriaGradoList()) {
                Grado oldIdGradoOfMateriaGradoListMateriaGrado = materiaGradoListMateriaGrado.getIdGrado();
                materiaGradoListMateriaGrado.setIdGrado(grado);
                materiaGradoListMateriaGrado = em.merge(materiaGradoListMateriaGrado);
                if (oldIdGradoOfMateriaGradoListMateriaGrado != null) {
                    oldIdGradoOfMateriaGradoListMateriaGrado.getMateriaGradoList().remove(materiaGradoListMateriaGrado);
                    oldIdGradoOfMateriaGradoListMateriaGrado = em.merge(oldIdGradoOfMateriaGradoListMateriaGrado);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findGrado(grado.getIdGrado()) != null) {
                throw new PreexistingEntityException("Grado " + grado + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Grado grado) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Grado persistentGrado = em.find(Grado.class, grado.getIdGrado());
            List<MateriaGrado> materiaGradoListOld = persistentGrado.getMateriaGradoList();
            List<MateriaGrado> materiaGradoListNew = grado.getMateriaGradoList();
            List<String> illegalOrphanMessages = null;
            for (MateriaGrado materiaGradoListOldMateriaGrado : materiaGradoListOld) {
                if (!materiaGradoListNew.contains(materiaGradoListOldMateriaGrado)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain MateriaGrado " + materiaGradoListOldMateriaGrado + " since its idGrado field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<MateriaGrado> attachedMateriaGradoListNew = new ArrayList<MateriaGrado>();
            for (MateriaGrado materiaGradoListNewMateriaGradoToAttach : materiaGradoListNew) {
                materiaGradoListNewMateriaGradoToAttach = em.getReference(materiaGradoListNewMateriaGradoToAttach.getClass(), materiaGradoListNewMateriaGradoToAttach.getIdMateriaGrado());
                attachedMateriaGradoListNew.add(materiaGradoListNewMateriaGradoToAttach);
            }
            materiaGradoListNew = attachedMateriaGradoListNew;
            grado.setMateriaGradoList(materiaGradoListNew);
            grado = em.merge(grado);
            for (MateriaGrado materiaGradoListNewMateriaGrado : materiaGradoListNew) {
                if (!materiaGradoListOld.contains(materiaGradoListNewMateriaGrado)) {
                    Grado oldIdGradoOfMateriaGradoListNewMateriaGrado = materiaGradoListNewMateriaGrado.getIdGrado();
                    materiaGradoListNewMateriaGrado.setIdGrado(grado);
                    materiaGradoListNewMateriaGrado = em.merge(materiaGradoListNewMateriaGrado);
                    if (oldIdGradoOfMateriaGradoListNewMateriaGrado != null && !oldIdGradoOfMateriaGradoListNewMateriaGrado.equals(grado)) {
                        oldIdGradoOfMateriaGradoListNewMateriaGrado.getMateriaGradoList().remove(materiaGradoListNewMateriaGrado);
                        oldIdGradoOfMateriaGradoListNewMateriaGrado = em.merge(oldIdGradoOfMateriaGradoListNewMateriaGrado);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                BigDecimal id = grado.getIdGrado();
                if (findGrado(id) == null) {
                    throw new NonexistentEntityException("The grado with id " + id + " no longer exists.");
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
            Grado grado;
            try {
                grado = em.getReference(Grado.class, id);
                grado.getIdGrado();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The grado with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<MateriaGrado> materiaGradoListOrphanCheck = grado.getMateriaGradoList();
            for (MateriaGrado materiaGradoListOrphanCheckMateriaGrado : materiaGradoListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Grado (" + grado + ") cannot be destroyed since the MateriaGrado " + materiaGradoListOrphanCheckMateriaGrado + " in its materiaGradoList field has a non-nullable idGrado field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(grado);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Grado> findGradoEntities() {
        return findGradoEntities(true, -1, -1);
    }

    public List<Grado> findGradoEntities(int maxResults, int firstResult) {
        return findGradoEntities(false, maxResults, firstResult);
    }

    private List<Grado> findGradoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Grado.class));
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

    public Grado findGrado(BigDecimal id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Grado.class, id);
        } finally {
            em.close();
        }
    }

    public int getGradoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Grado> rt = cq.from(Grado.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

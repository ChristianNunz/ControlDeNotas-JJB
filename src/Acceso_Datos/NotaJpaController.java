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
import Logica_Negocios.Alumno;
import Logica_Negocios.Materia;
import Logica_Negocios.Nota;
import Logica_Negocios.Periodo;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Jorge Villanueva
 */
public class NotaJpaController implements Serializable {

    public NotaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Nota nota) throws PreexistingEntityException, Exception {
        if (nota.getPeriodoList() == null) {
            nota.setPeriodoList(new ArrayList<Periodo>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Alumno idAlumno = nota.getIdAlumno();
            if (idAlumno != null) {
                idAlumno = em.getReference(idAlumno.getClass(), idAlumno.getIdAlumno());
                nota.setIdAlumno(idAlumno);
            }
            Materia idMateria = nota.getIdMateria();
            if (idMateria != null) {
                idMateria = em.getReference(idMateria.getClass(), idMateria.getIdMateria());
                nota.setIdMateria(idMateria);
            }
            List<Periodo> attachedPeriodoList = new ArrayList<Periodo>();
            for (Periodo periodoListPeriodoToAttach : nota.getPeriodoList()) {
                periodoListPeriodoToAttach = em.getReference(periodoListPeriodoToAttach.getClass(), periodoListPeriodoToAttach.getIdPeriodo());
                attachedPeriodoList.add(periodoListPeriodoToAttach);
            }
            nota.setPeriodoList(attachedPeriodoList);
            em.persist(nota);
            if (idAlumno != null) {
                idAlumno.getNotaList().add(nota);
                idAlumno = em.merge(idAlumno);
            }
            if (idMateria != null) {
                idMateria.getNotaList().add(nota);
                idMateria = em.merge(idMateria);
            }
            for (Periodo periodoListPeriodo : nota.getPeriodoList()) {
                Nota oldIdNotaOfPeriodoListPeriodo = periodoListPeriodo.getIdNota();
                periodoListPeriodo.setIdNota(nota);
                periodoListPeriodo = em.merge(periodoListPeriodo);
                if (oldIdNotaOfPeriodoListPeriodo != null) {
                    oldIdNotaOfPeriodoListPeriodo.getPeriodoList().remove(periodoListPeriodo);
                    oldIdNotaOfPeriodoListPeriodo = em.merge(oldIdNotaOfPeriodoListPeriodo);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findNota(nota.getIdNota()) != null) {
                throw new PreexistingEntityException("Nota " + nota + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Nota nota) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Nota persistentNota = em.find(Nota.class, nota.getIdNota());
            Alumno idAlumnoOld = persistentNota.getIdAlumno();
            Alumno idAlumnoNew = nota.getIdAlumno();
            Materia idMateriaOld = persistentNota.getIdMateria();
            Materia idMateriaNew = nota.getIdMateria();
            List<Periodo> periodoListOld = persistentNota.getPeriodoList();
            List<Periodo> periodoListNew = nota.getPeriodoList();
            List<String> illegalOrphanMessages = null;
            for (Periodo periodoListOldPeriodo : periodoListOld) {
                if (!periodoListNew.contains(periodoListOldPeriodo)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Periodo " + periodoListOldPeriodo + " since its idNota field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (idAlumnoNew != null) {
                idAlumnoNew = em.getReference(idAlumnoNew.getClass(), idAlumnoNew.getIdAlumno());
                nota.setIdAlumno(idAlumnoNew);
            }
            if (idMateriaNew != null) {
                idMateriaNew = em.getReference(idMateriaNew.getClass(), idMateriaNew.getIdMateria());
                nota.setIdMateria(idMateriaNew);
            }
            List<Periodo> attachedPeriodoListNew = new ArrayList<Periodo>();
            for (Periodo periodoListNewPeriodoToAttach : periodoListNew) {
                periodoListNewPeriodoToAttach = em.getReference(periodoListNewPeriodoToAttach.getClass(), periodoListNewPeriodoToAttach.getIdPeriodo());
                attachedPeriodoListNew.add(periodoListNewPeriodoToAttach);
            }
            periodoListNew = attachedPeriodoListNew;
            nota.setPeriodoList(periodoListNew);
            nota = em.merge(nota);
            if (idAlumnoOld != null && !idAlumnoOld.equals(idAlumnoNew)) {
                idAlumnoOld.getNotaList().remove(nota);
                idAlumnoOld = em.merge(idAlumnoOld);
            }
            if (idAlumnoNew != null && !idAlumnoNew.equals(idAlumnoOld)) {
                idAlumnoNew.getNotaList().add(nota);
                idAlumnoNew = em.merge(idAlumnoNew);
            }
            if (idMateriaOld != null && !idMateriaOld.equals(idMateriaNew)) {
                idMateriaOld.getNotaList().remove(nota);
                idMateriaOld = em.merge(idMateriaOld);
            }
            if (idMateriaNew != null && !idMateriaNew.equals(idMateriaOld)) {
                idMateriaNew.getNotaList().add(nota);
                idMateriaNew = em.merge(idMateriaNew);
            }
            for (Periodo periodoListNewPeriodo : periodoListNew) {
                if (!periodoListOld.contains(periodoListNewPeriodo)) {
                    Nota oldIdNotaOfPeriodoListNewPeriodo = periodoListNewPeriodo.getIdNota();
                    periodoListNewPeriodo.setIdNota(nota);
                    periodoListNewPeriodo = em.merge(periodoListNewPeriodo);
                    if (oldIdNotaOfPeriodoListNewPeriodo != null && !oldIdNotaOfPeriodoListNewPeriodo.equals(nota)) {
                        oldIdNotaOfPeriodoListNewPeriodo.getPeriodoList().remove(periodoListNewPeriodo);
                        oldIdNotaOfPeriodoListNewPeriodo = em.merge(oldIdNotaOfPeriodoListNewPeriodo);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                BigDecimal id = nota.getIdNota();
                if (findNota(id) == null) {
                    throw new NonexistentEntityException("The nota with id " + id + " no longer exists.");
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
            Nota nota;
            try {
                nota = em.getReference(Nota.class, id);
                nota.getIdNota();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The nota with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Periodo> periodoListOrphanCheck = nota.getPeriodoList();
            for (Periodo periodoListOrphanCheckPeriodo : periodoListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Nota (" + nota + ") cannot be destroyed since the Periodo " + periodoListOrphanCheckPeriodo + " in its periodoList field has a non-nullable idNota field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Alumno idAlumno = nota.getIdAlumno();
            if (idAlumno != null) {
                idAlumno.getNotaList().remove(nota);
                idAlumno = em.merge(idAlumno);
            }
            Materia idMateria = nota.getIdMateria();
            if (idMateria != null) {
                idMateria.getNotaList().remove(nota);
                idMateria = em.merge(idMateria);
            }
            em.remove(nota);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Nota> findNotaEntities() {
        return findNotaEntities(true, -1, -1);
    }

    public List<Nota> findNotaEntities(int maxResults, int firstResult) {
        return findNotaEntities(false, maxResults, firstResult);
    }

    private List<Nota> findNotaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Nota.class));
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

    public Nota findNota(BigDecimal id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Nota.class, id);
        } finally {
            em.close();
        }
    }

    public int getNotaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Nota> rt = cq.from(Nota.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

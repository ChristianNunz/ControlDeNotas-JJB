/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acceso_Datos;

import Acceso_Datos.exceptions.IllegalOrphanException;
import Acceso_Datos.exceptions.NonexistentEntityException;
import Acceso_Datos.exceptions.PreexistingEntityException;
import Logica_Negocios.Alumno;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Logica_Negocios.AlumnoResponsable;
import java.util.ArrayList;
import java.util.List;
import Logica_Negocios.Nota;
import java.math.BigDecimal;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Jorge Villanueva
 */
public class AlumnoJpaController implements Serializable {

    public AlumnoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Alumno alumno) throws PreexistingEntityException, Exception {
        if (alumno.getAlumnoResponsableList() == null) {
            alumno.setAlumnoResponsableList(new ArrayList<AlumnoResponsable>());
        }
        if (alumno.getNotaList() == null) {
            alumno.setNotaList(new ArrayList<Nota>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<AlumnoResponsable> attachedAlumnoResponsableList = new ArrayList<AlumnoResponsable>();
            for (AlumnoResponsable alumnoResponsableListAlumnoResponsableToAttach : alumno.getAlumnoResponsableList()) {
                alumnoResponsableListAlumnoResponsableToAttach = em.getReference(alumnoResponsableListAlumnoResponsableToAttach.getClass(), alumnoResponsableListAlumnoResponsableToAttach.getIdAlumnoResponsable());
                attachedAlumnoResponsableList.add(alumnoResponsableListAlumnoResponsableToAttach);
            }
            alumno.setAlumnoResponsableList(attachedAlumnoResponsableList);
            List<Nota> attachedNotaList = new ArrayList<Nota>();
            for (Nota notaListNotaToAttach : alumno.getNotaList()) {
                notaListNotaToAttach = em.getReference(notaListNotaToAttach.getClass(), notaListNotaToAttach.getIdNota());
                attachedNotaList.add(notaListNotaToAttach);
            }
            alumno.setNotaList(attachedNotaList);
            em.persist(alumno);
            for (AlumnoResponsable alumnoResponsableListAlumnoResponsable : alumno.getAlumnoResponsableList()) {
                Alumno oldIdAlumnoOfAlumnoResponsableListAlumnoResponsable = alumnoResponsableListAlumnoResponsable.getIdAlumno();
                alumnoResponsableListAlumnoResponsable.setIdAlumno(alumno);
                alumnoResponsableListAlumnoResponsable = em.merge(alumnoResponsableListAlumnoResponsable);
                if (oldIdAlumnoOfAlumnoResponsableListAlumnoResponsable != null) {
                    oldIdAlumnoOfAlumnoResponsableListAlumnoResponsable.getAlumnoResponsableList().remove(alumnoResponsableListAlumnoResponsable);
                    oldIdAlumnoOfAlumnoResponsableListAlumnoResponsable = em.merge(oldIdAlumnoOfAlumnoResponsableListAlumnoResponsable);
                }
            }
            for (Nota notaListNota : alumno.getNotaList()) {
                Alumno oldIdAlumnoOfNotaListNota = notaListNota.getIdAlumno();
                notaListNota.setIdAlumno(alumno);
                notaListNota = em.merge(notaListNota);
                if (oldIdAlumnoOfNotaListNota != null) {
                    oldIdAlumnoOfNotaListNota.getNotaList().remove(notaListNota);
                    oldIdAlumnoOfNotaListNota = em.merge(oldIdAlumnoOfNotaListNota);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findAlumno(alumno.getIdAlumno()) != null) {
                throw new PreexistingEntityException("Alumno " + alumno + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Alumno alumno) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Alumno persistentAlumno = em.find(Alumno.class, alumno.getIdAlumno());
            List<AlumnoResponsable> alumnoResponsableListOld = persistentAlumno.getAlumnoResponsableList();
            List<AlumnoResponsable> alumnoResponsableListNew = alumno.getAlumnoResponsableList();
            List<Nota> notaListOld = persistentAlumno.getNotaList();
            List<Nota> notaListNew = alumno.getNotaList();
            List<String> illegalOrphanMessages = null;
            for (AlumnoResponsable alumnoResponsableListOldAlumnoResponsable : alumnoResponsableListOld) {
                if (!alumnoResponsableListNew.contains(alumnoResponsableListOldAlumnoResponsable)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain AlumnoResponsable " + alumnoResponsableListOldAlumnoResponsable + " since its idAlumno field is not nullable.");
                }
            }
            for (Nota notaListOldNota : notaListOld) {
                if (!notaListNew.contains(notaListOldNota)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Nota " + notaListOldNota + " since its idAlumno field is not nullable.");
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
            alumno.setAlumnoResponsableList(alumnoResponsableListNew);
            List<Nota> attachedNotaListNew = new ArrayList<Nota>();
            for (Nota notaListNewNotaToAttach : notaListNew) {
                notaListNewNotaToAttach = em.getReference(notaListNewNotaToAttach.getClass(), notaListNewNotaToAttach.getIdNota());
                attachedNotaListNew.add(notaListNewNotaToAttach);
            }
            notaListNew = attachedNotaListNew;
            alumno.setNotaList(notaListNew);
            alumno = em.merge(alumno);
            for (AlumnoResponsable alumnoResponsableListNewAlumnoResponsable : alumnoResponsableListNew) {
                if (!alumnoResponsableListOld.contains(alumnoResponsableListNewAlumnoResponsable)) {
                    Alumno oldIdAlumnoOfAlumnoResponsableListNewAlumnoResponsable = alumnoResponsableListNewAlumnoResponsable.getIdAlumno();
                    alumnoResponsableListNewAlumnoResponsable.setIdAlumno(alumno);
                    alumnoResponsableListNewAlumnoResponsable = em.merge(alumnoResponsableListNewAlumnoResponsable);
                    if (oldIdAlumnoOfAlumnoResponsableListNewAlumnoResponsable != null && !oldIdAlumnoOfAlumnoResponsableListNewAlumnoResponsable.equals(alumno)) {
                        oldIdAlumnoOfAlumnoResponsableListNewAlumnoResponsable.getAlumnoResponsableList().remove(alumnoResponsableListNewAlumnoResponsable);
                        oldIdAlumnoOfAlumnoResponsableListNewAlumnoResponsable = em.merge(oldIdAlumnoOfAlumnoResponsableListNewAlumnoResponsable);
                    }
                }
            }
            for (Nota notaListNewNota : notaListNew) {
                if (!notaListOld.contains(notaListNewNota)) {
                    Alumno oldIdAlumnoOfNotaListNewNota = notaListNewNota.getIdAlumno();
                    notaListNewNota.setIdAlumno(alumno);
                    notaListNewNota = em.merge(notaListNewNota);
                    if (oldIdAlumnoOfNotaListNewNota != null && !oldIdAlumnoOfNotaListNewNota.equals(alumno)) {
                        oldIdAlumnoOfNotaListNewNota.getNotaList().remove(notaListNewNota);
                        oldIdAlumnoOfNotaListNewNota = em.merge(oldIdAlumnoOfNotaListNewNota);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                BigDecimal id = alumno.getIdAlumno();
                if (findAlumno(id) == null) {
                    throw new NonexistentEntityException("The alumno with id " + id + " no longer exists.");
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
            Alumno alumno;
            try {
                alumno = em.getReference(Alumno.class, id);
                alumno.getIdAlumno();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The alumno with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<AlumnoResponsable> alumnoResponsableListOrphanCheck = alumno.getAlumnoResponsableList();
            for (AlumnoResponsable alumnoResponsableListOrphanCheckAlumnoResponsable : alumnoResponsableListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Alumno (" + alumno + ") cannot be destroyed since the AlumnoResponsable " + alumnoResponsableListOrphanCheckAlumnoResponsable + " in its alumnoResponsableList field has a non-nullable idAlumno field.");
            }
            List<Nota> notaListOrphanCheck = alumno.getNotaList();
            for (Nota notaListOrphanCheckNota : notaListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Alumno (" + alumno + ") cannot be destroyed since the Nota " + notaListOrphanCheckNota + " in its notaList field has a non-nullable idAlumno field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(alumno);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Alumno> findAlumnoEntities() {
        return findAlumnoEntities(true, -1, -1);
    }

    public List<Alumno> findAlumnoEntities(int maxResults, int firstResult) {
        return findAlumnoEntities(false, maxResults, firstResult);
    }

    private List<Alumno> findAlumnoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Alumno.class));
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

    public Alumno findAlumno(BigDecimal id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Alumno.class, id);
        } finally {
            em.close();
        }
    }

    public int getAlumnoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Alumno> rt = cq.from(Alumno.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

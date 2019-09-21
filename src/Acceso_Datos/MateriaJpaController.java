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
import Logica_Negocios.DocenteMateria;
import java.util.ArrayList;
import java.util.List;
import Logica_Negocios.Seccion;
import Logica_Negocios.Anho;
import Logica_Negocios.Materia;
import Logica_Negocios.Nota;
import Logica_Negocios.MateriaGrado;
import java.math.BigDecimal;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Jorge Villanueva
 */
public class MateriaJpaController implements Serializable {

    public MateriaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Materia materia) throws PreexistingEntityException, Exception {
        if (materia.getDocenteMateriaList() == null) {
            materia.setDocenteMateriaList(new ArrayList<DocenteMateria>());
        }
        if (materia.getSeccionList() == null) {
            materia.setSeccionList(new ArrayList<Seccion>());
        }
        if (materia.getAnhoList() == null) {
            materia.setAnhoList(new ArrayList<Anho>());
        }
        if (materia.getNotaList() == null) {
            materia.setNotaList(new ArrayList<Nota>());
        }
        if (materia.getMateriaGradoList() == null) {
            materia.setMateriaGradoList(new ArrayList<MateriaGrado>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<DocenteMateria> attachedDocenteMateriaList = new ArrayList<DocenteMateria>();
            for (DocenteMateria docenteMateriaListDocenteMateriaToAttach : materia.getDocenteMateriaList()) {
                docenteMateriaListDocenteMateriaToAttach = em.getReference(docenteMateriaListDocenteMateriaToAttach.getClass(), docenteMateriaListDocenteMateriaToAttach.getIdDocenteMateria());
                attachedDocenteMateriaList.add(docenteMateriaListDocenteMateriaToAttach);
            }
            materia.setDocenteMateriaList(attachedDocenteMateriaList);
            List<Seccion> attachedSeccionList = new ArrayList<Seccion>();
            for (Seccion seccionListSeccionToAttach : materia.getSeccionList()) {
                seccionListSeccionToAttach = em.getReference(seccionListSeccionToAttach.getClass(), seccionListSeccionToAttach.getIdSeccion());
                attachedSeccionList.add(seccionListSeccionToAttach);
            }
            materia.setSeccionList(attachedSeccionList);
            List<Anho> attachedAnhoList = new ArrayList<Anho>();
            for (Anho anhoListAnhoToAttach : materia.getAnhoList()) {
                anhoListAnhoToAttach = em.getReference(anhoListAnhoToAttach.getClass(), anhoListAnhoToAttach.getIdAnho());
                attachedAnhoList.add(anhoListAnhoToAttach);
            }
            materia.setAnhoList(attachedAnhoList);
            List<Nota> attachedNotaList = new ArrayList<Nota>();
            for (Nota notaListNotaToAttach : materia.getNotaList()) {
                notaListNotaToAttach = em.getReference(notaListNotaToAttach.getClass(), notaListNotaToAttach.getIdNota());
                attachedNotaList.add(notaListNotaToAttach);
            }
            materia.setNotaList(attachedNotaList);
            List<MateriaGrado> attachedMateriaGradoList = new ArrayList<MateriaGrado>();
            for (MateriaGrado materiaGradoListMateriaGradoToAttach : materia.getMateriaGradoList()) {
                materiaGradoListMateriaGradoToAttach = em.getReference(materiaGradoListMateriaGradoToAttach.getClass(), materiaGradoListMateriaGradoToAttach.getIdMateriaGrado());
                attachedMateriaGradoList.add(materiaGradoListMateriaGradoToAttach);
            }
            materia.setMateriaGradoList(attachedMateriaGradoList);
            em.persist(materia);
            for (DocenteMateria docenteMateriaListDocenteMateria : materia.getDocenteMateriaList()) {
                Materia oldIdMateriaOfDocenteMateriaListDocenteMateria = docenteMateriaListDocenteMateria.getIdMateria();
                docenteMateriaListDocenteMateria.setIdMateria(materia);
                docenteMateriaListDocenteMateria = em.merge(docenteMateriaListDocenteMateria);
                if (oldIdMateriaOfDocenteMateriaListDocenteMateria != null) {
                    oldIdMateriaOfDocenteMateriaListDocenteMateria.getDocenteMateriaList().remove(docenteMateriaListDocenteMateria);
                    oldIdMateriaOfDocenteMateriaListDocenteMateria = em.merge(oldIdMateriaOfDocenteMateriaListDocenteMateria);
                }
            }
            for (Seccion seccionListSeccion : materia.getSeccionList()) {
                Materia oldIdMateriaOfSeccionListSeccion = seccionListSeccion.getIdMateria();
                seccionListSeccion.setIdMateria(materia);
                seccionListSeccion = em.merge(seccionListSeccion);
                if (oldIdMateriaOfSeccionListSeccion != null) {
                    oldIdMateriaOfSeccionListSeccion.getSeccionList().remove(seccionListSeccion);
                    oldIdMateriaOfSeccionListSeccion = em.merge(oldIdMateriaOfSeccionListSeccion);
                }
            }
            for (Anho anhoListAnho : materia.getAnhoList()) {
                Materia oldMateriaIdMateriaOfAnhoListAnho = anhoListAnho.getMateriaIdMateria();
                anhoListAnho.setMateriaIdMateria(materia);
                anhoListAnho = em.merge(anhoListAnho);
                if (oldMateriaIdMateriaOfAnhoListAnho != null) {
                    oldMateriaIdMateriaOfAnhoListAnho.getAnhoList().remove(anhoListAnho);
                    oldMateriaIdMateriaOfAnhoListAnho = em.merge(oldMateriaIdMateriaOfAnhoListAnho);
                }
            }
            for (Nota notaListNota : materia.getNotaList()) {
                Materia oldIdMateriaOfNotaListNota = notaListNota.getIdMateria();
                notaListNota.setIdMateria(materia);
                notaListNota = em.merge(notaListNota);
                if (oldIdMateriaOfNotaListNota != null) {
                    oldIdMateriaOfNotaListNota.getNotaList().remove(notaListNota);
                    oldIdMateriaOfNotaListNota = em.merge(oldIdMateriaOfNotaListNota);
                }
            }
            for (MateriaGrado materiaGradoListMateriaGrado : materia.getMateriaGradoList()) {
                Materia oldIdMateriaOfMateriaGradoListMateriaGrado = materiaGradoListMateriaGrado.getIdMateria();
                materiaGradoListMateriaGrado.setIdMateria(materia);
                materiaGradoListMateriaGrado = em.merge(materiaGradoListMateriaGrado);
                if (oldIdMateriaOfMateriaGradoListMateriaGrado != null) {
                    oldIdMateriaOfMateriaGradoListMateriaGrado.getMateriaGradoList().remove(materiaGradoListMateriaGrado);
                    oldIdMateriaOfMateriaGradoListMateriaGrado = em.merge(oldIdMateriaOfMateriaGradoListMateriaGrado);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findMateria(materia.getIdMateria()) != null) {
                throw new PreexistingEntityException("Materia " + materia + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Materia materia) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Materia persistentMateria = em.find(Materia.class, materia.getIdMateria());
            List<DocenteMateria> docenteMateriaListOld = persistentMateria.getDocenteMateriaList();
            List<DocenteMateria> docenteMateriaListNew = materia.getDocenteMateriaList();
            List<Seccion> seccionListOld = persistentMateria.getSeccionList();
            List<Seccion> seccionListNew = materia.getSeccionList();
            List<Anho> anhoListOld = persistentMateria.getAnhoList();
            List<Anho> anhoListNew = materia.getAnhoList();
            List<Nota> notaListOld = persistentMateria.getNotaList();
            List<Nota> notaListNew = materia.getNotaList();
            List<MateriaGrado> materiaGradoListOld = persistentMateria.getMateriaGradoList();
            List<MateriaGrado> materiaGradoListNew = materia.getMateriaGradoList();
            List<String> illegalOrphanMessages = null;
            for (DocenteMateria docenteMateriaListOldDocenteMateria : docenteMateriaListOld) {
                if (!docenteMateriaListNew.contains(docenteMateriaListOldDocenteMateria)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain DocenteMateria " + docenteMateriaListOldDocenteMateria + " since its idMateria field is not nullable.");
                }
            }
            for (Seccion seccionListOldSeccion : seccionListOld) {
                if (!seccionListNew.contains(seccionListOldSeccion)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Seccion " + seccionListOldSeccion + " since its idMateria field is not nullable.");
                }
            }
            for (Anho anhoListOldAnho : anhoListOld) {
                if (!anhoListNew.contains(anhoListOldAnho)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Anho " + anhoListOldAnho + " since its materiaIdMateria field is not nullable.");
                }
            }
            for (Nota notaListOldNota : notaListOld) {
                if (!notaListNew.contains(notaListOldNota)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Nota " + notaListOldNota + " since its idMateria field is not nullable.");
                }
            }
            for (MateriaGrado materiaGradoListOldMateriaGrado : materiaGradoListOld) {
                if (!materiaGradoListNew.contains(materiaGradoListOldMateriaGrado)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain MateriaGrado " + materiaGradoListOldMateriaGrado + " since its idMateria field is not nullable.");
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
            materia.setDocenteMateriaList(docenteMateriaListNew);
            List<Seccion> attachedSeccionListNew = new ArrayList<Seccion>();
            for (Seccion seccionListNewSeccionToAttach : seccionListNew) {
                seccionListNewSeccionToAttach = em.getReference(seccionListNewSeccionToAttach.getClass(), seccionListNewSeccionToAttach.getIdSeccion());
                attachedSeccionListNew.add(seccionListNewSeccionToAttach);
            }
            seccionListNew = attachedSeccionListNew;
            materia.setSeccionList(seccionListNew);
            List<Anho> attachedAnhoListNew = new ArrayList<Anho>();
            for (Anho anhoListNewAnhoToAttach : anhoListNew) {
                anhoListNewAnhoToAttach = em.getReference(anhoListNewAnhoToAttach.getClass(), anhoListNewAnhoToAttach.getIdAnho());
                attachedAnhoListNew.add(anhoListNewAnhoToAttach);
            }
            anhoListNew = attachedAnhoListNew;
            materia.setAnhoList(anhoListNew);
            List<Nota> attachedNotaListNew = new ArrayList<Nota>();
            for (Nota notaListNewNotaToAttach : notaListNew) {
                notaListNewNotaToAttach = em.getReference(notaListNewNotaToAttach.getClass(), notaListNewNotaToAttach.getIdNota());
                attachedNotaListNew.add(notaListNewNotaToAttach);
            }
            notaListNew = attachedNotaListNew;
            materia.setNotaList(notaListNew);
            List<MateriaGrado> attachedMateriaGradoListNew = new ArrayList<MateriaGrado>();
            for (MateriaGrado materiaGradoListNewMateriaGradoToAttach : materiaGradoListNew) {
                materiaGradoListNewMateriaGradoToAttach = em.getReference(materiaGradoListNewMateriaGradoToAttach.getClass(), materiaGradoListNewMateriaGradoToAttach.getIdMateriaGrado());
                attachedMateriaGradoListNew.add(materiaGradoListNewMateriaGradoToAttach);
            }
            materiaGradoListNew = attachedMateriaGradoListNew;
            materia.setMateriaGradoList(materiaGradoListNew);
            materia = em.merge(materia);
            for (DocenteMateria docenteMateriaListNewDocenteMateria : docenteMateriaListNew) {
                if (!docenteMateriaListOld.contains(docenteMateriaListNewDocenteMateria)) {
                    Materia oldIdMateriaOfDocenteMateriaListNewDocenteMateria = docenteMateriaListNewDocenteMateria.getIdMateria();
                    docenteMateriaListNewDocenteMateria.setIdMateria(materia);
                    docenteMateriaListNewDocenteMateria = em.merge(docenteMateriaListNewDocenteMateria);
                    if (oldIdMateriaOfDocenteMateriaListNewDocenteMateria != null && !oldIdMateriaOfDocenteMateriaListNewDocenteMateria.equals(materia)) {
                        oldIdMateriaOfDocenteMateriaListNewDocenteMateria.getDocenteMateriaList().remove(docenteMateriaListNewDocenteMateria);
                        oldIdMateriaOfDocenteMateriaListNewDocenteMateria = em.merge(oldIdMateriaOfDocenteMateriaListNewDocenteMateria);
                    }
                }
            }
            for (Seccion seccionListNewSeccion : seccionListNew) {
                if (!seccionListOld.contains(seccionListNewSeccion)) {
                    Materia oldIdMateriaOfSeccionListNewSeccion = seccionListNewSeccion.getIdMateria();
                    seccionListNewSeccion.setIdMateria(materia);
                    seccionListNewSeccion = em.merge(seccionListNewSeccion);
                    if (oldIdMateriaOfSeccionListNewSeccion != null && !oldIdMateriaOfSeccionListNewSeccion.equals(materia)) {
                        oldIdMateriaOfSeccionListNewSeccion.getSeccionList().remove(seccionListNewSeccion);
                        oldIdMateriaOfSeccionListNewSeccion = em.merge(oldIdMateriaOfSeccionListNewSeccion);
                    }
                }
            }
            for (Anho anhoListNewAnho : anhoListNew) {
                if (!anhoListOld.contains(anhoListNewAnho)) {
                    Materia oldMateriaIdMateriaOfAnhoListNewAnho = anhoListNewAnho.getMateriaIdMateria();
                    anhoListNewAnho.setMateriaIdMateria(materia);
                    anhoListNewAnho = em.merge(anhoListNewAnho);
                    if (oldMateriaIdMateriaOfAnhoListNewAnho != null && !oldMateriaIdMateriaOfAnhoListNewAnho.equals(materia)) {
                        oldMateriaIdMateriaOfAnhoListNewAnho.getAnhoList().remove(anhoListNewAnho);
                        oldMateriaIdMateriaOfAnhoListNewAnho = em.merge(oldMateriaIdMateriaOfAnhoListNewAnho);
                    }
                }
            }
            for (Nota notaListNewNota : notaListNew) {
                if (!notaListOld.contains(notaListNewNota)) {
                    Materia oldIdMateriaOfNotaListNewNota = notaListNewNota.getIdMateria();
                    notaListNewNota.setIdMateria(materia);
                    notaListNewNota = em.merge(notaListNewNota);
                    if (oldIdMateriaOfNotaListNewNota != null && !oldIdMateriaOfNotaListNewNota.equals(materia)) {
                        oldIdMateriaOfNotaListNewNota.getNotaList().remove(notaListNewNota);
                        oldIdMateriaOfNotaListNewNota = em.merge(oldIdMateriaOfNotaListNewNota);
                    }
                }
            }
            for (MateriaGrado materiaGradoListNewMateriaGrado : materiaGradoListNew) {
                if (!materiaGradoListOld.contains(materiaGradoListNewMateriaGrado)) {
                    Materia oldIdMateriaOfMateriaGradoListNewMateriaGrado = materiaGradoListNewMateriaGrado.getIdMateria();
                    materiaGradoListNewMateriaGrado.setIdMateria(materia);
                    materiaGradoListNewMateriaGrado = em.merge(materiaGradoListNewMateriaGrado);
                    if (oldIdMateriaOfMateriaGradoListNewMateriaGrado != null && !oldIdMateriaOfMateriaGradoListNewMateriaGrado.equals(materia)) {
                        oldIdMateriaOfMateriaGradoListNewMateriaGrado.getMateriaGradoList().remove(materiaGradoListNewMateriaGrado);
                        oldIdMateriaOfMateriaGradoListNewMateriaGrado = em.merge(oldIdMateriaOfMateriaGradoListNewMateriaGrado);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                BigDecimal id = materia.getIdMateria();
                if (findMateria(id) == null) {
                    throw new NonexistentEntityException("The materia with id " + id + " no longer exists.");
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
            Materia materia;
            try {
                materia = em.getReference(Materia.class, id);
                materia.getIdMateria();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The materia with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<DocenteMateria> docenteMateriaListOrphanCheck = materia.getDocenteMateriaList();
            for (DocenteMateria docenteMateriaListOrphanCheckDocenteMateria : docenteMateriaListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Materia (" + materia + ") cannot be destroyed since the DocenteMateria " + docenteMateriaListOrphanCheckDocenteMateria + " in its docenteMateriaList field has a non-nullable idMateria field.");
            }
            List<Seccion> seccionListOrphanCheck = materia.getSeccionList();
            for (Seccion seccionListOrphanCheckSeccion : seccionListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Materia (" + materia + ") cannot be destroyed since the Seccion " + seccionListOrphanCheckSeccion + " in its seccionList field has a non-nullable idMateria field.");
            }
            List<Anho> anhoListOrphanCheck = materia.getAnhoList();
            for (Anho anhoListOrphanCheckAnho : anhoListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Materia (" + materia + ") cannot be destroyed since the Anho " + anhoListOrphanCheckAnho + " in its anhoList field has a non-nullable materiaIdMateria field.");
            }
            List<Nota> notaListOrphanCheck = materia.getNotaList();
            for (Nota notaListOrphanCheckNota : notaListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Materia (" + materia + ") cannot be destroyed since the Nota " + notaListOrphanCheckNota + " in its notaList field has a non-nullable idMateria field.");
            }
            List<MateriaGrado> materiaGradoListOrphanCheck = materia.getMateriaGradoList();
            for (MateriaGrado materiaGradoListOrphanCheckMateriaGrado : materiaGradoListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Materia (" + materia + ") cannot be destroyed since the MateriaGrado " + materiaGradoListOrphanCheckMateriaGrado + " in its materiaGradoList field has a non-nullable idMateria field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(materia);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Materia> findMateriaEntities() {
        return findMateriaEntities(true, -1, -1);
    }

    public List<Materia> findMateriaEntities(int maxResults, int firstResult) {
        return findMateriaEntities(false, maxResults, firstResult);
    }

    private List<Materia> findMateriaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Materia.class));
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

    public Materia findMateria(BigDecimal id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Materia.class, id);
        } finally {
            em.close();
        }
    }

    public int getMateriaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Materia> rt = cq.from(Materia.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

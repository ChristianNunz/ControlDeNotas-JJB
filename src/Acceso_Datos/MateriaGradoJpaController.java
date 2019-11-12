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
import Logica_Negocios.Docente;
import Logica_Negocios.Grado;
import Logica_Negocios.Materia;
import Logica_Negocios.MateriaGrado;
import Logica_Negocios.Seccion;
import Logica_Negocios.Turno;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author chris
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
            Docente idDocente = materiaGrado.getIdDocente();
            if (idDocente != null) {
                idDocente = em.getReference(idDocente.getClass(), idDocente.getIdDocente());
                materiaGrado.setIdDocente(idDocente);
            }
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
            Seccion idSeccion = materiaGrado.getIdSeccion();
            if (idSeccion != null) {
                idSeccion = em.getReference(idSeccion.getClass(), idSeccion.getIdSeccion());
                materiaGrado.setIdSeccion(idSeccion);
            }
            Turno idTurno = materiaGrado.getIdTurno();
            if (idTurno != null) {
                idTurno = em.getReference(idTurno.getClass(), idTurno.getIdTurno());
                materiaGrado.setIdTurno(idTurno);
            }
            em.persist(materiaGrado);
            if (idDocente != null) {
                idDocente.getMateriaGradoList().add(materiaGrado);
                idDocente = em.merge(idDocente);
            }
            if (idGrado != null) {
                idGrado.getMateriaGradoList().add(materiaGrado);
                idGrado = em.merge(idGrado);
            }
            if (idMateria != null) {
                idMateria.getMateriaGradoList().add(materiaGrado);
                idMateria = em.merge(idMateria);
            }
            if (idSeccion != null) {
                idSeccion.getMateriaGradoList().add(materiaGrado);
                idSeccion = em.merge(idSeccion);
            }
            if (idTurno != null) {
                idTurno.getMateriaGradoList().add(materiaGrado);
                idTurno = em.merge(idTurno);
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
            Docente idDocenteOld = persistentMateriaGrado.getIdDocente();
            Docente idDocenteNew = materiaGrado.getIdDocente();
            Grado idGradoOld = persistentMateriaGrado.getIdGrado();
            Grado idGradoNew = materiaGrado.getIdGrado();
            Materia idMateriaOld = persistentMateriaGrado.getIdMateria();
            Materia idMateriaNew = materiaGrado.getIdMateria();
            Seccion idSeccionOld = persistentMateriaGrado.getIdSeccion();
            Seccion idSeccionNew = materiaGrado.getIdSeccion();
            Turno idTurnoOld = persistentMateriaGrado.getIdTurno();
            Turno idTurnoNew = materiaGrado.getIdTurno();
            if (idDocenteNew != null) {
                idDocenteNew = em.getReference(idDocenteNew.getClass(), idDocenteNew.getIdDocente());
                materiaGrado.setIdDocente(idDocenteNew);
            }
            if (idGradoNew != null) {
                idGradoNew = em.getReference(idGradoNew.getClass(), idGradoNew.getIdGrado());
                materiaGrado.setIdGrado(idGradoNew);
            }
            if (idMateriaNew != null) {
                idMateriaNew = em.getReference(idMateriaNew.getClass(), idMateriaNew.getIdMateria());
                materiaGrado.setIdMateria(idMateriaNew);
            }
            if (idSeccionNew != null) {
                idSeccionNew = em.getReference(idSeccionNew.getClass(), idSeccionNew.getIdSeccion());
                materiaGrado.setIdSeccion(idSeccionNew);
            }
            if (idTurnoNew != null) {
                idTurnoNew = em.getReference(idTurnoNew.getClass(), idTurnoNew.getIdTurno());
                materiaGrado.setIdTurno(idTurnoNew);
            }
            materiaGrado = em.merge(materiaGrado);
            if (idDocenteOld != null && !idDocenteOld.equals(idDocenteNew)) {
                idDocenteOld.getMateriaGradoList().remove(materiaGrado);
                idDocenteOld = em.merge(idDocenteOld);
            }
            if (idDocenteNew != null && !idDocenteNew.equals(idDocenteOld)) {
                idDocenteNew.getMateriaGradoList().add(materiaGrado);
                idDocenteNew = em.merge(idDocenteNew);
            }
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
            if (idSeccionOld != null && !idSeccionOld.equals(idSeccionNew)) {
                idSeccionOld.getMateriaGradoList().remove(materiaGrado);
                idSeccionOld = em.merge(idSeccionOld);
            }
            if (idSeccionNew != null && !idSeccionNew.equals(idSeccionOld)) {
                idSeccionNew.getMateriaGradoList().add(materiaGrado);
                idSeccionNew = em.merge(idSeccionNew);
            }
            if (idTurnoOld != null && !idTurnoOld.equals(idTurnoNew)) {
                idTurnoOld.getMateriaGradoList().remove(materiaGrado);
                idTurnoOld = em.merge(idTurnoOld);
            }
            if (idTurnoNew != null && !idTurnoNew.equals(idTurnoOld)) {
                idTurnoNew.getMateriaGradoList().add(materiaGrado);
                idTurnoNew = em.merge(idTurnoNew);
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
            Docente idDocente = materiaGrado.getIdDocente();
            if (idDocente != null) {
                idDocente.getMateriaGradoList().remove(materiaGrado);
                idDocente = em.merge(idDocente);
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
            Seccion idSeccion = materiaGrado.getIdSeccion();
            if (idSeccion != null) {
                idSeccion.getMateriaGradoList().remove(materiaGrado);
                idSeccion = em.merge(idSeccion);
            }
            Turno idTurno = materiaGrado.getIdTurno();
            if (idTurno != null) {
                idTurno.getMateriaGradoList().remove(materiaGrado);
                idTurno = em.merge(idTurno);
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
    public int GetIdValidar(BigDecimal idm, BigDecimal ids, BigDecimal idg,BigDecimal idt, BigDecimal idd,Connection con){
        try {
           // ConectionDB con = new ConectionDB();
            Statement st = con.createStatement();
             ResultSet resultSet = st.executeQuery("SELECT  ID_MATERIA_GRADO FROM MATERIA_GRADO WHERE ID_MATERIA = '"+(idm)+"' AND ID_GRADO =  '"+(ids)+"' AND ID_SECCION = '"+(idg)+"'  AND ID_TURNO = '"+(idt)+"'");
             resultSet.next();
              int iddd = Integer.parseInt(resultSet.getString(1));
              st.close();
              return iddd;
        } catch (Exception e) {
             return 0;
        }
    }
    
}

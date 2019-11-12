/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acceso_Datos;

import Acceso_Datos.exceptions.NonexistentEntityException;
import Acceso_Datos.exceptions.PreexistingEntityException;
import Logica_Negocios.EditarNota;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Logica_Negocios.Nota;
import Logica_Negocios.Periodo;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Diego Huete
 */
public class PeriodoJpaController implements Serializable {

    public PeriodoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Periodo periodo) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Nota idNota = periodo.getIdNota();
            if (idNota != null) {
                idNota = em.getReference(idNota.getClass(), idNota.getIdNota());
                periodo.setIdNota(idNota);
            }
            em.persist(periodo);
            if (idNota != null) {
                idNota.getPeriodoList().add(periodo);
                idNota = em.merge(idNota);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPeriodo(periodo.getIdPeriodo()) != null) {
                throw new PreexistingEntityException("Periodo " + periodo + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Periodo periodo) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Periodo persistentPeriodo = em.find(Periodo.class, periodo.getIdPeriodo());
            Nota idNotaOld = persistentPeriodo.getIdNota();
            Nota idNotaNew = periodo.getIdNota();
            if (idNotaNew != null) {
                idNotaNew = em.getReference(idNotaNew.getClass(), idNotaNew.getIdNota());
                periodo.setIdNota(idNotaNew);
            }
            periodo = em.merge(periodo);
            if (idNotaOld != null && !idNotaOld.equals(idNotaNew)) {
                idNotaOld.getPeriodoList().remove(periodo);
                idNotaOld = em.merge(idNotaOld);
            }
            if (idNotaNew != null && !idNotaNew.equals(idNotaOld)) {
                idNotaNew.getPeriodoList().add(periodo);
                idNotaNew = em.merge(idNotaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                BigDecimal id = periodo.getIdPeriodo();
                if (findPeriodo(id) == null) {
                    throw new NonexistentEntityException("The periodo with id " + id + " no longer exists.");
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
            Periodo periodo;
            try {
                periodo = em.getReference(Periodo.class, id);
                periodo.getIdPeriodo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The periodo with id " + id + " no longer exists.", enfe);
            }
            Nota idNota = periodo.getIdNota();
            if (idNota != null) {
                idNota.getPeriodoList().remove(periodo);
                idNota = em.merge(idNota);
            }
            em.remove(periodo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Periodo> findPeriodoEntities() {
        return findPeriodoEntities(true, -1, -1);
    }

    public List<Periodo> findPeriodoEntities(int maxResults, int firstResult) {
        return findPeriodoEntities(false, maxResults, firstResult);
    }

    private List<Periodo> findPeriodoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Periodo.class));
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

    public Periodo findPeriodo(BigDecimal id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Periodo.class, id);
        } finally {
            em.close();
        }
    }

    public int getPeriodoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Periodo> rt = cq.from(Periodo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
     public List<EditarNota> GetListaNotas(String periodo, String grado, String materia,String Seccion, String docenteid,Connection con){
        try {
            //ConectionDB con = new ConectionDB();
            List<EditarNota> editarNotas = new ArrayList<EditarNota>();
            Statement st = con.createStatement();
            ResultSet resultSet = st.executeQuery("SELECT p.id_periodo,a.alumno_nombre,a.alumno_apelidos,p.nota1,p.nota2,p.nota3 FROM alumno A"
                    + " INNER JOIN NOTA N ON a.id_alumno = n.id_alumno "
                    + "INNER JOIN periodo P ON n.id_nota = p.id_nota "
                    + "INNER JOIN materia_grado MG ON n.id_materia_grado=mg.id_materia_grado "
                    + "INNER JOIN SECCION S ON mg.id_seccion = s.id_seccion "
                    + "INNER JOIN turno T ON mg.id_turno = t.id_turno "
                    + "INNER JOIN materia M ON mg.id_materia = m.id_materia "
                    + "INNER JOIN docente D ON mg.id_docente=d.id_docente "
                    + "INNER JOIN grado G ON mg.id_grado = g.id_grado "
                    + "WHERE p.periodo="+periodo+" AND g.grado='"+grado+"' AND m.materia_nombre='"+materia+"' AND s.nombre_seccion='"+Seccion+"' AND d.id_docente='"+docenteid+"'");
            while(resultSet.next()){
                
                
                 EditarNota editarNota = new EditarNota(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), Double.parseDouble(resultSet.getString(4)), Double.parseDouble(resultSet.getString(5)), Double.parseDouble(resultSet.getString(6)));
                 editarNotas.add(editarNota);                
           }
            st.close();
            return editarNotas;
        } catch (Exception e) {
             return null;
        }
    }
    
     public void UpdateNota(String id_periodo, String nota1, String nota2, String nota3,Connection con){
         try {
             //ConectionDB con = new ConectionDB();
            Statement st = con.createStatement();
            st.executeQuery("UPDATE PERIODO SET nota1="+nota1+", nota2="+nota2+", nota3="+nota3+" WHERE id_periodo="+id_periodo+"");                   
            st.close();
        } catch (Exception e) {
            
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acceso_Datos;

import Acceso_Datos.exceptions.NonexistentEntityException;
import Acceso_Datos.exceptions.PreexistingEntityException;
import Logica_Negocios.Alumno;
import Logica_Negocios.EditarNota;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author diego
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
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(alumno);
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

    public void edit(Alumno alumno) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            alumno = em.merge(alumno);
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

    public void destroy(BigDecimal id) throws NonexistentEntityException {
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
    public List<EditarNota> GetListaAlumnos( String grado, String materia,String Seccion, String docenteid, Connection con)    {
        try {
           // ConectionDB con = new ConectionDB();
            List<EditarNota> editarNotas = new ArrayList<EditarNota>();
            Statement st = con.createStatement();
            ResultSet resultSet = st.executeQuery("SELECT a.ID_ALUMNO,a.alumno_nombre,a.alumno_apellidos,a.ALUMNO_ESTADO FROM alumno A"
                    + " INNER JOIN NOTA N ON a.id_alumno = n.id_alumno "
                    + "INNER JOIN periodo P ON n.id_nota = p.id_nota "
                    + "INNER JOIN materia_grado MG ON n.id_materia_grado=mg.id_materia_grado "
                    + "INNER JOIN SECCION S ON mg.id_seccion = s.id_seccion "
                    + "INNER JOIN turno T ON mg.id_turno = t.id_turno "
                    + "INNER JOIN materia M ON mg.id_materia = m.id_materia "
                    + "INNER JOIN docente D ON mg.id_docente=d.id_docente "
                    + "INNER JOIN grado G ON mg.id_grado = g.id_grado "
                    + "WHERE  g.grado='"+grado+"' AND m.materia_nombre='"+materia+"' AND s.nombre_seccion='"+Seccion+"' AND d.id_docente='"+docenteid+"'"
                    + " GROUP BY a.ID_ALUMNO,A.ALUMNO_NOMBRE,a.alumno_apelidos,a.ALUMNO_ESTADO");
            while(resultSet.next()){
                
                
                 EditarNota editarNota = new EditarNota(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3),resultSet.getString(4));
                 editarNotas.add(editarNota);                
           }
            st.close();
            return editarNotas;
        } catch (Exception e) {
             return null;
        }
    }
    public void ActulizarEstadoAlumno(String id, Boolean estado, Connection con) {
        try {
            //ConectionDB con = new ConectionDB();
             Statement st = con.createStatement();
             
            if (estado) {               
                String query="UPDATE ALUMNO SET ALUMNO_ESTADO=1 WHERE ID_ALUMNO="+id+"";
                int count=st.executeUpdate(query);
                st.close();
                //st.executeUpdate();
                //con.desconexion();
               
            }else{
                 String query="UPDATE ALUMNO SET ALUMNO_ESTADO=0 WHERE ID_ALUMNO="+id+"";
                int count=st.executeUpdate(query);
                st.close();
               // con.desconexion();

            }
        } catch (Exception e) {
            String err=e+"";
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acceso_Datos;

import Acceso_Datos.exceptions.NonexistentEntityException;
import Acceso_Datos.exceptions.PreexistingEntityException;
import Logica_Negocios.Grado;
import java.io.Serializable;
import java.math.BigDecimal;
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
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(grado);
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

    public void edit(Grado grado) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            grado = em.merge(grado);
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

    public void destroy(BigDecimal id) throws NonexistentEntityException {
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
    public List<String> GetGrados(String IdLog){
         try {
             ConectionDB con = new ConectionDB();
             List<String> grados = new ArrayList<>();
             Statement st = con.conn();
             ResultSet resultSet = st.executeQuery("SELECT GRADO FROM MATERIA_GRADO M " +
                                                    "INNER JOIN GRADO G ON M.ID_GRADO = G.ID_GRADO " +
                                                    "WHERE ID_DOCENTE ="+IdLog+"" +
                                                    "GROUP BY GRADO");
              while(resultSet.next()){
              String grad = resultSet.getString(1);
              grados.add(grad);
              }
              st.close();
               return grados;
         } catch (Exception e) {
         }
         return null;
     }
    
     public BigDecimal GetIdGrado(String NombreG){
        try {
            ConectionDB con = new ConectionDB();
            Statement st = con.conn();
             ResultSet resultSet = st.executeQuery("SELECT  ID_GRADO FROM GRADO WHERE GRADO= '"+(NombreG)+"'");
             resultSet.next();
              int iddd = Integer.parseInt(resultSet.getString(1));
              BigDecimal id = new BigDecimal(iddd);
              st.close();
              return id;
        } catch (Exception e) {
             return null;
        }
    }
}

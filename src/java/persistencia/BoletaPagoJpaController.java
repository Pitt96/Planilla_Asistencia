/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import persistencia.exceptions.NonexistentEntityException;
import persistencia.exceptions.PreexistingEntityException;

/**
 *
 * @author KARLA
 */
public class BoletaPagoJpaController implements Serializable {

    public BoletaPagoJpaController() {
    }  

    public BoletaPagoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProyectoPlanillaPU");

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(BoletaPago boletaPago) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Empleado idemp = boletaPago.getIdemp();
            if (idemp != null) {
                idemp = em.getReference(idemp.getClass(), idemp.getId());
                boletaPago.setIdemp(idemp);
            }
            em.persist(boletaPago);
            if (idemp != null) {
                idemp.getBoletaPagoList().add(boletaPago);
                idemp = em.merge(idemp);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findBoletaPago(boletaPago.getId()) != null) {
                throw new PreexistingEntityException("BoletaPago " + boletaPago + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(BoletaPago boletaPago) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            BoletaPago persistentBoletaPago = em.find(BoletaPago.class, boletaPago.getId());
            Empleado idempOld = persistentBoletaPago.getIdemp();
            Empleado idempNew = boletaPago.getIdemp();
            if (idempNew != null) {
                idempNew = em.getReference(idempNew.getClass(), idempNew.getId());
                boletaPago.setIdemp(idempNew);
            }
            boletaPago = em.merge(boletaPago);
            if (idempOld != null && !idempOld.equals(idempNew)) {
                idempOld.getBoletaPagoList().remove(boletaPago);
                idempOld = em.merge(idempOld);
            }
            if (idempNew != null && !idempNew.equals(idempOld)) {
                idempNew.getBoletaPagoList().add(boletaPago);
                idempNew = em.merge(idempNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = boletaPago.getId();
                if (findBoletaPago(id) == null) {
                    throw new NonexistentEntityException("The boletaPago with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            BoletaPago boletaPago;
            try {
                boletaPago = em.getReference(BoletaPago.class, id);
                boletaPago.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The boletaPago with id " + id + " no longer exists.", enfe);
            }
            Empleado idemp = boletaPago.getIdemp();
            if (idemp != null) {
                idemp.getBoletaPagoList().remove(boletaPago);
                idemp = em.merge(idemp);
            }
            em.remove(boletaPago);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<BoletaPago> findBoletaPagoEntities() {
        return findBoletaPagoEntities(true, -1, -1);
    }

    public List<BoletaPago> findBoletaPagoEntities(int maxResults, int firstResult) {
        return findBoletaPagoEntities(false, maxResults, firstResult);
    }

    private List<BoletaPago> findBoletaPagoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(BoletaPago.class));
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

    public BoletaPago findBoletaPago(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(BoletaPago.class, id);
        } finally {
            em.close();
        }
    }

    public int getBoletaPagoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<BoletaPago> rt = cq.from(BoletaPago.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

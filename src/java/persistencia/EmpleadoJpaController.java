/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import persistencia.exceptions.NonexistentEntityException;
import persistencia.exceptions.PreexistingEntityException;

/**
 *
 * @author KARLA
 */
public class EmpleadoJpaController implements Serializable {

    public EmpleadoJpaController() {
    }
    
    public EmpleadoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProyectoPlanillaPU");

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Empleado empleado) throws PreexistingEntityException, Exception {
        if (empleado.getAsistenciaList() == null) {
            empleado.setAsistenciaList(new ArrayList<Asistencia>());
        }
        if (empleado.getBoletaPagoList() == null) {
            empleado.setBoletaPagoList(new ArrayList<BoletaPago>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Asistencia> attachedAsistenciaList = new ArrayList<Asistencia>();
            for (Asistencia asistenciaListAsistenciaToAttach : empleado.getAsistenciaList()) {
                asistenciaListAsistenciaToAttach = em.getReference(asistenciaListAsistenciaToAttach.getClass(), asistenciaListAsistenciaToAttach.getId());
                attachedAsistenciaList.add(asistenciaListAsistenciaToAttach);
            }
            empleado.setAsistenciaList(attachedAsistenciaList);
            List<BoletaPago> attachedBoletaPagoList = new ArrayList<BoletaPago>();
            for (BoletaPago boletaPagoListBoletaPagoToAttach : empleado.getBoletaPagoList()) {
                boletaPagoListBoletaPagoToAttach = em.getReference(boletaPagoListBoletaPagoToAttach.getClass(), boletaPagoListBoletaPagoToAttach.getId());
                attachedBoletaPagoList.add(boletaPagoListBoletaPagoToAttach);
            }
            empleado.setBoletaPagoList(attachedBoletaPagoList);
            em.persist(empleado);
            for (Asistencia asistenciaListAsistencia : empleado.getAsistenciaList()) {
                Empleado oldIdempleadoOfAsistenciaListAsistencia = asistenciaListAsistencia.getIdempleado();
                asistenciaListAsistencia.setIdempleado(empleado);
                asistenciaListAsistencia = em.merge(asistenciaListAsistencia);
                if (oldIdempleadoOfAsistenciaListAsistencia != null) {
                    oldIdempleadoOfAsistenciaListAsistencia.getAsistenciaList().remove(asistenciaListAsistencia);
                    oldIdempleadoOfAsistenciaListAsistencia = em.merge(oldIdempleadoOfAsistenciaListAsistencia);
                }
            }
            for (BoletaPago boletaPagoListBoletaPago : empleado.getBoletaPagoList()) {
                Empleado oldIdempOfBoletaPagoListBoletaPago = boletaPagoListBoletaPago.getIdemp();
                boletaPagoListBoletaPago.setIdemp(empleado);
                boletaPagoListBoletaPago = em.merge(boletaPagoListBoletaPago);
                if (oldIdempOfBoletaPagoListBoletaPago != null) {
                    oldIdempOfBoletaPagoListBoletaPago.getBoletaPagoList().remove(boletaPagoListBoletaPago);
                    oldIdempOfBoletaPagoListBoletaPago = em.merge(oldIdempOfBoletaPagoListBoletaPago);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findEmpleado(empleado.getId()) != null) {
                throw new PreexistingEntityException("Empleado " + empleado + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Empleado empleado) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Empleado persistentEmpleado = em.find(Empleado.class, empleado.getId());
            List<Asistencia> asistenciaListOld = persistentEmpleado.getAsistenciaList();
            List<Asistencia> asistenciaListNew = empleado.getAsistenciaList();
            List<BoletaPago> boletaPagoListOld = persistentEmpleado.getBoletaPagoList();
            List<BoletaPago> boletaPagoListNew = empleado.getBoletaPagoList();
            List<Asistencia> attachedAsistenciaListNew = new ArrayList<Asistencia>();
            for (Asistencia asistenciaListNewAsistenciaToAttach : asistenciaListNew) {
                asistenciaListNewAsistenciaToAttach = em.getReference(asistenciaListNewAsistenciaToAttach.getClass(), asistenciaListNewAsistenciaToAttach.getId());
                attachedAsistenciaListNew.add(asistenciaListNewAsistenciaToAttach);
            }
            asistenciaListNew = attachedAsistenciaListNew;
            empleado.setAsistenciaList(asistenciaListNew);
            List<BoletaPago> attachedBoletaPagoListNew = new ArrayList<BoletaPago>();
            for (BoletaPago boletaPagoListNewBoletaPagoToAttach : boletaPagoListNew) {
                boletaPagoListNewBoletaPagoToAttach = em.getReference(boletaPagoListNewBoletaPagoToAttach.getClass(), boletaPagoListNewBoletaPagoToAttach.getId());
                attachedBoletaPagoListNew.add(boletaPagoListNewBoletaPagoToAttach);
            }
            boletaPagoListNew = attachedBoletaPagoListNew;
            empleado.setBoletaPagoList(boletaPagoListNew);
            empleado = em.merge(empleado);
            for (Asistencia asistenciaListOldAsistencia : asistenciaListOld) {
                if (!asistenciaListNew.contains(asistenciaListOldAsistencia)) {
                    asistenciaListOldAsistencia.setIdempleado(null);
                    asistenciaListOldAsistencia = em.merge(asistenciaListOldAsistencia);
                }
            }
            for (Asistencia asistenciaListNewAsistencia : asistenciaListNew) {
                if (!asistenciaListOld.contains(asistenciaListNewAsistencia)) {
                    Empleado oldIdempleadoOfAsistenciaListNewAsistencia = asistenciaListNewAsistencia.getIdempleado();
                    asistenciaListNewAsistencia.setIdempleado(empleado);
                    asistenciaListNewAsistencia = em.merge(asistenciaListNewAsistencia);
                    if (oldIdempleadoOfAsistenciaListNewAsistencia != null && !oldIdempleadoOfAsistenciaListNewAsistencia.equals(empleado)) {
                        oldIdempleadoOfAsistenciaListNewAsistencia.getAsistenciaList().remove(asistenciaListNewAsistencia);
                        oldIdempleadoOfAsistenciaListNewAsistencia = em.merge(oldIdempleadoOfAsistenciaListNewAsistencia);
                    }
                }
            }
            for (BoletaPago boletaPagoListOldBoletaPago : boletaPagoListOld) {
                if (!boletaPagoListNew.contains(boletaPagoListOldBoletaPago)) {
                    boletaPagoListOldBoletaPago.setIdemp(null);
                    boletaPagoListOldBoletaPago = em.merge(boletaPagoListOldBoletaPago);
                }
            }
            for (BoletaPago boletaPagoListNewBoletaPago : boletaPagoListNew) {
                if (!boletaPagoListOld.contains(boletaPagoListNewBoletaPago)) {
                    Empleado oldIdempOfBoletaPagoListNewBoletaPago = boletaPagoListNewBoletaPago.getIdemp();
                    boletaPagoListNewBoletaPago.setIdemp(empleado);
                    boletaPagoListNewBoletaPago = em.merge(boletaPagoListNewBoletaPago);
                    if (oldIdempOfBoletaPagoListNewBoletaPago != null && !oldIdempOfBoletaPagoListNewBoletaPago.equals(empleado)) {
                        oldIdempOfBoletaPagoListNewBoletaPago.getBoletaPagoList().remove(boletaPagoListNewBoletaPago);
                        oldIdempOfBoletaPagoListNewBoletaPago = em.merge(oldIdempOfBoletaPagoListNewBoletaPago);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = empleado.getId();
                if (findEmpleado(id) == null) {
                    throw new NonexistentEntityException("The empleado with id " + id + " no longer exists.");
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
            Empleado empleado;
            try {
                empleado = em.getReference(Empleado.class, id);
                empleado.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The empleado with id " + id + " no longer exists.", enfe);
            }
            List<Asistencia> asistenciaList = empleado.getAsistenciaList();
            for (Asistencia asistenciaListAsistencia : asistenciaList) {
                asistenciaListAsistencia.setIdempleado(null);
                asistenciaListAsistencia = em.merge(asistenciaListAsistencia);
            }
            List<BoletaPago> boletaPagoList = empleado.getBoletaPagoList();
            for (BoletaPago boletaPagoListBoletaPago : boletaPagoList) {
                boletaPagoListBoletaPago.setIdemp(null);
                boletaPagoListBoletaPago = em.merge(boletaPagoListBoletaPago);
            }
            em.remove(empleado);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Empleado> findEmpleadoEntities() {
        return findEmpleadoEntities(true, -1, -1);
    }

    public List<Empleado> findEmpleadoEntities(int maxResults, int firstResult) {
        return findEmpleadoEntities(false, maxResults, firstResult);
    }

    private List<Empleado> findEmpleadoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Empleado.class));
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

    public Empleado findEmpleado(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Empleado.class, id);
        } finally {
            em.close();
        }
    }
    
    
    public int getEmpleadoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Empleado> rt = cq.from(Empleado.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

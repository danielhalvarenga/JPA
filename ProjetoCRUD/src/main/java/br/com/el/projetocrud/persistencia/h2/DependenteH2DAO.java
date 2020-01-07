/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.el.projetocrud.persistencia.h2;

import br.com.el.projetocrud.modelo.Dependente;
import br.com.el.projetocrud.persistencia.DAO;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author daniel.alvarenga
 */
public class DependenteH2DAO implements DAO<Dependente> {

    private static DependenteH2DAO instance;

    private DependenteH2DAO() {
    }

    public static DependenteH2DAO GetInstance() {
        if (instance == null) {
            instance = new DependenteH2DAO();
        }
        return instance;
    }

    @Override
    public void salva(Dependente o) {
        EntityManager em = EMF.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(o);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    @Override
    public void exclui(String o) {
        EntityManager em = EMF.createEntityManager();
        try {
            em.getTransaction().begin();
            Dependente d = (Dependente)em.createQuery("select e from Dependente e where nome = :nomeDependente").setParameter("nomeDependente", o).getSingleResult();
            if (!em.contains(d)) {
                Dependente dependente = em.find(Dependente.class, d.getId());
                em.remove(dependente);
            } else {
                em.remove(d);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
            ex.getStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public Dependente get(Object identificador) {
        Dependente dependente = null;
        EntityManager em = EMF.createEntityManager();
        try {
            em.getTransaction().begin();
            dependente = em.find(Dependente.class, identificador);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return dependente;
    }

    @Override
    public Collection<Dependente> todos() {
        List<Dependente> lstDependente = new ArrayList<>();
        EntityManager em = EMF.createEntityManager();
        try {
            em.getTransaction().begin();
            Query q = em.createQuery("select D from Dependente D", Dependente.class);
            lstDependente = q.getResultList();
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
            ex.getStackTrace();
        } finally {
            em.close();
        }
        return lstDependente;
    }
}

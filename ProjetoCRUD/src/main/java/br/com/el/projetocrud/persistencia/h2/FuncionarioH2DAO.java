/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.el.projetocrud.persistencia.h2;

import br.com.el.projetocrud.modelo.Funcionario;
import br.com.el.projetocrud.persistencia.DAO;
import static br.com.el.projetocrud.persistencia.DAO.EMF;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.hibernate.Session;

/**
 *
 * @author daniel.alvarenga
 */
public class FuncionarioH2DAO implements DAO<Funcionario> {

    private static FuncionarioH2DAO instance;

    private FuncionarioH2DAO() {
    }

    public static FuncionarioH2DAO GetInstance() {
        if (instance == null) {
            instance = new FuncionarioH2DAO();
        }
        return instance;
    }

    @Override
    public void salva(Funcionario o) {
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
            Funcionario f = (Funcionario) em.createQuery("select e from Funcionario e where matricula = :idMatricula").setParameter("idMatricula", o).getSingleResult();
            if (!em.contains(f)) {
                Funcionario funcionario = em.find(Funcionario.class, f.getMatricula());
                em.remove(funcionario);
            } else {
                em.remove(f);
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
    public Funcionario get(Object identificador) {
        Funcionario funcionario = null;
        EntityManager em = EMF.createEntityManager();
        try {
            em.getTransaction().begin();
            funcionario = em.find(Funcionario.class, identificador);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return funcionario;
    }

    @Override
    public Collection<Funcionario> todos() {
        List<Funcionario> lstFuncionario = new ArrayList<>();
        EntityManager em = EMF.createEntityManager();
        try {
            em.getTransaction().begin();
            Query q = em.createQuery("select F from Funcionario F", Funcionario.class);
            lstFuncionario = q.getResultList();
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return lstFuncionario;
    }

}

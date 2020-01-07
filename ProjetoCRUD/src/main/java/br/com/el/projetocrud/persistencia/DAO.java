/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.el.projetocrud.persistencia;

import java.util.Collection;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author daniel.alvarenga
 */
public interface DAO<T> {

    public final static EntityManagerFactory EMF = Persistence.createEntityManagerFactory("bd-h2-pu");

    void salva(T o);

    void exclui(String o);

    T get(Object identificador);

    Collection<T> todos();
}

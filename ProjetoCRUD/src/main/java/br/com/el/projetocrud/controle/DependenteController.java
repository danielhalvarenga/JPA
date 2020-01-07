/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.el.projetocrud.controle;

import br.com.el.projetocrud.modelo.Dependente;
import br.com.el.projetocrud.modelo.Funcionario;
import br.com.el.projetocrud.persistencia.DAO;
import br.com.el.projetocrud.persistencia.h2.DependenteH2DAO;
import br.com.el.projetocrud.persistencia.h2.FuncionarioH2DAO;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author daniel.alvarenga
 */
public class DependenteController {

    private final DAO dao = DependenteH2DAO.GetInstance();
    private final DAO dao_func = FuncionarioH2DAO.GetInstance();
    private Dependente dependente = new Dependente();
    private Collection<Dependente> dependentes;

    public Dependente getDependente() {
        return dependente;
    }

    public Dependente getDependente(long id) {
        this.dependente = (Dependente) this.dao.get(id);
        return dependente;
    }

    public Collection<Dependente> getDependentes() {
        this.dependentes = this.dao.todos();
        Collections.sort((List) this.dependentes, (Dependente o1, Dependente o2) -> o1.getNome().compareTo(o2.getNome()));
        return dependentes;
    }

    public void adicionaDependente(String nome, long resp) {

        Funcionario funcionario = (Funcionario) this.dao_func.get(resp);

        this.dependente.setNome(nome);
        this.dependente.setFuncionario(funcionario);
        this.dao.salva(dependente);
        this.dependente = new Dependente();
    }

    public void removeDependente(String nome) {
        if (nome != null) {
            this.dao.exclui(nome);
            this.dependente = new Dependente();
        }
    }

}

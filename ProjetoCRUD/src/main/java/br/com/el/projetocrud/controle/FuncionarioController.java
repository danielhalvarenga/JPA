
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.el.projetocrud.controle;

import br.com.el.projetocrud.modelo.Funcionario;
import br.com.el.projetocrud.persistencia.DAO;
import br.com.el.projetocrud.persistencia.h2.FuncionarioH2DAO;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author daniel.alvarenga
 */
public class FuncionarioController {

    private final DAO dao = FuncionarioH2DAO.GetInstance();
    private Funcionario funcionario = new Funcionario();
    private Collection<Funcionario> funcionarios;

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public Funcionario getFuncionario(long id) {
        this.funcionario = (Funcionario) this.dao.get(id);
        return this.funcionario;
    }

    public Collection<Funcionario> getFuncionarios() {
        this.funcionarios = this.dao.todos();
        Collections.sort((List) this.funcionarios, (Funcionario o1, Funcionario o2) -> o1.getMatricula().compareTo(o2.getMatricula()));
        return funcionarios;
    }

    public void adicionaFuncionario(String matricula) {
        this.funcionario.setMatricula(matricula);
        this.dao.salva(funcionario);
        this.funcionario = new Funcionario();
    }

    public void removeFuncionario(String removerId) {
        if (removerId != null) {
            this.dao.exclui(removerId);
            this.funcionario = new Funcionario();
        }
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.el.projetocrud.visao.funcionario;

import br.com.el.projetocrud.controle.FuncionarioController;
import br.com.el.projetocrud.persistencia.h2.FuncionarioH2DAO;
import br.com.el.projetocrud.visao.TelaCRUD;
import java.util.Scanner;

/**
 *
 * @author daniel.alvarenga
 */
public class TelaCRUDFuncionario extends TelaCRUD {

    private final FuncionarioController controller = new FuncionarioController();

    @Override
    public void exibeNovo() {
        System.out.println("Cadastro de funcionário ");
    }

    @Override
    public void exibeOpNovo() {
        System.out.println("Insira a matricula do funcionario ");
        String x = scnEntrada.next();
        controller.adicionaFuncionario(x);
    }

    @Override
    public void exibeExcluir() {
        System.out.println("Exclusão de funcionário ");
    }

    @Override
    public void exibeOpExcluir() {
        System.out.println("Digite a matricula do Funcionario que voce deseja excluir: ");
        //variavel q sera enviada para pesquisa e exclusao do registro
        Scanner s = new Scanner(System.in);
        String deletarMatricula = s.nextLine();
        
        System.out.println("Deseja excluir o funcionário " + s.nextLine() + " ?");
        System.out.println("1 - Sim");
        System.out.println("2 - Não");
        int x = scnEntrada.nextInt();
        if (x == 1) {
            controller.removeFuncionario(deletarMatricula);
        }
    }

    @Override
    public void exibeRecuperar() {
        System.out.println("Seleção de funcionário");
    }

    @Override
    public void exibeOpRecuperar() {
        System.out.println("Digite o id do funcionario: ");
        String x = scnEntrada.next();
        System.out.println(controller.getFuncionario(Long.parseLong(x)));
    }

    @Override
    public void exibeListarTodos() {
        System.out.println("Mostrar todos os funcionários");
    }

    @Override
    public void exibeOpListarTodos() {
        controller.getFuncionarios().forEach(x -> System.out.println("--> " + x));
    }

    @Override
    public void exibeMenu() {
        int x = 0;
        do {
            System.out.println("Escolha sua opção ");
            System.out.println("0 = Sair");
            System.out.print("1 = ");
            this.exibeListarTodos();
            System.out.print("2 = ");
            this.exibeRecuperar();
            System.out.print("3 = ");
            this.exibeExcluir();
            System.out.print("4 = ");
            this.exibeNovo();
            x = scnEntrada.nextInt();
            switch (x) {
                case 1:
                    this.exibeOpListarTodos();
                    break;
                case 2:
                    this.exibeOpRecuperar();
                    break;
                case 3:
                    this.exibeOpExcluir();
                    break;
                case 4:
                    this.exibeOpNovo();
                    break;
            }
        } while (x != 0);
        this.scnEntrada.close();
    }

}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.el.projetocrud.visao.dependente;

import br.com.el.projetocrud.controle.DependenteController;
import br.com.el.projetocrud.visao.TelaCRUD;
import java.util.Scanner;

/**
 *
 * @author daniel.alvarenga
 */
public class TelaCRUDDependente extends TelaCRUD {

    private final DependenteController dependenteController = new DependenteController();

    @Override
    public void exibeNovo() {
        System.out.println("Cadastro de dependente ");
    }

    @Override
    public void exibeOpNovo() {
        System.out.println("Digite o id do Responsável por este Dependente: ");
        String x = scnEntrada.next();
        System.out.println("Insira o nome do Dependente: ");
        String y = scnEntrada.next();
        dependenteController.adicionaDependente(y, Long.parseLong(x));
    }

    @Override
    public void exibeExcluir() {
        System.out.println("Exclusão de Dependente ");
    }

    @Override
    public void exibeOpExcluir() {
        System.out.println("Digite nome do Dependente que voce deseja excluir: ");

        //nome do dependente q sera deletado
        Scanner s = new Scanner(System.in);
        String deletarDependente = s.nextLine();

        System.out.println("Deseja excluir o Dependente " + deletarDependente + " ?");
        System.out.println("1 - Sim");
        System.out.println("2 - Não");

        int x = scnEntrada.nextInt();
        if (x == 1) {
            dependenteController.removeDependente(deletarDependente);
        }
    }

    @Override
    public void exibeRecuperar() {
        System.out.println("Seleção de Dependente ");
    }

    @Override
    public void exibeOpRecuperar() {
        System.out.println("Digite o id do Dependente ");
        String x = scnEntrada.next();
        System.out.println(dependenteController.getDependente(Long.parseLong(x)));
    }

    @Override
    public void exibeListarTodos() {
        System.out.println("Mostrar todos os Dependentes ");
    }

    @Override
    public void exibeOpListarTodos() {
        dependenteController.getDependentes().forEach(x -> System.out.println("--> " + x));
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

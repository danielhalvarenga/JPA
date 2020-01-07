/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.el.projetocrud.app;


import br.com.el.projetocrud.*;
import br.com.el.projetocrud.modelo.Funcionario;
import br.com.el.projetocrud.visao.Tela;
import br.com.el.projetocrud.visao.funcionario.TelaCRUDFuncionario;
/**
 *
 * @author daniel.alvarenga
 */
public class MainFuncionario {
   
    public static void main(String[] args) {
        TelaCRUDFuncionario tf = new TelaCRUDFuncionario();
        tf.exibeMenu();
                
    }
}

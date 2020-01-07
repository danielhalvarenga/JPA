/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.el.projetocrud.visao;

import java.util.Scanner;

/**
 *
 * @author daniel.alvarenga
 */
public abstract class TelaCRUD implements Tela {

    protected Scanner scnEntrada = new Scanner(System.in);

    public abstract void exibeNovo();

    public abstract void exibeOpNovo();

    public abstract void exibeExcluir();

    public abstract void exibeOpExcluir();

    public abstract void exibeRecuperar();

    public abstract void exibeOpRecuperar();

    public abstract void exibeListarTodos();

    public abstract void exibeOpListarTodos();
    
}

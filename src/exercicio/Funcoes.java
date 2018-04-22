/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio;

import java.util.Scanner;

/**
 *
 * @author Gabriel Linhares <glinhares@engebras.com.br>
 */
public class Funcoes {
    
        // Pesquisar carro pelo modelo
    static void searchCarByModelo(ListaSimples lista) {

        Scanner leitor = new Scanner(System.in);

        System.out.print("Modelo: ");
        String result = lista.pesquisarNo(leitor.nextLine());

        System.out.println(result);
    }
    // metodo de remover carro pelo modelo
    static ListaSimples removeCarByModelo(ListaSimples lista) {

        Scanner leitor = new Scanner(System.in);
        System.out.println("Remover carro");
        System.out.print("Modelo: ");
        boolean isRemoved = lista.removerNo(leitor.nextLine());

        if (isRemoved) {
            System.out.println("Esse carro foi removido do sistema.");
            return lista;
        } else {
            System.out.println("Não foi encontrado esse carro.");
            return lista;
        }
    }
    // metodo remover tudo
    static ListaSimples removeAll(ListaSimples lista) {

        if (!lista.isEmpty()) {
            System.out.println("A lista de carros foi apagada.");
            return new ListaSimples();
        } else {
            System.out.println("Não possui nenhum carro na lista.");
            return lista;
        }
    }
}

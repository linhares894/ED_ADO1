/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercicio;

import java.util.Scanner;

/**
 *
 * @author Gabriel Linhares <glinhares@engebras.com.br>
 */
public class Principal {
    
    public static void main(String[] args) {
     
    ListaSimples ListaCarros = new ListaSimples();
    
    Opcoes(ListaCarros);
        
    }
    
    static void Opcoes(ListaSimples list){
        
        int opcoes;
        
        do{
            System.out.println(">>> MENU <<<<");
            System.out.println("1- Adicionar carro comeco da lista "
                    +"2 - Adicionar carro final da lista"
                    +"3 - Pesquisar o carro pelo modelo"
                    +"4 - Mostar a lista"
                    +"5 - Remover carro pelo modelo"
                    +"6 - Excluir tudo"
                    +"7 - Sair do sistema");
            
            System.out.println("Escolha uma das opcoes acima");
            
            switch(opcoes){
                
                case 1:
                    // adicionando carro no comeco da lista
                    Carros carros = setCar();
                    list.inserirPrimeiro(carros);
                    carros = null;
                    break;
                
                case 2:
                    //adicionando carro no fim da lista
                    carros = setCar();
                    list.inserirUltimo(carros);
                    carros = null;
                    break;
                
                case 3:
                    //pesquisando pelo modelo
                    searchCarByModelo(list);
                    break;
                
                case 4:
                    // mostrar a lista
                    System.out.println(list.impimirLista());
                    break;
                
                case 5:
                    // removendo carro pelo modelo
                    list = removeCarByModelo(list);
                    break;
                    
                case 6:
                    // removendo tudo
                    list = removeAll(list);
                    break;
                
                case 7:
                    // sair do sistema
                    System.out.println("Voce saiu do sistema");
                    break;
            }
            
        } while (opcoes != 7);
    }
    
        static int inputCheck() {

        Scanner read = new Scanner(System.in);

        String option = read.nextLine();
        return 0;
        }
    
    static Carros setCar() {

        Scanner leitor = new Scanner(System.in);

        Carros car = new Carros();

        System.out.println(">>Informacao do carro <<");

        System.out.print("Modelo: ");
        car.setModelo(leitor.nextLine());

        System.out.print("Marca: ");
        car.setMarca(leitor.nextLine());

        System.out.print("Ano: ");
        car.setAno(yearCheck());

        return car;
    }

    static int yearCheck() {

        Scanner leitor = new Scanner(System.in);

        String year = leitor.nextLine();

        if (!year.matches("\\d+")) {
            System.out.println("Nao e numero.");
            yearCheck();
        }

        int yearNum = Integer.parseInt(year);
        return yearNum;
    }
    // metodo pesquisar pelo modelo
    static void searchCarByModelo(ListaSimples list) {

        Scanner leitor = new Scanner(System.in);

        System.out.print("Modelo: ");
        String result = list.pesquisarNo(leitor.nextLine());

        System.out.println(result);
    }
    // metodo de remover carro pelo modelo
    static ListaSimples removeCarByModelo(ListaSimples list) {

        Scanner leitor = new Scanner(System.in);
        System.out.println("Remover carro");
        System.out.print("Modelo: ");
        boolean isRemoved = list.removerNo(leitor.nextLine());

        if (isRemoved) {
            System.out.println("Esse carro foi removido do sistema.");
            return list;
        } else {
            System.out.println("Não foi encontrado esse carro.");
            return list;
        }
    }
    // metodo remover tudo
    static ListaSimples removeAll(ListaSimples list) {

        if (!list.isEmpty()) {
            System.out.println("A lista de carros foi apagada.");
            return new ListaSimples();
        } else {
            System.out.println("Não possui nenhum carro na lista.");
            return list;
        }
    }
}
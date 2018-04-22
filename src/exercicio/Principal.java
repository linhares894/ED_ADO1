/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gabriel Linhares <glinhares@engebras.com.br>
 */
public class Principal {
    
    public static void main(String[] args) {
     
    ListaSimples listaCarros = new ListaSimples();
    
        try {
            Opcoes(listaCarros);
        } catch (ParseException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    static void Opcoes(ListaSimples lista) throws ParseException{
        
        int opcoes = 0;
        
        Scanner leitor = new Scanner(System.in);
        
        
        
        do{
            System.out.println("Escolha umas das opções abaixo:");
            
            System.out.println("");
            
            System.out.println(">>> CAR MENU<<<<");
            System.out.println("1- Adicionar carro no comeco da lista \n"
                    +"2 - Adicionar carro no final da lista \n"
                    +"3 - Pesquisar o carro pelo modelo \n"
                    +"4 - Mostrar a lista de carros adicionados \n"
                    +"5 - Remover carro pelo modelo \n"
                    +"6 - Excluir tudo \n"
                    +"7 - Sair do sistema \n");
            
            opcoes = leitor.nextInt();
            
            
            
            switch(opcoes){
                
                case 1:
                    // adicionando carro no comeco da lista
                    Carros carros = setCar();
                    lista.inserirPrimeiro(carros);
                    carros = null;
                    break;
                
                case 2:
                    //adicionando carro no fim da lista
                    carros = setCar();
                    lista.inserirUltimo(carros);
                    carros = null;
                    break;
                
                case 3:
                    //pesquisando pelo modelo
                    Funcoes.searchCarByModelo(lista);
                    break;
                
                case 4:
                    // mostrar a lista
                    System.out.println(lista.impimirLista());
                    break;
                
                case 5:
                    // removendo carro pelo modelo
                    lista = Funcoes.removeCarByModelo(lista);
                    break;
                    
                case 6:
                    // removendo tudo
                    lista = Funcoes.removeAll(lista);
                    break;
                
                case 7:
                    // sair do sistema
                    System.out.println("Voce saiu do sistema");
                    System.exit(0);
            }
            
        } while (true);
    }
    
    static Carros setCar() throws ParseException {

        Scanner leitor = new Scanner(System.in);

        Carros car = new Carros();

        System.out.println(">>Informacao do carro <<");

        System.out.print("Modelo: ");
        car.setModelo(leitor.nextLine());

        System.out.print("Marca: ");
        car.setMarca(leitor.nextLine());
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");

        System.out.print("Ano: ");
        
        while(true){
            try{
                String ano = leitor.nextLine();
                car.setAno(sdf.parse(ano));
                break;
            } catch(Exception e){
                System.out.println("Valor de data informada invalida \n");
                System.out.println("Digite novamente o ano");
            } 
        }

        return car;
    }
}
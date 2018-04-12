/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio;

/**
 *
 * @author Gabriel Linhares <glinhares@engebras.com.br>
 */
public class No {
    
    private Carros carro;
    private No prox;

    public No(Carros car) {
        this.carro = car;
        this.prox = null;
    }

    public Carros getCarro() {
        return carro;
    }

    public void setCarro(Carros carro) {
        this.carro = carro;
    }

    public No getProx() {
        return prox;
    }

    public void setProx(No prox) {
        this.prox = prox;
    }

}
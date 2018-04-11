/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ED_ADO1;

/**
 *
 * @author Gabriel Linhares <glinhares@engebras.com.br>
 */
public class No {
    
    private Carros c;
    private No prox;

    public No(Carros car) {
        this.c = car;
        this.prox = null;
    }

    public Carros getC() {
        return c;
    }

    public void setC(Carros c) {
        this.c = c;
    }

    public No getProx() {
        return prox;
    }

    public void setProx(No prox) {
        this.prox = prox;
    }

}
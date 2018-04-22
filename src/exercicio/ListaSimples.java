/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio;

import java.text.SimpleDateFormat;

/**
 *
 * @author Gabriel Linhares <glinhares@engebras.com.br>
 */
public class ListaSimples {
    
    private No prim;
    private No ult;
    private int qtdNo;

    public ListaSimples() {
        this.prim = null;
        this.ult = null;
        this.qtdNo = 0;
    }

    public No getPrim() {
        return prim;
    }

    public void setPrim(No prim) {
        this.prim = prim;
    }

    public No getUlt() {
        return ult;
    }

    public void setUlt(No ult) {
        this.ult = ult;
    }

    public int getQtdNo() {
        return qtdNo;
    }

    public void setQtdNo(int qtdNo) {
        this.qtdNo = qtdNo;
    }

    //Metodos
    public boolean isEmpty() {
        return (this.prim == null);
    }

    public void inserirPrimeiro(Carros carro) {
        No novoNo = new No(carro);
        if (this.isEmpty()) {
            this.ult = novoNo;
        }
        novoNo.setProx(this.prim);
        this.prim = novoNo;
        this.qtdNo++;
    }

    public void inserirUltimo(Carros carro) {
        No novoNo = new No(carro);
        if (this.isEmpty()) {
            this.prim = novoNo;
        } else {
            this.ult.setProx(novoNo);
        }
        this.ult = novoNo;
        this.qtdNo++;
    }

    public boolean removerNo(String modelo) {
        No atual = this.prim;
        No anterior = null;
        if (this.isEmpty()) {
            return false;
        } else {
            while (atual != null && (!atual.getCarro().getModelo().equalsIgnoreCase(modelo))) {
                anterior = atual;
                atual = atual.getProx();
            }
            if (atual == prim) {
                if (this.prim == this.ult) {
                    this.ult = null;
                }
                this.prim = this.prim.getProx();
            } else {
                if (atual == ult) {
                    this.ult = anterior;
                }
                anterior.setProx(atual.getProx());
            }
        }

        this.qtdNo--;
        return true;
    }

    public String pesquisarNo(String modelo) {
        String msg = "";
        No atual = this.prim;

        while (atual != null) {
            if(atual.getCarro().getModelo().equalsIgnoreCase(modelo)){
                msg = "Modelo: " + atual.getCarro().getModelo() + "\n"
                + "Marca: " + atual.getCarro().getMarca() + "\n"
                + "Ano: " + atual.getCarro().getAno();
                return msg;
            }
            atual = atual.getProx();
        }
        
        return "Nenhum modelo encontrado";
    }

    public String impimirLista() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        String msg = "";
        if (this.isEmpty()) {
            msg = "Lista vazia";
        } else {
            No atual = this.prim;
            while (atual != null) {
                msg += "Modelo: " + atual.getCarro().getModelo() + "\n"
                        + "Marca: " + atual.getCarro().getMarca() + "\n"
                        + "Ano: " + sdf.format(atual.getCarro().getAno()) + "\n\n";
                atual = atual.getProx();
            }
        }
        return msg;
    }

}
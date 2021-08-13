/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetolp3;

import java.util.Scanner;

/**
 *
 * @author user1
 */
public class Transacoes  {
    private String descricao;
    private String data;
    private float valor;
    


    public Transacoes(String descricao, float valor, String data) {
        this.descricao = descricao;
        this.data = data;
        this.valor = valor;
        
       
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

   
    
//    public criarTransacao(){
//        List<transacoes>;
//        
//        
//        Scanner sc1 = new Scanner(System.in);
//        System.out.print("A descricao da transacao: " + "\n");
//        String aux = sc1.nextLine();
//        this.setDescricao(aux);
//        System.out.print("Digite o valor da transacao: " + "\n");
//        float v1 = sc1.nextFloat();
//        this.setValor(valor);
//        sc1.nextLine();
//        System.out.print("Digite a data: " + "\n");
//        aux = sc1.nextLine();
//        this.setData(data);
//        
//        
//        
//        
//        return
//    }
    


    
    

  
   
}

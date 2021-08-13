/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetolp3;

/**
 *
 * @author user1
 */
public class Poupanca { //extends Carteira 
    private String banco;
    private float saldo; 
    private float rendimento;
    
    
    
    

//    public Poupanca(float saldo, String id, String tipo, float despesa) {
//        super(saldo, id, tipo, despesa);
//    }

    public Poupanca(String banco, float saldo ) {
        this.banco = banco;
        this.saldo = saldo;
       
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    
     
     

  
     
     
    
    
    
}

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
public class Corrente { //extends Carteira {
    private String banco;
    private float saldo;
    private float chequeEspecial;
    private float taxa;

//    public Corrente(float saldo, String id, String tipo, float despesa) {
//        super(saldo, id, tipo, despesa);
//    }

    public Corrente(String banco,float saldo, float chequeEspecial) {
        this.banco= banco;
        this.saldo = saldo;
        this.chequeEspecial = chequeEspecial;
        
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

    public float getChequeEspecial() {
        return chequeEspecial;
    }

    public void setChequeEspecial(float chequeEspecial) {
        this.chequeEspecial = chequeEspecial;
    }

  

  
    
    
    
}

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
public class CalculoDinheiro implements Runnable{
    private double dinheiro, gasto;
    

    public CalculoDinheiro(double dinheiro, double gasto) {
        this.dinheiro = dinheiro;
        this.gasto = gasto;
       
        new Thread(this).start();
    }
    
    

    public double getDinheiro() {
        return dinheiro;
    }

    public void setDinheiro(double dinheiro) {
        this.dinheiro = dinheiro;
    }

    public double getGasto() {
        return gasto;
    }

    public void setGasto(double gasto) {
        this.gasto = gasto;
    }

    

   

   
    @Override
    public void run (){
        this.dinheiro = this.dinheiro - this.gasto;
        if(this.dinheiro >= 0 ){
             
            System.out.println("Seu saldo total e positivo: R$"+ this.dinheiro );
        }else
        {
            System.out.println("Seu saldo total e negativo: R$"+ this.dinheiro );
        }
    }
}



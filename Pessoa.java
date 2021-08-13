




package projetolp3;

import java.util.logging.Level;
import java.util.logging.Logger;


public class Pessoa  {
    private String nome;
    private String email;

    public Pessoa(String nome, String email) {
        this.nome = nome;
        this.email = email;
       
       
    }

   

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
    
}

/*
    Elaborar e codificar um sistema para controle de orçamento financeiro pessoal 
    ou  familiar  utilizando  a  Linguagem  de  Programação  Java,  o  sistema  deve  permitir  o 
    controle de gastos, receitas, das categorias de receitas e gastos (salário, alimentação, 
    transporte, moradia etc.), das contas (exemplo: dinheiro, conta corrente itaú etc), datas 
    e descrição das transações.

    Durante  o  código  o  aluno  deve  utilizar  as  tecnologias  Java  aprendidas  neste 
    semestre  (Threads,  Lambda,  Streams,  Optional,  Reduce,  Exceções,  Estratégias  de 
    Refatoração  e  de  Código  Limpo).  O  código  deve  ser  enviado  para  um  repositório  no 
    GitHub e o link deste do repositório deve ser entregue no moodle.

*/









package projetolp3;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.DoubleStream;


public class ProjetoLp3 {
private static ArrayList<Transacoes> minhaLista = new ArrayList<Transacoes>();
private static ArrayList<Poupanca> minhaLista2 = new ArrayList<Poupanca>();
private static ArrayList<Corrente> minhaLista3 = new ArrayList<Corrente>();

 
   
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       
      
       
     //Populando Transacoes 
     Transacoes t1 = new Transacoes("Mercado", 1000.00f, "20/01/2021");
     Transacoes t2 = new Transacoes("Recarga Celular", 10.00f, "21/01/2021");
     Transacoes t3 = new Transacoes("Recarga Bilhete Unico", 30.00f, "22/01/2021");  
     
     minhaLista.add(t1);
     minhaLista.add(t2);
     minhaLista.add(t3);
     
      
     
     //Populando Poupança
     Poupanca p1 = new Poupanca("Bradesco", 3000.00f);
     Poupanca p2 = new Poupanca("Santander", 100.00f);
     Poupanca p3 = new Poupanca("Banco do Brasil", 1500.00f);
    
     
    minhaLista2.add(p1); 
    minhaLista2.add(p2);
    minhaLista2.add(p3); 
    
    
    
    
    
    //Populando Conta Corrente
    
    Corrente c1 = new Corrente("Bradesco", 2700f, 2000f);
    Corrente c2 = new Corrente("Santander", 53.00f, 1000f);
    Corrente c3 = new Corrente("Banco do Brasil", 1200f, 2700f);
    
    minhaLista3.add(c1);
    minhaLista3.add(c2);
    minhaLista3.add(c3);
     
       
       
       Pessoa pessoa = new Pessoa("Meu nome", "exemplo@mail.com");
       
       
       
       
       
       
       
       // boolean meuLoop = true;
        int opc = 0;
       
           do{
                  //Usando Streams
               
               double somaPoupanca = minhaLista2.stream()
                       .mapToDouble(Poupanca::getSaldo)
                       .sum();
                      
               System.out.println("Total Poupanca: " + somaPoupanca);
               
               
              
               
                 //Usando Reduce

                double somaCorrente = minhaLista3.stream()
                .mapToDouble(item -> item.getSaldo())
                .reduce(0, (a, b) -> a + b);
               System.out.println("Total Conta Corrente: "+ somaCorrente);
               
               double somaTransacoes = minhaLista.stream()
                       .mapToDouble(item -> item.getValor())
                       .reduce(0, (a, b) -> a + b);
               System.out.println("Total de gastos em transacoes: " + somaTransacoes);
               
               
                double somaCheque = minhaLista3.stream()
                .mapToDouble(item -> item.getChequeEspecial())
                .reduce(0, (a, b) -> a + b);
               System.out.println("Cheque Especial disponivel: "+ somaCheque);
               
               
                   //usando tread
            double aux = somaPoupanca + somaCorrente;
            CalculoDinheiro meuDinheiro = new CalculoDinheiro(aux, somaTransacoes);
               
               
               System.out.println("\n\n###### Usuario #######");
               System.out.print("Nome: " + pessoa.getNome());
               System.out.print("   Email: "+ pessoa.getEmail() + "\n");
               
               
            
               
             
               
              
          
           
          
            
            InterfaceFuncional menu = () -> menuPrincipal();
            menu.show();
            
            
            try{
            opc = sc.nextInt();
            }catch(Exception erro){
                System.out.println("\nCOMANDO INVALIDO");
                sc.nextLine();
                continue;
            }
            
            
            System.out.print("\n");
            switch(opc){
                case 1:
                   
                   
                    String meuNome;
                    System.out.print("Digite seu nome: " + "\n");
                    try{
                    sc.nextLine();
                   
                    meuNome = sc.nextLine();
                    }catch(Exception erro){
                         System.out.println("\nCOMANDO INVALIDO");
                         sc.nextLine();
                         continue;
                    }
                    //System.out.println("Nome atual: " + meuNome);
                    
                    pessoa.setNome(meuNome);
                    System.out.println("Seu nome atual: "+ pessoa.getNome() + "\n");
                    
                    break;
                   
                case 2:
                    String meuEmail;
                    System.out.print("Digite seu email: ");
                    sc.nextLine();
                    meuEmail = sc.nextLine();
                    //System.out.println("Email Atual: " + meuEmail);
                    pessoa.setEmail(meuEmail);
                    System.out.println("Seu email atual: "+ pessoa.getEmail() + "\n");
                    break;
                    
                case 3:
                    
                    System.out.println("Conta Poupança");
                   minhaLista2.forEach(p -> System.out.println(
                          "\nBanco: "
                           +p.getBanco()
                           +"\nSaldo: "
                           +p.getSaldo()
                           
                   )
                   );

                    
                    
                    

                    break;
                    
                    
                case 4:
                    System.out.println("Adicionando Poupança");
                    addPoupanca();
                    break;
                    
                    
                case 5:
                    
                     System.out.println("Conta Corrente");
                    minhaLista3.forEach(p -> System.out.println(
                            "\nBanco: "
                            +p.getBanco()
                            +"\nSaldo: "
                            +p.getSaldo()
                            +"\n Cheque Especial: "
                            +p.getChequeEspecial()
                           
                                    
                    )
                    );


                     break;
                    
                case 6: 
                     System.out.println("Adicionando Conta Corrente");
                    addCorrente();
                    break;
                    
                    
                case 7:
                    addTransacao();

                    break;
                    
                case 8:
                    System.out.println("Minhas Transacoes");
                    minhaLista.forEach(p -> System.out.println(
                            "\nDescricao:"
                            +p.getDescricao()
                            +"\nValor:"
                            +p.getValor()
                            +"\nData:"
                            +p.getData())
                    );

                case 0:
                     
                        break;
            }
            
           }while (opc != 9);
            
            
            
       
        
        
        
        
    }
  
    
    public static void menuPrincipal(){
        
            System.out.println("===============================");
            System.out.println("###### Menu ######");
            System.out.println("1: Mudar nome");
            System.out.println("2: Mudar email");
            System.out.println("3: Ver Poupança");
            System.out.println("4: Adicionar Conta Poupança");
            System.out.println("5: Ver Conta Corrente");
            System.out.println("6: Adicionar Conta Corrente");
            System.out.println("7: Adicionar Transacoes");
            System.out.println("8: Ver Transacoes");
            System.out.println("9: Sair");
            
        
        
    }
    
    
    
    
    
    
    
    
    private static void addTransacao (){
       
        Scanner sc1 = new Scanner(System.in);
        System.out.print("A descricao da transacao: " + "\n");
        String aux1 = sc1.nextLine();
        
        System.out.print("Digite o valor da transacao: " + "\n");
        try{
        float v1 = sc1.nextFloat();
        
            sc1.nextLine();
            
        
        sc1.nextLine();
        System.out.print("Digite a data: " + "\n");
        String aux2 = sc1.nextLine();
       
        minhaLista.add(new Transacoes(aux1,v1,aux2));
        }catch (Exception erro){
            System.out.println("ERRO Respeite os tipos de dados !");
        }
        
    }
    
    
        private static void addPoupanca (){
       
         try{   
        Scanner sc1 = new Scanner(System.in);
        System.out.print("Nome do banco: " + "\n");
        String aux1 = sc1.nextLine();
        
        System.out.print("Saldo: " + "\n");
        float v1 = sc1.nextFloat();
       
        sc1.nextLine();
        
       
        minhaLista2.add(new Poupanca(aux1,v1));
         }catch(Exception erro){
             System.out.println("ERRO Respeite os tipos de dados !");
        
    }
        }
        
        
        
        
        
        private static void addCorrente (){
       
        Scanner sc1 = new Scanner(System.in);
        try{
        System.out.print("Nome do banco: " + "\n");
        String aux1 = sc1.nextLine();
        
        System.out.print("Saldo: " + "\n");
        float v1 = sc1.nextFloat();
        sc1.nextLine();
        
        
        System.out.print("Cheque Especial: " + "\n");
        float v2 = sc1.nextFloat();
        sc1.nextLine();
        
     
       
        minhaLista3.add(new Corrente(aux1,v1,v2));
        }catch(Exception erro){
            System.out.println("ERRO Respeite os tipo de dados");
        }
        
        
    }
    
   
    
    
    
    
    
    
}
    


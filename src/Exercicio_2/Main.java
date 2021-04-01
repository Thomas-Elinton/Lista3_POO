
package Exercicio_2;

import java.util.ArrayList;
import javax.swing.JOptionPane;


public class Main {
    
     public static void main(String[] args) {
         
         int opc = 0;
         int codigo;
         String nome,marca = null,modelo = null, msg;
         ArrayList<Pessoa> listPessoa = new ArrayList <>();
         Pessoa pessoaSelecionada = null;
         Pessoa pessoaTrans = null;
        
         while (opc!= 6){
             opc = Integer.parseInt(JOptionPane.showInputDialog("1- Criar Pessoa \n 2- Criar Automovel\n"
                     + "3- Tranferir Automovel\n 4-Mostar todas as pessoas\n 5- Mostar automovel da pessoa\n"
                     + "6- Sair"));
             if(opc == 2 || opc == 3 || opc == 5){
                 pessoaSelecionada = null;
                 codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o código da pessoa"));
                 for(Pessoa p : listPessoa){
                     if(p.getCodigo() == codigo)
                         pessoaSelecionada = p;  
                 }
                 if(pessoaSelecionada == null)
                     continue;
             }
             
             switch (opc){
                 case 1 :
                     codigo = Integer.parseInt(JOptionPane.showInputDialog("Código"));
                     nome = JOptionPane.showInputDialog("Nome");
                     listPessoa.add(new Pessoa (codigo, nome));
                     break;
                 case 2 : 
                     marca = JOptionPane.showInputDialog("Marca Auto");
                     modelo = JOptionPane.showInputDialog ("Modelo Auto");
                    pessoaSelecionada.inserirAutomovel(new Automovel (marca,modelo));
                     
                     break;
                 case 3 :
                    marca = JOptionPane.showInputDialog("Seleciona a marca");
                    modelo = JOptionPane.showInputDialog("Seleciona o modelo");
                    int index = -1;
                    for (Automovel a : pessoaSelecionada.getAutomoveis()){
                        if(a.getModelo().equals(modelo) && a.getMarca().equals (marca))
                            index = pessoaSelecionada.getAutomoveis().indexOf(a);
                    }
                     if(index >=0){
                         pessoaSelecionada.removerAutomovel(index); 
                     }
                     codigo = Integer.parseInt(JOptionPane.showInputDialog("Novo Proprietario"));
                     for(Pessoa trans : listPessoa ){
                         if(trans.getCodigo() == codigo)
                             pessoaSelecionada = trans;
                         
                     }
                     
                     for(Automovel transfere : pessoaTrans.getAutomoveis()){
                        if(transfere.getModelo().equals(modelo) && transfere.getMarca().equals(marca))
                            index = pessoaTrans.getAutomoveis().indexOf(transfere);
                     }
                     pessoaTrans.inserirAutomovel(new Automovel(marca,modelo));
                     break;
                 case 4 :
                     msg = "";
                     for(Pessoa p : listPessoa){
                         msg += p.imprimir() +"\n";
                     }
                     JOptionPane.showMessageDialog(null, msg);
                     break;
                 case 5 :
                     JOptionPane.showMessageDialog(null, pessoaSelecionada.imprimirCompleto());
                     break;
                 case 6 : break;
                 default: break ;
             }
             
             
         }
     }
}



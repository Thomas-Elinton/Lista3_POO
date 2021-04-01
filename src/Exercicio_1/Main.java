
package Exercicio_1;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Main {

    
    public static void main(String[] args) {
       
        int opc = 0;
        int cod , ch;
        String nome, ra, msg;
        ArrayList <Curso> listCurso = new ArrayList <>();
        Curso cursoSelecionado = null;
        while (opc !=6){
           opc = Integer.parseInt(JOptionPane.showInputDialog("1- Criar Curso \n 2- Criar Aluno \n 3- Remover Aluno \n"
                    + "4- Mostar Todos os Crusos\n 5-Mostar Alunos do Curso \n 6- Sair"));
           
           if(opc == 2 || opc ==3 || opc == 5){
              cursoSelecionado = null;
              cod = Integer.parseInt(JOptionPane.showInputDialog("Digite o codigo do curso"));
              for(Curso c : listCurso){
                  if(c.getCodigo() == cod)
                      cursoSelecionado = c;
              }
              if(cursoSelecionado == null)
                  continue;
           }
           
           switch(opc){
               case 1: 
                   cod = Integer.parseInt(JOptionPane.showInputDialog("Codigo"));
                   nome = JOptionPane.showInputDialog("Nome do Curso");
                   ch = Integer.parseInt(JOptionPane.showInputDialog("Carga Horaria"));
                   listCurso.add(new Curso (cod,nome,ch));
                           break;
               case 2: 
                   ra = JOptionPane.showInputDialog("Ra");
                   nome = JOptionPane.showInputDialog("Nome do Aluno");
                   cursoSelecionado.inserirAluno(new Aluno(ra, nome));
                   break;         
               case 3: 
                   ra = JOptionPane.showInputDialog("Digite o Ra");
                   int index = -1;
                   for(Aluno a : cursoSelecionado.getAlunos()){
                       if(a.getRa().equals(ra))
                           index = cursoSelecionado.getAlunos().indexOf(a);  
                   }
                   if(index >= 0)
                       cursoSelecionado.removerAluno(index);
                   break;
               case 4: 
                   msg = "";
                   for(Curso c : listCurso){
                       msg += c.imprimir() +"\n";
                   }
                   JOptionPane.showMessageDialog(null, msg);
                   break;
               case 5:
                   JOptionPane.showMessageDialog(null, cursoSelecionado.imprimirCompleto());
                   break;
               case 6: break;
               default: break;
           }
        }
    }
    
}

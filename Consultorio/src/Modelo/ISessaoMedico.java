/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Gerson
 */
public interface ISessaoMedico extends ISessao{
    /*+solicitarExame()
+gerarReceita()
+gerarAtestado()
+exibirHistorico()*/
    public int solicitarExame();
    public int gerarReceita();
    public int gerarAtestado();
    public int exibirHistorico();
    
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Gerson
 */
public interface ISessaoAtendente extends ISessao{
    /*+cadastrarPaciente()
+atualizarPaciente()
+cadastrarFuncionario()
+marcarConsulta()
+cancelarConsulta()
+verificarPagamento()
+verificarConvenio()*/
    public int cadastrarPaciente(String nome, String telefone, String CPF,String nascimento,String convenio);
    public int editarPaciente(String nome, String telefone, String CPF,String nascimento,String convenio);
    public int cadastrarAtendente(String nome, String CPF,String telefone, String login, String senha);
    public int cadastrarMedico(String nome, String CPF, String CRM,String telefone, String login, String senha);
    public int editarAtendente(String nome, String CPF,String telefone, String login, String senha);
    public int editarMedico(String nome, String CPF, String CRM,String telefone, String login, String senha);
    public int marcarConsulta(String paciente, String medico,String data,String horario);
    public int cancelarConsulta(String nome);
    public int verificarPagamento();
    
    
    
    
}

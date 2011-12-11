/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;
import Modelo.*;
/**
 *
 * @author Gerson
 */
public class Controler {
    public SessaoLogin mySession; //Modelo
    public SessaoAtendente mySessionA; //Modelo
    public SessaoMedico mySessionM; //Modelo
    public javax.swing.JFrame myTela; //Visao
    private static Controler control;
    
    public static Controler getInstance(){
        if (control == null)
            Controler.control = new Controler();
        return control;
    }

    private Controler(){
        this.mySession = new SessaoLogin();
        this.mySessionA = new SessaoAtendente();
//        this.mySessionM = new SessaoMedico();
    }

    public void setIdSessaoA(String idFunc){
        this.mySessionA.setId(idFunc);
    }
    
    public void setIdSessaoM(String idMed){
        this.mySessionM.setId(idMed);
    }
    
    
    //public Controler(){};
    
    
    public String login(String user, String senha){
        return mySession.login(user, senha);
    }
    
    public int logoff(){
        return mySession.logoff();
    }
    
    public int cadastrarPaciente(String nome,String CPF, String nascimento, String telefone,String convenio) {
        return mySessionA.cadastrarPaciente(nome,CPF,nascimento,telefone,convenio);
    }
    public String buscarPaciente(String CPF){
       String result = mySessionA.buscarPaciente(CPF);
       return result;
    }
   
    public int editarPaciente(String nome,String CPF, String nascimento, String telefone,String convenio) {
         return mySessionA.editarPaciente(nome,CPF,nascimento,telefone,convenio);
    }
 
    public int marcarConsulta(String paciente, String medico,String data,String horario) {
         return mySessionA.marcarConsulta(paciente, medico, data, horario);
    }
    
    public int cadastrarAtendente(String nome, String CPF,String telefone, String login, String senha){
        return mySessionA.cadastrarAtendente(nome, CPF, telefone, login, senha);
    }
    
    public int cadastrarMedico(String nome, String CPF, String CRM,String telefone, String login, String senha){
        return mySessionA.cadastrarMedico(nome, CPF, CRM, telefone, login, senha);
    }
    
    public String buscarAtendente(String Nome){
        return mySessionA.buscarAtendente(Nome);
    }
    public String buscarMedico(String Nome){
        return mySessionA.buscarMedico(Nome);
    }
    public String buscarConsulta(String nome){
        return mySessionA.buscarConsulta(nome);
    }
    public String buscarConsulta2(String nome){
        return mySessionA.buscarConsulta2(nome);
    }
    public String buscarConta(String idConsulta){
        return mySessionA.buscarConsulta(idConsulta);
    }
    
    public int editarAtendende(String nome, String CPF,String telefone, String login, String senha){
        return mySessionA.editarAtendente(nome, CPF, telefone, login, senha);
    }
    
    public int editarMedico(String nome, String CPF, String CRM,String telefone, String login, String senha){
        return mySessionA.editarMedico(nome, CPF, CRM, telefone, login, senha);
    }
    
    
    public int cancelarConsulta(String nome) {
         return mySessionA.cancelarConsulta(nome);
    }

   
    public int verificarPagamento() {
         return mySession.verificarPagamento();
    }

    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import DAO.DAOSingleton;

/**
 *
 * @author Gerson
 */
public class SessaoAtendente implements ISessaoAtendente{

    public DAOSingleton myDAO;
    public String idFunc;
    
    public void setId(String idFunc){
        this.idFunc = idFunc;
    }
    
    
    @Override
    public int cadastrarPaciente(String nome,String CPF, String nascimento, String telefone,String convenio) {
        myDAO = DAOSingleton.getInstance();
        return myDAO.cadastrarPaciente(nome,CPF,nascimento,telefone,convenio);
    }

    @Override
    public int editarPaciente(String nome,String CPF, String nascimento, String telefone,String convenio) {
       myDAO = DAOSingleton.getInstance();
       return myDAO.editarPaciente(nome,CPF,nascimento,telefone,convenio);
    }
    public String buscarPaciente(String CPF){
        myDAO = DAOSingleton.getInstance();
        String result = myDAO.buscarPaciente(CPF);
        return result;
    }
    
    @Override
    public int marcarConsulta(String paciente, String medico,String data,String horario) {
        myDAO = DAOSingleton.getInstance();
        return myDAO.marcarConsulta(paciente, medico, data, horario,this.idFunc);
    }

    @Override
    public int cancelarConsulta(String nome) {
        myDAO = DAOSingleton.getInstance();
        return myDAO.cancelarConsulta(nome);
    }

    @Override
    public int verificarPagamento() {
        myDAO = DAOSingleton.getInstance();
        return myDAO.verificarPagamento();
    }

    @Override
    public String login(String user, String senha) {
        myDAO = DAOSingleton.getInstance();
        return myDAO.login(user, senha);
    }

    @Override
    public int logoff() {
        myDAO = DAOSingleton.getInstance();
      //  return myDAO.;
    }

    @Override
    public int cadastrarAtendente(String nome, String CPF,String telefone, String login, String senha) {
        myDAO = DAOSingleton.getInstance();
        return myDAO.cadastrarAtendente(nome, CPF, telefone, login, senha);
    }

    @Override
    public int cadastrarMedico(String nome, String CPF, String CRM,String telefone, String login, String senha) {
        myDAO = DAOSingleton.getInstance();
        return myDAO.cadastrarMedico(nome,CPF,CRM,telefone,login,senha);
    }

    @Override
    public int editarAtendente(String nome, String CPF,String telefone, String login, String senha) {
        myDAO = DAOSingleton.getInstance();
        return myDAO.editarAtendente(nome, CPF, telefone, login, senha);
    }

    @Override
    public int editarMedico(String nome, String CPF, String CRM,String telefone, String login, String senha) {
        myDAO = DAOSingleton.getInstance();
        return myDAO.editarMedico(nome, CPF, CRM, telefone, login, senha);
    }
     
    public String buscarAtendente(String nome){
        myDAO = DAOSingleton.getInstance();
        String result = myDAO.buscarAtendente(nome);
        return result;
    }
      
     public String buscarMedico(String nome){
        myDAO = DAOSingleton.getInstance();
        String result = myDAO.buscarMedico(nome);
        return result;
    }
     
    public String buscarConsulta(String nome){
        myDAO = DAOSingleton.getInstance();
        String result = myDAO.buscarConsulta(nome);
        return result;
    } 
    
    public String buscarConsulta2(String nome){
        myDAO = DAOSingleton.getInstance();
        String result = myDAO.buscarConsulta2(nome);
        return result;
    } 

    public String buscarConta(String idConsulta){
        myDAO = DAOSingleton.getInstance();
        String result = myDAO.buscarConta(idConsulta);
        return result;
    }
}

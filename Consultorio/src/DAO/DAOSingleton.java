/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
/**
 *
 * @author Gerson
 */
public class DAOSingleton {
    public String url  = "jdbc:mysql://localhost:3306/consultorio";
    public String user = "root";
    public String senha = "1234546";
    private static DAOSingleton conexao = null;
    private static Connection conn;
    
    private DAOSingleton() throws SQLException{
        //Class.forName("com.mysql.jdbc.Driver").newInstance();
        conn = DriverManager.getConnection(url, user, senha);
    }
    
    public static Connection getConexao(){
        if (conexao == null)
            try {
            conexao = new DAOSingleton();
        } catch (SQLException ex) {
            Logger.getLogger(DAOSingleton.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
    
    public static DAOSingleton getInstance(){
        if (conexao == null)
            try {
            conexao = new DAOSingleton();
        } catch (SQLException ex) {
            Logger.getLogger(DAOSingleton.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conexao;
    }
    
    
    
    public String login (String user, String senha){
        try {
            Connection myConn = DAOSingleton.getConexao(); 
            String query = "SELECT Login,Senha,Privilegio,Funcionario_idFuncionario "
                    + "FROM login WHERE Login =? AND Senha=?";
            
            PreparedStatement stm = myConn.prepareStatement(query);
            stm.setString(1,user);
            stm.setString(2,senha);
            ResultSet rs = stm.executeQuery();
            if(rs.first()){ //se existir a coluna
                if(rs.getString("Login").equals(user) && rs.getString("Senha").equals(senha) && rs.getString(3).equals("Medico")){
                        String result =  rs.getString("Funcionario_idFuncionario");
                        stm.close();
                        return "1;" + result;
                     }
         
                else if(rs.getString("Login").equals(user) && rs.getString("Senha").equals(senha) && rs.getString(3).equals("Atendente")){
                        String result =  rs.getString("Funcionario_idFuncionario");
                        stm.close();
                       return "2;" + result;
                     }
                else
                    stm.close();
                    return "0;";
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOSingleton.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return "3;";
    }
    
    public String buscarPaciente(String CPF){
        try {
            Connection myConn = DAOSingleton.getConexao(); 
            String query = "SELECT Nome,CPF,Nascimento,Convenio,Telefone FROM paciente WHERE CPF=?";
            PreparedStatement stm = myConn.prepareStatement(query);
            stm.setString(1,CPF);
            ResultSet rs = stm.executeQuery();
            String result = "";
            boolean next = rs.next();
            result = rs.getString("Nome")+";"+rs.getString("CPF")+";"+rs.getString("Nascimento")+";"+rs.getString("Convenio")+";"+rs.getString("Telefone");
            stm.close();
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(DAOSingleton.class.getName()).log(Level.SEVERE, null, ex);
            return "Inexistente";
        }
        
    }
    
    public String buscarAtendente(String Nome){
        try {
            Connection myConn = DAOSingleton.getConexao(); 
            String query = "SELECT Nome,CPF,Telefone,Login,Senha FROM funcionario,login WHERE Nome=? AND idFuncionario = Funcionario_idFuncionario";
            PreparedStatement stm = myConn.prepareStatement(query);
            stm.setString(1,Nome);
            ResultSet rs = stm.executeQuery();
            String result = "";
            boolean next = rs.next();
            result = rs.getString("Nome")+";"+rs.getString("CPF")+";"+ rs.getString("Telefone")+";"+ rs.getString("Login")+";"+ rs.getString("Senha");
            stm.close();
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(DAOSingleton.class.getName()).log(Level.SEVERE, null, ex);
            return "Inexistente";
        }
        
    }
    
    public String buscarMedico(String Nome){
        try {
            Connection myConn = DAOSingleton.getConexao(); 
            String query = "SELECT Nome,CPF,Telefone,CRM,login,senha FROM medico,funcionario,login WHERE Nome=? AND idFuncionario = Medico.Funcionario_idFuncionario";
            PreparedStatement stm = myConn.prepareStatement(query);
            stm.setString(1,Nome);
            ResultSet rs = stm.executeQuery();
            String result = "";
            boolean next = rs.next();
            result = rs.getString("Nome")+";"+rs.getString("CPF")+";"+rs.getString("CRM")+";"+rs.getString("Telefone")+";"+rs.getString("Login")+";"+rs.getString("Senha");
            stm.close();
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(DAOSingleton.class.getName()).log(Level.SEVERE, null, ex);
            return "Inexistente";
        }
        
    }
    
    public String buscarConsulta(String nome){
        try {
            Connection myConn = DAOSingleton.getConexao(); 
            String query = "SELECT DISTINCT Paciente.nome,funcionario.nome,data,horario,Medico_Funcionario_idFuncionario,idConsulta"
                    +" FROM funcionario,medico,consulta,paciente"
                    +" WHERE Paciente.Nome=? AND Medico_Funcionario_idFuncionario = Medico.Funcionario_idFuncionario"
                    +" AND Paciente_idPaciente = idPaciente AND idFuncionario =  Medico.Funcionario_idFuncionario";
            PreparedStatement stm = myConn.prepareStatement(query);
            stm.setString(1,nome);
            ResultSet rs = stm.executeQuery();
            String result = "";
            boolean next = rs.next();
            result = rs.getString("Paciente.nome")+";"+rs.getString("funcionario.nome")+";"+rs.getString("data")+";"+rs.getString("horario")+";"+rs.getString("idConsulta");
            stm.close();
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(DAOSingleton.class.getName()).log(Level.SEVERE, null, ex);
            return "Inexistente";
        }
     }
     public String buscarConsulta2(String nome){
        try {
            Connection myConn = DAOSingleton.getConexao(); 
            String query = "SELECT DISTINCT Paciente.nome,funcionario.nome,data,horario,Medico_Funcionario_idFuncionario,idConsulta"
                    +" FROM funcionario,medico,consulta,paciente"
                    +" WHERE Paciente.Nome=? AND Medico_Funcionario_idFuncionario = Medico.Funcionario_idFuncionario"
                    +" AND Paciente_idPaciente = idPaciente AND idFuncionario =  Medico.Funcionario_idFuncionario";
            PreparedStatement stm = myConn.prepareStatement(query);
            stm.setString(1,nome);
            ResultSet rs = stm.executeQuery();
            String result = "";
            
            while(rs.next())
                result = result+ (rs.getString("idConsulta") + ";");
            stm.close();
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(DAOSingleton.class.getName()).log(Level.SEVERE, null, ex);
            return "Inexistente";
        }
     }
    
     public int cadastrarPaciente(String nome,String CPF, String nascimento, String telefone,String convenio) {
        try {
            Connection myConn = DAOSingleton.getConexao(); 
            String query = "INSERT INTO `Consultorio`.`Paciente` (`Nome`, `CPF`, `Nascimento`, `Convenio`, `Telefone`) "
                            + "VALUES (?, ?, ?, ?, ?);";
            PreparedStatement stm = myConn.prepareStatement(query);
            stm.setString(1,nome);
            stm.setString(2,CPF);
            stm.setString(3,nascimento);
            stm.setString(4,convenio);
            stm.setString(5,telefone);
            int executeUpdate = stm.executeUpdate();
            stm.close();
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(DAOSingleton.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
       
    }

   
    public int editarPaciente(String nome,String CPF, String nascimento, String telefone,String convenio) {
        try {
            Connection myConn = DAOSingleton.getConexao(); 
            String query = ("SELECT idPaciente FROM paciente WHERE CPF = ?");
            String query2 = ("UPDATE paciente SET  Nome = ?,"+
                                                "CPF = ?,"+
                                                "Nascimento = ?,"+
                                                "Convenio = ?,"+
                                                "Telefone = ?"+
                                                "WHERE idPaciente = ?");
                    
            PreparedStatement stm = myConn.prepareStatement(query);
            stm.setString(1,CPF);
            ResultSet rs = stm.executeQuery();
            boolean next = rs.next();
            String id = rs.getString("idPaciente");
            
            stm =  myConn.prepareStatement(query2);
            stm.setString(1,nome);
            stm.setString(2,CPF);
            stm.setString(3,nascimento);
            stm.setString(4,convenio);
            stm.setString(5,telefone);
            stm.setString(6,id);
            int executeUpdate = stm.executeUpdate();
            stm.close();
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(DAOSingleton.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    //BUGADO! Corrigir depois!
    public int marcarConsulta(String paciente, String medico,String data,String horario, String idFunc) {
         try {
            Connection myConn = DAOSingleton.getConexao(); 
            //Pegar o id do paciente
            String query1 = "SELECT idPaciente FROM paciente WHERE Nome = ?";
            PreparedStatement stm = myConn.prepareStatement(query1);
            stm.setString(1,paciente);
            ResultSet rs = stm.executeQuery();
            boolean next = rs.next();
            String idpaciente = rs.getString("idPaciente");
            
            //Pegar o id do medico
            String query2 = "SELECT idFuncionario FROM medico,funcionario "
                    + "WHERE Nome = ?";
            stm = myConn.prepareStatement(query2);
            stm.setString(1,medico);
            rs = stm.executeQuery();
            next = rs.next();
            String idmedico = rs.getString("idFuncionario");
            
            //Inserir COnsulta
            
            
            String query3 = "INSERT INTO Consultorio.Consulta (Paciente_idPaciente, Data, Horario,"
                    + "Secretaria_Funcionario_idFuncionario,"
                    + "Atestado_idAtestado,Medico_Funcionario_idFuncionario) "
                    + "VALUES (?,?,?,?,?,?)";
            stm = myConn.prepareStatement(query3);
            stm.setString(1,idpaciente);
            stm.setString(2,data);
            stm.setString(3,horario);
            stm.setString(4,idFunc);
            stm.setString(5,null);
            stm.setString(6,idmedico);
            int executeUpdate = stm.executeUpdate();
            stm.close();
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(DAOSingleton.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }

    }

    
    public int cancelarConsulta(String nome) {
        try {
            Connection myConn = DAOSingleton.getConexao(); 
            String result = DAOSingleton.getInstance().buscarConsulta(nome);
            String delims = "[;]+";
            String[] tokens = result.split(delims);
            String idConsult = tokens[4];
            String query = "DELETE FROM `consultorio`.`consulta` WHERE idConsulta = ?";
            PreparedStatement stm = myConn.prepareStatement(query);
            stm.setString(1, idConsult);
            int executeUpdate = stm.executeUpdate();
            stm.close();
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(DAOSingleton.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

   
    public int verificarPagamento() {

    }


    public int cadastrarAtendente(String nome, String CPF,String telefone, String login, String senha){
        try {
            Connection myConn = DAOSingleton.getConexao(); 
            //Inserir Funcionario
            String query1 = "INSERT INTO `Consultorio`.`Funcionario` (`Nome`, `Telefone`, `CPF`) "
                    + "VALUES (?,?,?)";
            PreparedStatement stm = myConn.prepareStatement(query1);
            stm.setString(1, nome);
            stm.setString(2, telefone);
            stm.setString(3, CPF);
            int executeUpdate = stm.executeUpdate();
            //Pegar id do funcionario
            String query2 = "SELECT idFuncionario FROM Consultorio.funcionario WHERE CPF = ?";
            stm = myConn.prepareStatement(query2);
            stm.setString(1, CPF);
            ResultSet rs = stm.executeQuery();
            boolean next = rs.next();
            String idFunc = rs.getString("idFuncionario");
            
            
            //Inserir Secretaria
            String query3 = "INSERT INTO `Consultorio`.`Secretaria` (`Funcionario_idFuncionario`) "
                    + "VALUES (?)";
            stm = myConn.prepareStatement(query3);
            stm.setString(1, idFunc);
            executeUpdate = stm.executeUpdate();
            
            //Inserir Login e Sesnha
            String query4 = "INSERT INTO `Consultorio`.`Login` (`Funcionario_idFuncionario`, `Login`, `Senha`, `Privilegio`) "
                    + "VALUES (?,?,?,?)";
            stm = myConn.prepareStatement(query4);
            stm.setString(1, idFunc);
            stm.setString(2, login);
            stm.setString(3, senha);
            stm.setString(4, "Atendente");
            executeUpdate = stm.executeUpdate();
            stm.close();
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(DAOSingleton.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
            
}

    public int cadastrarMedico(String nome, String CPF, String CRM,String telefone, String login, String senha){
        try {
            Connection myConn = DAOSingleton.getConexao(); 
            //Inserir Funcionario
            String query1 = "INSERT INTO `Consultorio`.`Funcionario` (`Nome`, `Telefone`, `CPF`) "
                    + "VALUES (?,?,?)";
            PreparedStatement stm = myConn.prepareStatement(query1);
            stm.setString(1, nome);
            stm.setString(2, telefone);
            stm.setString(3, CPF);
            int executeUpdate = stm.executeUpdate();
            //Pegar id do funcionario
            String query2 = "SELECT idFuncionario FROM Consultorio.funcionario WHERE CPF = ?";
            stm = myConn.prepareStatement(query2);
            stm.setString(1, CPF);
            ResultSet rs = stm.executeQuery();
            boolean next = rs.next();
            String idFunc = rs.getString("idFuncionario");
            
            
            //Inserir Medico
            String query3 = "INSERT INTO `Consultorio`.`Medico` (`Funcionario_idFuncionario`,CRM) "
                    + "VALUES (?,?)";
            stm = myConn.prepareStatement(query3);
            stm.setString(1, idFunc);
            stm.setString(2, CRM);
            executeUpdate = stm.executeUpdate();
            
            //Inserir Login e Sesnha
            String query4 = "INSERT INTO `Consultorio`.`Login` (`Funcionario_idFuncionario`, `Login`, `Senha`, `Privilegio`) "
                    + "VALUES (?,?,?,?)";
            stm = myConn.prepareStatement(query4);
            stm.setString(1, idFunc);
            stm.setString(2, login);
            stm.setString(3, senha);
            stm.setString(4, "Medico");
            executeUpdate = stm.executeUpdate();
            stm.close();
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(DAOSingleton.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }

}

    public int editarAtendente(String nome, String CPF,String telefone, String login, String senha){
        try {
            Connection myConn = DAOSingleton.getConexao(); 
            String query = "SELECT idFuncionario FROM funcionario WHERE Nome = ?";
            String query2 = "UPDATE funcionario set Nome=?,CPF=?,Telefone=? WHERE idFuncionario = ?";
            String query3 = "UPDATE login SET login=?,senha=? WHERE Funcionario_idFuncionario=?";
            //Pegar id Medico       
            PreparedStatement stm = myConn.prepareStatement(query);
            stm.setString(1,nome);
            ResultSet rs = stm.executeQuery();
            boolean next = rs.next();
            String id = rs.getString("idFuncionario");
            //Atualizar dados funcionario
            stm =  myConn.prepareStatement(query2);
            stm.setString(1,nome);
            stm.setString(2,CPF);
            stm.setString(3,telefone);
            stm.setString(4,id);
            int executeUpdate = stm.executeUpdate();
            //Atualizar dados login
            stm =  myConn.prepareStatement(query3);
            stm.setString(1,login);
            stm.setString(2,senha);
            stm.setString(3,id);
            stm.executeUpdate();            
            stm.close();
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(DAOSingleton.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }

    }

    public int editarMedico(String nome, String CPF, String CRM,String telefone, String login, String senha){
        try {
            Connection myConn = DAOSingleton.getConexao(); 
            String query = "SELECT idFuncionario FROM funcionario WHERE Nome = ?";
            String query2 = "UPDATE funcionario set Nome=?,CPF=?,Telefone=? WHERE idFuncionario = ?";
            String query3 = "UPDATE medico set CRM = ? WHERE Funcionario_idFuncionario = ?";
            String query4 = "UPDATE login SET login=?,senha=? WHERE Funcionario_idFuncionario=?";
            //Pegar id Medico       
            PreparedStatement stm = myConn.prepareStatement(query);
            stm.setString(1,nome);
            ResultSet rs = stm.executeQuery();
            boolean next = rs.next();
            String id = rs.getString("idFuncionario");
            //Atualizar dados funcionario
            stm =  myConn.prepareStatement(query2);
            stm.setString(1,nome);
            stm.setString(2,CPF);
            stm.setString(3,telefone);
            stm.setString(4,id);
            int executeUpdate = stm.executeUpdate();
            //Atualizar dados Medico
            stm =  myConn.prepareStatement(query3);
            stm.setString(1,CRM);
            stm.setString(2,id);
            stm.executeUpdate();
            //Atualizar dados login
            stm =  myConn.prepareStatement(query4);
            stm.setString(1,login);
            stm.setString(2,senha);
            stm.setString(3,id);
            stm.executeUpdate();            
            stm.close();
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(DAOSingleton.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    public String buscarConta(String idConsulta) {
        Connection myConn = DAOSingleton.getConexao(); 
        String query = 
        
        
    }
}

    
        
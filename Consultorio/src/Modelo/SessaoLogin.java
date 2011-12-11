/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import DAO.*;
import java.util.Observable;
/**
 *
 * @author Gerson
 */
public class SessaoLogin extends Observable implements ISessao{
    
    public DAOSingleton myDAO;
    
    
    @Override
    public String login (String user, String senha){
        myDAO = DAOSingleton.getInstance();
        return myDAO.login(user, senha);
    }

    @Override
    public int logoff() {
        throw new UnsupportedOperationException("Not supported yet.");
    }


    
}

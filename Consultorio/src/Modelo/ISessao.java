/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Gerson
 */
public interface ISessao {
    public String login(String user, String senha);
    public int logoff();
}

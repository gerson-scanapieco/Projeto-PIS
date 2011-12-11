/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package consultorio;

import Controle.Controler;
import Modelo.SessaoLogin;
import Visao.VisaoLogin;

/**
 *
 * @author Gerson
 */
public class Consultorio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Controler control = Controler.getInstance();
        VisaoLogin app = new VisaoLogin();
        app.setVisible(true);
        
    }
}

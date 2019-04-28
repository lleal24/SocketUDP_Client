/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketudp_client;

/**
 *
 * @author user
 */
public class SocketUDP_Client {

    /**
     * @param args the command line arguments
     */
    byte[] buffer = new byte[1024];

    public static void main(String[] args) {

        vistaMagia vista = new vistaMagia();
        vista.setVisible(true);

    }
}

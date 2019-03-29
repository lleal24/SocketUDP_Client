/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketudp_client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class SocketUDP_Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            String msj = JOptionPane.showInputDialog("Ingrese el mensaje a enviar");
            DatagramSocket miSocket = new DatagramSocket();
            //conversion de string msj a bytes para enviar
            byte [] mensaje = msj.getBytes();
            InetAddress host = InetAddress.getByName("127.0.0.1");
            //puerto de destino definido en el servidor
            int puerto = 9107;
                
             Scanner entrada = new Scanner(System.in);
             int [] binario = new int [7];
             
             
             for(int i=binario.length-1; i>=0; i--){
                 System.out.print("Ingrese numero");
                 binario[i] = entrada.nextInt();
             }
                //Conversion de array a estring separado por comas
                String str = Arrays.toString(binario);
                System.out.print(str);
                
                /*Impresion de array
               for(int i=0; i<binario.length; i++){
                System.out.println(binario[i]);
                 }
                */
            byte [] mensaje2 = str.getBytes();    
             
             
            //Se arma el paquete a enviar que contiene mensaje host y puerto
            DatagramPacket miPaquete = new DatagramPacket(mensaje, msj.length(), host, puerto);
            miSocket.send(miPaquete);
             DatagramPacket miPaquete2 = new DatagramPacket(mensaje2, str.length(), host, puerto);
            miSocket.send(miPaquete2);
            
        } catch (SocketException ex) {
            Logger.getLogger(SocketUDP_Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnknownHostException ex) {
            Logger.getLogger(SocketUDP_Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SocketUDP_Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatencriptado;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Renan
 */
public final class Server {
    
    public Server(){
        System.out.println("Servidor iniciado");
        this.start();
    }
    
    public void start() {
        System.out.println("Teste iniciado");
        Scanner entrada = new Scanner(System.in);
        new Thread(){
            @Override
            public void run() {
                ServerSocket servidor = null;
                try {
                    servidor = new ServerSocket(12345);
                } catch (IOException ex) {
                    Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("Porta 12345 aberta!");
                Socket cliente = null;
                try {
                    cliente = servidor.accept();
                } catch (IOException ex) {
                    Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("Nova conexão com o cliente " + cliente.getInetAddress().getHostAddress());
                Scanner entrada = null;
                try {
                    entrada = new Scanner(cliente.getInputStream());
                } catch (IOException ex) {
                    Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                }
                while (entrada.hasNextLine()) {
                    System.out.println("Texto recebido pelo servidor: ");
                    System.out.println(entrada.nextLine());
                }
                entrada.close();
                try {
                    servidor.close();
                } catch (IOException ex) {
                    Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }.start();
    }

    public void startServer() throws IOException{
        ServerSocket servidor = new ServerSocket(12345);
        System.out.println("Porta 12345 aberta!");

        Socket cliente = servidor.accept();
        System.out.println("Nova conexão com o cliente " +     
            cliente.getInetAddress().getHostAddress()
        );

        Scanner s = new Scanner(cliente.getInputStream());
        while (s.hasNextLine()) {
            System.out.println(s.nextLine());
        }

        s.close();
        servidor.close();
        cliente.close();
    }
}

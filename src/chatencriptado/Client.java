/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatencriptado;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 *
 * @author Renan
 */
public class Client {
    
    public String name;
    public String publicKey;
    public String privateKey;
    
    public Client(String name) throws IOException{
        this.name = name;
        this.privateKey = this.generateKey();
        this.publicKey = this.generateKey();
        System.out.println("Cliente iniciado: "+ name);
        this.start();
    }
    
    public void start() throws UnknownHostException, IOException {
        Socket cliente = new Socket("127.0.0.1", 12345);
        System.out.println("O cliente se conectou ao servidor!");

        Scanner teclado = new Scanner(System.in);
        PrintStream saida = new PrintStream(cliente.getOutputStream());
        while (teclado.hasNextLine()) {
            saida.println(teclado.nextLine());
        }

        saida.close();
        teclado.close();
        cliente.close();
    }
    
    private String generateKey(){
        return "";
    }
    
    public String sendMessage(){
        return "";
    }
    
    public String receiveMessage(){
        return "";
    }
    
}

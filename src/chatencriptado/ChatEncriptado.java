/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatencriptado;

import java.io.IOException;

/**
 *
 * @author Renan
 */
public class ChatEncriptado {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        Server server = new Server();
        Client ana = new Client("Ana");
        Client bob = new Client("Bob");
    }
    
}

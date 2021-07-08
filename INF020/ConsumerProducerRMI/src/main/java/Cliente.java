/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Victor Hugo
 */
import java.io.IOException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.net.MalformedURLException;
import java.net.Socket;
import java.rmi.NoSuchObjectException;
import java.rmi.NotBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.ArrayList;
import java.lang.Integer;

public class Cliente {
      ProducerConsumerCadastrer rmiServer;
      Registry registry;
      String serverAddress = "192.168.0.33";
      int serverPort = 1099;     
      String message = new String();
      int porta=0;
  
    public Cliente() {
        
        
    
        
        
        try {
            // get the “registry” 
            registry = LocateRegistry.getRegistry(
                    serverAddress,
                    serverPort
            );
            // look up the remote object 
            rmiServer = (ProducerConsumerCadastrer) (registry.lookup("rmiServer"));
            
            
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
    }
    
    public String  produzirProduto  ()throws RemoteException{
        
        return message = rmiServer.produzirProduto();
        
    }
    
    public String consumirProduto  () throws RemoteException{
         
         
         return message = rmiServer.consumirProduto();
    }
    
    public static void main(String[] args) throws NotBoundException, MalformedURLException, RemoteException, IOException {
        String message = new String();
        Scanner ler = new Scanner(System.in);
        int op = 0;
        Cliente cliente =  new Cliente();
   
        do {
                
            System.out.println("\nSelecione uma opção:");
            System.out.println("1 - Produzir produto.");
            System.out.println("2 - Consumir produto.");
            System.out.println("0 - Sair.");

            op = ler.nextInt();

            switch (op) {
                case 1:
                    message =  cliente.rmiServer.produzirProduto();
                    System.out.println(message);

                    break;

                case 2:

                    message = cliente.rmiServer.consumirProduto();
                    System.out.println(message);

                case 0:

                    break;

                default:
                    System.out.println("Opção inválida!!!!");
            }

        } while (op != 0);

    }
}

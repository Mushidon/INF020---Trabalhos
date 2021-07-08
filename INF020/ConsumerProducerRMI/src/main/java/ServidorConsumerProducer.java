/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Victor Hugo
 */
public class ServidorConsumerProducer  {
    String ip;
    Registry registro;
    int count =0;
    int porta = 1099;
    public ServidorConsumerProducer() throws UnknownHostException, RemoteException{
      
      
        try{
            
            ProducerConsumerCadastrer obj = new ProducerConsumerImpl();
            registro = LocateRegistry.createRegistry(porta);
            registro.rebind(("rmiServer"), obj);
            ip = InetAddress.getLocalHost().getHostAddress();
            System.out.println("Estou funcionando no ip " + ip);
    }
        catch(Exception e){
            System.out.println("Erro " + e);
        }
    }
    
    /**
     *
     * @param args
     * @throws UnknownHostException
     * @throws RemoteException
     */
    
    public static void main(String[] args){
        try {
            new ServidorConsumerProducer();
        } catch (UnknownHostException ex) {
            Logger.getLogger(ServidorConsumerProducer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(ServidorConsumerProducer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
      
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Victor Hugo
 */
public interface ProducerConsumerCadastrer extends Remote {
    
    
    public String produzirProduto  () throws RemoteException;
    public String consumirProduto  () throws RemoteException;

 

   

   

   

    
}

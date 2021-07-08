
import java.rmi.RemoteException;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Victor Hugo
 */
public class ProducerConsumerImpl extends java.rmi.server.UnicastRemoteObject
        implements ProducerConsumerCadastrer {

    int itemCount = 0;
    ArrayList<Integer> buffer = new ArrayList();
    private boolean canRun = true;
    int contador;

    public ProducerConsumerImpl() throws java.rmi.RemoteException {
        super();
    }

    public String produzirProduto() throws RemoteException {
        contador++;
        buffer.add(contador);
        itemCount++;
        return new String("Produzindo item:" + contador + "\n");
    }

    public String consumirProduto() throws RemoteException {
        int item;
        item = (Integer) buffer.get(0);
        buffer.remove(0);
        itemCount--;
        contador--;
        return new String("Consumindo item:" + (1 + itemCount) + "\n");
    }

}

package main;

import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;


public class RMICalculatorServer extends UnicastRemoteObject implements MathFunctions {

    public RMICalculatorServer() throws RemoteException {
        super();
    }

    @Override
    public double sum (double n1, double n2) throws RemoteException, RemoteException{
    	return n1 + n2;
    }
    @Override
    public double subs (double n1, double n2) throws RemoteException, RemoteException{
    	return n1 - n2;
    }
    @Override
    public double mult (double n1, double n2) throws RemoteException, RemoteException{
    	return n1 * n2;
    }
    @Override
    public double div (double n1, double n2) throws RemoteException, RemoteException{
    	if (n2 != 0) {
    		return n1 / n2;
    	} else {
    		return 0.0;
    	}
	
    }
   
    public static void main(String[] args){
        try{
            Registry registro = LocateRegistry.createRegistry(7777);
            registro.rebind("RemoteServer", new RMICalculatorServer());
            System.out.println("Server is running");
        }catch (RemoteException e){
            System.out.println(e.getMessage());
        }
    }
}
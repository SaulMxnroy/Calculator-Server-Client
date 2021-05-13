package main;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {
	
	Scanner input = new Scanner(System.in);
	
    public static void main(String[] arg){
        Client client = new Client();
        client.connectServer();
    }

    private void connectServer() {
        try {
        	
            double n1,n2,res;
            int op;

            Registry registro = LocateRegistry.getRegistry("localhost", 7777);
            MathFunctions interfaz = (MathFunctions) registro.lookup("RemoteServer");
            
            System.out.println("Elija una figura: \n"
            		+ "1.-Suma\n"
            		+ "2.-Resta\n"
            		+ "3.-Multiplicaci�n\n"
            		+ "4.-Divisi�n\n");
            op = input.nextInt();
            
            switch (op) {
            
            case 1: //Suma
            	System.out.println("Ingrese el primer n�mero: ");
            	n1 = input.nextDouble();
            	System.out.println("Ingrese el segundo n�mero: ");
            	n2 = input.nextDouble();
            	
                System.out.println("La suma es: " + interfaz.sum(n1, n2));
                
            	break;
            case 2: //resta
            	System.out.println("Ingrese el primer n�mero: ");
            	n1 = input.nextDouble();
            	System.out.println("Ingrese el segundo n�mero: ");
            	n2 = input.nextDouble();
            	
                System.out.println("La resta es: " + interfaz.subs(n1, n2));
                
            	break;
            case 3://multiplicaci�n
            	System.out.println("Ingrese el primer n�mero: ");
            	n1 = input.nextDouble();
            	System.out.println("Ingrese el segundo n�mero: ");
            	n2 = input.nextDouble();
            	
                System.out.println("La multiplicaci�n es: " + interfaz.mult(n1, n2));
                
            	break;
            case 4://divisi�n
            	System.out.println("Ingrese el primer n�mero: ");
            	n1 = input.nextDouble();
            	System.out.println("Ingrese el segundo n�mero: ");
            	n2 = input.nextDouble();
            	
                System.out.println("La divisi�n es: " + interfaz.div(n1, n2));
                
            	break;
            	
            }
    
        } catch (RemoteException | NotBoundException ex) {
            System.out.println("error: " + ex.getMessage());
        }
    }
}
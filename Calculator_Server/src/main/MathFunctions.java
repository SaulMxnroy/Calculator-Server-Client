package main;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MathFunctions extends Remote {
	public double sum (double n1, double n2) throws RemoteException, RemoteException;
	public double subs (double n1, double n2) throws RemoteException, RemoteException;
	public double mult (double n1, double n2) throws RemoteException, RemoteException;
	public double div (double n1, double n2) throws RemoteException, RemoteException;
}
